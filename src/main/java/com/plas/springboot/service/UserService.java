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
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
    public User queryUserById(int id){
        User user= userMapper.queryUserById(id);
        return user;

    }
    public String addUser(User user){
        userMapper.addUser(user);
        return "新增成功";

    }
    public String deleteUserById(int id){
        userMapper.deleteUserById(id);
        return "删除成功";
    }

    public boolean checkStr(String inputString){
        String canshu=inputString;
        boolean checkStrReturn=false;
        String pattern=".+";
        Pattern p=Pattern.compile(pattern);
        if(StringUtil.isNotEmpty(pattern)){
            Matcher m=p.matcher(canshu);
            boolean matches = m.matches();
            checkStrReturn=matches;
        }
        return checkStrReturn;
    }
}
