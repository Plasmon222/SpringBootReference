package com.plas.springboot.service;

import com.plas.springboot.mapper.UserMapper;
import com.plas.springboot.pojo.User;
import com.plas.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:07
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    //查询全部用户
    public List<User> queryUserList() {
        System.out.println("--------selectAll method test-------");
        return userMapper.selectList(null);
    }

    public User queryUserById(String id) {
        return userMapper.selectById(id);
    }
    public int addUser(User user){
        return userMapper.insert(user);
    }
    public int deleteUser(String id){
        return userMapper.deleteById(id);
    }

}
