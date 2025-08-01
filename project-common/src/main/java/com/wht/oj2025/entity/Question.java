package com.wht.oj2025.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 表名：question
*/
@Table(name = "question")
public class Question implements Serializable {
    /**
     * id
     */
    private static final long serialVersionUID = 1L;

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
    private Integer submitNum;

    /**
     * 题目通过数
     */
    private Integer acceptedNum;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
     * 题目答案
     */
    private String answer;

    /**
     * 判题用例（json 数组）
     */
    private String judgeCase;

    /**
     * 判题配置（json 对象）
     */
    private String judgeConfig;

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
     * @return submitNum - 题目提交数
     */
    public Integer getSubmitNum() {
        return submitNum;
    }

    /**
     * 设置题目提交数
     *
     * @param submitNum 题目提交数
     */
    public void setSubmitNum(Integer submitNum) {
        this.submitNum = submitNum;
    }

    /**
     * 获取题目通过数
     *
     * @return acceptedNum - 题目通过数
     */
    public Integer getAcceptedNum() {
        return acceptedNum;
    }

    /**
     * 设置题目通过数
     *
     * @param acceptedNum 题目通过数
     */
    public void setAcceptedNum(Integer acceptedNum) {
        this.acceptedNum = acceptedNum;
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
     * @return judgeCase - 判题用例（json 数组）
     */
    public String getJudgeCase() {
        return judgeCase;
    }

    /**
     * 设置判题用例（json 数组）
     *
     * @param judgeCase 判题用例（json 数组）
     */
    public void setJudgeCase(String judgeCase) {
        this.judgeCase = judgeCase;
    }

    /**
     * 获取判题配置（json 对象）
     *
     * @return judgeConfig - 判题配置（json 对象）
     */
    public String getJudgeConfig() {
        return judgeConfig;
    }

    /**
     * 设置判题配置（json 对象）
     *
     * @param judgeConfig 判题配置（json 对象）
     */
    public void setJudgeConfig(String judgeConfig) {
        this.judgeConfig = judgeConfig;
    }
}