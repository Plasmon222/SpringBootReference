//package com.plas.springboot.controller;
//
//import com.plas.springboot.pojo.User;
//import com.plas.springboot.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @Auther:Plasmon222
// * @Date: 2023/7/20/10:07
// * @Description:
// */
//@RestController
//public class UserController {
//    @Autowired
//    public UserService userService;
//
//    @GetMapping("queryUserList")
//    public List<User> queryUserList(){
//        return userService.queryUserList();
//    }
//
//    @GetMapping ("queryUserById")
//    public User queryUserById(int user_id){
//        return userService.queryUserById(user_id);
//
//    }
//
//    @GetMapping("/addUser")
//    public String addUser(User user){
//        return userService.addUser(user);
//
//    }
//
//    @GetMapping("/deleteUserById")
//    public String deleteUserById(int id){
//        return userService.deleteUserById(id);
//
//    }
//}
