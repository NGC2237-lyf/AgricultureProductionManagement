package com.management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.management.entity.CropGrowthTracking;
import com.management.entity.SoilTestData;
import com.management.entity.vo.CropGrowthTrackingVo;
import com.management.service.CropGrowthTrackingService;
import com.management.service.LandService;
import com.management.service.SoilTestDataService;
import com.management.utils.ChatGgtUtils;
import com.management.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.PageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TokisakiKurumi
 * @className AgriculturalProductionController
 * @date 2024/3/8
 * @description
 **/
@RestController
@RequestMapping("/agriculture")
public class AgriculturalProductionController {

    private String question;

    @Autowired
    private LandService landService;

    @Autowired
    private ISysUserService userService;


    @Autowired
    private SoilTestDataService soilTestDataService;

    @Autowired
    private CropGrowthTrackingService cropGrowthTrackingService;

    /*土壤监测*/
    @GetMapping("/soil/{id}/{pageNum}/{pageSize}")
    public AjaxResult getSoilTestData(@PathVariable("id") Integer landId , @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        QueryWrapper<SoilTestData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("location", landId);
        PageUtils.startPage(pageNum, pageSize);
        List<SoilTestData> soilTestDatas = soilTestDataService.getBaseMapper().selectList(queryWrapper);
        PageUtils.clearPage();
        PageInfo<SoilTestData> pageInfo = new PageInfo<>(soilTestDatas);
        if (!ObjectUtils.isEmpty(soilTestDatas)) {
            pageInfo.getList().forEach(soilTestData -> {
                soilTestData.setTestDate(DateUtils.toFormatDate(soilTestData.getTestDate()));
            });
            return AjaxResult.success("查询成功", pageInfo);
        }
        return AjaxResult.error("查询失败");
    }

    @GetMapping("/soil/{pageNum}/{pageSize}")
    public AjaxResult getAllSoilTestData( @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<SoilTestData> soilTestDatas = soilTestDataService.getBaseMapper().selectList(null);
        PageUtils.clearPage();
        PageInfo<SoilTestData> pageInfo = new PageInfo<>(soilTestDatas);
        if (!ObjectUtils.isEmpty(soilTestDatas)) {
            pageInfo.getList().forEach(soilTestData -> {
                soilTestData.setTestDate(DateUtils.toFormatDate(soilTestData.getTestDate()));
            });
            return AjaxResult.success("查询成功", pageInfo);
        }
        return AjaxResult.error("查询失败");
    }

    @PostMapping("/soil/insert")
    public AjaxResult insertSoilTestData(@RequestBody SoilTestData soilTestData) {
        return soilTestDataService.save(soilTestData) ? AjaxResult.success("添加成功") : AjaxResult.error("添加失败");
    }

    @PostMapping("/soil/delete")
    public AjaxResult deleteSoilTestData(@RequestBody List<Integer> soilTestDataIds) {
        return soilTestDataService.removeByIds(soilTestDataIds) ? AjaxResult.success("删除成功") : AjaxResult.error("删除失败");
    }

    @PostMapping("/soil/update")
    public AjaxResult updateSoilTestData(@RequestBody SoilTestData soilTestData) {
        return soilTestDataService.updateById(soilTestData) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
    }

    /*作物生长状况跟踪*/

    @PostMapping("/crop/insert")
    public AjaxResult insertCropPlanting(@RequestBody List<CropGrowthTracking> cropGrowthTrackings) {
        return cropGrowthTrackingService.saveBatch(cropGrowthTrackings) ? AjaxResult.success("添加成功") : AjaxResult.error("添加失败");
    }

    @PostMapping("/crop/delete")
    public AjaxResult deleteCropPlanting(@RequestBody List<Integer> cropGrowthTrackingIds) {
        return cropGrowthTrackingService.removeByIds(cropGrowthTrackingIds) ? AjaxResult.success("删除成功") : AjaxResult.error("删除失败");
    }

    @PostMapping("/crop/update")
    public AjaxResult updateCropPlanting(@RequestBody CropGrowthTracking cropGrowthTracking) {
        return cropGrowthTrackingService.updateById(cropGrowthTracking) ? AjaxResult.success("更新成功") : AjaxResult.error("更新失败");
    }

    @GetMapping("/crop/{id}/{pageNum}/{pageSize}")
    public AjaxResult getCropPlanting(@PathVariable("id") Integer farmId , @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<CropGrowthTrackingVo> cropGrowthTrackingVos = cropGrowthTrackingService.getCropGrowthTracking(farmId);
        PageUtils.clearPage();
        PageInfo<CropGrowthTrackingVo> pageInfo = new PageInfo<>(cropGrowthTrackingVos);
        return!ObjectUtils.isEmpty(cropGrowthTrackingVos) ? AjaxResult.success("查询成功", pageInfo) : AjaxResult.error("查询失败");
    }

    @GetMapping("/crop/{pageNum}/{pageSize}")
    public AjaxResult getAllCropPlanting(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum, pageSize);
        List<CropGrowthTrackingVo> cropGrowthTrackingVos = cropGrowthTrackingService.getAllCropGrowthTracking();
        PageUtils.clearPage();
        PageInfo<CropGrowthTrackingVo> pageInfo = new PageInfo<>(cropGrowthTrackingVos);
        return !ObjectUtils.isEmpty(cropGrowthTrackingVos)? AjaxResult.success("查询成功", pageInfo) : AjaxResult.error("查询失败");
    }

    @GetMapping("/question")
    public AjaxResult getAnswer(@RequestParam("q") String question) {
        String solution = ChatGgtUtils.sendQuestion(question);
        if (StringUtils.isEmpty(solution)) {
            return AjaxResult.warn("暂无答案");
        }
        return AjaxResult.success("成功",solution);
    }
}
