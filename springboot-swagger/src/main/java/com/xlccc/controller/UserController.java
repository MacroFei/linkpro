package com.xlccc.controller;

import com.xlccc.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api
@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long , User> users= Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    @ApiOperation(value = "获取用户列表")
    public List<User> getUser(){
        List<User> r = new ArrayList<>(users.values());
        return r ;
    }

    @PostMapping("/")
    @ApiOperation(value = "创建用户",notes="根据User对象创建用户")
    public String postUser(@RequestBody User user ){
        users.put(user.getId(),user);
        return "success";
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户详细信息" , notes = "根据url的id来获取用户详细信息")
    public User getUser(@PathVariable Long id ){
        return users.get(id);
    }

    @PutMapping("/{id}")
    @ApiImplicitParam(paramType = "path" , dataType = "Long",name = "id",value="用户编号",required = true , example = "1")
    @ApiOperation(value="更新用户详细信息",notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    public String putUser (@PathVariable Long id , @RequestBody User user ){
        User u = users.get(id);
        u.setName(user.getName());

        users.put(id,u);
        return "success";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户" , notes = "根据url的id来指定删除对象")
    public String deleteUser (@PathVariable Long id){
        users.remove(id);
        return "success";
    }


}
