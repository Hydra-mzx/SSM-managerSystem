package com.mzx.crud.bean;

public class Admin {
    private Integer adminId;

    private String adminEmail;

    private String adminPassword;

    public Integer getAdminId() {
        return adminId;
    }


	public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail == null ? null : adminEmail.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }
    
    @Override
    public String toString() {
    	return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + "]";
    }
}