package com.wipe.healthy.web.controller;

import com.google.common.base.Strings;
import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.service.biz.AccountBiz;
import com.wipe.healthy.web.dto.AccountInput;
import com.wipe.healthy.web.dto.AjaxResult;
import com.wipe.healthy.web.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆控制器
 * User:Created by wei.li
 * Date: on 2016/3/11.
 * Time:14:06
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Resource
    AccountBiz accountBiz;

    public String getRoutePath() {
        return "/../";
    }
    /**
     * 登陆验证控制器
     * @param accountInput 账户信息
     * @param request 请求参数
     * @return 登陆结果
     */
    @ResponseBody
    @RequestMapping(value ="/login")
    public AjaxResult login(AccountInput accountInput,
                            HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult(false);
        if (Strings.isNullOrEmpty(accountInput.getEnglishName())){
            ajaxResult.setDescription("请输入登陆账号");
            return ajaxResult;
        }
        else if (Strings.isNullOrEmpty(accountInput.getPassword())){
            ajaxResult.setDescription("请输入密码");
            return ajaxResult;
        }
        else if (Strings.isNullOrEmpty(accountInput.getVerification())){
            ajaxResult.setDescription("请输入验证码");
            return ajaxResult;
        }

        //判断验证码
        HttpSession session = request.getSession();
        String verification = (String)session.getAttribute("captchaToken");
        if (!verification.equalsIgnoreCase(accountInput.getVerification())){
            ajaxResult.setDescription("验证码错误");
            return ajaxResult;
        }
        //比较登陆密码
        boolean result = false;
        try {
            result = accountBiz.login(accountInput.convertToAccount());
        } catch (Exception e) {
            ajaxResult.setDescription(e.getMessage());
            return ajaxResult;
        }
        if (!result){
            ajaxResult.setDescription("账号密码不匹配");
            return ajaxResult;
        } else {
            accountBiz.loginWrite(accountInput.convertToAccount(),request);
            ajaxResult.setSuccess(true);
        }
        return ajaxResult;
    }


    /**
     * 功能权限控制
     * @param request 请求参数
     * @return 主页
     */
    @ResponseBody
    @RequestMapping(value = "/authorithy")
    public AjaxResult authorithy(HttpServletRequest request){
        Account loginAccount = SessionUtils.getAccount(request);
        AjaxResult ajaxResult = new AjaxResult(true);
        Account account = accountBiz.findById(loginAccount.getId());
        ajaxResult.setData(account.getAuthorithy());
        return ajaxResult;
    }
    private final String loginOutViewName = "login";

    /**
     * 退出登陆
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/loginOut")
    public ModelAndView loginOut(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+loginOutViewName);
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        return modelAndView;
    }
}
