package com.wipe.healthy.web.controller;

import com.google.common.collect.ArrayListMultimap;
import com.wipe.healthy.service.biz.ChartBiz;
import com.wipe.healthy.web.dto.AjaxResult;
import com.wipe.healthy.web.dto.PieChartOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 图表控制层
 * User:Created by wei.li
 * Date: on 2016/3/15.
 * Time:15:27
 */
@Controller
@RequestMapping(value = "/chart/")
public class ChartController {
    @Resource
    ChartBiz chartBiz;


    /**
     * 体重-肺活量/心率图表视图
     * @return 输出视图
     */
    @ResponseBody
    @RequestMapping(value = "weightVPulmonary")
    public AjaxResult weightVPulmonary(){
        AjaxResult ajaxResult = new AjaxResult(true);
        ArrayListMultimap multimap = chartBiz.weightVPulmonary();
        Map<String,Float> map = multimap.asMap();
        ajaxResult.setData(map);
        return ajaxResult;
    }

    /**
     * 时间-卡路里视图
     * @return输出视图
     */
    @ResponseBody
    @RequestMapping(value = "dateVCalorie")
    public AjaxResult dateVCalorie(){
        AjaxResult ajaxResult = new AjaxResult(true);
        List<Map> maps = chartBiz.dateVCalorie();
        ajaxResult.setData(maps);
        return ajaxResult;
    }

    /**
     * 运动类型饼状图
     * @return 输出视图
     */
    @ResponseBody
    @RequestMapping(value = "SportType")
    public AjaxResult SportType(){
        AjaxResult ajaxResult = new AjaxResult(true);
        List<PieChartOutput> list = chartBiz.SportType();
        ajaxResult.setData(list);
        return ajaxResult;
    }
}
