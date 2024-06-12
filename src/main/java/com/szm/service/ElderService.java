package com.szm.service;

import com.szm.mapper.ElderMapper;
import com.szm.pojo.Elder;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ElderService {
    SqlSessionFactory factory= SqlSessionFactoryUtils.getInstance();

    public List<Elder> selectAllElder(){
        SqlSession session=factory.openSession();
        ElderMapper elderMapper=session.getMapper(ElderMapper.class);
        List<Elder> elders=elderMapper.selectAllElder();
        return elders;
    }

    public Elder selectElderById(int id){
        SqlSession session=factory.openSession();
        ElderMapper elderMapper=session.getMapper(ElderMapper.class);
        Elder elder=elderMapper.selectElderById(id);
        return elder;
    }
}
