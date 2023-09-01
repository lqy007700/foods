package com.imooc.service.impl;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.YesOrNo;
import com.imooc.mapper.OrderItemsMapper;
import com.imooc.mapper.OrderStatusMapper;
import com.imooc.mapper.OrdersMapper;
import com.imooc.pojo.*;
import com.imooc.pojo.bo.OrderBO;
import com.imooc.service.AddressService;
import com.imooc.service.ItemsService;
import com.imooc.service.OrderService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Sid sid;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ItemsService itemsService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String createOrder(OrderBO orderBO) {
        String userId = orderBO.getUserId();
        String addressId = orderBO.getAddressId();
        String itemSpecIds = orderBO.getItemSpecIds();
        Integer payMethod = orderBO.getPayMethod();
        String leftMsg = orderBO.getLeftMsg();
        Integer postAmount = 0;

        UserAddress userAddress = addressService.queryUserAddress(userId, addressId);

        String orderId = sid.nextShort();
        Orders orders = new Orders();
        orders.setId(orderId);
        orders.setUserId(userId);
        orders.setReceiverName(userAddress.getReceiver());
        orders.setReceiverAddress(userAddress.getUserId());
        orders.setReceiverMobile(userAddress.getProvince() + " " + userAddress.getCity() + " " + userAddress.getDistrict() + " " + userAddress.getDetail());
        orders.setPostAmount(postAmount);
        orders.setPayMethod(payMethod);
        orders.setLeftMsg(leftMsg);
        orders.setIsComment(YesOrNo.NO.type);
        orders.setIsDelete(YesOrNo.NO.type);
        orders.setCreatedTime(new Date());
        orders.setUpdatedTime(new Date());

        String[] split = itemSpecIds.split(",");
        int totalAmount = 0;
        int realPayAmount = 0;
        for (String sId : split) {
            Integer buyCounts = 1;
            ItemsSpec itemsSpec = itemsService.queryItemsSpecById(sId);
            totalAmount += itemsSpec.getPriceNormal();
            realPayAmount += itemsSpec.getDiscounts() * buyCounts;

            String itemId = itemsSpec.getItemId();
            Items item = itemsService.queryItemById(itemId);
            String imgUrl = itemsService.queryItemsMainImgById(itemId);

            OrderItems orderItems = new OrderItems();
            orderItems.setId(sid.nextShort());
            orderItems.setOrderId(orderId);
            orderItems.setItemId(itemId);
            orderItems.setItemSpecName(itemsSpec.getName());
            orderItems.setItemImg(imgUrl);
            orderItems.setItemName(item.getItemName());
            orderItems.setItemSpecId(sId);
            orderItems.setBuyCounts(buyCounts);
            orderItems.setPrice(itemsSpec.getDiscounts());

            orderItemsMapper.insert(orderItems);

            // 扣除库存
//            itemsService.decreaseItemSpecStock(sId, buyCounts);
        }
        orders.setTotalAmount(totalAmount);
        orders.setRealPayAmount(realPayAmount);
        ordersMapper.insert(orders);

        OrderStatus orderStatus1 = new OrderStatus();
        orderStatus1.setOrderId(orderId);
        orderStatus1.setCreatedTime(new Date());
        orderStatus1.setOrderStatus(OrderStatusEnum.WAIT_PAY.type);
        orderStatusMapper.insert(orderStatus1);
        return orderId;
    }
}
