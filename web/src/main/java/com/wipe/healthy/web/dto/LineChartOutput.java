package com.wipe.healthy.web.dto;

import java.util.List;

/**
 * 时间 - 卡路里折线图输出
 * User:Created by wei.li
 * Date: on 2016/4/9.
 * Time:15:11
 */
public class LineChartOutput {
    private String name;

    private List value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getValue() {
        return value;
    }

    public void setValue(List value) {
        this.value = value;
    }
}
