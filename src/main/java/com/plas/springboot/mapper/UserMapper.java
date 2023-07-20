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
    List<User> queryUserList();
    User queryUserById(int id);
    void addUser(User user);
    void deleteUserById(int id);

}
