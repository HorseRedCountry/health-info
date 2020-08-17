package com.wipe.healthy.core.model;

import java.util.Date;

/**
 * 数据持久层用户实体
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:23:44
 */
public class User {

    /** 用户信息主键**/
    private Integer id;

    /** 账户主键**/
    private Integer accountId;

    /**用户性别**/
    private Integer sex;

    /**用户姓名*/
    private String name;

    /**用户出生年月**/
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (accountId != null ? !accountId.equals(user.accountId) : user.accountId != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (describe != null ? !describe.equals(user.describe) : user.describe != null) return false;
        if (foodHabits != null ? !foodHabits.equals(user.foodHabits) : user.foodHabits != null) return false;
        if (heartRate != null ? !heartRate.equals(user.heartRate) : user.heartRate != null) return false;
        if (height != null ? !height.equals(user.height) : user.height != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (major != null ? !major.equals(user.major) : user.major != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (nativePlace != null ? !nativePlace.equals(user.nativePlace) : user.nativePlace != null) return false;
        if (pulmonary != null ? !pulmonary.equals(user.pulmonary) : user.pulmonary != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (weight != null ? !weight.equals(user.weight) : user.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (nativePlace != null ? nativePlace.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (heartRate != null ? heartRate.hashCode() : 0);
        result = 31 * result + (pulmonary != null ? pulmonary.hashCode() : 0);
        result = 31 * result + (foodHabits != null ? foodHabits.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", nativePlace='" + nativePlace + '\'' +
                ", major='" + major + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", heartRate=" + heartRate +
                ", pulmonary=" + pulmonary +
                ", foodHabits=" + foodHabits +
                ", describe='" + describe + '\'' +
                '}';
    }
}

