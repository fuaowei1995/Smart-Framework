package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

public class CastUtil {
    /*
    转换为String类型
     */
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    public static String castString(Object obj,String defaultValue){
        return obj!= null? String.valueOf(obj):defaultValue;
    }

    /*
    转换为double型
     */

    public static double castDouble(Object obj,double defaultvalue){
        double doubleValue=defaultvalue;
        if(obj!=null){
            String strValue=castString(obj,"");
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    doubleValue=defaultvalue;
                }catch(NumberFormatException e){
                    doubleValue=defaultvalue;
                }
            }
        }
        return doubleValue;
    }
    /*
    转化为long型
     */
    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    /*
    转换为long型(指定默认值)
     */
    public static long castLong(Object obj,long defaultValue){
        long longValue = defaultValue;
        if(obj!=null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    longValue=Long.parseLong(strValue);
                }catch(NumberFormatException e){
                    longValue=defaultValue;
                }
            }
        }
        return longValue;
    }

    /*
    转换为int型
     */
    public static int castInt(Object obj){
        return CastUtil.castInt(obj,0);

    }

    /*
    转换为int型(可指定默认值)
     */
    public static int castInt(Object obj,int defaultValue){
        int intValue = defaultValue;
        if(obj!=null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try{
                    intValue=Integer.parseInt(strValue);
                } catch(NumberFormatException e){
                    intValue=defaultValue;
                }
            }
        }
        return intValue;
    }

    /*
    转换为boolean型
     */
    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }

    /*
    转化为boolean型（提供默认值）
     */
    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean boolValue =  defaultValue;
        if(obj!=null){
            boolValue=Boolean.parseBoolean(castString(obj));
        }
        return boolValue;
    }
}