package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author XuYang
 * @date 2020/7/14 11:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    /**
     * 数据库主键注解
     * id 自增策略
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除，走的是更新操作，不是真正的删除操作
     */
     @TableLogic
    private Integer deleted;
}
