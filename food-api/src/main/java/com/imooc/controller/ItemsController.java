package com.imooc.controller;

import com.imooc.pojo.*;
import com.imooc.pojo.vo.ItemsInfoVO;
import com.imooc.service.ItemsService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "商品", tags = {"商品详情"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @ApiOperation(value = "获取商品详情", notes = "获取商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public JSONResult info(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg("非法请求");
        }

        Items items = itemsService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = itemsService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecs = itemsService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemsService.queryItemParam(itemId);

        ItemsInfoVO itemsInfoVO = new ItemsInfoVO();
        itemsInfoVO.setItems(items);
        itemsInfoVO.setItemsImg(itemsImgs);
        itemsInfoVO.setItemsSpecs(itemsSpecs);
        itemsInfoVO.setItemsParam(itemsParam);
        return JSONResult.ok(itemsInfoVO);
    }
}