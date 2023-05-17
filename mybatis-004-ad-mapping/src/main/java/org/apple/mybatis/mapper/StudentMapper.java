package org.apple.mybatis.mapper;

import org.apple.mybatis.pojo.Student;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:13
 */
public interface StudentMapper {

    /**
     * 根据班级编号查询学生信息
     *
     * @param cid
     * @return
     */
    List<Student> selectByCidStep2(Integer cid);

    /**
     * 分步查询第一步：现根据学生的sid查询学生的信息
     *
     * @param sid
     * @return
     */
    Student selectByIdStep1(Integer sid);

    /**
     * 一条SQL语句，association
     *
     * @param sid
     * @return
     */
    Student selectByIdAssociation(Integer sid);


    /**
     * 根据id获取学生信息，同时获取学生关联的班级信息
     *
     * @param sid 学生id
     * @return 学生对象，但是学生对象当中含有班级对象
     */
    Student selectById(Integer sid);
}
