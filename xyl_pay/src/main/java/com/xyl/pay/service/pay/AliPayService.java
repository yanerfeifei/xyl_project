package com.xyl.pay.service.pay;

/**
 * Created by acer on 19/9/23.
 */

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.xyl.pay.config.AliPayConfig;
import com.xyl.pay.domain.AliPayReqParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author acer
 * @version 1.0
 * @date 19/9/23 creat AliPayService
 */
@Service
public class AliPayService {

    @Autowired
    AliPayConfig aliPayConfig;

    public void alipayTradePagePay(HttpServletRequest httpRequest,
                                   HttpServletResponse httpResponse, AliPayReqParam aliPayReqParam) throws ServletException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient( aliPayConfig.getGATEWAYURL(), aliPayConfig.APP_ID, aliPayConfig.APP_PRIVATE_KEY, aliPayConfig.FORMAT, aliPayConfig.CHARSET, aliPayConfig.ALIPAY_PUBLIC_KEY, aliPayConfig.SIGN_TYPE );
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //alipayRequest.setReturnUrl( ALIPAY_ReturnUrl );
        //在公共参数中设置回跳和通知地址
        //alipayRequest.setNotifyUrl( ALIPAY_NotifyUrl );
        //填充业务参数
        alipayRequest.setBizContent( JSON.toJSONString( aliPayReqParam ) );
        String form = "";
        try {
            //调用SDK生成表单
            form = alipayClient.pageExecute( alipayRequest ).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType( "text/html;charset=" + aliPayConfig.CHARSET );
        //直接将完整的表单html输出到页面
        httpResponse.getWriter().write( form );
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    public AlipayTradePrecreateResponse alipayQRcodePay(AlipayTradePrecreateModel tradePrecreateModel) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient( aliPayConfig.GATEWAYURL, aliPayConfig.APP_ID, aliPayConfig.APP_PRIVATE_KEY, aliPayConfig.FORMAT, aliPayConfig.CHARSET, aliPayConfig.ALIPAY_PUBLIC_KEY, aliPayConfig.SIGN_TYPE );
        //创建API对应的request
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel( tradePrecreateModel );
        System.out.println(JSON.toJSONString( request ));
        AlipayTradePrecreateResponse response = alipayClient.execute( request );
        System.out.println(JSON.toJSONString( response ));
        return response;
    }

    public AlipayTradeQueryResponse queryAlipayTrade(AlipayTradeQueryModel tradeQueryModel) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient( aliPayConfig.getGATEWAYURL(), aliPayConfig.APP_ID, aliPayConfig.APP_PRIVATE_KEY, "json", aliPayConfig.CHARSET, aliPayConfig.ALIPAY_PUBLIC_KEY, "RSA2" );
        //创建API对应的request类
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        //设置业务参数
        request.setBizModel(  tradeQueryModel  );
        //通过alipayClient调用API，获得对应的response类
        AlipayTradeQueryResponse response = alipayClient.execute( request );

        System.out.println(JSON.toJSONString( response ));
        return response;
    }


}
