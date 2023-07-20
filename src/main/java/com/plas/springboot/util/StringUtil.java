package com.plas.springboot.util;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/18/14:23
 * @Description:
 */
public class StringUtil {

    public static boolean isNotEmpty(String param){
        return param != null && !"".equals(param.trim());
    }
}
