package com.imooc.controller;

import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.ShopCatBO;
import com.imooc.service.CarouselService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "购物车", tags = {"购物车"})
@RestController
@RequestMapping("shopcat")
public class ShopCatController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "添加购物车", notes = "添加购物车", httpMethod = "post")
    @GetMapping("/add")
    public JSONResult add(
            @RequestParam String userId,
            @RequestBody ShopCatBO shopCatBO,
            HttpServletRequest req,
            HttpServletResponse resp
    ) {

        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("");
        }
        return JSONResult.ok();
    }
}