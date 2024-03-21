package com.management.controller;

import com.github.pagehelper.PageInfo;
import com.management.entity.CropPlantingPlan;
import com.management.entity.IrrigationRecord;
import com.management.entity.Land;
import com.management.entity.vo.CropPlantingPlanVo;
import com.management.entity.vo.IrrigationRecordVo;
import com.management.entity.vo.LandVo;
import com.management.service.CropPlantingPlanService;
import com.management.service.IrrigationRecordService;
import com.management.service.LandService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author TokisakiKurumi
 * @className FarmPlaningController
 * @date 2024/3/7
 * @description
 **/
@RestController
@RequestMapping("/farm")
public class FarmPlaningController {

    @Autowired
    private LandService landService;

    @Autowired
    private CropPlantingPlanService cropPlantingPlanService;

    @Autowired
    private IrrigationRecordService irrigationRecordService;

    /*土地资源管理*/

    @GetMapping("/land/{id}")
    public AjaxResult getLand(@PathVariable("id") Integer farmId) {
        LandVo landVO = landService.getByFarmId(farmId);
        return Objects.nonNull(landVO) ? AjaxResult.success("查询成功",landVO) : AjaxResult.error("查询失败");
    }

    @GetMapping("/land/{pageNum}/{pageSize}")
    public AjaxResult getAllLand(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum,pageSize);
        List<LandVo> landVoS = landService.getAll();
        PageUtils.clearPage();
        PageInfo<LandVo> pageInfo = new PageInfo<>(landVoS);
        return !ObjectUtils.isEmpty(landVoS) ? AjaxResult.success("查询成功",pageInfo) : AjaxResult.error("查询失败");
    }

    @PostMapping("/land/update")
    public AjaxResult updateLand(@RequestBody Land land) {
        return landService.updateById(land)?AjaxResult.success("更新成功"):AjaxResult.error("更新失败");
    }
    @PostMapping("/land/delete")
    public AjaxResult deleteLand(@RequestBody List<Integer> landIds) {
        return landService.removeByIds(landIds)?AjaxResult.success("删除成功"):AjaxResult.error("删除失败");
    }

    @PostMapping("/land/insert")
    public AjaxResult insertLand(@RequestBody List<Land> lands) {
        return landService.saveBatch(lands)?AjaxResult.success("成功"):AjaxResult.error("失败");
    }

    /*作物种植计划*/

    @GetMapping("/cropPlanting/{id}/{pageNum}/{pageSize}")
    public AjaxResult getCropPlanting(@PathVariable("id") Integer farmId , @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum,pageSize);
        List<CropPlantingPlanVo> cropPlantingPlanVos = cropPlantingPlanService.getByFarmId(farmId);
        PageUtils.clearPage();
        PageInfo<CropPlantingPlanVo> pageInfo = new PageInfo<>(cropPlantingPlanVos);
        return !ObjectUtils.isEmpty(cropPlantingPlanVos) ? AjaxResult.success("查询成功",pageInfo) : AjaxResult.error("查询失败");
    }

    @GetMapping("/cropPlanting/{pageNum}/{pageSize}")
    public AjaxResult getAllCropPlanting(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum,pageSize);
        List<CropPlantingPlanVo> cropPlantingPlanVos = cropPlantingPlanService.getAll();
        PageUtils.clearPage();
        PageInfo<CropPlantingPlanVo> pageInfo = new PageInfo<>(cropPlantingPlanVos);
        return !ObjectUtils.isEmpty(cropPlantingPlanVos) ? AjaxResult.success("查询成功",pageInfo) : AjaxResult.error("查询失败");
    }

    @PostMapping("/cropPlanting/update")
    public AjaxResult updateCropPlanting(@RequestBody CropPlantingPlan cropPlantingPlan) {
        return cropPlantingPlanService.updateById(cropPlantingPlan)?AjaxResult.success("更新成功"):AjaxResult.error("更新失败");
    }
    @PostMapping("/cropPlanting/delete")
    public AjaxResult deleteCropPlanting(@RequestBody List<Integer> cropPlantingPlanIds) {
        return cropPlantingPlanService.removeByIds(cropPlantingPlanIds)?AjaxResult.success("删除成功"):AjaxResult.error("删除失败");
    }
    @PostMapping("/cropPlanting/insert")
    public AjaxResult insertCropPlanting(@RequestBody CropPlantingPlan cropPlantingPlan) {
        return cropPlantingPlanService.save(cropPlantingPlan)?AjaxResult.success("插入成功"):AjaxResult.error("插入失败");
    }

    /*灌溉记录*/

    @GetMapping("/irrigationRecord/{id}/{pageNum}/{pageSize}")
    public AjaxResult getIrrigationRecord(@PathVariable("id") Integer farmId , @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum,pageSize);
        List<IrrigationRecordVo> irrigationRecordVos = irrigationRecordService.getByFarmId(farmId);
        PageUtils.clearPage();
        PageInfo<IrrigationRecordVo> pageInfo = new PageInfo<>(irrigationRecordVos);
        return !ObjectUtils.isEmpty(irrigationRecordVos) ? AjaxResult.success("查询成功",pageInfo) : AjaxResult.error("查询失败");
    }

    @GetMapping("/irrigationRecord/{pageNum}/{pageSize}")
    public AjaxResult getAllIrrigationRecord(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        PageUtils.startPage(pageNum,pageSize);
        List<IrrigationRecordVo> irrigationRecordVos = irrigationRecordService.getAll();
        PageUtils.clearPage();
        PageInfo<IrrigationRecordVo> pageInfo = new PageInfo<>(irrigationRecordVos);
        return !ObjectUtils.isEmpty(irrigationRecordVos) ? AjaxResult.success("查询成功",pageInfo) : AjaxResult.error("查询失败");
    }

    @PostMapping("/irrigationRecord/update")
    public AjaxResult updateIrrigationRecord(@RequestBody IrrigationRecord irrigationRecord) {
        return irrigationRecordService.updateById(irrigationRecord)?AjaxResult.success("更新成功"):AjaxResult.error("更新失败");
    }

    @PostMapping("/irrigationRecord/delete")
    public AjaxResult deleteIrrigationRecord(@RequestBody List<Integer> irrigationRecordIds) {
        return irrigationRecordService.removeByIds(irrigationRecordIds)?AjaxResult.success("删除成功"):AjaxResult.error("删除失败");
    }

    @PostMapping("/irrigationRecord/insert")
    public AjaxResult insertIrrigationRecord(@RequestBody IrrigationRecord irrigationRecord) {
        return irrigationRecordService.save(irrigationRecord)?AjaxResult.success("插入成功"):AjaxResult.error("插入失败");
    }

}
