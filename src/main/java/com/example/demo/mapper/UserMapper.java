package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;

/**
 * 继承 BaseMapper 接口后，简单的CRUD功能将不需要自己再写了
 *
 * @author XuYang
 * @date 2020/7/14 11:03
 */
public interface UserMapper extends BaseMapper<User> {
}
