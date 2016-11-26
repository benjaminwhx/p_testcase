package com.jd.bt.register;

/**
 * User: 吴海旭
 * Date: 2016-11-26
 * Time: 下午9:48
 */
public class RegisterDTO {
    // 用户名
    private String userName;
    // 密码
    private String password;
    // 短信验证码
    private String phoneVerifyCode;
    // 图形验证码
    private String imageVerifyCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneVerifyCode() {
        return phoneVerifyCode;
    }

    public void setPhoneVerifyCode(String phoneVerifyCode) {
        this.phoneVerifyCode = phoneVerifyCode;
    }

    public String getImageVerifyCode() {
        return imageVerifyCode;
    }

    public void setImageVerifyCode(String imageVerifyCode) {
        this.imageVerifyCode = imageVerifyCode;
    }
}
