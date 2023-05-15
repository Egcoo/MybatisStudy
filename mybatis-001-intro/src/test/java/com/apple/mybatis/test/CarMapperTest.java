package com.apple.mybatis.test;

import com.apple.mybatis.pojo.Car;
import com.apple.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/4/23 - 14:43
 */
public class CarMapperTest {


    public void testInsertCarByUtil() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        List<Object> cars = sqlSession.selectList("org.mybatis.selectAll");
        //将lamda方法替换为方法引用
        cars.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = sqlSession.selectOne("org.mybatis.selectById", 1L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        //封装数据
        Car car = new Car(null, "3333", "宝马", 100.0, "2023-04-23", "新能源");
        //执行sql
        int count = sqlSession.insert("org.mybatis.insertCar", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //如果占位符只有一个的话，#{}
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        int count = sqlSession.delete("org.mybatis.deleteById", 8);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        Car car = new Car(9L, "3333", "保时捷", 100.0, "2023-04-23", "新能源");
        int count = sqlSession.update("org.mybatis.updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
}
