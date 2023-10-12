package com.qy.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data// 替代get和set方法
@TableName("sys_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private  String username;
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

    //@TableField(value = "avatar_url")//指定数据库字段名称
    //private String avatar;

}
