package com.wipe.healthy.web.dto;

import com.wipe.healthy.core.model.User;
import com.wipe.healty.common.utils.DateUtils;

import java.util.Date;


/**
 * 用户信息输入视图
 * User:Created by wei.li
 * Date: on 2016/3/1.
 * Time:21:11
 */
public class UserInput {

    /** 用户信息主键**/
    private Integer id;

    /** 用户信息名称**/
    private String name;

    /**用户性别**/
    private Integer sex;

    /**用户出生年月**/
    private String birthday;

    /**用户籍贯**/
    private String nativePlace;

    /**用户专项**/
    private String major;

    /**用户身高**/
    private Float height;

    /**用户体重**/
    private Float weight;

    /**用户心率**/
    private Float heartRate;

    /**用户肺活量**/
    private Float pulmonary;

    /**用户食物爱好**/
    private Integer foodHabits;

    /**描叙信息**/
    private String describe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Float heartRate) {
        this.heartRate = heartRate;
    }

    public Float getPulmonary() {
        return pulmonary;
    }

    public void setPulmonary(Float pulmonary) {
        this.pulmonary = pulmonary;
    }

    public Integer getFoodHabits() {
        return foodHabits;
    }

    public void setFoodHabits(Integer foodHabits) {
        this.foodHabits = foodHabits;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  User convertToUser(UserInput userInput){
        User user = new User();
        user.setSex(userInput.getSex());
        user.setName(userInput.getName());
        user.setMajor(userInput.getMajor());
        user.setHeight(userInput.getHeight());
        user.setDescribe(userInput.getDescribe());
        user.setFoodHabits(userInput.getFoodHabits());
        user.setId(userInput.getId());
        user.setHeartRate(userInput.getHeartRate());
        user.setNativePlace(userInput.getNativePlace());
        user.setPulmonary(userInput.getPulmonary());
        user.setWeight(userInput.getWeight());
        user.setBirthday(DateUtils.convertDate(userInput.getBirthday()));
        return user;
    }

}
