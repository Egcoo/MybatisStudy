package com.apple.mybatis.test;

import com.apple.mybatis.mapper.CarMapper;
import com.apple.mybatis.pojo.Car;
import com.apple.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2023/5/7 - 10:27
 */
public class CarMapperTest {

    @Test
    public void testDeleteByIds2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {1L, 2L, 3L};
        int count = mapper.deleteByIds2(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsertBatch() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null, "1200", "奔驰", 4.0, "2023-08-07", "轿车");
        Car car2 = new Car(null, "1201", "奔驰", 4.0, "2023-08-07", "轿车");
        Car car3 = new Car(null, "1203", "奔驰", 4.0, "2023-08-07", "轿车");
        List<Car> list = new ArrayList<>();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDeleteByIds() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {1L, 2L, 3L};
        int count = mapper.deleteByIds(ids);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByChoose() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByChoose("宝马", null, null);
        for (Car car : list) {
            System.out.println(car);
        }
        sqlSession.close();

    }

    @Test
    public void testUpdateBySet() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(24L, "833", "奔驰", 4.0, "2023-08-07", "轿车");
        int count = mapper.updateBySet(car);
        System.out.println(count);
        sqlSession.commit();

    }

    @Test
    public void testSelectByMultiCondition() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 假设三个条件都不是空
        List<Car> cars = mapper.selectByMultiCondition("宝马", 2.0, "新能源");
        cars.forEach(System.out::println);

        // 假设三个条件都是空
        // cars = mapper.selectByMultiCondition("", null, "");
        sqlSession.close();

    }

    @Test
    public void testSelectTotal() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total = mapper.selectTotal();
        System.out.println("总记录数:" + total);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void testSelectAllByResultMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(System.out::println);
        sqlSession.close();
    }


    @Test
    public void testSelectAllRetMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long, Map<String, Object>> map = mapper.selectAllRetMap();
        System.out.println(map);
    }


    @Test
    public void testSelectAllRetListMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String, Object>> list = mapper.selectAllRetListMap();
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByIdRetMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String, Object> carMap = mapper.selectByIdRetMap(24L);
        System.out.println(carMap);
        sqlSession.close();
    }


    @Test
    public void testselectByBrandLike() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> list = mapper.selectByBrandLike("奔驰");
        for (Car car : list) {
            System.out.println(car);
        }
    }


    @Test
    public void insertCarUseGeneratedKeys() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "8654", "奔驰", 4.0, "2023-05-09", "轿车");
        mapper.insertCarUseGeneratedKeys(car);
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "8654", "奔驰", 4.0, "2023-05-07", "轿车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();

    }

    @Test
    public void testDeleteById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(24L);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(24L, "8653", "奔驰", 4.0, "2023-08-07", "轿车");
        int count = mapper.update(car);
        System.out.println(count);
        sqlSession.commit();

    }

    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(24L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(System.out::println);
    }


    @Test
    public void testDeleteBatch() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("5,6,7");
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testSelectByBrandLike() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.openSqlSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("奔驰");
        cars.forEach(System.out::println);
    }

}
