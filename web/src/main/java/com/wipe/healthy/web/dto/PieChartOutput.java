package com.wipe.healthy.web.dto;

/**
 * 饼状图输出视图
 * User:Created by wei.li
 * Date: on 2016/4/9.
 * Time:15:25
 */
public class PieChartOutput {
    /** 值**/
    private Integer value;
    /** 名称**/
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieChartOutput(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
