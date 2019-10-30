package com.xyl.pay.domain;

/**
 * Created by acer on 19/9/23.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author acer
 * @version 1.0
 * @date 19/9/23 creat AliPayReqParam
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AliPayReqParam {

    //必选	64	商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
    private String out_trade_no;
    //		必选	64	销售产品码，与支付宝签约的产品码名称。注：目前仅支持FAST_INSTANT_TRADE_PAY	FAST_INSTANT_TRADE_PAY
    private String product_code;
    // 必选	11	订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。	88.88
    private String total_amount;
    //必选	256	订单标题	Iphone6 16G
    private String subject;
    //可选	128	订单描述	Iphone6 16G
    private String body;
    //可选	32	绝对超时时间，格式为yyyy-MM-dd HH:mm:ss	2016-12-31 10:05:01
    private String time_expire;
    //可选		订单包含的商品列表信息，json格式，其它说明详见商品明细说明
    private String goods_detail;
    // 可选	512	公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。	merchantBizType%3d3C%26merchantBizNo%3d2016010101111

    String passback_params;
    //  ExtendParams extend_params;//可选		业务扩展参数
    //可选	2	商品主类型 :0-虚拟类商品,1-实物类商品 注：虚拟类商品不支持使用花呗渠道	0
    String goods_type;
    //可选	6	该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m	90m
    String timeout_express;
    //可选	512	优惠参数 注：仅与支付宝协商后可用	{"storeIdType":"1"}
    String promo_params;
    //    RoyaltyInfo royalty_info;//	可选		描述分账信息，json格式，详见分账参数说明
    //  SubMerchant sub_merchant;//	可选		间连受理商户信息体，当前只对特殊银行机构特定场景下使用此字段
    //	可选	32	商户原始订单号，最大长度限制32位	20161008001
    String merchant_order_no;
    //	可选	128	可用渠道,用户只能在指定渠道范围内支付，多个渠道以逗号分割 注，与disable_pay_channels互斥 渠道列表：https://docs.open.alipay.com/common/wifww7	pcredit,moneyFund,debitCardExpress
    String enable_pay_channels;
    //可选	32	商户门店编号	NJ_001
    String store_id;
    //可选	128	禁用渠道,用户不可用指定渠道支付，多个渠道以逗号分割 注，与enable_pay_channels互斥 渠道列表：https://docs.open.alipay.com/common/wifww7	pcredit,moneyFund,debitCardExpress
    String disable_pay_channels;
    //可选	2	PC扫码支付的方式，支持前置模式和 跳转模式。 前置模式是将二维码前置到商户 的订单确认页的模式。需要商户在 自己的页面中以 iframe 方式请求 支付宝页面。
    String qr_pay_mode;
    /* 具体分为以下几种：
       0：订单码-简约前置模式，对应 iframe 宽度不能小于600px，高度不能小于300px；
        1：订单码-前置模式，对应iframe 宽度不能小于 300px，高度不能小于600px；
        3：订单码-迷你前置模式，对应 iframe 宽度不能小于 75px，高度不能小于75px；
        4：订单码-可定义宽度的嵌入式二维码，商户可根据需要设定二维码的大小。
        跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。
        2：订单码-跳转模式	1*/

    Number qrcode_width;

    //可选	4商户自定义二维码宽度  注：qr_pay_mode=4时该参数生效	100
    // SettleInfo settle_info;//    可选 描述结算信息，json格式，详见结算参数说明
    //InvoiceInfo invoice_info;//    可选 开票信息
    // AgreementSignParams agreement_sign_params;//    可选 签约参数，支付后签约场景使用
    /*
      可选	16 请求后页面的集成方式。   取值范围：
                1.ALIAPP：支付宝钱包内
                2.PCWEB：PC端访问
        默认值为PCWEB。PCWEB*/
    String integration_type;

    //可选	256请求来源地址。如果使用ALIAPP的集成方式，用户中途取消支付会返回该地址。https://
    String request_from_url;

    //    可选	512商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
    String business_params;

    // ExtUserInfo ext_user_info;//    可选 外部指定买家

}
