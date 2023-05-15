package org.apple.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apple.mybatis.mapper.StudentMapper;
import org.apple.mybatis.pojo.Student;
import org.apple.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/5/15 - 13:00
 */
public class StudentMapperTest {

    //写一个名为testSelectByIdStep1()的测试方法，并打印结果
    @Test
    public void testSelectByIdStep1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(1);
        System.out.println(student);
        sqlSession.close();
    }


    //写一个名为testSelectByIdAssociation()的测试方法，并打印结果
    @Test
    public void testSelectByIdAssociation() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(1);
        System.out.println(student);
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student);
        sqlSession.close();

    }
}














