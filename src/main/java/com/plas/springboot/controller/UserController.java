package com.plas.springboot.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.springboot.pojo.User;
import com.plas.springboot.pojo.vo.UserVO;
import com.plas.springboot.service.IUserService;
import com.plas.springboot.service.impl.UserServiceImpl;
import com.plas.springboot.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:07
 * @Description:
 */
@RestController
public class UserController {
    @Autowired
    public IUserService userService;

    @GetMapping("queryUserList")
    public ServerResponse queryUserList() {
        List<User> users = userService.queryUserList();
        return ServerResponse.createBySuccess("查询全部用户",users,users.size());
    }

    @GetMapping("queryUserById")
    public ServerResponse queryUserById(String id) {
        User user = userService.queryUserById(id);
        return ServerResponse.createBySuccess("根据单个id查用户",user,1);
    }

    @GetMapping("selectByMap")
    public ServerResponse selectByMap(User user) {
        List<User> users = userService.selectByMap(user);
        return ServerResponse.createBySuccess("条件查询成功",users,users.size());
    }

    @GetMapping("getCourseList/{current}/{limit}")
    public ServerResponse getCourseList(
            @PathVariable Long current,    //当前页
            @PathVariable Long limit,    //要查询记录数
            User user    //查询条件封装的对象
    ){
        //创建一个Page对象，传入当前页和要查询记录数
        Page pageCourse=new Page<>(current,limit);
        //调用服务层的查询方法，传入Page对象和查询条件对象
        userService.pageCourseQuery(pageCourse,user);
        //查询结束之后，Page对象就存在数据了，此时可以
        //通过该Page对象获取对应的行记录和总记录数
        List rows = pageCourse.getRecords();
        long total = pageCourse.getTotal();
        Map map=new HashMap();
        map.put("rows",rows);
        map.put("total",total);
        //统一返回结果
        return ServerResponse.createBySuccess("200",rows,total);
    }


    @GetMapping("/addUser")
    public ServerResponse addUser(User user) {
        int i = userService.addUser(user);
        return ServerResponse.createBySuccess("添加用户成功",i);
    }

    @GetMapping("/deleteUserById")
    public ServerResponse deleteUserById(String id) {
        int i = userService.deleteUser(id);
        return ServerResponse.createBySuccess("删除用户成功",i);
    }
}
