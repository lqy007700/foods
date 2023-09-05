package com.imooc.service.center;

import com.imooc.pojo.Orders;
import com.imooc.utils.PagedGridResult;

public interface MyOrdersService {
    PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);

    void updateDeliverOrderStatus(String orderId);

    Orders queryMyOrder(String userId, String orderId);

    Integer updateReceiveOrderStatus(String orderId);
}
