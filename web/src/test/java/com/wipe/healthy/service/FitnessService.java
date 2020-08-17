package com.wipe.healthy.service;

import com.wipe.healthy.BaseTest;
import com.wipe.healthy.core.model.ActionInfo;
import com.wipe.healthy.core.model.FitnessAction;
import com.wipe.healthy.service.biz.FitnessBiz;
import com.wipe.healthy.web.dto.FitnessOutput;
import org.junit.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User:Created by wei.li
 * Date: on 2016/3/16.
 * Time:16:42
 * To change this template use File | Settings | File and Code Templates.
 */
public class FitnessService extends BaseTest {
    @Autowired
    FitnessBiz fitnessBiz;


    @org.junit.Test
    public void test(){
        FitnessAction fitnessAction = new FitnessAction();
        fitnessAction.setStyle(1);
        fitnessAction.setFitPeople("老人");
        fitnessAction.setCalorie(123f);
        fitnessAction.setActionName("運動");

        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setWeather(11);
        actionInfo.setTemperature(11f);
        actionInfo.setData(new Date());
        actionInfo.setBeginTime(new Time(1235));
        actionInfo.setEndTime(new Time(1523));

        fitnessBiz.create(fitnessAction,actionInfo);
    }

    @Test
    public void list(){
        List<FitnessOutput> list = fitnessBiz.list();
        System.out.println(list);
    }
}
