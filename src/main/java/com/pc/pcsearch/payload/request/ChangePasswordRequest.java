package com.pc.pcsearch.payload.request;

public class ChangePasswordRequest {
    private String oldPassword;

    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}
