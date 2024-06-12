package com.szm.mapper;

import com.szm.pojo.Caretaker;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CaretakerMapper {

    @Select("select * from coursedesign.caretaker")
    public List<Caretaker> selectAllCaretaker();

}
