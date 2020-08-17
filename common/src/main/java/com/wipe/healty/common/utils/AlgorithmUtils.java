package com.wipe.healty.common.utils;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 算法工具类
 * User:Created by wei.li
 * Date: on 2016/3/15.
 * Time:14:26
 */
public class AlgorithmUtils {


    /**
     * 求list里面最接近目标数字的数
     * @param fromList 输入数组
     * @param targetNum 目标数
     * @return 最接近的数字
     */
    public static float approach(List<Float> fromList,float targetNum){
        Collections.sort(fromList);
        int targetindex = 0;
        int left = 0;int right = 0;
        for ( right = fromList.size()-1;right != left;){
            int midIndex = (right + left) / 2;
            int mid = (right - left);
            float midValue = fromList.get(midIndex);
            if (targetNum == midValue) {
                return midValue;
            }

            if (targetNum > midValue) {
                left = midIndex;
            } else {
                right = midIndex;
            }

            if (mid <= 2) {
                break;
            }
        }
        float result = fromList.get(right) - fromList.get(left)/2 >targetNum ? fromList.get(right) : fromList.get(left);
        return result;
    }

}
