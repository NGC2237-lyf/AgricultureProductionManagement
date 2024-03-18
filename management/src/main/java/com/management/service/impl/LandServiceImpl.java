package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.Land;
import com.management.entity.vo.LandVo;
import com.management.service.LandService;
import com.management.mapper.LandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author lenovo
* @description 针对表【land】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class LandServiceImpl extends ServiceImpl<LandMapper, Land>
    implements LandService{

    @Autowired
    private LandMapper landMapper;

    @Override
    public List<LandVo> getAll() {
        return landMapper.getAll();
    }

    @Override
    public LandVo getByFarmId(Integer farmId) {
        return landMapper.getByFarmId(farmId);
    }
}




