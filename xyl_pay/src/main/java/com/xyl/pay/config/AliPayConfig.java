package com.xyl.pay.config;

/**
 * Created by acer on 19/9/23.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Component
@ConfigurationProperties(prefix = "spring.alipay")
public class AliPayConfig {

    /**
     * 支付宝网关gatewayUrl
     */
    @Value("${spring.alipay.GATEWAYURL}")
    public String GATEWAYURL;
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
     */
    @Value("${spring.alipay.APP_ID}")
    public String APP_ID;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @Value("${spring.alipay.APP_PRIVATE_KEY}")
    public String APP_PRIVATE_KEY;

    /**
     * 格式
     */
    @Value("${spring.alipay.FORMAT}")
    public String FORMAT;

    /**
     * 字符编码格式
     */
    @Value("${spring.alipay.CHARSET}")
    public String CHARSET;

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    @Value("${spring.alipay.ALIPAY_PUBLIC_KEY}")
    public String ALIPAY_PUBLIC_KEY;

    /**
     * 签名方式
     */
    @Value("${spring.alipay.SIGN_TYPE}")
    public String SIGN_TYPE;

    private AliPayConfig() {}

    /**
     * PostContruct是spring框架的注解，在方法上加该注解会在项目启动的时候执行该方法
     *  也可以理解为在spring容器初始化的时候执行该方法。
     */
    @PostConstruct
    public void sys() {
        System.out.println(description());
    }

    public String description() {
        StringBuilder sb = new StringBuilder("\nConfigs{");
        sb.append(" 支付宝网关: ").append(GATEWAYURL).append("\n");
        sb.append(", appid: ").append(APP_ID).append("\n");
        sb.append(", 商户RSA私钥: ").append(getKeyDescription(APP_PRIVATE_KEY)).append("\n");
        sb.append(", 支付宝RSA公钥: ").append(getKeyDescription(ALIPAY_PUBLIC_KEY)).append("\n");
        sb.append(", 签名类型: ").append(SIGN_TYPE).append("\n");
        sb.append("}");
        return sb.toString();
    }
    private String getKeyDescription(String key) {
        int showLength = 6;
        if (null != key && key.length() > showLength) {
            return new StringBuilder(key.substring(0, showLength)).append("******")
                    .append(key.substring(key.length() - showLength)).toString();
        }
        return null;
    }
}
