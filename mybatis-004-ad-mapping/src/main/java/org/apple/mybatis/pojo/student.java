package org.apple.mybatis.pojo;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:09
 */
public class student {
    private Integer sid;
    private String sname;

    public student() {

    }

    public student(Integer sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
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
}
