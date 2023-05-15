package com.apple.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/4/23 - 11:53
 */
public class MybatisCompleteTest {

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取SqlSessionFactory对象
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //开启事务
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句，返回受影响的条数
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            // 如果没有出现异常，则终止事务
            sqlSession.commit();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
