package org.apple.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apple.mybatis.mapper.ClazzMapper;
import org.apple.mybatis.pojo.Clazz;
import org.apple.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2023/5/15 - 14:23
 */
public class ClazzMapperTest {

    //写一个名为testSelectByCollection()的测试方法，并打印结果
    @Test
    public void testSelectByCollection() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1000);
        System.out.println(clazz);
        sqlSession.close();
    }
}
