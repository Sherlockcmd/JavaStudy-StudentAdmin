package com.easy.springboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String KEY = "easy";

    //接收业务数据,生成token并返回
    public static String createToken(Map<String, Object> map) {
        return JWT.create()
                .withClaim("claims", map) //有效载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 )) //失效时间
                .sign(Algorithm.HMAC256(KEY)); //秘钥
    }

    //接收token,验证token,并返回业务数据
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("ID",2);
        String token = createToken(map);
        System.out.println(token);

        String token2 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsibmFtZSI6InpoYW5nc2FuIiwiSUQiOjJ9LCJleHAiOjE3NjA3MDg1NTV9.DLhYxmdvXQmEJTTcy0SEZhIun-PqnC_dqE5EmHtY4cE";
        Map<String, Object> map2 = parseToken(token2);
        System.out.println(map2);

    }
}
