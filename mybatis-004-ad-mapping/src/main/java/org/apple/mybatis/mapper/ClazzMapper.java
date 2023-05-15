package org.apple.mybatis.mapper;

import org.apple.mybatis.pojo.Clazz;

/**
 * @ author Egcoo
 * @ date 2023/5/14 - 11:14
 */
public interface ClazzMapper {

    /**
     * 分布查询第二步，根据cid获取班级信息
     *
     * @param id
     * @return
     */
    Clazz selectByIdStep2(Integer id);
}
