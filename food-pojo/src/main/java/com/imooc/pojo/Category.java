package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class  Category {
    /**
     * 主键
     */
    private Integer id;

    private String name;

    private Byte type;

    @Column(name = "father_id")
    private Integer fatherId;

    private String logo;

    private String slogan;

    @Column(name = "cat_image")
    private String catImage;

    @Column(name = "bg_color")
    private String bgColor;

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
     * @return father_id
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     * @param fatherId
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return slogan
     */
    public String getSlogan() {
        return slogan;
    }

    /**
     * @param slogan
     */
    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    /**
     * @return cat_image
     */
    public String getCatImage() {
        return catImage;
    }

    /**
     * @param catImage
     */
    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    /**
     * @return bg_color
     */
    public String getBgColor() {
        return bgColor;
    }

    /**
     * @param bgColor
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
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