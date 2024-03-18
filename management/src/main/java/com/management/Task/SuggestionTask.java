package com.management.Task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.entity.CropGrowthTracking;
import com.management.entity.Land;
import com.management.entity.SoilTestData;
import com.management.service.CropGrowthTrackingService;
import com.management.service.LandService;
import com.management.service.SoilTestDataService;
import com.management.utils.ChatGgtUtils;
import com.management.utils.EmailUtils;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author TokisakiKurumi
 * @className SuggestionTask
 * @date 2024/3/9
 * @description
 **/
@Component
public class SuggestionTask {

    private String question ;

    @Autowired
    private SoilTestDataService soilTestDataService;

    @Autowired
    private CropGrowthTrackingService cropGrowthTrackingService;

    @Autowired
    private LandService landService;

    @Autowired
    private ISysUserService userService;
    public void run() {
        List<Land> lands = landService.getBaseMapper().selectList(null);
        lands.forEach(land -> {
            question = "请帮我根据以下数据分析施肥、灌溉、病虫防害的建议。";
            QueryWrapper<SoilTestData> soilTestDataQueryWrapper = new QueryWrapper<>();
            soilTestDataQueryWrapper.eq("location", land.getLandId()).orderByDesc("test_date");
            Page<SoilTestData> soilTestDataPage = soilTestDataService.getBaseMapper().selectPage(new Page<>(1, 10), soilTestDataQueryWrapper);
            QueryWrapper<CropGrowthTracking> cropGrowthTrackingQueryWrapper = new QueryWrapper<>();
            cropGrowthTrackingQueryWrapper.eq("land_id", land.getLandId()).orderByDesc("observation_date");
            Page<CropGrowthTracking> cropGrowthTrackingPage = cropGrowthTrackingService.getBaseMapper().selectPage(new Page<>(1, 10), cropGrowthTrackingQueryWrapper);
            if (soilTestDataPage.getRecords().isEmpty() || cropGrowthTrackingPage.getRecords().isEmpty()) {
                return;
            }
            SoilTestData soilTestData = soilTestDataPage.getRecords().get(0);
            CropGrowthTracking cropGrowthTracking = cropGrowthTrackingPage.getRecords().get(0);
            question += "土壤监测数据：PH值 " + soilTestData.getPhLevel() + "、" + "氮含量 " + soilTestData.getNitrogen() + "mg/kg、" + "磷含量  " + soilTestData.getSalinity() + "mg/kg、"
                    + "钾含量  " + soilTestData.getPotassium() + "mg/kg、" + "有机物含量 " + soilTestData.getOrganicMatter() + "%、" + "盐分含量 " + soilTestData.getSalinity() + "mg/kg、"
                    + "土壤湿度 " + soilTestData.getSoilMoisture() + "%、" + "土壤类型 " + soilTestData.getSoilType();
            question += "作物生长状况：作物种类 " + cropGrowthTracking.getCropType() + "、" + "生长阶段 " + cropGrowthTracking.getGrowthStage() + "、" + "高度 " + cropGrowthTracking.getHeight() + "cm、"
                    + "冠幅宽度 " + cropGrowthTracking.getCanopyWidth() + "cm、" + "害虫存在情况 " + cropGrowthTracking.getPestPresence() + "、" + "病害存在情况 " + cropGrowthTracking.getDiseasePresence();
            String solution = ChatGgtUtils.sendQuestion(question);
            String email = userService.selectUserById(land.getOwnership()).getEmail();
            EmailUtils.sendMessage(email, "基于监测数据的施肥等建议", solution);
        });
    }
}
