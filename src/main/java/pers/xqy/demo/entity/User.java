package pers.xqy.demo.entity;

import java.util.Date;

public class User {
    //用户Id 主键
    private Integer uId;
    //用户OpenId
    private String uOpenId;
    //用户性别
    private String uGender;
    //用户昵称
    private String uNickName;
    //用户所在城市
    private String uCountry;
    //用户头像
    private String uAvatarUrl;
    //用户是否可评论 默认为1 可评论
    private Integer uCanComment;
    //用户最后登陆时间
    private Date uLastLoginTime;
    //用户注册时间
    private Date uRegisterTime;

    public Date getuLastLoginTime() {
        return uLastLoginTime;
    }

    public void setuLastLoginTime(Date uLastLoginTime) {
        this.uLastLoginTime = uLastLoginTime;
    }

    public Date getuRegisterTime() {
        return uRegisterTime;
    }

    public void setuRegisterTime(Date uRegisterTime) {
        this.uRegisterTime = uRegisterTime;
    }

    public Integer getuCanComment() {
        return uCanComment;
    }

    public void setuCanComment(Integer uCanComment) {
        this.uCanComment = uCanComment;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuOpenId() {
        return uOpenId;
    }

    public void setuOpenId(String uOpenId) {
        this.uOpenId = uOpenId;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    public String getuCountry() {
        return uCountry;
    }

    public void setuCountry(String uCountry) {
        this.uCountry = uCountry;
    }

    public String getuAvatarUrl() {
        return uAvatarUrl;
    }

    public void setuAvatarUrl(String uAvatarUrl) {
        this.uAvatarUrl = uAvatarUrl;
    }
}
