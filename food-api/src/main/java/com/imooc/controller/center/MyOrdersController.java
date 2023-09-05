package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Orders;
import com.imooc.service.center.MyOrdersService;
import com.imooc.utils.JSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "我的订单", tags = {"我的订单"})
@RestController
@RequestMapping("myorders")
public class MyOrdersController extends BaseController {

    @Autowired
    private MyOrdersService myOrdersService;


    @ApiOperation(value = "我的订单", notes = "我的订单", httpMethod = "POST")
    @PostMapping("/query")
    public JSONResult query(
            @ApiParam(name = "userId", value = "uid", required = true)
            @RequestParam String userId,
            @ApiParam(name = "orderStatus", value = "状态")
            @RequestParam Integer orderStatus,
            @ApiParam(name = "page", value = "分页")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页")
            @RequestParam Integer pageSize
    ) {

        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("非法请求");
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult pagedGridResult = myOrdersService.queryMyOrders(userId, orderStatus, page, pageSize);
        return JSONResult.ok(pagedGridResult);
    }

    @ApiOperation(value = "商家发货", notes = "商家发货", httpMethod = "GET")
    @GetMapping("/deliver")
    public JSONResult deliver(
            @ApiParam(name = "orderId", value = "orderId", required = true)
            @RequestParam String orderId
    ) {
        if (StringUtils.isBlank(orderId)) {
            return JSONResult.errorMsg("非法请求");
        }

        myOrdersService.updateDeliverOrderStatus(orderId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "确认收货", notes = "确认收货", httpMethod = "POST")
    @PostMapping("/confirmReceive")
    public JSONResult confirmReceive(
            @ApiParam(name = "orderId", value = "orderId", required = true)
            @RequestParam String orderId,
            @ApiParam(name = "userId", value = "userId", required = true)
            @RequestParam String userId
    ) {
        if (StringUtils.isBlank(orderId) || StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("非法请求");
        }

        Orders o = myOrdersService.queryMyOrder(userId, orderId);
        if (o == null) {
            return JSONResult.errorMsg("非法请求");
        }

        myOrdersService.updateReceiveOrderStatus(orderId);
        return JSONResult.ok();
    }
}