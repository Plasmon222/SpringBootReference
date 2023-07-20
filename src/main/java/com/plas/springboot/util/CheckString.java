package com.plas.springboot.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther:Plasmon222
 * @Date: 2023/7/20/19:59
 * @Description: 检查字符串是否匹配
 */
public class CheckString {
    public boolean checkStr(String inputString){
        String canshu=inputString;
        boolean checkStrReturn=false;
        String pattern=".+";
        Pattern p=Pattern.compile(pattern);
        if(StringUtil.isNotEmpty(pattern)){
            Matcher m=p.matcher(canshu);
            boolean matches = m.matches();
            checkStrReturn=matches;
        }
        return checkStrReturn;
    }
}
