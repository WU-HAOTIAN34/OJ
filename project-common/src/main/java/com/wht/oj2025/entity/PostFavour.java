package com.wht.oj2025.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 表名：post_favour
*/
@Table(name = "post_favour")
public class PostFavour {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 帖子 id
     */
    private Long postId;

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
     * 获取帖子 id
     *
     * @return postId - 帖子 id
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置帖子 id
     *
     * @param postId 帖子 id
     */
    public void setPostId(Long postId) {
        this.postId = postId;
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
}