package com.szm.service;

import com.szm.mapper.UserMapper;
import com.szm.pojo.User;
import com.szm.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



import java.util.ArrayList;
import java.util.List;

public class UserService {

    //1.获取SQL session factory
    SqlSessionFactory factory=SqlSessionFactoryUtils.getInstance();


    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password){
        //2.调用mybatis完成查询
        //2.1获取SQL session factory对象
        //String resource = "mybatis-config.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.2获取SQL session对象
        SqlSession sqlSession = factory.openSession();
        //2.3获取Mapper
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //2.4调用方法
        User user=userMapper.login(username,password);
        //2.5释放资源
        sqlSession.close();

        return user;
    }

    public boolean register(User user){
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        //判断用户名是否存在
        User user1=userMapper.selectByUsername(user.getUsername());

        if(user1==null) {
            //用户名不存在，可注册
            userMapper.add(user);
            sqlSession.commit();
            sqlSession.close();
        }
        return user1==null;
    }

    /**
     * 查询所有用户数据
     * @return
     */
    public List<User> selectAll(){

        //2.获取sqlsession
        SqlSession sqlSession=factory.openSession();
        //3.获取UserMapper
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        List<User>users=userMapper.selectAll();

        sqlSession.close();
        return users;
    }

    /**
     * 添加用户
     * @param user
     */
    public void insert(User user){
        //1.获取事务对象
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //2.调用方法
        userMapper.add(user);
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }

    /**
     * 通过username查询
     * @param username
     * @return
     */
    public User selectByUsername(String username){

        //2.获取sqlsession
        SqlSession sqlSession=factory.openSession();
        //3.获取UserMapper
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //4.调用方法
        User user=userMapper.selectByUsername(username);

        sqlSession.close();
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user){
        //1.获取事务对象
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        //2.调用方法
        userMapper.update(user);
        System.out.println("update coursedesign.user set fullname="
                + user.getFullname()+ ",phonenumber="+user.getPhonenumber()+
                ",email="+user.getEmail()+
                " where username="+user.getUsername()+";");
        //3.提交事务
        sqlSession.commit();
        //4.释放资源
        sqlSession.close();
    }


}
