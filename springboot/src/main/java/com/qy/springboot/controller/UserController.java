package com.qy.springboot.controller;

import com.qy.springboot.entity.User;
import com.qy.springboot.mapper.UserMapper;
import com.qy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;

@RestController
@RequestMapping("/user")//映射名前缀
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //查询所有
    @GetMapping
    public List<User> index(){
        return userMapper.findAll();
    }

    //新增或更新信息
    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }

    //通过id删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
        }
    }




