package com.xyl.pay.controller;

import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.xyl.pay.service.pay.AliPayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by meridian on 2019/10/10.
 */
@Controller
@RequestMapping("/jsp")
public class PayController {

    @Autowired
    AliPayService aliPayService;

    @RequestMapping("/qrcode")
    public String getOrderAliPayQRcode(ModelMap model){
       // model.addAttribute("code","https://qr.alipay.com/bax06027689i9c33wrg9400d");
       try{
           AlipayTradePrecreateModel aliPayTradePrecreate = new AlipayTradePrecreateModel();
           // out_trade_no; 必选	64	商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
           aliPayTradePrecreate.setOutTradeNo("20150320010101001");
           // total_amount 必选	11	订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。	88.88
           aliPayTradePrecreate.setTotalAmount("0.01");
           //必选subject	256	订单标题	Iphone6 16G
           aliPayTradePrecreate.setSubject("测试");
           AlipayTradePrecreateResponse response = aliPayService.alipayQRcodePay( aliPayTradePrecreate );
           if (response.isSuccess()) {
               String url = response.getQrCode();
               model.addAttribute("code",url);
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return "pay";
    }

    @GetMapping("/code")
    public String getQRcode(ModelMap model){
        //ModelAndView mv =  new ModelAndView("pay");
        model.addAttribute("code","weixin://wxpay/bizpayurl?pr=rxJ6VIC");
        return "pay";
    }
}

/**
 * spring boot项目中是不推荐使用jsp的，但是也可以配置
 * 1、在src/main/下新建webapp/WEB_INF/jsp文件夹
 * 2、在project structure 中创建的web项目添加web模块，并且配置文件的根路径是webapp，且访问路径是/
 * 3、在yml文件中配置接口视图的转发路径和文件类型
 *     spring:
         mvc:
         view:
         prefix: /WEB-INF/jsp/
         suffix: .jsp
 * 4、pom文件中不需要加入spring-boot-starter-thymeleaf的jar引用，若是用到resource中的tempalte时，需要加入此包
 */


