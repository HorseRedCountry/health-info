package com.wipe.healthy.service.biz;

import com.wipe.healthy.core.model.Account;
import com.wipe.healthy.core.service.IAccountService;
import com.wipe.healty.common.utils.EncryptUtil;
import com.wipe.healty.common.utils.HttpUtils;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 账户业务服务层
 * User:Created by wei.li
 * Date: on 2016/3/2.
 * Time:11:32
 */

@Service
public class AccountBiz {
    @Resource
    IAccountService accountService;

    /**
     * 账户信息新增
     * @param account 账户信息
     * @return 新增账户主键
     */
    public Integer create(Account account)throws RuntimeException{
        boolean isRegister = this.isRegister(account);
        if (isRegister){
            throw new RuntimeException("改账号已经被注册");
        }
        String password = EncryptUtil.MD5Hex(account.getPassword());
        account.setPassword(password);
        account.setLoginCount(0);
        return  accountService.create(account);
    }

    /**
     * 账户信息修改
     * @param account 账户信息
     * @return 修改结果（true/false）
     */
    public Boolean update(Account account) throws RuntimeException{
        boolean isRegister = this.isRegister(account);
        if (isRegister){
            throw new RuntimeException("改账号已经被注册");
        }
        Account dbAccount = accountService.findById(account.getId());
        if (!dbAccount.getPassword().equals(account.getPassword())){
            EncryptUtil.MD5Hex(account.getPassword());
            String password = EncryptUtil.MD5Hex(account.getPassword());
            account.setPassword(password);
        }
        return accountService.update(account);
    }

    /**
     * 账户信息删除
     * @param id 账户信息主键
     * @return 删除结果（true/false）
     */
    public Boolean delete(Integer id){
        return accountService.delete(id);
    }

    /**
     * 根据主键查找账户信息
     * @param id 账户主键
     * @return 账户信息
     */
    public Account findById(Integer id){
        return accountService.findById(id);
    }


    /**
     * 根据条件查询账户信息
     * @param query 查询条件
     * @return 账户信息列表
     */
    public List<Account> list(Map<String,Object> query){
        return accountService.list(query);
    }

    /**
     * 根据id集合查找账户信息
     * @param ids 主键集合
     * @return 账户信息列表
     */
    public List<Account> batchQuery(Set<Integer> ids){
        return accountService.batchQuery(ids);
    }


    /**
     * 登陆验证方法
     * @param account 账户信息
     * @return 是否成功（true/false）
     */
    public boolean login(Account account) throws Exception{
        Account dbAccount = null;

        dbAccount = accountService.findByName(account.getEnglishName());
        if (dbAccount == null){
            throw new Exception("账号不存在");
        }
        String enctrPassword = EncryptUtil.MD5Hex(account.getPassword());
        if(dbAccount.getPassword().equals(enctrPassword)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 写入登陆参数
     * @param account 登陆账号
     * @param request 请求参数
     */
    public void loginWrite(Account account,HttpServletRequest request){
        //写入数据库
        Account dbAccount = accountService.findByName(account.getEnglishName());
        dbAccount.setLoginCount(dbAccount.getLoginCount()+1);
        dbAccount.setLoginTime(new Date());
        dbAccount.setLoginIp(HttpUtils.getRemoteAddress(request));
        accountService.update(account);

        //写入session
        HttpSession session = request.getSession();
        session.setAttribute("account",dbAccount);
    }


    /**
     * 判断账号是否被注册
     * @param account 账户信息
     * @return true/false
     */
    public boolean isRegister(Account account){
        try {
            accountService.findByName(account.getEnglishName());
        } catch (TooManyResultsException te) {
          return true;
        }
        return false;
    }
}
