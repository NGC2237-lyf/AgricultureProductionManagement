package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.entity.SoilTestData;
import com.management.service.SoilTestDataService;
import com.management.mapper.SoilTestDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【soil_test_data】的数据库操作Service实现
* @createDate 2024-03-07 21:03:05
*/
@Service
public class SoilTestDataServiceImpl extends ServiceImpl<SoilTestDataMapper, SoilTestData>
    implements SoilTestDataService{

    @Autowired
    private SoilTestDataMapper soilTestDataMapper;

}




