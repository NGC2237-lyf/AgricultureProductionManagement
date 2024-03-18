package com.management.mapper;

import com.management.entity.CropPlantingPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.entity.vo.CropPlantingPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【crop_planting_plan】的数据库操作Mapper
* @createDate 2024-03-07 21:03:05
* @Entity com.management.entity.CropPlantingPlan
*/
@Mapper
public interface CropPlantingPlanMapper extends BaseMapper<CropPlantingPlan> {
    CropPlantingPlanVo getByFarmId(@Param("farmId") Integer farmId);

    List<CropPlantingPlanVo> getAll();
}




