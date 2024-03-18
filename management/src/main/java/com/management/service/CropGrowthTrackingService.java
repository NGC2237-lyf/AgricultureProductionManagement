package com.management.service;

import com.management.entity.CropGrowthTracking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.entity.vo.CropGrowthTrackingVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【crop_growth_tracking】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface CropGrowthTrackingService extends IService<CropGrowthTracking> {
    List<CropGrowthTrackingVo> getAllCropGrowthTracking();

    List<CropGrowthTrackingVo> getCropGrowthTracking(Integer farmId);
}
