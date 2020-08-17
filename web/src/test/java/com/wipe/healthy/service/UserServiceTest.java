package com.wipe.healthy.service;

import com.wipe.healthy.BaseTest;
import com.wipe.healthy.core.model.User;
import com.wipe.healthy.core.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 用户信息服务测试单元
 * User:Created by wei.li
 * Date: on 2015/12/9.
 * Time:9:17
 */
public class UserServiceTest extends BaseTest{

    @Autowired
    IUserService userService;

    @Test
    public void testCreate(){
        User user = create();
        Integer id = userService.create(user);
        System.out.print(id);
    }


    @Test
    public void testFindById(){
        User user = userService.findById(6);
        System.out.print(user.toString());
    }

    private User create(){
        User user = new User();
        user.setBirthday(new Date());
        user.setFoodHabits(2);
        user.setHeartRate(2F);
        user.setHeight(3F);
        user.setMajor("test");
        return user;
    }
}
