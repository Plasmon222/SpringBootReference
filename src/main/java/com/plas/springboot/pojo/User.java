package com.plas.springboot.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:08
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private String uuid;
    private String name;
    @TableField(fill = FieldFill.INSERT) //添加时自动填充
    private String sex;
    @TableField(fill = FieldFill.INSERT) //添加时自动填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE) //添加或修改时自动填充
    private Date updateTime;

//    @Version    //乐观锁version注解
//    private Integer version;

    private String text;

}
