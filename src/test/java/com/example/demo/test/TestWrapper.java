package com.example.demo.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * 测试 mybatis-plus 的条件构造器进行复杂查询
 *
 * @author XuYang
 * @date 2020/7/14 15:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestWrapper {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询 name 和邮箱均不为空且年龄大于等于 18 岁的的用户
     */
    @Test
    public void testQueryByWrapper1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 18);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    /**
     * 查询一个 name 等于 Sandy 的用户
     */
    @Test
    public void testQueryByWrapper2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Sandy");
        // 只查询一个
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * 查询 age 在 [20, 30] 之间的用户数量
     */
    @Test
    public void testQueryByWrapper3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30);
        // 查询满足条件的记录数
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    /**
     * 模糊查询，查询 name 中不包含 s 的记录并且 email 以 t 开头的用户
     */
    @Test
    public void testQueryByWrapper4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "s")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 子查询, id 在子查询中查出来
     */
    @Test
    public void testQueryByWrapper5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", " select id from user where id<5 ");
        // 注意这里的 selectObjs 只会返回查询出来的第一个字段的值
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    /**
     * 查询并按照 id 排序
     */
    @Test
    public void testQueryByWrapper6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 降序
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
