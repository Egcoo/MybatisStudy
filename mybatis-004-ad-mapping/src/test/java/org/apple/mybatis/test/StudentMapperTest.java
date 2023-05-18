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
        //System.out.println(student);

        //当你之查看学生名字的时候就只会执行一条语句
        System.out.println(student.getSname());
        //直到程序执行到查看班级的名字,才会执行下一条语句
        System.out.println(student.getClazz().getCname());

        sqlSession.close();
    }


    //写一个名为testSelectByIdAssociation()的测试方法，并打印结果
    @Test
    public void testSelectByIdAssociation() throws IOException {
        SqlSession sqlSession1 = SqlSessionUtil.openSqlSession();
        SqlSession sqlSession2 = SqlSessionUtil.openSqlSession();
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);

        //这行代码执行结束之后,实际上数据是缓存到一级缓存当中了。(sqlSession1是一级缓存。)
        Student student1 = mapper1.selectByIdAssociation(1);
        System.out.println(student1);

        //如果这里不关闭SqlSession1对象的话,二级缓存中还是没有数据的
        //如果执行了这行代码,sqlSession1的一级缓存中的数据会放到二级缓存当中
        sqlSession1.close();

        //这行代码执行结束之后,实际上数据会缓存到一级缓存当中。(sqlSession2是一级缓存。)
        Student student2 = mapper2.selectByIdAssociation(1);
        System.out.println(student2);
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














