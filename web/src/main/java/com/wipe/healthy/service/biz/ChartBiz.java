package com.wipe.healthy.service.biz;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.wipe.healthy.constant.Constant;
import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IActionInfoService;
import com.wipe.healthy.core.service.IFitnessActionService;
import com.wipe.healthy.core.service.IUserService;
import com.wipe.healthy.web.dto.LineChartOutput;
import com.wipe.healthy.web.dto.PieChartOutput;
import com.wipe.healty.common.utils.AlgorithmUtils;
import com.wipe.healty.common.utils.DateUtils;
import com.wipe.healty.common.utils.LangUtils;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 图表服务层
 * User:Created by wei.li
 * Date: on 2016/3/14.
 * Time:13:50
 */

@Service
public class ChartBiz {

    @Resource
    IFitnessActionService fitnessActionService;

    @Resource
    IActionInfoService actionInfoService;

    @Resource
    IUserService userService;

    /**
     * 拼接 肺活量V图表数据
     * @return 肺活量V图表数据
     */
    public ArrayListMultimap pulmonaryVCalorie(){
        ArrayListMultimap multimap = ArrayListMultimap.create();
        List<Float> calorieFilterList = this.evaluationCalorie();
        multimap.putAll("calorieList",calorieFilterList);
        return multimap;
    }


    /**
     * 拼接 体重-肺活量/心率图表数据
     * @return 体重-肺活量/心率图表数据
     */
    public ArrayListMultimap weightVPulmonary(){
        ArrayListMultimap multimap = ArrayListMultimap.create();
        List<Float> weightList = this.evaluationWeight();
        List<Float> pulmonaryList = this.evaluationPulmonary();
        List<Float> heartRateList = this.evaluationHeartRate();
        multimap.putAll("weightList",weightList);
        multimap.putAll("pulmonaryList",pulmonaryList);
        multimap.putAll("heartRateList",heartRateList);
        return multimap;
    }

    /**
     * 拼接 时间-卡路里图表数据
     * @return 拼接 时间-卡路里图表数据
     */
    public List dateVCalorie(){
        List<LineChartOutput> list = Lists.newArrayList();
        List<ActionInfo> actionInfoList = actionInfoService.list(new HashMap<String, Object>());
       for (ActionInfo actionInfo : actionInfoList){
           List<Object> valueList = Lists.newArrayList();
           LineChartOutput lineChartOutput = new LineChartOutput();
           FitnessAction fitnessAction = fitnessActionService.findById(actionInfo.getId());
           valueList.add(DateUtils.formatDate(actionInfo.getData()));
           valueList.add(fitnessAction.getCalorie());
           lineChartOutput.setName(actionInfo.getData().toString());
           lineChartOutput.setValue(valueList);
           list.add(lineChartOutput);
       }
        return list;
    }

    /**
     * 运动类型饼状图
     * @return 运动类型饼状图数据
     */
    public List SportType(){
        List<FitnessAction> aerobic = fitnessActionService.list(Constant.aerobic);
        List<FitnessAction> anaerobic = fitnessActionService.list(Constant.anaerobic);
        List<FitnessAction> endurance = fitnessActionService.list(Constant.endurance);
        PieChartOutput pieChartAerobic = new PieChartOutput(aerobic.size(),"有氧运动");
        PieChartOutput pieChartAnaerobic = new PieChartOutput(anaerobic.size(),"无氧运动");
        PieChartOutput pieChartEndurance = new PieChartOutput(endurance.size(),"耐力运动");
        return Lists.newArrayList(pieChartAerobic,pieChartAnaerobic,pieChartEndurance);
    }
    /**
     * 卡路里过滤取值
     * @return list
     */
    public List<Float> evaluationCalorie(){
        List<FitnessAction> fitnessActionList = fitnessActionService.list(new HashMap<String, Object>());
        final List<Float> calorieList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(fitnessActionList)){
            for (FitnessAction fitnessAction : fitnessActionList){
                calorieList.add(fitnessAction.getCalorie());
            }
        }
        //过滤取值
        List<Float> calorieFilterList = LangUtils.filter(calorieList, new Predicate<Float>() {
            @Override
            public boolean apply(Float input) {
                Float max = Collections.max(calorieList);
                Float min = Collections.min(calorieList);
                for (int i = 0; i < Constant.CHART_Y_NUM; i++) {
                    float targetNum = (max - min) / Constant.CHART_Y_NUM * (i + 1);
                    float result = AlgorithmUtils.approach(calorieList, targetNum);
                    if (input.equals(result)) {
                        return true;
                    }
                }
                return false;
            }
        });
        return calorieFilterList;
    }


    /**
     * 体重过滤
     * @return list
     */
    public List<Float> evaluationWeight(){
        List<User> userList = userService.list(new HashMap<String, Object>());
        List<Float> weightFilterList = Lists.newArrayList();
        final List<Float> weightList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(userList)){
            for (User user : userList){
                weightList.add(user.getWeight());
            }

            Float max = Collections.max(weightList);
            Float min = Collections.min(weightList);
            for (int i = 0; i<Constant.CHART_Y_NUM;i++){
                float targetNum = (max - min) / Constant.CHART_Y_NUM * (i + 1);
                float result = AlgorithmUtils.approach(weightList, targetNum);
                weightFilterList.add(result);
            }
        }

        return weightFilterList;
    }


    /**
     * 肺活量过滤
     * @return list
     */
    public List<Float> evaluationPulmonary(){
        List<Float> heightFilterList = Lists.newArrayList();
        List<User> userList = userService.list(new HashMap<String, Object>());
        final List<Float> pulmonaryList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(userList)){
            for (User user : userList){
                pulmonaryList.add(user.getPulmonary());
            }
            Float max = Collections.max(pulmonaryList);
            Float min = Collections.min(pulmonaryList);
            for (int i = 0; i<Constant.CHART_X_NUM;i++){
                float targetNum = (max - min) / Constant.CHART_X_NUM * (i + 1);
                float result = AlgorithmUtils.approach(pulmonaryList, targetNum);
                heightFilterList.add(result);
            }
        }

        return heightFilterList;
    }

    /**
     * 心率过滤
     * @return list
     */
    public List<Float> evaluationHeartRate(){
        List<User> userList = userService.list(new HashMap<String, Object>());
        final List<Float> heartRateList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(userList)){
            for (User user : userList){
                heartRateList.add(user.getHeartRate());
            }
        }

        List<Float> heightFilterList = Lists.newArrayList();
        Float max = Collections.max(heartRateList);
        Float min = Collections.min(heartRateList);
        for (int i = 0; i<Constant.CHART_X_NUM;i++){
            float targetNum = (max - min) / Constant.CHART_X_NUM * (i + 1);
            float result = AlgorithmUtils.approach(heartRateList, targetNum);
            heightFilterList.add(result);
        }

        return heightFilterList;
    }


}
