package com.imooc.controller;

import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemsInfoVO;
import com.imooc.service.ItemsService;
import com.imooc.utils.JSONResult;
import com.imooc.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商品", tags = {"商品详情"})
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

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

    @ApiOperation(value = "商品评价", notes = "商品评价", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public JSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg("非法请求");
        }

        CommentLevelCountsVO commentLevelCountsVO = itemsService.queryCommentCounts(itemId);
        return JSONResult.ok(commentLevelCountsVO);
    }


    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public JSONResult comments(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评论等级", required = true)
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "分页")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页")
            @RequestParam Integer pageSize
    ) {

        if (StringUtils.isBlank(itemId)) {
            return JSONResult.errorMsg("非法请求");
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult pagedGridResult = itemsService.queryPagedComments(itemId, level, page, pageSize);
        return JSONResult.ok(pagedGridResult);
    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public JSONResult search(
            @ApiParam(name = "keywords", value = "关键字", required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort", value = "排序", required = true)
            @RequestParam String sort,
            @ApiParam(name = "page", value = "分页")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页")
            @RequestParam Integer pageSize
    ) {

        if (StringUtils.isBlank(keywords)) {
            return JSONResult.errorMsg("搜索内容为空");
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        PagedGridResult pagedGridResult = itemsService.searchItems(keywords, sort, page, pageSize);
        return JSONResult.ok(pagedGridResult);
    }
}