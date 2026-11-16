package org.xue.xue_iot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xue.xue_iot.Service.UserService;
import org.xue.xue_iot.pojo.Result;
import org.xue.xue_iot.pojo.User;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user/findByUsername")
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }
    @RequestMapping("/user/register")
    public Result register(String username,String password,String email) {
     /*字段：用户名（唯一）、密码（需加密）、邮箱
     要求：用户名不能为空且唯一，密码长度 ≥ 6 位*/
        User u = new User();
        u = findByUsername(username);
        if(u == null){
            if(password.length() < 6){
                return Result.fail("密码长度不能小于6位");
            }
            userService.register(username,password,email);
            return Result.success();
        }
        else{
            return Result.fail("用户名已存在");
        }
    }

    @PostMapping("/user/login")
    public Result login(String username, String password) {
        User u = findByUsername(username);//判断用户是否存在
        if(u != null) {
            //userService.login(username, password);
            if(password.equals(u.getPassword())) {
                return Result.success();
            }
        }
        return Result.fail("用户名或密码错误");
    }
}
