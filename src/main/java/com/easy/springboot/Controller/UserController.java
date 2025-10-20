package com.easy.springboot.Controller;


import com.easy.springboot.Service.IUserService;
import com.easy.springboot.pojo.dto.UserPasswordDTO;
import com.easy.springboot.pojo.entity.User;
import com.easy.springboot.pojo.query.UserQuery;
import com.easy.springboot.util.JwtUtil;
import com.easy.springboot.util.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    //Restful    GET(查找)、POST(添加)、DELETE(删除)、PUT(修改)
    //@RequestMapping("/list")
    //@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    //@RequestMapping(value = "/list", method = RequestMethod.GET)

    @GetMapping("/list")
    public Result list(UserQuery userQuery){
        PageInfo pageInfo = userService.list(userQuery);
        return Result.ok(pageInfo);
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
         userService.add(user);
         return Result.ok("添加成功");
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.ok("删除成功");
    }

    @DeleteMapping("/deleteAll/{ids}")
    public Result deleteAll(@PathVariable Integer[] ids){
        userService.deleteAll(ids);
        return Result.ok("删除成功");
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.ok(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userService.update(user);
        return Result.ok("修改成功");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
       User loginUser = userService.login(user);
        if(loginUser==null){
            return Result.error("用户名或密码错误");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id",loginUser.getId());
        map.put("name",loginUser.getName());
        String token = JwtUtil.createToken(map);

        return Result.ok("登录成功",token);
    }

    @GetMapping("/userInfo")
    public Result userInfo(@RequestHeader(name="Authorization") String token){
      Map<String,Object> map = JwtUtil.parseToken(token);
      int id = (int) map.get("id");
      User user = userService.selectById(id);
      return Result.ok(user);
    }

    @PutMapping("/resetPassword")
    public Result resetPassword(@RequestBody UserPasswordDTO userPasswordDTO,
                                @RequestHeader(name="Authorization") String token ){
        Map<String,Object> map=JwtUtil.parseToken(token);
        int id = (int) map.get("id");
        User user = userService.selectById(id);
        if(!user.getPassword().equalsIgnoreCase(userPasswordDTO.getOldPassword())){
            return Result.error("原密码错误");
        }
        else{
            User resetPasswordUser = new User();
            resetPasswordUser.setId(id);
            resetPasswordUser.setPassword(userPasswordDTO.getNewPassword());
            userService.update(resetPasswordUser);
            return Result.ok("修改密码成功");
        }
    }







}
