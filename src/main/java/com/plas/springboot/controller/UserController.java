package com.plas.springboot.controller;

import com.plas.springboot.pojo.User;
import com.plas.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:07
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("queryUserList")
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    @GetMapping("queryUserById")
    public User queryUserById(String id) {
        return userService.queryUserById(id);
    }

    @GetMapping("/addUser")
    public String addUser(User user) {
        int i = userService.addUser(user);
        return String.valueOf(i);
    }

    @GetMapping("/deleteUserById")
    public String deleteUserById(String id) {
        int i = userService.deleteUser(id);
        return String.valueOf(i);
    }
}
