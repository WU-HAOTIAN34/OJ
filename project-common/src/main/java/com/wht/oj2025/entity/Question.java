package com.wht.oj2025.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 表名：question
*/
@Table(name = "question")
public class Question implements Serializable {
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
     * 题目提交数
     */
    @Column(name = "submitNum")
    private Integer submitnum;

    /**
     * 题目通过数
     */
    @Column(name = "acceptedNum")
    private Integer acceptednum;

    /**
     * 点赞数
     */
    @Column(name = "thumbNum")
    private Integer thumbnum;

    /**
     * 收藏数
     */
    @Column(name = "favourNum")
    private Integer favournum;

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
     * 是否删除
     */
    @Column(name = "isDelete")
    private Byte isdelete;

    /**
     * 内容
     */
    private String content;

    /**
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例（json 数组）
     */
    @Column(name = "judgeCase")
    private String judgecase;

    /**
     * 判题配置（json 对象）
     */
    @Column(name = "judgeConfig")
    private String judgeconfig;

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
     * 获取题目提交数
     *
     * @return submitnum - 题目提交数
     */
    public Integer getSubmitnum() {
        return submitnum;
    }

    /**
     * 设置题目提交数
     *
     * @param submitnum 题目提交数
     */
    public void setSubmitnum(Integer submitnum) {
        this.submitnum = submitnum;
    }

    /**
     * 获取题目通过数
     *
     * @return acceptednum - 题目通过数
     */
    public Integer getAcceptednum() {
        return acceptednum;
    }

    /**
     * 设置题目通过数
     *
     * @param acceptednum 题目通过数
     */
    public void setAcceptednum(Integer acceptednum) {
        this.acceptednum = acceptednum;
    }

    /**
     * 获取点赞数
     *
     * @return thumbnum - 点赞数
     */
    public Integer getThumbnum() {
        return thumbnum;
    }

    /**
     * 设置点赞数
     *
     * @param thumbnum 点赞数
     */
    public void setThumbnum(Integer thumbnum) {
        this.thumbnum = thumbnum;
    }

    /**
     * 获取收藏数
     *
     * @return favournum - 收藏数
     */
    public Integer getFavournum() {
        return favournum;
    }

    /**
     * 设置收藏数
     *
     * @param favournum 收藏数
     */
    public void setFavournum(Integer favournum) {
        this.favournum = favournum;
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

    /**
     * 获取题目答案
     *
     * @return answer - 题目答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置题目答案
     *
     * @param answer 题目答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 获取判题用例（json 数组）
     *
     * @return judgecase - 判题用例（json 数组）
     */
    public String getJudgecase() {
        return judgecase;
    }

    /**
     * 设置判题用例（json 数组）
     *
     * @param judgecase 判题用例（json 数组）
     */
    public void setJudgecase(String judgecase) {
        this.judgecase = judgecase;
    }

    /**
     * 获取判题配置（json 对象）
     *
     * @return judgeconfig - 判题配置（json 对象）
     */
    public String getJudgeconfig() {
        return judgeconfig;
    }

    /**
     * 设置判题配置（json 对象）
     *
     * @param judgeconfig 判题配置（json 对象）
     */
    public void setJudgeconfig(String judgeconfig) {
        this.judgeconfig = judgeconfig;
    }
}