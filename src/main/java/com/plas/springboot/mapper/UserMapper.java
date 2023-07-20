package com.plas.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
//再对应的mapper上面实现基本的接口 BaseMapper
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD都已经完成
    //不需要像以前一样配置一大堆文件：pojo-dao（连接mybatis，配置mapper.xml文件）==>service-controller
}