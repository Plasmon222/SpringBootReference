package com.plas.springboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.springboot.pojo.User;
import com.plas.springboot.pojo.vo.UserVO;

import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/21/9:11
 * @Description:
 */
public interface IUserService {

    public List<User> queryUserList();//查询全部用户
    public User queryUserById(String id);//根据id查询
    public List<User> selectByMap(User user);//条件查询
    public Page pageCourseQuery(Page pageCourse, User user);//定义pageCourseQuery方法，指定参数Page对象及查询条件对象
    public int addUser(User user);//添加用户
    public int deleteUser(String id);//根据id删用户
}
