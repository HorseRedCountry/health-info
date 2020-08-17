package com.wipe.healthy.web.controller;

import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IUserService;
import com.wipe.healthy.service.biz.FitnessBiz;
import com.wipe.healthy.web.dto.AjaxResult;
import com.wipe.healthy.web.dto.FitnessInput;
import com.wipe.healthy.web.dto.FitnessOutput;
import com.wipe.healthy.web.utils.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * 健身信息控制层
 * User:Created by wei.li
 * Date: on 2016/3/14.
 * Time:23:28
 */
@Controller
@RequestMapping(value = "/fitness")
public class FitnessController {
    @Resource
    FitnessBiz fitnessBiz;
    @Resource
    IUserService userService;

    protected static Logger logger = LoggerFactory.getLogger(FitnessController.class);


    public String getRoutePath() {
        return "../page/fitness/";
    }
    /**
     * 新增健身信息
     * @param fitnessInput 健身信息输入视图
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping(value ="/create" )
    public AjaxResult create(FitnessInput fitnessInput,HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        Account account = SessionUtils.getAccount(request);
        User user = userService.findByAccountId(account.getId());
        fitnessInput.setUserId(user.getId());
        try {
            fitnessBiz.create(fitnessInput.convertToFitnessAction(),
                    fitnessInput.convertToActionInfo());
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("新增健身信息成功");
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("新增健身信息异常");
            logger.error("新增健身信息异常",e);
        }
        return ajaxResult;
    }

    private final String modifyShowViewName = "modify";

    /**
     * 健身信息修改查询
     * @param id 信息主键
     * @return 修改视图
     */
    @RequestMapping(value = "/modifyShow",method = RequestMethod.GET)
    public ModelAndView modifyShow(Integer id){
        ModelAndView modelAndView = new ModelAndView(this.getRoutePath()+modifyShowViewName);
        FitnessOutput fitnessOutput = fitnessBiz.findById(id);
        modelAndView.addObject("fitness",fitnessOutput);
        return modelAndView;
    }
    /**
     * 修改健身信息
     * @param fitnessInput 健身信息输入视图
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping(value = "/modify")
    public AjaxResult modify(FitnessInput fitnessInput){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            fitnessBiz.update(fitnessInput.convertToFitnessAction(),
                    fitnessInput.convertToActionInfo());
            ajaxResult.setSuccess(true);
            ajaxResult.setDescription("修改健身信息成功");
        } catch (Exception e) {
            ajaxResult.setSuccess(false);
            ajaxResult.setDescription("修改健身信息异常");
            logger.error("修改健身信息异常",e);
        }
        return ajaxResult;
    }

    private final String viewViewName = "view";
    /**
     * 健身信息查看
     * @param id 健身信息主键
     * @return 查询视图
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(Integer id){
        ModelAndView modelAndView = new ModelAndView(this.getRoutePath()+viewViewName);
        FitnessOutput fitnessOutput = fitnessBiz.findById(id);
        modelAndView.addObject("fitness",fitnessOutput);
        return modelAndView;
    }


    private final String listViewName = "list";
    /**
     *健身信息列表查询
     * @return 查询列表
     */

    @RequestMapping(value = "/list")
    public ModelAndView list(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView(this.getRoutePath()+listViewName);
        Account account = SessionUtils.getAccount(request);
        List<FitnessOutput> fitnessOutputList;
        if (account != null&& account.getAuthorithy().equals("user")){
            User user = userService.findByAccountId(account.getId());
            if (user == null){
                modelAndView.addObject("list",Collections.emptyList());
                return modelAndView;
            }
            fitnessOutputList = fitnessBiz.list(user.getId());
        }else {
            fitnessOutputList = fitnessBiz.list();
        }

        modelAndView.addObject("list",fitnessOutputList);
        return modelAndView;
    }

    /**
     * 删除健身信息
     * @param actionId 健身信息异常
     * @return 删除结果(true/false)
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public AjaxResult delete(Integer actionId){
        AjaxResult ajaxResult = new AjaxResult();
        try {
            fitnessBiz.delete(actionId);
            ajaxResult.setDescription("删除健身信息成功");
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            ajaxResult.setDescription("删除健身信息异常");
            ajaxResult.setSuccess(false);
           logger.error("删除健身信息异常",e);
        }
        return ajaxResult;
    }
}
