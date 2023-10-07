package com.qy.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// 替代get和set方法

public class User {
    private Integer id;
    private  String username;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
