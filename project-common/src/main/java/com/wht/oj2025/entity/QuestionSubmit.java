package com.wht.oj2025.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 表名：question_submit
*/
@Table(name = "question_submit")
public class QuestionSubmit {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;

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
     * 用户代码
     */
    private String code;

    /**
     * 判题信息（json 对象）
     */
    private String judgeInfo;

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
     * 获取编程语言
     *
     * @return language - 编程语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置编程语言
     *
     * @param language 编程语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     *
     * @return status - 判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     *
     * @param status 判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取题目 id
     *
     * @return questionId - 题目 id
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 设置题目 id
     *
     * @param questionId 题目 id
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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
     * 获取用户代码
     *
     * @return code - 用户代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置用户代码
     *
     * @param code 用户代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取判题信息（json 对象）
     *
     * @return judgeInfo - 判题信息（json 对象）
     */
    public String getJudgeInfo() {
        return judgeInfo;
    }

    /**
     * 设置判题信息（json 对象）
     *
     * @param judgeInfo 判题信息（json 对象）
     */
    public void setJudgeInfo(String judgeInfo) {
        this.judgeInfo = judgeInfo;
    }
}