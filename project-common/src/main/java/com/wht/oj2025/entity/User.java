package com.wht.oj2025.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 表名：user
*/
@Builder
@Accessors(chain = true)
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 微信开放平台id
     */
    private String unionId;

    /**
     * 公众号openId
     */
    private String mpOpenId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

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
     * 获取账号
     *
     * @return userAccount - 账号
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 设置账号
     *
     * @param userAccount 账号
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * 获取密码
     *
     * @return userPassword - 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取微信开放平台id
     *
     * @return unionId - 微信开放平台id
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置微信开放平台id
     *
     * @param unionId 微信开放平台id
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取公众号openId
     *
     * @return mpOpenId - 公众号openId
     */
    public String getMpOpenId() {
        return mpOpenId;
    }

    /**
     * 设置公众号openId
     *
     * @param mpOpenId 公众号openId
     */
    public void setMpOpenId(String mpOpenId) {
        this.mpOpenId = mpOpenId;
    }

    /**
     * 获取用户昵称
     *
     * @return userName - 用户昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户昵称
     *
     * @param userName 用户昵称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户头像
     *
     * @return userAvatar - 用户头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 设置用户头像
     *
     * @param userAvatar 用户头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    /**
     * 获取用户简介
     *
     * @return userProfile - 用户简介
     */
    public String getUserProfile() {
        return userProfile;
    }

    /**
     * 设置用户简介
     *
     * @param userProfile 用户简介
     */
    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * 获取用户角色：user/admin/ban
     *
     * @return userRole - 用户角色：user/admin/ban
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置用户角色：user/admin/ban
     *
     * @param userRole 用户角色：user/admin/ban
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
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
}