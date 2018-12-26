package com.tingkelai.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@ApiModel(description = "用户登录用vo")
@Component
public class LoginUserVO {

    @ApiModelProperty(value = "用户名", name = "admin", example = "string")
    private String username;

    @ApiModelProperty(value = "密码", name = "123", example = "string")
    private String password;

    @ApiModelProperty(value = "公司id", name = "123", example = "5")
    private String teamId;

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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
