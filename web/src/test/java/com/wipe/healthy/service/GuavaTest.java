package com.wipe.healthy.service;

import com.google.common.base.Predicate;
import com.google.common.cache.*;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.wipe.healthy.core.model.User;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User:Created by wei.li
 * Date: on 2015/12/14.
 * Time:11:25
 * To change this template use File | Settings | File and Code Templates.
 */
public class GuavaTest {

    @Test
    public void compare(){
        int result = Ints.compare(4,1);
        System.out.print(result);
    }

    @Test
    public void predicate(){
        User user1 = new User();
        User user2 = new User();
        user1.setSex(1);
        user2.setSex(2);
        List<User> list = Lists.newArrayList(user1,user2);
        ImmutableMultiset<User> set =  ImmutableMultiset.copyOf(Collections2.filter(list, new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return input.getSex().equals(1);
            }
        }));

        System.out.print(set);
    }


    /**
     * 缓存单元测试
     */
    @Test
    public void cache(){
        LoadingCache<Integer,Integer> loadingCache
                = CacheBuilder.newBuilder().concurrencyLevel(8).expireAfterWrite(8, TimeUnit.SECONDS)
                .initialCapacity(10).maximumSize(100)
                .recordStats().removalListener(new RemovalListener<Object, Object>() {

                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                }).build(
                        new CacheLoader<Integer, Integer>() {
                            @Override
                            public Integer load(Integer key) throws Exception {
                                System.out.println("load key " + key);
                                return key;
                            }
                        }
                );
        for (int i=0;i<20;i++){
            try {
                Integer result = loadingCache.get(1);
                System.out.println(result);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
