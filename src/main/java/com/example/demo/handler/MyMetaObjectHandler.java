package com.example.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充表字段创建时间、更新时间的处理器
 *
 * @author XuYang
 * @date 2020/7/14 13:52
 */
@Slf4j
@Component  // 一定不要忘了把处理器加入到 IOC 容器中
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时的填充策略
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("====开始执行插入====");
        this.setFieldValByName("createdTime", new Date(), metaObject);
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("====开始执行更新====");
        this.setFieldValByName("updatedTime", new Date(), metaObject);
    }
}
