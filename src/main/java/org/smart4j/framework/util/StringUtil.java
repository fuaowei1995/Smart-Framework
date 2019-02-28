package org.smart4j.framework.util;

public class StringUtil {
    /*
   判断字符串是否为空
    */
    public static boolean isEmpty(String str){
        if(str!=null){
            str=str.trim();
        }
        return StringUtil.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static String[] splitString(String str1,String str2){
        return com.sun.deploy.util.StringUtils.splitString(str1,str2);
    }

}
