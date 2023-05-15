package com.apple.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ author Egcoo
 * @ date 2023/4/22 - 11:44
 */
public class MybatisIntroTest {

    public static void main(String[] args) throws IOException {

        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 从类的根路径查找资源
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql语句，返回受影响的条数
        int count = sqlSession.insert("insertCar");
        System.out.println(count);

        // 手动提交,底层还是执行的jdbc的 conn.commit 方法
        sqlSession.commit();

    }
}
