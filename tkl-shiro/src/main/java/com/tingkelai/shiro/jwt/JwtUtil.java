package com.tingkelai.shiro.jwt;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 *
 * 2018-12-5 14:10:53
 * @author liuzhengjie
 * @version 1.0
 */
public class JwtUtil {

    //密钥
    @Value("${tkl.jwt.apiKey}")
    private static String apiKey = "ktl";

    //session token有效期为30天
    @Value("${tkl.jwt.sessionTokenExpireSeconds}")
    private static int sessionTokenExpireSeconds = 60 * 60 * 24 * 30;

    //auth token有效期为15天
    @Value("${tkl.jwt.authTokenExpireSeconds}")
    private static int authTokenExpireSeconds = 60 * 60 * 24 * 15;

    @Value("${tkl.jwt.showIssuedAt}")
    private static boolean showIssuedAt = true;

    /**
     * 生成sessionToken签名
     * @param map 需要进行签名的对象，键值对以HashMap的形式存储
     * @return 返回签名
     */
    public static String signSessionToken(Map<String, Object> map){
        JWTSigner signer = new JWTSigner(apiKey);
        JWTSigner.Options options = new JWTSigner.Options();
        options.setExpirySeconds(sessionTokenExpireSeconds);
        options.setIssuedAt(showIssuedAt);
        return signer.sign(map, options);
    }

    /**
     * 验证sessionToken的签名
     * @param token 需要验证的token
     * @return 验证成功，则返回解析之后的Map对象
     */
    public static Map<String, Object> verifySessionToken(String token){
        try {
            JWTVerifier verifier = new JWTVerifier(apiKey);
            return verifier.verify(token);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
