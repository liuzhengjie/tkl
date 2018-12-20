package com.tingkelai.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel(description = "用户登录用vo")
@Component
public class LoginUserVO {

    @ApiModelProperty(value = "用户名", name = "admin")
    private String username;

    @ApiModelProperty(value = "密码", name = "123")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
