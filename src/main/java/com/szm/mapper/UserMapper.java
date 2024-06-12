package com.szm.mapper;

import com.szm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    /**
     * 查询所有用户数据
     * @return
     */
    @Select("select * from coursedesign.user;")
    List<User> selectAll();

    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from coursedesign.user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 根据username查询用户信息（检查是否用户名重复，数据回显）
     * @param username
     * @return
     */
    @Select("select * from coursedesign.user where username=#{username};")
    User selectByUsername(@Param("username") String username);

    /**
     * 添加用户(注册，加密码)
     * @param user
     */
    @Insert("insert into coursedesign.user(username, fullname, password, role, phonenumber, email) " +
            "values (#{username},#{fullname},#{password},2,#{phonenumber},#{email});")
    void add(User user);

    /**
     * 添加用户(不加密码)
     * @param user
     */
    @Insert("insert into coursedesign.user(username, fullname, role, phonenumber, email) " +
            "values (#{username},#{fullname},2,#{phonenumber},#{email});")
    void addUser(User user);

    /**
     * 修改操作
     * @param user
     */
    @Update("update coursedesign.user set " +
            "fullname=#{fullname}," +
            "phonenumber=#{phonenumber},email=#{email} " +
            "where username=#{username};")
    void update(User user);
}
