package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "item_spec")
public class ItemSpec {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    private String name;

    private Integer stock;

    private BigDecimal discounts;

    @Column(name = "price_discounts")
    private Integer priceDiscounts;

    @Column(name = "price_normal")
    private Integer priceNormal;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return discounts
     */
    public BigDecimal getDiscounts() {
        return discounts;
    }

    /**
     * @param discounts
     */
    public void setDiscounts(BigDecimal discounts) {
        this.discounts = discounts;
    }

    /**
     * @return price_discounts
     */
    public Integer getPriceDiscounts() {
        return priceDiscounts;
    }

    /**
     * @param priceDiscounts
     */
    public void setPriceDiscounts(Integer priceDiscounts) {
        this.priceDiscounts = priceDiscounts;
    }

    /**
     * @return price_normal
     */
    public Integer getPriceNormal() {
        return priceNormal;
    }

    /**
     * @param priceNormal
     */
    public void setPriceNormal(Integer priceNormal) {
        this.priceNormal = priceNormal;
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