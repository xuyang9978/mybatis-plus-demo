package com.example.demo.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.MybatisPlusApplication;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author XuYang
 * @date 2020/7/14 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestMapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试查询全部用户
     */
    @Test
    public void testQueryAll() {
        // 参数是一个Wrapper，条件构造器，不要条件直接为null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入
     */
    @Test
    public void testInsert() {
        // id 会根据你在实体类主键字段上使用的注解来进行设置，默认是IdType.NONE
        User user = new User();
        user.setName("test02");
        user.setAge(21);
        user.setEmail("xuyang9978@gamil.com");
        int res = userMapper.insert(user);
        System.out.println(res);
        System.out.println(user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setName("xy");
        int res = userMapper.updateById(user);
        System.out.println(res);
        log.info("我更新完啦！！！");
    }

    /**
     * 测试乐观锁（成功案例）
     */
    @Test
    public void testOptimisticLockerSuccessful() {
        // 查询用户信息
        User user = userMapper.selectById(1L);
        // 修改用户信息
        user.setName("xuyang");
        user.setEmail("xuyang9978@gmail.com");
        // 执行更新操作
        userMapper.updateById(user);
    }

    /**
     * 测试乐观锁（失败案例）
     */
    @Test
    public void testOptimisticLockerFaild() {
        // 线程1
        User user = userMapper.selectById(1L);
        user.setName("xuyang111");
        user.setEmail("xuyang9978@gmail.com");

        // 模拟另一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("xuyang222");
        user2.setEmail("xuyang9978@gmail.com");
        userMapper.updateById(user2);

        // 如果没有乐观锁，这里就会执行成功将插队线程修改的值覆盖掉
        userMapper.updateById(user);

    }

    /**
     * 测试批量查询
     */
    @Test
    public void testQueryBatch() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * 测试条件查询: 使用 map 封装条件
     */
    @Test
    public void testConditionQuery() {
        HashMap<String, Object> map = new HashMap<>();
        // 自定义查询条件
        map.put("name", "xy");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    /**
     * 测试分页查询
     */
    @Test
    public void testQueryPage() {
        // 参数一： 当前页
        // 参数二： 页面大小
        Page<User> page = new Page<>(2, 5);
        Page<User> userPage = userMapper.selectPage(page, null);

        userPage.getRecords().forEach(System.out::println);
        System.out.println(userPage.getTotal());
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        int res = userMapper.deleteById(1282908865892995075L);
        System.out.println(res);
    }
}
