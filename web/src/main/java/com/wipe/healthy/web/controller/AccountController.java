package com.wipe.healthy.web.controller;

import org.slf4j.Logger;
import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.service.biz.AccountBiz;
import com.wipe.healthy.web.dto.AccountInput;
import com.wipe.healthy.web.dto.AjaxResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 账号控制器
 * User:Created by wei.li
 * Date: on 2016/3/2.
 * Time:11:39
 */

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    AccountBiz accountBiz;

    public String getRoutePath() {
        return "../page/account/";
    }
    protected static Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     * 账号新增
     * @param accountInput 账号输入视图
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create")
    public AjaxResult create(AccountInput accountInput){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            accountBiz.create(accountInput.convertToAccount());
            ajaxResult.setDescription("新增账户成功");
            ajaxResult.setSuccess(true);
        }catch (RuntimeException re){
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription(re.getMessage());
            logger.error("新增账户异常",re);
        }
        catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("新增账户异常");
            logger.error("新增账户异常",e);
        }
      return ajaxResult;
    }

    /**
     * 更新账号信息
     * @param accountInput
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modify")
    public AjaxResult modify(AccountInput accountInput){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            accountBiz.update(accountInput.convertToAccount());
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("修改账户成功");
        }catch (RuntimeException re){
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription(re.getMessage());
            logger.error("新增账户异常",re);
        }
        catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("修改账户异常");
            logger.error("修改账户异常",e);
        }
        return ajaxResult;
    }

    private final String modifyShowViewName = "/modify";

    /**
     * 账户修改视图
     * @param id 账户主键
     * @return 修改视图
     */
    @RequestMapping(value = "/modifyShow",method = RequestMethod.GET)
    public ModelAndView modifyShow(Integer id){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+modifyShowViewName);
        Account account = accountBiz.findById(id);
        modelAndView.addObject("account",account);
        return modelAndView;
    }

    private final String viewShowViewName = "/view";

    /**
     * 详情查询视图
     * @param id 账户主键
     * @return 详情视图
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(Integer id){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+viewShowViewName);
        Account account = accountBiz.findById(id);
        modelAndView.addObject("account",account);
        return modelAndView;
    }
    /**
     * 删除账户信息
     * @param id 主键
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public AjaxResult delete(Integer id){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            accountBiz.delete(id);
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("删除账户成功");
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("删除账户异常");
            logger.error("删除账户异常",e);
        }
        return ajaxResult;
    }

    private final String listViewName = "list";
    /**
     * 查询账户列表
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView(getRoutePath()+listViewName);
        List<Account> accountList = accountBiz.list(new HashMap<String, Object>());
        modelAndView.addObject(accountList);
        return modelAndView;
    }
}
