package com.management.service;

import com.management.entity.CropPlantingPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.entity.vo.CropPlantingPlanVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【crop_planting_plan】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface CropPlantingPlanService extends IService<CropPlantingPlan> {

    CropPlantingPlanVo getByFarmId(Integer farmId);

    List<CropPlantingPlanVo> getAll();


}
