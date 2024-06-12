package com.szm.service;

import com.szm.mapper.BedMapper;
import com.szm.mapper.CaretakerMapper;
import com.szm.pojo.Bed;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BedService {
    SqlSessionFactory factory= SqlSessionFactoryUtils.getInstance();

    /*查找已分配床位*/
    public List<Bed> SelectDistributedBed(){
        SqlSession session=factory.openSession();
        BedMapper mapper=session.getMapper(BedMapper.class);
        List<Bed> list=mapper.SelectDistributedBed();
        session.close();
        return list;
    }

    /*查找未分配床位*/
    public List<Bed> SelectDistributingBed(){
        SqlSession session=factory.openSession();
        BedMapper mapper=session.getMapper(BedMapper.class);
        List<Bed> list=mapper.SelectDistributingBed();
        session.close();
        return list;
    }

    /*更新床位状态*/
    public void SetBedStatus(int id){
        SqlSession session=factory.openSession();
        BedMapper mapper=session.getMapper(BedMapper.class);
        mapper.SetBedStatus(id);
        session.commit();
        session.close();
    }
}
