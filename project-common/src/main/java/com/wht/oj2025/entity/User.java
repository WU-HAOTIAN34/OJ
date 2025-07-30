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
    @Column(name = "userAccount")
    private String useraccount;

    /**
     * 密码
     */
    @Column(name = "userPassword")
    private String userpassword;

    /**
     * 微信开放平台id
     */
    @Column(name = "unionId")
    private String unionid;

    /**
     * 公众号openId
     */
    @Column(name = "mpOpenId")
    private String mpopenid;

    /**
     * 用户昵称
     */
    @Column(name = "userName")
    private String username;

    /**
     * 用户头像
     */
    @Column(name = "userAvatar")
    private String useravatar;

    /**
     * 用户简介
     */
    @Column(name = "userProfile")
    private String userprofile;

    /**
     * 用户角色：user/admin/ban
     */
    @Column(name = "userRole")
    private String userrole;

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
     * 是否删除
     */
    @Column(name = "isDelete")
    private Byte isdelete;

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
     * @return useraccount - 账号
     */
    public String getUseraccount() {
        return useraccount;
    }

    /**
     * 设置账号
     *
     * @param useraccount 账号
     */
    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    /**
     * 获取密码
     *
     * @return userpassword - 密码
     */
    public String getUserpassword() {
        return userpassword;
    }

    /**
     * 设置密码
     *
     * @param userpassword 密码
     */
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    /**
     * 获取微信开放平台id
     *
     * @return unionid - 微信开放平台id
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * 设置微信开放平台id
     *
     * @param unionid 微信开放平台id
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * 获取公众号openId
     *
     * @return mpopenid - 公众号openId
     */
    public String getMpopenid() {
        return mpopenid;
    }

    /**
     * 设置公众号openId
     *
     * @param mpopenid 公众号openId
     */
    public void setMpopenid(String mpopenid) {
        this.mpopenid = mpopenid;
    }

    /**
     * 获取用户昵称
     *
     * @return username - 用户昵称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户昵称
     *
     * @param username 用户昵称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户头像
     *
     * @return useravatar - 用户头像
     */
    public String getUseravatar() {
        return useravatar;
    }

    /**
     * 设置用户头像
     *
     * @param useravatar 用户头像
     */
    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    /**
     * 获取用户简介
     *
     * @return userprofile - 用户简介
     */
    public String getUserprofile() {
        return userprofile;
    }

    /**
     * 设置用户简介
     *
     * @param userprofile 用户简介
     */
    public void setUserprofile(String userprofile) {
        this.userprofile = userprofile;
    }

    /**
     * 获取用户角色：user/admin/ban
     *
     * @return userrole - 用户角色：user/admin/ban
     */
    public String getUserrole() {
        return userrole;
    }

    /**
     * 设置用户角色：user/admin/ban
     *
     * @param userrole 用户角色：user/admin/ban
     */
    public void setUserrole(String userrole) {
        this.userrole = userrole;
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

    /**
     * 获取是否删除
     *
     * @return isdelete - 是否删除
     */
    public Byte getIsdelete() {
        return isdelete;
    }

    /**
     * 设置是否删除
     *
     * @param isdelete 是否删除
     */
    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }
}