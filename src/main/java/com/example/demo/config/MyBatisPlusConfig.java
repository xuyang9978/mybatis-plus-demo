package com.example.demo.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 配置 mybatis-plus 的乐观锁插件
 *
 * @author XuYang
 * @date 2020/7/14 14:14
 */
@MapperScan("com.example.demo.mapper")
@EnableTransactionManagement    // 加了这个就可以把启动类上的MapperScan注解写到这里
@Configuration  // 配置类注解
public class MyBatisPlusConfig {

    // 注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    // 配置 mybatis-plus 的分页拦截器
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 想自己详细配置可以去参看 mybatis-plus 官网
        return new PaginationInterceptor();
    }

}
