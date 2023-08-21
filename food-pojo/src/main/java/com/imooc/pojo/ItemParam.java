package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "item_param")
public class ItemParam {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "item_id")
    private Integer itemId;

    /**
     * 产地
     */
    @Column(name = "produc_place")
    private String producPlace;

    /**
     * 保质期
     */
    @Column(name = "foot_period")
    private String footPeriod;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 生产厂名
     */
    @Column(name = "factory_name")
    private String factoryName;

    /**
     * 生产地址
     */
    @Column(name = "factory_address")
    private String factoryAddress;

    /**
     * 包装方式
     */
    @Column(name = "packaging_method")
    private String packagingMethod;

    /**
     * 重量
     */
    private Integer weight;

    /**
     * 存储方式
     */
    @Column(name = "storage_method")
    private String storageMethod;

    /**
     * 使用方式
     */
    @Column(name = "eat_method")
    private String eatMethod;

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
     * 获取产地
     *
     * @return produc_place - 产地
     */
    public String getProducPlace() {
        return producPlace;
    }

    /**
     * 设置产地
     *
     * @param producPlace 产地
     */
    public void setProducPlace(String producPlace) {
        this.producPlace = producPlace;
    }

    /**
     * 获取保质期
     *
     * @return foot_period - 保质期
     */
    public String getFootPeriod() {
        return footPeriod;
    }

    /**
     * 设置保质期
     *
     * @param footPeriod 保质期
     */
    public void setFootPeriod(String footPeriod) {
        this.footPeriod = footPeriod;
    }

    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取生产厂名
     *
     * @return factory_name - 生产厂名
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * 设置生产厂名
     *
     * @param factoryName 生产厂名
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    /**
     * 获取生产地址
     *
     * @return factory_address - 生产地址
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * 设置生产地址
     *
     * @param factoryAddress 生产地址
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    /**
     * 获取包装方式
     *
     * @return packaging_method - 包装方式
     */
    public String getPackagingMethod() {
        return packagingMethod;
    }

    /**
     * 设置包装方式
     *
     * @param packagingMethod 包装方式
     */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }

    /**
     * 获取重量
     *
     * @return weight - 重量
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置重量
     *
     * @param weight 重量
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取存储方式
     *
     * @return storage_method - 存储方式
     */
    public String getStorageMethod() {
        return storageMethod;
    }

    /**
     * 设置存储方式
     *
     * @param storageMethod 存储方式
     */
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    /**
     * 获取使用方式
     *
     * @return eat_method - 使用方式
     */
    public String getEatMethod() {
        return eatMethod;
    }

    /**
     * 设置使用方式
     *
     * @param eatMethod 使用方式
     */
    public void setEatMethod(String eatMethod) {
        this.eatMethod = eatMethod;
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