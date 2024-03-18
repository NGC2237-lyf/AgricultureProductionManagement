package com.management.mapper;

import com.management.entity.CropGrowthTracking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.entity.vo.CropGrowthTrackingVo;
import com.management.entity.vo.CropPlantingPlanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【crop_growth_tracking】的数据库操作Mapper
* @createDate 2024-03-07 21:03:05
* @Entity com.management.entity.CropGrowthTracking
*/
@Mapper
public interface CropGrowthTrackingMapper extends BaseMapper<CropGrowthTracking> {
    List<CropGrowthTrackingVo> getByFarmId(@Param("farmId") Integer farmId);

    List<CropGrowthTrackingVo> getAll();
}




