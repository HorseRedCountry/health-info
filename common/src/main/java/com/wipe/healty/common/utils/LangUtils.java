package com.wipe.healty.common.utils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 实现描述：通用工具类
 * User:Created by wei.li
 * Date: on 2016/3/14.
 * Time:13:56
 */
public class LangUtils {

    public static int nvl(Integer i, int defaults) {
        return i == null ? defaults : i;
    }

    public static long nvl(Long l, long defaults) {
        return l == null ? defaults : l;
    }

    public static boolean nvl(Boolean b, boolean defaults) {
        return b == null ? defaults : b;
    }

    public static boolean nvl(String bool, boolean defaults) {
        return bool == null ? defaults : Boolean.parseBoolean(bool);
    }

    public static String nvl(String string, String defaults) {
        return string == null ? defaults : string;
    }

    /**
     * List 的转换
     * @param fromList 输入list
     * @param function 转换fuction
     * @param <F> 输入类型
     * @param <T> 输出类型
     * @return 转换后的list
     */
    public static <F,T> List<T> transform(List<F> fromList,Function<? super F,? extends T> function){
        List<T> result = Lists.newArrayList();
        for (F input: fromList){
            result.add(function.apply(input));
        }
        return result;
    }

    /**
     * list 过滤
     * @param fromList 输入list
     * @param predicate 过滤结果
     * @param <T> 输入类型
     * @return 过滤后的数据
     */
    public static <T> List<T> filter(List<T> fromList,Predicate<? super T> predicate){
        List<T> result = Lists.newArrayList();
        for (T input : fromList){
            if (predicate.apply(input)){
                result.add(input);
            }
        }
        return result;
    }


    /**
     * list string 转long
     * @param stringList 输入list
     * @return 输出list
     */
    public static List<Long> longList(List<String> stringList) {
        List<Long> result = Lists.newArrayList();
        for (String string : stringList) {
            result.add(Long.valueOf(string));
        }
        return result;
    }
}
