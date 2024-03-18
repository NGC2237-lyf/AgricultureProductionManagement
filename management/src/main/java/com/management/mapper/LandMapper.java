package com.management.mapper;

import com.management.entity.Land;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.entity.vo.LandVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author lenovo
* @description 针对表【land】的数据库操作Mapper
* @createDate 2024-03-07 21:03:05
* @Entity com.management.entity.Land
*/
@Mapper
public interface LandMapper extends BaseMapper<Land> {

    LandVo getByFarmId(@Param("farmId") Integer farmId);

    List<LandVo> getAll();
}




