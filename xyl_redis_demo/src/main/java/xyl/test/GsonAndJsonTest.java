package xyl.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.BigDecimalCodec;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.MD5Util;
import domain.Student;

/**
 * JSON常用组件有三种：：
 * apache jackson
 * ali  fastjson
 * google  gson
 * Created by meridian on 2019/7/27.
 */
public class GsonAndJsonTest {
    public static void main(String[] args) throws UnsupportedEncodingException {

       /* String str = "{\"drug\":\"沙参麦冬\",\"detail\":[{\"name\":\"连翘\",\"specs\":\"09g\"},{\"name\":\"豆豉\",\"specs\":\"09g\"},{\"name\":\"荆芥穗\",\"specs\":\"09g\"}]}";

        Map<String,Object> map = new HashMap<String, Object>();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> mapStr = new HashMap<String, String>();
        mapStr.put("name","连翘");
        mapStr.put("specs","09g");
        Map<String,String> mapStr1 = new HashMap<String, String>();
        mapStr1.put("name","豆豉");
        mapStr1.put("specs","09g");
        Map<String,String> mapStr2 = new HashMap<String, String>();
        mapStr2.put("name","荆芥穗");
        mapStr2.put("specs","09g");
        list.add(mapStr);
        list.add(mapStr1);
        list.add(mapStr2);
        map.put("name","沙参麦冬");
        map.put("detail",list);
        String drug = JSONObject.toJSONString(map);
        System.out.println(JSONObject.toJSONString(map));

        Map<String,Object> map1 = JSONObject.parseObject(drug,Map.class);
		List<Map<String,String>> listmap = (List<Map<String,String>>)map1.get("detail");*/

       //{"doctorUid":"2c9480836d6b6b70016d6b8f87e00000","id":"8569da0b6fea41f1b0c1e723464f9c85","token":"f09862b345944a05bf18a6b13146d0d3","timestamp":"1571888975733"}
        Map<String, String> params = new HashMap<String, String>();
        params.put("doctorUid","2c9480836d6b6b70016d6b8f87e00000");
        params.put("id","8569da0b6fea41f1b0c1e723464f9c85");
        params.put("token","f09862b345944a05bf18a6b13146d0d3");
        params.put("timestamp","1571888975733");

        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            temp.append(URLEncoder.encode(valueString, "UTF-8"));
        }
        String result = MD5Util.encrypt(new String(temp)).toUpperCase();
        System.out.println(result);


        //{"doctorUid":"2c9480836d6b6b70016d6b8f87e00000","id":"2ddc47b65ea4413f81dd50292ac75739","token":"836f377ed19e4702b7a08a4441906933","timestamp":"1571886758516"}
      /* Double d = new Double(0.01);
       String s = "0.01";
        System.out.println(d.equals("0.01"));
        System.out.println(d.equals(Double.valueOf("0.01")));
        System.out.println(s.equals("0.01"));*/

       /* BigDecimal big = new BigDecimal("4.02299999999999995103916461403059656731784343719482421875");
        System.out.println(big.scaleByPowerOfTen(2));
        System.out.println(big.setScale(2,BigDecimal.ROUND_HALF_DOWN));
        System.out.println(big.setScale(2,BigDecimal.ROUND_DOWN));
        System.out.println(big.setScale(2,BigDecimal.ROUND_UP));
        System.out.println(big.setScale(2,BigDecimal.ROUND_CEILING));
        System.out.println(big.setScale(2,BigDecimal.ROUND_FLOOR));
        System.out.println(big.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(big.setScale(2,BigDecimal.ROUND_HALF_EVEN));
        double d = big.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.println("--------------->"+d);*/

     // TODO 自动生成的方法存根
        //生成json
        /*List<Student> arrayList=new ArrayList<Student>();
        Student stu1=new Student("张三", "男");
        Student stu2=new Student("李四", "男");
        Student stu3=new Student("王二", "女");
        arrayList.add(stu1);
        arrayList.add(stu2);
        arrayList.add(stu3);

        Gson gson = new Gson();
        System.out.println("将对象转化成json字符串"+gson.toJson(stu1));
        System.out.println("将list转化成json字符串"+gson.toJson(arrayList));
        String stuStr = gson.toJson(stu1);
        String listStr = gson.toJson(arrayList);

        //转成对象
        Student stu = gson.fromJson(stuStr,Student.class);
        System.out.println(stu.toString());

        List<Student> list = gson.fromJson(listStr,new TypeToken<List<Student>>(){}.getType());
        for(Student s:list)
        {
            System.out.println(s.getName()+" "+s.getSex());
        }
        stu.setName(gson.toJson(stu1));
        System.out.println(gson.toJson("{content':'"+stu.getName()+"'}"));

        System.out.println(gson.toJson(stu.getName()));*/

       /* Map<String,String> map = new HashMap<String, String>();
        map.put("systolic",145+"");
        map.put("diastolic",78+"");
        System.out.println(JSONObject.toJSONString(map));*/

    }
}
