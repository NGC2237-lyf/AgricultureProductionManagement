package com.management.mapper;

import com.management.entity.IrrigationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.entity.vo.IrrigationRecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【irrigation_record】的数据库操作Mapper
* @createDate 2024-03-07 21:03:05
* @Entity com.management.entity.IrrigationRecord
*/
@Mapper
public interface IrrigationRecordMapper extends BaseMapper<IrrigationRecord> {
    IrrigationRecordVo getByFarmId(@Param("farmId") Integer farmId);

    List<IrrigationRecordVo> getAll();
}




