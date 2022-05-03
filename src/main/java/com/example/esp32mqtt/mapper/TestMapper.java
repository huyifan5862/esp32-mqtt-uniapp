package com.example.esp32mqtt.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
@Mapper
public interface TestMapper {
    @Select("select * from user where User='root'")
    Map selOne();
}
