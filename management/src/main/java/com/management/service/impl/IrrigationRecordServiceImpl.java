package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.IrrigationRecord;
import com.management.entity.vo.IrrigationRecordVo;
import com.management.service.IrrigationRecordService;
import com.management.mapper.IrrigationRecordMapper;
import com.management.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

/**
* @author lenovo
* @description 针对表【irrigation_record】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class IrrigationRecordServiceImpl extends ServiceImpl<IrrigationRecordMapper, IrrigationRecord>
    implements IrrigationRecordService{

    @Autowired
    private IrrigationRecordMapper irrigationRecordMapper;

    @Override
    public List<IrrigationRecordVo> getByFarmId(Integer farmId) {
        List<IrrigationRecordVo> irrigationRecordVos = irrigationRecordMapper.getByFarmId(farmId);
        if (Objects.nonNull(irrigationRecordVos)) {
            irrigationRecordVos.forEach(irrigationRecordVo -> {
                irrigationRecordVo.setIrrigationDate(DateUtils.toFormatDate(irrigationRecordVo.getIrrigationDate()));
            });
        }
        return irrigationRecordVos;
    }

    @Override
    public List<IrrigationRecordVo> getAll() {
        List<IrrigationRecordVo> irrigationRecordVos = irrigationRecordMapper.getAll();
        if (!ObjectUtils.isEmpty(irrigationRecordVos)) {
            irrigationRecordVos.forEach(irrigationRecordVo -> {
                irrigationRecordVo.setIrrigationDate(DateUtils.toFormatDate(irrigationRecordVo.getIrrigationDate()));
            });
        }
        return irrigationRecordVos;
    }
}




