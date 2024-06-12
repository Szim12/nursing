package com.szm.mapper;

import com.szm.pojo.Elder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ElderMapper {

    @Select("select * from coursedesign.elder")
    public List<Elder> selectAllElder();

    @Select("select * from coursedesign.elder where id=#{id}")
    public Elder selectElderById(int id);
}
