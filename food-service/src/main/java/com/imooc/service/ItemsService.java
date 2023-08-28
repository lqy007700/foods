package com.imooc.service;

import com.imooc.pojo.*;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ItemsCommentVO;
import com.imooc.pojo.vo.SearchItemsVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface ItemsService {
    Items queryItemById(String itemId);

    List<ItemsImg> queryItemImgList(String itemId);

    List<ItemsSpec> queryItemSpecList(String itemId);

    ItemsParam queryItemParam(String itemId);

    CommentLevelCountsVO queryCommentCounts(String itemId);

    PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);
}
