package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

public class Orders {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_mobile")
    private String receiverMobile;

    @Column(name = "receiver_address")
    private String receiverAddress;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "real_pay_amount")
    private Integer realPayAmount;

    @Column(name = "post_amount")
    private Integer postAmount;

    @Column(name = "pay_method")
    private Byte payMethod;

    @Column(name = "left_msg")
    private String leftMsg;

    private String extand;

    @Column(name = "is_comment")
    private Integer isComment;

    @Column(name = "is_delete")
    private Byte isDelete;

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
     * @return receiver_name
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * @return receiver_mobile
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * @param receiverMobile
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * @return receiver_address
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * @param receiverAddress
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * @return total_amount
     */
    public Integer getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount
     */
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return real_pay_amount
     */
    public Integer getRealPayAmount() {
        return realPayAmount;
    }

    /**
     * @param realPayAmount
     */
    public void setRealPayAmount(Integer realPayAmount) {
        this.realPayAmount = realPayAmount;
    }

    /**
     * @return post_amount
     */
    public Integer getPostAmount() {
        return postAmount;
    }

    /**
     * @param postAmount
     */
    public void setPostAmount(Integer postAmount) {
        this.postAmount = postAmount;
    }

    /**
     * @return pay_method
     */
    public Byte getPayMethod() {
        return payMethod;
    }

    /**
     * @param payMethod
     */
    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * @return left_msg
     */
    public String getLeftMsg() {
        return leftMsg;
    }

    /**
     * @param leftMsg
     */
    public void setLeftMsg(String leftMsg) {
        this.leftMsg = leftMsg;
    }

    /**
     * @return extand
     */
    public String getExtand() {
        return extand;
    }

    /**
     * @param extand
     */
    public void setExtand(String extand) {
        this.extand = extand;
    }

    /**
     * @return is_comment
     */
    public Integer getIsComment() {
        return isComment;
    }

    /**
     * @param isComment
     */
    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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