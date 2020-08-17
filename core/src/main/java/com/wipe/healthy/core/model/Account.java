package com.wipe.healthy.core.model;


import java.util.Date;

/**
 * 数据持久层账号实体
 * User:Created by wei.li
 * Date: on 2015/12/8.
 * Time:19:46
 */

public class Account {

    /**用户主键**/
    private Integer id;

    /**用户登录名**/
    private String englishName;

    /**用户登陆密码**/
    private String password;

    /** 登陆次数 **/
    private Integer loginCount;

    /** 登陆IP**/
    private String loginIp;

    /** 最后登陆时间 **/
    private Date loginTime;

    /**联系  QQ **/
    private String qq;

    /**描叙信息**/
    private String describes;

    /**用户授权信息**/
    private String authorithy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorithy() {
        return authorithy;
    }

    public void setAuthorithy(String authorithy) {
        this.authorithy = authorithy;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (authorithy != null ? !authorithy.equals(account.authorithy) : account.authorithy != null) return false;
        if (describes != null ? !describes.equals(account.describes) : account.describes != null) return false;
        if (englishName != null ? !englishName.equals(account.englishName) : account.englishName != null) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (loginCount != null ? !loginCount.equals(account.loginCount) : account.loginCount != null) return false;
        if (loginIp != null ? !loginIp.equals(account.loginIp) : account.loginIp != null) return false;
        if (loginTime != null ? !loginTime.equals(account.loginTime) : account.loginTime != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (qq != null ? !qq.equals(account.qq) : account.qq != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (englishName != null ? englishName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (loginCount != null ? loginCount.hashCode() : 0);
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (qq != null ? qq.hashCode() : 0);
        result = 31 * result + (describes != null ? describes.hashCode() : 0);
        result = 31 * result + (authorithy != null ? authorithy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", englishName='" + englishName + '\'' +
                ", password='" + password + '\'' +
                ", loginCount=" + loginCount +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", qq='" + qq + '\'' +
                ", describes='" + describes + '\'' +
                ", authorithy='" + authorithy + '\'' +
                '}';
    }
}
