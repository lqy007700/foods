package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Carousel {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "cat_id")
    private Integer catId;

    private Byte type;

    private Byte sort;

    @Column(name = "is_show")
    private Byte isShow;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return background_color
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return item_id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * @return cat_id
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * @param catId
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return sort
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * @return is_show
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}