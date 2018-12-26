package com.tingkelai.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * 重置用户密码vo
 * 2018-12-24 11:25:24
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "重置用户密码vo")
@Component
public class ResetUserVO {

    @ApiModelProperty(value = "手机号", name = "15239198710", example = "15239198710")
    private String phone;

    @ApiModelProperty(value = "密码", name = "password", example = "123")
    private String password;

    @ApiModelProperty(value = "手机验证码", name = "verifyCode", example = "123456")
    private String verifyCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
