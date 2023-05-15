package com.apple.bank.service.impl;

import com.apple.bank.dao.AccountDao;
import com.apple.bank.exception.MoneyNotEnoughException;
import com.apple.bank.exception.transferException;
import com.apple.bank.pojo.Account;
import com.apple.bank.service.AccountService;
import com.apple.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/4/28 - 14:26
 */
public class AccountServiceImpl implements AccountService {

    //private AccountDao accountDao;

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    // 使用mybatis中的面向接口的动态代理机制
    private AccountDao accountDao = SqlSessionUtil.openSqlSession().getMapper(AccountDao.class);

    public AccountServiceImpl() throws IOException {
    }

    //public AccountServiceImpl() {
    //    this.accountDao = new AccountDaoImpl();
    //}


    @Override
    public void transfer(String fromActno, String toActno, double money) throws IOException, MoneyNotEnoughException, transferException {
        logger.info("Executing transfer method with fromActno: {}, toActno: {}, money: {}", fromActno, toActno, money);

        // 添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();

        // 1. 判断转出账户的余额是否充足（select)
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            // 2. 如果转出账户余额不足，提示用户
            throw new MoneyNotEnoughException("转出账户余额不足!");
        }
        // 3. 如果转出账户余额充足，更新转出账户余额
        // 3.1先更新内存中java对象中的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        // 3.2上面只是更新内存，这里才是更新数据库
        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);
        // 4. 更新转入账户余额（update）
        if (count != 2) {
            throw new transferException("转账失败!");
        }

        // 提交事务，关闭事务
        sqlSession.commit();
        SqlSessionUtil.closeSqlSession(sqlSession);

    }
}
