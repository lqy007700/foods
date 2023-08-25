package com.imooc.pojo.vo;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;

import java.util.List;

public class ItemsInfoVO {
    private Items items;
    private List<ItemsImg> itemsImg;
    private List<ItemsSpec> itemsSpecs;
    private ItemsParam itemsParam;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public List<ItemsImg> getItemsImg() {
        return itemsImg;
    }

    public void setItemsImg(List<ItemsImg> itemsImg) {
        this.itemsImg = itemsImg;
    }

    public List<ItemsSpec> getItemsSpecs() {
        return itemsSpecs;
    }

    public void setItemsSpecs(List<ItemsSpec> itemsSpecs) {
        this.itemsSpecs = itemsSpecs;
    }

    public ItemsParam getItemsParam() {
        return itemsParam;
    }

    public void setItemsParam(ItemsParam itemsParam) {
        this.itemsParam = itemsParam;
    }
}