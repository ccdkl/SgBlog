package com.sangeng.utils;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cc
 */
public class BeanCopyUtils {
    private BeanCopyUtils() {

    }
    public static <V> V copyBean(Object source,Class<V> clazz) {
        V result = null;
        try {
            result = clazz.newInstance();
            BeanUtils.copyProperties(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;


    }
    public static <O,V> List<V> copyBeanList(List<O> sourceList,Class<V> clazz){
        return sourceList.stream()
                .map(o -> copyBean(o,clazz))
                .collect(Collectors.toList());



    }
}
