package com.xyl.pay.domain;

import com.xyl.pay.util.DateUtil;

import java.util.Date;

/**
 * Created by meridian on 2019/10/28.
 */
public class Test {
    public static void main(String[] args) {
        Date d = DateUtil.strToDate("2019-10-25 18:29:54","yyyy-MM-dd HH:mm:ss");
        int m = DateUtil.dayDifferenceByCondition(d,new Date(),3);
        System.out.println(m);
        System.out.println(m>=24*60);
    }
}
