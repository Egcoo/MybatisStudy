package org.apple.mybatis.pojo;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:08
 * <p>
 * 多对一：
 * 多的一方是：Student
 * 一的一方是：Clazz
 * 怎么分主表和副表
 * 原则：谁在前谁是主表
 * 多对一： 多在前，那么多就是主表
 * 一对多：一在前，那么一就是主表
 */
public class Clazz {
    private Integer cid;
    private String cname;

    public Clazz() {
    }

    public Clazz(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
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
}
