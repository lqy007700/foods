package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Items {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "sell_count")
    private Integer sellCount;

    @Column(name = "root_cat_id")
    private Integer rootCatId;

    private Byte status;

    private String conntent;

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
     * @return item_name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
     * @return sell_count
     */
    public Integer getSellCount() {
        return sellCount;
    }

    /**
     * @param sellCount
     */
    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }

    /**
     * @return root_cat_id
     */
    public Integer getRootCatId() {
        return rootCatId;
    }

    /**
     * @param rootCatId
     */
    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @return conntent
     */
    public String getConntent() {
        return conntent;
    }

    /**
     * @param conntent
     */
    public void setConntent(String conntent) {
        this.conntent = conntent;
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