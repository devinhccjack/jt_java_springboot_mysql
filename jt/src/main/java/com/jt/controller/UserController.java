package com.jt.controller;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin    //前后端进行跨域操作
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){

        return userService.findAll();
    }

    /**
     * URL: /user/login
     * 参数: username/password  json串!!!!
     * 类型: post
     * 返回值: SysResult(token)
     */
    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        //token 用户登录之后,返回业务凭证! 业务字符串
        String token = userService.login(user);
        if(!StringUtils.hasLength(token)){
            return SysResult.fail();
        }
        return SysResult.success(token);
    }

    /**
     * 业务说明: 分页查询用户信息
     * URL:  http://localhost:8091/user/list?query=查询关键字&pageNum=1&pageSize=10
     * 参数:  ?query=查询关键字&pageNum=1&pageSize=10
     * 返回值: SysResult(PageResult)
     */
    @GetMapping("/list")
    public SysResult findUserList(PageResult pageResult){//3个有值
        //业务层完成 查询总数和记录数的操作
        pageResult = userService.findUserList(pageResult);
        return SysResult.success(pageResult);
    }

    /**
     * URL:  /user/status/{id}/{status}
     * 参数:  id/status
     * 返回值: SysResult对象
     */
    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(User user){

        userService.updateStatus(user);
        return SysResult.success();
    }

    /**
     * URL:  /user/addUser
     * 参数:  form表单 js对象 json串
     * 返回值: SysResult对象
     */
    @PostMapping("/addUser")
    public SysResult addUser(@RequestBody User user){

        userService.addUser(user);
        return SysResult.success();
    }

    /**
     * URL: /user/{id}
     * 参数: id
     * 返回值: SysResult(user对象)
     */
    @GetMapping("/{id}")
    public SysResult findUserById(@PathVariable Integer id){

        User user = userService.findUserById(id);
        return SysResult.success(user);
    }

    /**
     * URL地址:   /user/updateUser
     * 参数:   3个参数 js对象 json串
     * 返回值: SysResult对象
     */
    @PutMapping("/updateUser")
    public SysResult updateUser(@RequestBody User user){

        userService.updateUser(user);
        return SysResult.success();
    }

    @DeleteMapping("/{id}")
    public SysResult deleteUserById(@PathVariable Integer id){

        userService.deleteUserById(id);
        return SysResult.success();
    }
}
