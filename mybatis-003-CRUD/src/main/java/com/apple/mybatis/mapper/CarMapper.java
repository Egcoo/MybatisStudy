package com.apple.mybatis.mapper;

import com.apple.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2023/5/7 - 10:17
 */
public interface CarMapper {

    /**
     * 插入car 信息并且使用生成的主键值
     *
     * @param car
     * @return
     */
    int insertCarUseGeneratedKeys(Car car);

    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();

    List<Car> selectAllByAscOrDesc();

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(String ids);

    /**
     * 根据汽车品牌进行模糊查询
     *
     * @param brand
     * @return
     */
    List<Car> selectByBrandLike(String brand);


    /**
     * 根据id获取汽车信息，并将其放到map集合中
     *
     * @param id
     * @return
     */
    Map<String, Object> selectByIdRetMap(Long id);

    /**
     * 查询所有car信息，返回一个放map集合的list集合
     *
     * @return
     */
    List<Map<String, Object>> selectAllRetListMap();

    /**
     * 拿 car 的id做key，以后取出对应的map集合更方便
     *
     * @return
     */
    @MapKey("id")
    Map<Long, Map<String, Object>> selectAllRetMap();

    /**
     * 查询所有的Car信息，使用resultMap标签进行结果映射
     *
     * @return
     */
    List<Car> selectAllByResultMap();

    /**
     * 查询所有的car信息，但是启用了驼峰命名自动映射机制。
     *
     * @return
     */
    List<Car> selectAllByMapUnderscoreToCamelCase();

    /**
     * 获取Car的总记录条数
     *
     * @return
     */
    Long selectTotal();

    /**
     * 使用动态sql获取信息，动态sql也就是可以动态拼接
     *
     * @param brand
     * @param price
     * @param carType
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double price, @Param("carType") String carType);


    /**
     * 使用where标签，让where子句更加智能
     *
     * @param brand
     * @param price
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double price, @Param("carType") String carType);


    /**
     * 使用trim标签
     *
     * @param brand
     * @param price
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double price, @Param("carType") String carType);

    /**
     * 使用set标签
     *
     * @param car
     * @return
     */
    int updateBySet(Car car);

    /**
     * 使用 choose when otherwise 标签
     *
     * @param brand
     * @param price
     * @param carType
     * @return
     */
    List<Car> selectByChoose(@Param("brand") String brand, @Param("guidePrice") Double price, @Param("carType") String carType);


    /**
     * 批量删除，foreach标签
     *
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") Long[] ids);

    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIds2(@Param("ids") Long[] ids);

    /**
     * 批量插入，一次插入多条信息
     *
     * @param cars
     * @return
     */
    int insertBatch(@Param("cars") List<Car> cars);

}
