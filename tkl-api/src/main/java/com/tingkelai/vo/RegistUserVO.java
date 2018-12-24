package com.tingkelai.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * 注册用户用vo
 * 2018-12-24 11:25:24
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "注册用户vo")
@Component
public class RegistUserVO {

    @ApiModelProperty(value = "用户名（手机号，必须是手机号）", name = "15239198710", example = "15239198710")
    private String phone;

    @ApiModelProperty(value = "密码", name = "password", example = "123")
    private String password;

    @ApiModelProperty(value = "公司名称", name = "teamName", example = "德玛西亚公司")
    private String teamName;

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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
