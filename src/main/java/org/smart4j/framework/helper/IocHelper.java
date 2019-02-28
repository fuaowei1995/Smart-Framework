package org.smart4j.framework.helper;

import com.sun.deploy.util.ArrayUtil;
import com.sun.javafx.collections.MappingChange;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;
import org.smart4j.framework.util.CollectionUtil;
import java.lang.reflect.Field;

import java.util.Map;

public final class IocHelper {
    static {
        //获取所有的Bean 类与Bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            //遍历Bean Map
            for (Map.Entry<Class<?>,Object>beanEntry:beanMap.entrySet()){
                //从BeanMap中获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFileds = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFileds)){
                    for(Field beanField:beanFileds){
                        if(beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance!=null){
                                ReflectionUtil.setFiled(beanInstance,beanField,beanFieldInstance);
                            }
                        }

                    }
                }
            }
        }
    }

}
