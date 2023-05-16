package org.apple.mybatis.pojo;

import java.util.List;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:08
 * <p>
 * 一对多:一在前。一是主表。多是副表。
 * 主表:t_clazz
 * 副表:t_student
 */
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> stus;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }
}
