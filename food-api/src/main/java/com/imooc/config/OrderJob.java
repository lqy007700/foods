package com.imooc.config;

import com.imooc.service.OrderService;
import com.imooc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderJob {

    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0/3 * * * * ?")
    public void autoCloseOrder() {
        System.out.println(DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
        orderService.closeOrder();
    }
}
