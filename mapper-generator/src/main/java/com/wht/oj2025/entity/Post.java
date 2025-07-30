package com.wht.oj2025.entity;

import java.util.Date;
import javax.persistence.*;

/**
 * 表名：post
*/
@Table(name = "post")
public class Post {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Byte isDelete;

    /**
     * 内容
     */
    private String content;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取标签列表（json 数组）
     *
     * @return tags - 标签列表（json 数组）
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签列表（json 数组）
     *
     * @param tags 标签列表（json 数组）
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取点赞数
     *
     * @return thumbNum - 点赞数
     */
    public Integer getThumbNum() {
        return thumbNum;
    }

    /**
     * 设置点赞数
     *
     * @param thumbNum 点赞数
     */
    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    /**
     * 获取收藏数
     *
     * @return favourNum - 收藏数
     */
    public Integer getFavourNum() {
        return favourNum;
    }

    /**
     * 设置收藏数
     *
     * @param favourNum 收藏数
     */
    public void setFavourNum(Integer favourNum) {
        this.favourNum = favourNum;
    }

    /**
     * 获取创建用户 id
     *
     * @return userId - 创建用户 id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置创建用户 id
     *
     * @param userId 创建用户 id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
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
     * @return updateTime - 更新时间
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

    /**
     * 获取是否删除
     *
     * @return isDelete - 是否删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}