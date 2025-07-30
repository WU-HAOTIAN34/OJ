package com.wht.oj2025.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 表名：question_submit
*/
@Table(name = "question_submit")
public class QuestionSubmit implements Serializable {
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
    @Column(name = "questionId")
    private Long questionid;

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
     * 用户代码
     */
    private String code;

    /**
     * 判题信息（json 对象）
     */
    @Column(name = "judgeInfo")
    private String judgeinfo;

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
     * @return questionid - 题目 id
     */
    public Long getQuestionid() {
        return questionid;
    }

    /**
     * 设置题目 id
     *
     * @param questionid 题目 id
     */
    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
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
     * @return judgeinfo - 判题信息（json 对象）
     */
    public String getJudgeinfo() {
        return judgeinfo;
    }

    /**
     * 设置判题信息（json 对象）
     *
     * @param judgeinfo 判题信息（json 对象）
     */
    public void setJudgeinfo(String judgeinfo) {
        this.judgeinfo = judgeinfo;
    }
}