package com.management.service;

import com.management.entity.IrrigationRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.entity.vo.IrrigationRecordVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【irrigation_record】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface IrrigationRecordService extends IService<IrrigationRecord> {
    IrrigationRecordVo getByFarmId(Integer farmId);

    List<IrrigationRecordVo> getAll();
}
