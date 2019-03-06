package com.yrsoft.prodemo.dao;

import com.yrsoft.prodemo.entity.Demo;

public interface DemoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}