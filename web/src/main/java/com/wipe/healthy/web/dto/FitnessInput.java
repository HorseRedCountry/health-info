package com.wipe.healthy.web.dto;

import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healty.common.utils.DateUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 *健身信息输入视图
 * User:Created by wei.li
 * Date: on 2016/3/14.
 * Time:23:31
 */
public class FitnessInput {
    /**健身行为id**/
    private Integer fitnessId;

    /** 詳情id**/
    private Integer actionId;

    /**健身行为名称**/
    private String actionName;

    /**健身行为类型**/
    private Integer style;

    /**健身行为适用人群**/
    private String fitPeople;

    /**健身行为消耗卡路里**/
    private Float calorie;

    /**用户主键**/
    private Integer userId;

    /**健身行为发生日期**/
    private String data;

    /**健身行为开始时间**/
    private String beginTime;

    /**健身行为结束时间**/
    private String endTime;

    /**健身行为当天天气**/
    private Integer weather;

    /**健身行为当天气温**/
    private Float temperature;

    public Integer getFitnessId() {
        return fitnessId;
    }

    public void setFitnessId(Integer fitnessId) {
        this.fitnessId = fitnessId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getFitPeople() {
        return fitPeople;
    }

    public void setFitPeople(String fitPeople) {
        this.fitPeople = fitPeople;
    }

    public Float getCalorie() {
        return calorie;
    }

    public void setCalorie(Float calorie) {
        this.calorie = calorie;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public FitnessAction convertToFitnessAction(){
        FitnessAction fitnessAction = new FitnessAction();
        fitnessAction.setActionName(this.actionName);
        fitnessAction.setCalorie(this.calorie);
        fitnessAction.setFitPeople(this.fitPeople);
        fitnessAction.setStyle(this.style);
        fitnessAction.setId(this.fitnessId);
        return fitnessAction;
    }

    public ActionInfo convertToActionInfo(){
        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setActionId(this.actionId);
        actionInfo.setBeginTime(DateUtils.strToTime(this.beginTime));
        actionInfo.setEndTime(DateUtils.strToTime(this.beginTime));
        actionInfo.setData(DateUtils.convertDate(this.data));
        actionInfo.setTemperature(this.temperature);
        actionInfo.setWeather(this.weather);
        actionInfo.setUserId(this.userId);
        return actionInfo;
    }
}
