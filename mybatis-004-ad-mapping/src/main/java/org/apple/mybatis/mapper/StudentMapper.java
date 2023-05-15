package org.apple.mybatis.mapper;

import org.apple.mybatis.pojo.Student;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:13
 */
public interface StudentMapper {

    /**
     * 根据id获取学生信息，同时获取学生关联的班级信息
     *
     * @param sid 学生id
     * @return 学生对象，但是学生对象当中含有班级对象
     */
    Student selectById(Integer sid);
}
