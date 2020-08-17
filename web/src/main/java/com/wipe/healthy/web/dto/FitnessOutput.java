package com.wipe.healthy.web.dto;

import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healty.common.utils.DateUtils;

/**
 * 健身行为输出视图
 * User:Created by wei.li
 * Date: on 2016/3/15.
 * Time:8:50
 */
public class FitnessOutput {

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

    /**用户名**/
    private String userName;

    /**用户名**/
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static FitnessOutput from(FitnessAction fitnessAction,ActionInfo actionInfo){
        FitnessOutput fitnessOutput = new FitnessOutput();
        fitnessOutput.setWeather(actionInfo.getWeather());
        fitnessOutput.setTemperature(actionInfo.getTemperature());
        fitnessOutput.setBeginTime(actionInfo.getBeginTime().toString());
        fitnessOutput.setEndTime(actionInfo.getEndTime().toString());
        fitnessOutput.setData(DateUtils.formatDate(actionInfo.getData()));
        fitnessOutput.setActionId(actionInfo.getId());

        fitnessOutput.setCalorie(fitnessAction.getCalorie());
        fitnessOutput.setActionName(fitnessAction.getActionName());
        fitnessOutput.setFitPeople(fitnessAction.getFitPeople());
        fitnessOutput.setStyle(fitnessAction.getStyle());
        fitnessOutput.setFitnessId(fitnessAction.getId());
        return fitnessOutput;
    }
}
