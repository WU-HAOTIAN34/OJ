package com.wht.oj2025.entity;

import java.util.Date;
import javax.persistence.*;

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
    @Column(name = "postId")
    private Long postid;

    /**
     * 创建用户 id
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

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
     * @return postid - 帖子 id
     */
    public Long getPostid() {
        return postid;
    }

    /**
     * 设置帖子 id
     *
     * @param postid 帖子 id
     */
    public void setPostid(Long postid) {
        this.postid = postid;
    }

    /**
     * 获取创建用户 id
     *
     * @return userid - 创建用户 id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置创建用户 id
     *
     * @param userid 创建用户 id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}