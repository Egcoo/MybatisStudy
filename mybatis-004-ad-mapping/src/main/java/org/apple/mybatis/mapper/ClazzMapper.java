package org.apple.mybatis.mapper;

import org.apple.mybatis.pojo.Clazz;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:14
 */
public interface ClazzMapper {

    /**
     * 分步查询。第一步：根据班级编号获取班级信息
     *
     * @param sid
     * @return
     */
    Clazz selectByStep1(Integer sid);

    /**
     * 根据班级编号查询班级信息
     *
     * @param cid
     * @return
     */
    Clazz selectByCollection(Integer cid);

    /**
     * 分布查询第二步，根据cid获取班级信息
     *
     * @param id
     * @return
     */
    Clazz selectByIdStep2(Integer id);


}
