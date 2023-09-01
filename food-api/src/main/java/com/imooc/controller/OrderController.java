package com.imooc.controller;

import com.imooc.enums.PayMethod;
import com.imooc.pojo.bo.OrderBO;
import com.imooc.service.CarouselService;
import com.imooc.service.OrderService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Api(value = "订单", tags = {"订单"})
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "下单", notes = "下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(
            @RequestBody OrderBO orderBO
    ) {
        if (!Objects.equals(orderBO.getPayMethod(), PayMethod.ALIPAY.type)
                && !Objects.equals(orderBO.getPayMethod(), PayMethod.WEIXIN.type)) {
            return JSONResult.errorMsg("支付方式不支持");
        }
        orderService.createOrder(orderBO);
        return JSONResult.ok();
    }
}