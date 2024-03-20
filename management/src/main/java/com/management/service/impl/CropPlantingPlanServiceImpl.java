package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.CropPlantingPlan;
import com.management.entity.vo.CropPlantingPlanVo;
import com.management.service.CropPlantingPlanService;
import com.management.mapper.CropPlantingPlanMapper;
import com.management.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author lenovo
* @description 针对表【crop_planting_plan】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class CropPlantingPlanServiceImpl extends ServiceImpl<CropPlantingPlanMapper, CropPlantingPlan>
    implements CropPlantingPlanService{

    @Autowired
    private CropPlantingPlanMapper cropPlantingPlanMapper;

    @Override
    public List<CropPlantingPlanVo> getByFarmId(Integer farmId) {
        List<CropPlantingPlanVo> cropPlantingPlanVos = cropPlantingPlanMapper.getByFarmId(farmId);
        if (Objects.nonNull(cropPlantingPlanVos)) {
            cropPlantingPlanVos.forEach(cropPlantingPlanVo -> {
                cropPlantingPlanVo.setPlantingDate(DateUtils.toFormatDate(cropPlantingPlanVo.getPlantingDate()));
                cropPlantingPlanVo.setHarvestDate(DateUtils.toFormatDate(cropPlantingPlanVo.getHarvestDate()));
            });
        }
        return cropPlantingPlanVos;
    }

    @Override
    public List<CropPlantingPlanVo> getAll() {
        List<CropPlantingPlanVo> cropPlantingPlanVos = cropPlantingPlanMapper.getAll();
        if (Objects.nonNull(cropPlantingPlanVos)) {
            cropPlantingPlanVos.forEach(cropPlantingPlanVo -> {
                cropPlantingPlanVo.setPlantingDate(DateUtils.toFormatDate(cropPlantingPlanVo.getPlantingDate()));
                cropPlantingPlanVo.setHarvestDate(DateUtils.toFormatDate(cropPlantingPlanVo.getHarvestDate()));
            });
        }
        return cropPlantingPlanVos;
    }
}




