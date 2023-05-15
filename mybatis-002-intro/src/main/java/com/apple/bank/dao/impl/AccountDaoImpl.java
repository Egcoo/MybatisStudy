package com.apple.bank.dao.impl;

import com.apple.bank.dao.AccountDao;
import com.apple.bank.pojo.Account;
import com.apple.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/4/29 - 14:07
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Account account = sqlSession.selectOne("com.apple.bank.dao.AccountDao.selectByActno", actno);

        return account;
    }

    @Override
    public int updateByActno(Account account) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.update("com.apple.bank.dao.AccountDao.updateByActno", account);
        return count;
    }
}
