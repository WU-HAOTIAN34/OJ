package com.wht.oj2025.constant;

public interface UserConstant {

    public static final String USER_ADMIN = "admin";
    public static final String USER_BAN = "ban";
    public static final String USER_DEFAULT_ROLE = "user";

    public static final String PASSWORD_SALT = "asdfghjkl";
    public static final String PASSWORD_NOT_SAME = "两次输入的密码不一致";
    public static final String PASSWORD_LENGTH_ERROR = "密码长度过短不得少于8位";
    public static final String ACCOUNT_LENGTH_ERROR = "用户名长度过短不得少于4位";
    public static final String ACCOUNT_REPEAT_ERROR = "用户名已存在";
    public static final String ACCOUNT_NOT_EXIST = "用户名不存在";
    public static final String PASSWORD_INCORRECT = "密码错误";
    public static final String USER_LOGIN_STATE = "user_login";
    public static final String USER_NOT_LOGIN = "未登录";
    public static final String USER_BANNED = "账号已被封禁";
    public static final String USER_DELETED = "账号已被删除";
    public static final String USERNAME_LENGTH_ERROR = "用户昵称长度不得大于16字符";
    public static final String USERPROFILE_LENGTH_ERROR = "用户简介长度不得大于64字符";
    public static final String AUTHORITY_ERROR = "用户权限不足";

}
