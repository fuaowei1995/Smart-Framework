package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.Map;

public class Param {
    private Map<String,Object>paraMap;
    public  Param(Map<String,Object>paraMap){
        this.paraMap = paraMap;
    }

    public long getLong(String name){
        return CastUtil.castLong(paraMap.get(name));
    }

    public Map<String,Object> getMap(){
        return paraMap;
    }
}
