package com.apple.bank.dao;

import com.apple.bank.pojo.Account;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/4/29 - 14:00
 * <p>
 * 账户的account对象，负责t_act表中的增删改查
 * DAO对象中的任何一个方法和业务不挂钩，没有任何业务逻辑在里面
 * DAO中的方法是做CRUD的，所以方法的名大部分是：insertXXX deleteXXX updateXXX selectXXX
 */
public interface AccountDao {

    /**
     * 根据账号查询账户信息
     *
     * @param actno
     * @return
     */
    Account selectByActno(String actno) throws IOException;

    /**
     * 更新账户信息
     *
     * @param account
     * @return
     */
    int updateByActno(Account account) throws IOException;


}
