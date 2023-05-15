package com.apple.bank.service;

import com.apple.bank.exception.MoneyNotEnoughException;
import com.apple.bank.exception.transferException;

import java.io.IOException;

/**
 * 账户业务类，业务方法中的名字最好见名知意
 *
 * @version 1.0
 * @ author Egcoo
 * @ date 2023/4/28 - 14:23
 */
public interface AccountService {
    /**
     * 转账
     *
     * @param fromAccount 转出账户
     * @param toAccount   转入账户
     * @param money       转出金额
     */
    void transfer(String fromAccount, String toAccount, double money) throws IOException, MoneyNotEnoughException, transferException;


}
