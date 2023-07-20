package com.plas.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/10:08
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private int id;
    private String sex;

}
