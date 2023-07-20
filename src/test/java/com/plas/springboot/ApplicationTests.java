package com.plas.springboot;

import com.plas.springboot.mapper.UserMapper;
import com.plas.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {

    }
    //继承了BaseMapper所有的方法，可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelect(){
        System.out.println("--------selectAll method test-------");
        //查询全部用户，参数是一个Wrapper，条件构造器，先不使用为null
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("李安");
        user.setSex("2");
        user.setText("我不是连，我是李安");
        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println(insert);//受影响行数
        System.out.println(user);//id会自动回填
    }
    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        //可以通过条件自动拼接动态SQL
        user.setName("id:5,修改过后");
        //updateById 参数是一个对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

}
