import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;

import domain.Student;

/**
 * Created by meridian on 2019/7/31.
 */
public class Test {
    public static void main(String[] args) {

        String str = "{\"name\":\"沙参麦冬汤\",\"detail\":[ 连翘09g,豆豉09g,荆芥穗09g]}";

        Map<String,Object> map = new HashMap<String, Object>();
        List<String> list = new ArrayList<String>();
        list.add("连翘09g");
        list.add("豆豉09g");
        list.add("荆芥穗09g");
        map.put("name","沙参麦冬");
        map.put("detail",list);
        System.out.println(JsonOb);

       /* String str = "01";
        System.out.println(Integer.parseInt(str));*/

        System.out.println(Integer.valueOf(""));
       /*Double d = 0.2499;

        BigDecimal sumPrice = new BigDecimal(0);
        for(int i=0;i<10;i++){
            sumPrice = sumPrice.add(new BigDecimal("0.29909").multiply(new BigDecimal(i)));
        }
        System.out.println(sumPrice);
        System.out.println(new BigDecimal("0.29999").multiply(new BigDecimal("0.09")));*/

        /*Student s = new Student();
        System.out.println(s.toString());*/

        /*Student s = new Student();
        s.setSex("男");
        if(s == null || s.getSex().equals("男")){
            System.out.println("------------------------");
        }*/

        /*String str = new String("123");
        change(str);
        System.out.println(str);*/

        //Map<String,String> map = JSONObject.parseObject(mapStr,Map.class);
    }

   /* private static void change(String str) {
        str = "abc";

    }*/
}
