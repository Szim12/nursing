package com.szm.service;

import com.szm.mapper.CaretakerMapper;
import com.szm.pojo.Caretaker;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CaretakerService {
    SqlSessionFactory factory= SqlSessionFactoryUtils.getInstance();

    public List<Caretaker> SelectAllCaretaker(){
        SqlSession session=factory.openSession();
        CaretakerMapper mapper=session.getMapper(CaretakerMapper.class);
        List<Caretaker> caretakerList=mapper.selectAllCaretaker();
        session.close();
        return caretakerList;
    }
}
