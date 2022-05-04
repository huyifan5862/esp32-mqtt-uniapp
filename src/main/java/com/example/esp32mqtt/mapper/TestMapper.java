package com.example.esp32mqtt.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
@Mapper
public interface TestMapper {
    @Select("select * from user where User='root'")
    Map selOne();

    @Insert("insert into client value(#{clientid},#{mobel})")
    int insertClientId(@Param("clientid") String clientid, @Param("mobel") String mobel);
}
