package com.wipe.healthy.web.dto;

import com.wipe.healthy.core.model.Account;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 账户信息输入视图
 * User:Created by wei.li
 * Date: on 2016/3/2.
 * Time:11:37
 */
public class AccountInput {
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

    /**联系  QQ **/
    private String qq;

    /**描叙信息**/
    private String describes;

    /** 前台验证码 */
    private String verification;

    /** 最后登陆时间 **/
    private Date loginTime;

    /**用户授权信息**/
    private String authorithy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public Account convertToAccount(){
        Account account = new Account();
        BeanUtils.copyProperties(this,account);
        return account;
    }
}
