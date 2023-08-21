package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("passport")
public class PassportController {

    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名为空");
        }

        boolean isExist = userService.queryUserNameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名已存在");
        }
        return JSONResult.ok();
    }

    @PostMapping("/register")
    public JSONResult register(@RequestBody UserBO bo) {
        String username = bo.getUsername();
        String password = bo.getPassword();
        String confirmPassword = bo.getConfirmPassword();

        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名为空");
        }

        if (StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("密码为空");
        }

        if (!Objects.equals(password, confirmPassword)) {
            return JSONResult.errorMsg("两次密码不一致");
        }

        boolean exist = userService.queryUserNameIsExist(username);
        if (exist) {
            return JSONResult.errorMsg("用户名已存在");
        }

        Users user = userService.createUser(bo);

        return JSONResult.ok(user);
    }
}