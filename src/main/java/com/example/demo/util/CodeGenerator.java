package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * mybatis-plus 代码生成器
 * 必须使用他支持的模板引擎并且安装相关依赖, 不支持 thymeleaf 模板引擎
 *
 * @author XuYang
 * @date 2020/7/14 17:07
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        // 配置策略
        // 1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 当前项目路径
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("xuyang");
        // 生成完不打开资源管理器
        globalConfig.setOpen(false);
        // 是否覆盖
        globalConfig.setFileOverride(false);
        // 设置Service的名字, 并且去掉Service的前缀I
        globalConfig.setServiceName("%sService");
        // 主键策略, 雪花算法
        globalConfig.setIdType(IdType.ASSIGN_ID);
        // 设置数据库时间类型 到 实体类时间类型 对应策略
        globalConfig.setDateType(DateType.ONLY_DATE);
        // 设置 swagger 接口文档
        globalConfig.setSwagger2(true);

        // 开启全局配置
        autoGenerator.setGlobalConfig(globalConfig);

        // 2. 设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 配置连接信息
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatisplusdemo?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setUsername("xuyang");
        dataSourceConfig.setPassword("12345");
        // 配置数据库驱动类型
        dataSourceConfig.setDbType(DbType.MYSQL);

        // 使用数据源
        autoGenerator.setDataSource(dataSourceConfig);

        // 3. 配置要生成的包
        PackageConfig packageConfig = new PackageConfig();
        // 设置模块名
        packageConfig.setModuleName("demo");
        packageConfig.setParent("com.example.demo");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setController("controller");

        // 使用包配置
        autoGenerator.setPackageInfo(packageConfig);

        // 4. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 重点: 要映射的表的名字
        strategy.setInclude("user");
        // 设置命名方式, 下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 使用 lombok 注解实体类
        strategy.setEntityLombokModel(true);
        // 设置逻辑删除字段名字
        strategy.setLogicDeleteFieldName("deleted");

        // 自动填充策略配置
        TableFill createdTime = new TableFill("created_time", FieldFill.INSERT);
        TableFill updatedTime = new TableFill("updated_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createdTime);
        tableFills.add(updatedTime);
        // 使用自动填充策略配置
        strategy.setTableFillList(tableFills);

        // 乐观锁配置
        strategy.setVersionFieldName("version");
        // 设置生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // controller 的路径写法: 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        // 执行代码生成器
        autoGenerator.execute();
    }
}
