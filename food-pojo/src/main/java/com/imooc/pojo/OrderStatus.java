package com.imooc.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order_status")
public class OrderStatus {
    /**
     * 主键
     */
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_status")
    private Byte orderStatus;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Integer createTime;

    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Integer payTime;

    /**
     * 发货时间
     */
    @Column(name = "deliver_time")
    private Integer deliverTime;

    /**
     * 交易成功时间
     */
    @Column(name = "success_time")
    private Integer successTime;

    @Column(name = "close_time")
    private Integer closeTime;

    /**
     * 留言时间
     */
    @Column(name = "comment_time")
    private Integer commentTime;

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
     * @return order_id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * @return order_status
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取订单创建时间
     *
     * @return create_time - 订单创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * 设置订单创建时间
     *
     * @param createTime 订单创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Integer getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取发货时间
     *
     * @return deliver_time - 发货时间
     */
    public Integer getDeliverTime() {
        return deliverTime;
    }

    /**
     * 设置发货时间
     *
     * @param deliverTime 发货时间
     */
    public void setDeliverTime(Integer deliverTime) {
        this.deliverTime = deliverTime;
    }

    /**
     * 获取交易成功时间
     *
     * @return success_time - 交易成功时间
     */
    public Integer getSuccessTime() {
        return successTime;
    }

    /**
     * 设置交易成功时间
     *
     * @param successTime 交易成功时间
     */
    public void setSuccessTime(Integer successTime) {
        this.successTime = successTime;
    }

    /**
     * @return close_time
     */
    public Integer getCloseTime() {
        return closeTime;
    }

    /**
     * @param closeTime
     */
    public void setCloseTime(Integer closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取留言时间
     *
     * @return comment_time - 留言时间
     */
    public Integer getCommentTime() {
        return commentTime;
    }

    /**
     * 设置留言时间
     *
     * @param commentTime 留言时间
     */
    public void setCommentTime(Integer commentTime) {
        this.commentTime = commentTime;
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