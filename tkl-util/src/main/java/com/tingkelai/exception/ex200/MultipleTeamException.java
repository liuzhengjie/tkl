package com.tingkelai.exception.ex200;

import org.apache.shiro.authc.AuthenticationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 如果当前登录手机号对应多个公司，那么返回该错误，让用户自己选择要登录的公司
 * 2018-12-24 10:14:21
 * @author liuzhengjie
 * @version 1.0
 */
public class MultipleTeamException extends AuthenticationException {

    public final static int STATUS = 200001;

    public final static String REASON = "当前账号属于多个公司，请选择要登录的公司！";

    // 多个公司时，返回公司列表
    List<Map<String, String>> teamList = new ArrayList<>();

    public List<Map<String, String>> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Map<String, String>> teamList) {
        this.teamList = teamList;
    }
}
