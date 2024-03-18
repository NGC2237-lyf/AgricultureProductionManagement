package com.management.service;

import com.management.entity.Land;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.entity.vo.LandVo;

import java.util.List;

/**
* @author lenovo
* @description 针对表【land】的数据库操作Service
* @createDate 2024-03-07 21:03:05
*/
public interface LandService extends IService<Land> {
    List<LandVo> getAll();

    LandVo getByFarmId(Integer farmId);
}
