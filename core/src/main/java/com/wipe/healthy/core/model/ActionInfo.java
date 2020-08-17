package com.wipe.healthy.core.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 数据持久层健身行为详情
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:23:58
 */
public class ActionInfo {

    /**健身行为详情id**/
    private Integer id;

    /**用户主键**/
    private Integer userId;

    /**健身行为主键**/
    private Integer actionId;

    /**健身行为发生日期**/
    private Date data;

    /**健身行为开始时间**/
    private Time beginTime;

    /**健身行为结束时间**/
    private Time endTime;

    /**健身行为当天天气**/
    private Integer weather;

    /**健身行为当天气温**/
    private Float temperature;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getWeather() {
        return weather;
    }

    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionInfo that = (ActionInfo) o;

        if (actionId != null ? !actionId.equals(that.actionId) : that.actionId != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (weather != null ? !weather.equals(that.weather) : that.weather != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (actionId != null ? actionId.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (weather != null ? weather.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", actionId=" + actionId +
                ", data=" + data +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", weather=" + weather +
                ", temperature=" + temperature +
                '}';
    }
}
