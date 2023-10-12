package com.qy.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.springboot.entity.User;
import com.qy.springboot.mapper.UserMapper;
import com.qy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")//映射名前缀
public class UserController {
    //@Autowired
    //private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //查询所有
    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }

    //新增或修改信息
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    //通过id删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
        }

    //批量删除
    @PostMapping ("/del/batch")
    public boolean deletebatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }

    // 分页查询
    //接口路径：/user/page?pageNum=1&pageSize=10
    //@RequestParam 接受参数
    //limit 第一个参数 =(pageNum-1)*pageSize pageNum 当页的第一个id
    //@GetMapping("/page")
    //public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
    //    pageNum = (pageNum-1) * pageSize;
    //    List<User> data= userMapper.selectPage(pageNum,pageSize);
    //    Integer total= userMapper.seleTotal();
    //    Map<String, Object> res=new HashMap<>();
    //    res.put("data",data);
    //    res.put("total",total);
    //    return res;
    //
    //}


    // 分页查询--Mybatis-Plus方式
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address
    ){
        IPage<User> page= new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        //queryWrapper.like("username",username);
        //queryWrapper.like(String.isNotEmpty(username),User::getUsername,username);
        //IambdaQueryWrapper.like(!username.isEmpty(),User::getUsername,username);
        //queryWrapper.like("nickname",nickname);
        //queryWrapper.like("address",address);
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }
        queryWrapper.orderByDesc("id");
        return userService.page(page,queryWrapper);

    }


}




