package org.apple.mybatis.pojo;

import java.io.Serializable;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:09
 * <p>
 * 多对一：
 * 多的一方是：Student
 * 一的一方是：Clazz
 * 怎么分主表和副表
 * 原则：谁在前谁是主表
 * 多对一： 多在前，那么多就是主表
 * 一对多：一在前，那么一就是主表
 */
public class Student implements Serializable {
    private Integer sid;
    private String sname;
    private Clazz clazz;

    public Student() {

    }

    public Student(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
