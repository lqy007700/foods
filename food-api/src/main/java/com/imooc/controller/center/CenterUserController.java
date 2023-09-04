package com.imooc.controller.center;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@Api(value = "用户信息", tags = {"用户信息"})
@RestController
@RequestMapping("userInfo")
public class CenterUserController {

    @Autowired
    private CenterUserService centerUserService;

    @ApiOperation(value = "更改", httpMethod = "POST")
    @PostMapping("update")
    public JSONResult update(
            @ApiParam(name = "userId", required = true)
            String userId,
            @RequestBody CenterUserBO centerUserBO,
            HttpServletRequest req,
            HttpServletResponse resp
    ) {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("参数错误");
        }

        Users users = centerUserService.updateUserInfo(userId, centerUserBO);

        System.out.println(centerUserBO);

        Users users1 = setNullProperty(users);
        CookieUtils.setCookie(req, resp, "user", JsonUtils.objectToJson(users1));
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