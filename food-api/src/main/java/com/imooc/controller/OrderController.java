package com.imooc.controller;

import com.imooc.enums.PayMethod;
import com.imooc.pojo.bo.OrderBO;
import com.imooc.service.OrderService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Api(value = "订单", tags = {"订单"})
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "下单", notes = "下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(
            @RequestBody OrderBO orderBO,
            HttpServletRequest req,
            HttpServletResponse resp
    ) {
        if (!Objects.equals(orderBO.getPayMethod(), PayMethod.ALIPAY.type)
                && !Objects.equals(orderBO.getPayMethod(), PayMethod.WEIXIN.type)) {
            return JSONResult.errorMsg("支付方式不支持");
        }
        String orderId = orderService.createOrder(orderBO);

//        CookieUtils.setCookie(req, resp, FOODIE_SHOPCAT, "", true);

        return JSONResult.ok(orderId);
    }
}