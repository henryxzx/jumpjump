package pers.xqy.demo.entity;

public class Admin {
    //管理员Id
    private Integer adminId;
    //管理员登陆名称
    private String adminLoginName;
    //管理员登陆密码
    private String adminLoginPassword;
    //管理员名字
    private String adminName;
    //管理员手机号
    private String adminPhone;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName;
    }

    public String getAdminLoginPassword() {
        return adminLoginPassword;
    }

    public void setAdminLoginPassword(String adminLoginPassword) {
        this.adminLoginPassword = adminLoginPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }
}
