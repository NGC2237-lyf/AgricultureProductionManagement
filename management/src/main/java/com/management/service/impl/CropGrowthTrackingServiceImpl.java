package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.CropGrowthTracking;
import com.management.entity.vo.CropGrowthTrackingVo;
import com.management.service.CropGrowthTrackingService;
import com.management.mapper.CropGrowthTrackingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【crop_growth_tracking】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class CropGrowthTrackingServiceImpl extends ServiceImpl<CropGrowthTrackingMapper, CropGrowthTracking>
    implements CropGrowthTrackingService{

    @Autowired
    private CropGrowthTrackingMapper cropGrowthTrackingMapper;

    @Override
    public List<CropGrowthTrackingVo> getAllCropGrowthTracking() {
        return cropGrowthTrackingMapper.getAll();
    }

    @Override
    public List<CropGrowthTrackingVo> getCropGrowthTracking(Integer farmId) {
        return cropGrowthTrackingMapper.getByFarmId(farmId);
    }
}




