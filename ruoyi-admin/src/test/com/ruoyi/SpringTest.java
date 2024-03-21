package com.ruoyi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.management.controller.AgriculturalProductionController;
import com.management.entity.CropGrowthTracking;
import com.management.entity.SoilTestData;
import com.management.mapper.CropPlantingPlanMapper;
import com.management.service.CropGrowthTrackingService;
import com.management.service.IrrigationRecordService;
import com.management.service.impl.AgriculturalProductServiceImpl;
import com.management.service.impl.SoilTestDataServiceImpl;
import com.management.utils.ChatGgtUtils;
import com.management.utils.CrawlerUtils;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author TokisakiKurumi
 * @className SpringTest
 * @date 2024/3/7
 * @description
 **/
@SpringBootTest
public class SpringTest {
    @Autowired
    private CropPlantingPlanMapper cropPlantingPlanMapper;

    @Autowired
    private SoilTestDataServiceImpl soilTestDataService;

    @Autowired
    private AgriculturalProductionController agriculturalProductionController;

    @Autowired
    private CropGrowthTrackingService cropGrowthTrackingService;

    @Autowired
    private AgriculturalProductServiceImpl agriculturalProductService;
    @Test
    void testAPI() {
        String question = "请帮我根据以下数据分析施肥、灌溉、病虫防害的建议。";
        QueryWrapper<SoilTestData> soilTestDataQueryWrapper = new QueryWrapper<>();
        soilTestDataQueryWrapper.orderByDesc("test_date");
        Page<SoilTestData> soilTestDataPage = soilTestDataService.getBaseMapper().selectPage(new Page<>(1, 2), soilTestDataQueryWrapper);
        QueryWrapper<CropGrowthTracking> cropGrowthTrackingQueryWrapper = new QueryWrapper<>();
        cropGrowthTrackingQueryWrapper.orderByDesc("observation_date");
        Page<CropGrowthTracking> cropGrowthTrackingPage = cropGrowthTrackingService.getBaseMapper().selectPage(new Page<>(1, 2), cropGrowthTrackingQueryWrapper);
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
        System.out.println(solution);
    }

    @Test
    void testFetch() {
        System.out.println(agriculturalProductService.findData("青菜"));
    }

    @Test
    void testMapper() {
        System.out.println(cropPlantingPlanMapper.getByFarmId(1));
    }

    @Autowired
    private IrrigationRecordService irrigationRecordService;
    @Test
    void testService() {
        System.out.println(soilTestDataService.getById(1));
    }
}
