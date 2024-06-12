package com.szm.mapper;

import com.szm.pojo.Bed;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BedMapper {

    /*查找未分配的床位*/
    @Select("select * from coursedesign.bed where flag=0")
    public List<Bed> SelectDistributingBed();

    /*查找已分配的床位*/
    @Select("select * from coursedesign.bed where flag=1")
    public List<Bed> SelectDistributedBed();

    @Update("update coursedesign.bed set flag=1 where id=#{id}")
    public void SetBedStatus(Integer id);
}
