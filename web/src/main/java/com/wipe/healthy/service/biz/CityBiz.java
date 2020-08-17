package com.wipe.healthy.service.biz;

import com.google.common.collect.Lists;
import com.wipe.healthy.constant.Constant;
import com.wipe.healthy.core.model.City;
import com.wipe.healthy.core.service.ICityService;
import com.wipe.healthy.web.dto.NodesOutput;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 城市业务服务层
 * User:Created by wei.li
 * Date: on 2015/12/22.
 * Time:23:11
 */

@Service
public class CityBiz {
    @Resource
    ICityService cityService;

    /**
     * 查询城市信息 并封装成树形结构
     * @return 树形结构数据
     */
    public List<NodesOutput> list(){
        List<City> cityList = cityService.list(null);
        //封装成树形结构
        return this.cityToTree(cityList);
    }


    /**
     * 把城市列表转化成树形结构
     * @param cityList 城市列表信息
     * @return 树形结构信息
     */
    public List<NodesOutput> cityToTree(List<City> cityList){
        List<NodesOutput> nodesOutputList = Lists.newArrayList();
        for (City city : cityList){
            if (city.getParentId().equals(0)){
                NodesOutput nodesOutput = new NodesOutput();
                nodesOutput.setId(city.getId());
                nodesOutput.setText(city.getName());
                //添加叶子节点
                nodesOutput.setNodes(this.addLeaf(city.getLeaf(),city.getId(),cityList));
                nodesOutputList.add(nodesOutput);
            }
        }
        return nodesOutputList;
    }

    /**
     * 递归添加子节点
     * @param leaf 是否叶子节点
     * @param parentId 父级id
     * @param cityList 城市列表
     * @return 节点列表
     */
    public List<NodesOutput> addLeaf(Integer leaf,Integer parentId,List<City> cityList){
       List<NodesOutput> nodesOutputList =Lists.newArrayList();
        if (leaf.equals(Constant.OWN_LEAF)){
            for (City city : cityList){
                if (city.getParentId().equals(parentId)){
                    NodesOutput nodesOutput = new NodesOutput();
                    nodesOutput.setText(city.getName());
                    nodesOutput.setId(city.getId());
                    List<NodesOutput> nodesOutputListOut = this.addLeaf(city.getLeaf(),city.getId(),cityList);
                    if(!CollectionUtils.isEmpty(nodesOutputListOut)){
                        nodesOutput.setNodes(nodesOutputListOut);
                    }
                   else {
                        //转json时需要忽略节点
                        nodesOutput.setNodes(null);
                    }
                    nodesOutputList.add(nodesOutput);
                }
            }
        }
        return nodesOutputList;
    }
}
