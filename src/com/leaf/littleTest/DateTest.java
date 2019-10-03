package com.leaf.littleTest;

import com.leaf.json.TestJsonBean;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by leaf on 16-10-21.
 */
public class DateTest {

    @Test
    public void test(){
        //获取昨天日期
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date d=cal.getTime();
        Date dd=new Date(System.currentTimeMillis()-1000*60*60*24);

        System.out.println(d);
        System.out.println(dd);

        //null强转对象 强转不报错，转后的对象为null
        List aa = (List)null;
        TestJsonBean a = new TestJsonBean();
        a = (TestJsonBean)null;
    }


}
