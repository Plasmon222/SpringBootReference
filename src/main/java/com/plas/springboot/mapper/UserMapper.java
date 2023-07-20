package com.plas.springboot.mapper;

import com.plas.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:08
 * @Description:
 */
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList(); //查询全部用户
    User queryUserById(int id); //查询用户(byID
    void addUser(User user); //添加用户
    void deleteUserById(int id); //删除用户（byID

}
