package com.zhengyu.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密：明文-->密文，只能加密，不能解密， 每次加密结果一样，所以我们对密码加上一个随机字符串来提高安全性
    // hello --> abc23def456
    // hello + 3eb45 --> ....
    public static String md5(String key) {
        if(StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
