package com.wipe.healthy.service.biz;

import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 *用户信息业务服务层
 * User:Created by wei.li
 * Date: on 2016/3/1.
 * Time:21:17
 */
@Service
public class UserBiz {
    @Resource
    IUserService userService;

    /**
     * 用户信息新增
     * @param user 用户信息
     * @return
     */
    public Integer create(User user){
        return userService.create(user);
    }

    /**
     * 通过id查找用户信息
     * @param id 主键id
     * @return 用户信息
     */
    public User findById(Integer id){
        return userService.findById(id);
    }
    /**
     * 删除用户信息
     * @param id 用户信息主键
     * @return 删除结果（true/false）
     */
    public Boolean delete(Integer id){
        return userService.delete(id);
    }
    /**
     * 修改用户信息
     * @param user 用户信息
     * @return 更新结果（true/false）
     */
    public Boolean update(User user){
        return userService.update(user);
    }
    /**
     * 用户信息列表
     * @return 用户信息列表
     */
    public List<User> list(){
        return userService.list(new HashMap<String, Object>());
    }


}
