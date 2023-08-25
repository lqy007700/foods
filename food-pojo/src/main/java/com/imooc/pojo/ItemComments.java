package com.imooc.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "item_comments")
public class ItemComments {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_spec_id")
    private Integer itemSpecId;

    @Column(name = "spec_name")
    private String specName;

    /**
     * 评价等级
     */
    @Column(name = "comment_level")
    private Integer commentLevel;

    /**
     * 评价内容
     */
    private String content;

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
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * @return item_spec_id
     */
    public Integer getItemSpecId() {
        return itemSpecId;
    }

    /**
     * @param itemSpecId
     */
    public void setItemSpecId(Integer itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    /**
     * @return spec_name
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * @param specName
     */
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    /**
     * 获取评价等级
     *
     * @return comment_level - 评价等级
     */
    public Integer getCommentLevel() {
        return commentLevel;
    }

    /**
     * 设置评价等级
     *
     * @param commentLevel 评价等级
     */
    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    /**
     * 获取评价内容
     *
     * @return content - 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评价内容
     *
     * @param content 评价内容
     */
    public void setContent(String content) {
        this.content = content;
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