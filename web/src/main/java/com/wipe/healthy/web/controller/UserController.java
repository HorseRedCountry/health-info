package com.wipe.healthy.web.controller;

import com.google.common.collect.Lists;
import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IUserService;
import com.wipe.healthy.service.biz.UserBiz;
import com.wipe.healthy.web.dto.AjaxResult;
import com.wipe.healthy.web.dto.UserInput;
import com.wipe.healthy.web.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户信息控制器
 * User:Created by wei.li
 * Date: on 2016/3/1.
 * Time:21:03
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    UserBiz userBiz;
    @Resource
    IUserService userService;

    public String getRoutePath() {
        return "../page/user/";
    }


    /**
     * 用户信息新增
     * @param userInput 用户信息输入视图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public AjaxResult create(UserInput userInput,HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult(true);
        Account account = SessionUtils.getAccount(request);
        User user = userInput.convertToUser(userInput);
        user.setAccountId(account.getId());
        userBiz.create(user);
        ajaxResult.setDescription("新增用户成功");
        return ajaxResult;
    }


    private final String modifyShowViewName = "modify";
    /**
     * 用户信息修改查询
     * @param id 用户信息id
     * @return 用户信息修改视图
     */
    @RequestMapping(value = "/modifyShow",method = RequestMethod.GET)
    public ModelAndView modifyShow(Integer id){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+modifyShowViewName);
        User user = userBiz.findById(id);
        modelAndView.addObject(user);
        return modelAndView;
    }

    /**
     * 用户信息修改
     * @param userInput 用户信息输入视图
     * @return 异步数据
     */
    @ResponseBody
    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public AjaxResult modify(UserInput userInput){
        AjaxResult ajaxResult = new AjaxResult();
        boolean result = userBiz.update(userInput.convertToUser(userInput));
        if (!result){
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("修改用户信息失败");
        }else {
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("修改用户信息成功");
        }
        return ajaxResult;
    }

    private final String viewViewName = "view";

    /**
     * 个人信息查询
     * @param id 主键
     * @return 个人信息查看视图
     */
    @RequestMapping(value = "/view",method = RequestMethod.GET)
    public ModelAndView view(Integer id){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+viewViewName);
        User user = userBiz.findById(id);
        modelAndView.addObject(user);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public AjaxResult delete(Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        boolean result = userBiz.delete(id);
        if (result){
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("删除用户信息成功");
        }else {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("删除用户信息异常");
        }
        return ajaxResult;
    }

    private final String listViewName = "list";
    /**
     * 用户列表查询
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request){
        Account account = SessionUtils.getAccount(request);
        List<User> userList;
        //判断用户角色
        if (account != null && account.getAuthorithy().equals("user")){
            User user = userService.findByAccountId(account.getId());
            userList = Lists.newArrayList(user);
        }else {
            userList = userBiz.list();
        }
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+listViewName);
        modelAndView.addObject("userList",userList);
        return modelAndView;
    }
}
