package com.imooc.service;

import com.imooc.pojo.*;

import java.util.List;

public interface ItemsService {
    Items queryItemById(String itemId);

    List<ItemsImg> queryItemImgList(String itemId);

    List<ItemsSpec> queryItemSpecList(String itemId);

    ItemsParam queryItemParam(String itemId);
}
