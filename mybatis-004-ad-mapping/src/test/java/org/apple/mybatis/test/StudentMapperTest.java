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

    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student);
        sqlSession.close();

    }
}














