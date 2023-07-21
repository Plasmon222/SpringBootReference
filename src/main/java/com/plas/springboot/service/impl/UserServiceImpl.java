package com.plas.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.plas.springboot.mapper.UserMapper;
import com.plas.springboot.pojo.User;
import com.plas.springboot.pojo.vo.UserVO;
import com.plas.springboot.service.IUserService;
import com.plas.springboot.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:07
 * @Description:
 */
@Service
public class UserServiceImpl implements IUserService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public UserMapper userMapper;
    public List<User> queryUserList() {
        System.out.println("--------selectAll method test-------");
        return userMapper.selectList(null);
    }
    public User queryUserById(String id) {
        return userMapper.selectById(id);
    }
    public List<User> selectByMap(User user){
        HashMap<String,Object> map = new HashMap<>();
        //自定义查询
        if(StringUtil.isNotEmpty(user.getUuid())){
            map.put("uuid",user.getUuid());
        }
        List<User> users = userMapper.selectByMap(map);
        logger.info("这是日志...条件查询:"+users.toString());
        users.forEach(System.out::println);
        return users;
    }
    public Page pageCourseQuery(Page pageCourse, User user) {
        //创建查询queryWrapper对象
        QueryWrapper queryWrapper=new QueryWrapper<>();
        //根据创建时间排序
        queryWrapper.orderByDesc("createTime");
        //判断此时的条件对象Vo是否等于空，若等于空，
        //直接进行selectPage查询
        if(user==null){
            Page page = userMapper.selectPage(pageCourse, queryWrapper);
            return page;
        }
        //若Vo对象不为空，分别获取其中的字段，
        //并对其进行判断是否为空，这一步类似动态SQL的拼装
        String uuid = user.getUuid();
        String name = user.getName();

        if(!StringUtils.isEmpty(uuid)){
            queryWrapper.eq("uuid",uuid);
        }
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        //最后调用selectPage方法，传入Page对象及queryWrapper对象
        Page page = userMapper.selectPage(pageCourse, queryWrapper);
        return page;
    }

    public int addUser(User user){
        return userMapper.insert(user);
    }
    public int deleteUser(String id){
        return userMapper.deleteById(id);
    }

}
