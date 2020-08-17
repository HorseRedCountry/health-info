package com.wipe.healthy.service.biz;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IActionInfoService;
import com.wipe.healthy.core.service.IFitnessActionService;
import com.wipe.healthy.core.service.IUserService;
import com.wipe.healthy.web.dto.FitnessOutput;
import com.wipe.healty.common.utils.LangUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 健身行为服务层
 * User:Created by wei.li
 * Date: on 2016/3/2.
 * Time:12:00
 */
@Service
public class FitnessBiz {
    @Resource
    IFitnessActionService fitnessActionService;

    @Resource
    IActionInfoService actionInfoService;

    @Resource
    IUserService userService;
    /**
     * 健身行为信息新增
     * @param fitnessAction 健身行为
     * @return 新增健身信息主键
     */

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    public boolean create(FitnessAction fitnessAction,ActionInfo actionInfo){
        this.fitnessActionService.create(fitnessAction);
        actionInfo.setActionId(fitnessAction.getId());
        this.actionInfoService.create(actionInfo);
        return true;
    }

    /**
     * 修改健身行为信息
     * @param fitnessAction 健身行为信息
     * @return 修改结果（true/false）
     */
    @Transactional
    public Boolean update(FitnessAction fitnessAction ,ActionInfo actionInfo){
        this.fitnessActionService.update(fitnessAction);
        this.actionInfoService.update(actionInfo);
        return true;
    }

    /**
     * 删除健身信息行为
     * @param actionId 健身行为信息主键
     * @return 删除结果（true/false）
     */
    @Transactional
    public Boolean delete(Integer actionId){
        ActionInfo actionInfo = actionInfoService.findById(actionId);
        this.actionInfoService.delete(actionInfo.getActionId());
        this.fitnessActionService.delete(actionId);
        return true;
    }

    /**
     * 根据infoId查找健身信息
     * @param infoId 健身信息主键
     * @return 健身信息输出视图
     */
    public FitnessOutput findById(Integer infoId){
        ActionInfo actionInfo = this.actionInfoService.findById(infoId);
        FitnessAction fitnessAction = this.fitnessActionService.findById(actionInfo.getActionId());
        FitnessOutput fitnessOutput = FitnessOutput.from(fitnessAction,actionInfo);
        User user = userService.findById(actionInfo.getUserId());
        fitnessOutput.setUserId(user.getId());
        fitnessOutput.setUserName(user.getName());
        return fitnessOutput;
    }


    /**
     * 返回健身信息列表
     * @return 健身信息列表
     */
    public List<FitnessOutput> list(Map<String,Object> query){
        List<ActionInfo> actionInfoList = this.actionInfoService.list(query);
        List<FitnessOutput> outputList = LangUtils.transform(actionInfoList, new Function<ActionInfo, FitnessOutput>() {
            @Override
            public FitnessOutput apply(ActionInfo input) {
                FitnessAction fitnessAction = fitnessActionService.findById(input.getActionId());
                return FitnessOutput.from(fitnessAction,input);
            }
        });

        if (CollectionUtils.isEmpty(outputList)){
            return Collections.emptyList();
        }
        return outputList;
    }

    /**
     * 返回健身信息列表
     * @return 健身信息列表
     */
    public List<FitnessOutput> list(){
        return  this.list(new HashMap<String, Object>());
    }

    /**
     * 返回健身信息列表
     * @return 健身信息列表
     */
    public List<FitnessOutput> list(Integer userId){
        Map<String,Object> query = Maps.newHashMap();
        query.put("userId",userId);
        return  this.list(query);
    }
}
