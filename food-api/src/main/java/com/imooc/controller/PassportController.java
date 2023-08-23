package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Api(value = "注册登陆", tags = {"注册登陆的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    private final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
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

    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    @PostMapping("/register")
    public JSONResult register(@RequestBody UserBO bo, HttpServletRequest req, HttpServletResponse resp) {
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
        Users userRes = setNullProperty(user);
        CookieUtils.setCookie(req, resp, "user", JsonUtils.objectToJson(userRes), true);
        return JSONResult.ok(user);
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆", httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO bo, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = bo.getUsername();
        String password = bo.getPassword();

        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名为空");
        }

        if (StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("密码为空");
        }

        Users user = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if (user == null) {
            return JSONResult.errorMsg("用户名或密码错误");
        }

        Users userRes = setNullProperty(user);
        CookieUtils.setCookie(req, resp, "user", JsonUtils.objectToJson(userRes), true);
        return JSONResult.ok();
    }

    @ApiOperation(value = "退出登陆", notes = "退出登陆", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String uid, HttpServletRequest req, HttpServletResponse resp) {
        CookieUtils.deleteCookie(req, resp, "user");
        return JSONResult.ok();
    }

    private Users setNullProperty(Users user) {
        user.setPassword(null);
        user.setRealname(null);
        user.setMobile(null);
        user.setEmail(null);
        return user;
    }
}