package com.leaf.BasicDatatypes;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by pekall on 17-1-3.
 * Double类型测试验证
 */
public class DoubleTest {
    /**
     * java double 转String整数位大于8位会自动使用科学计数法，下面是不使用科学技术法和保留小数位的验证
     */
    @Test
    public void test(){
        //不使用科学计数法，但是小数为会自动保留三位小数
        Double d = new Double("123456789.12345678");
        System.out.println("d:="+d);
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        System.out.println("d:="+nf.format(d).toString());
        System.out.println();


        double myvalue = 123456789.1234567890123;
        //Option 1 Print bare double.
        System.out.println(myvalue);
        //Option2, use decimalFormat.
        //不使用科学计数法，最多8位小数
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        System.out.println(df.format(myvalue));

        //不使用科学计数法，保留9位小数，不足9位自动补零
        //Option 3, use printf.
        System.out.printf("%.9f", myvalue);
        System.out.println();

        //Double转BigDecimal小数位多，要原样的小数位输出，先把Double转成string然后再转成BigDecimal小数位就和原来一样
        //Option 4, convert toBigDecimal and ask for toPlainString().
        System.out.println("toBigDecimal:"+new BigDecimal(myvalue).toPlainString());
        System.out.println("toBigDecimal:"+new BigDecimal(String.valueOf(myvalue)).toPlainString());

        //Option 5, String.format
        System.out.println(String.format("%.12f", myvalue));



        Double double1 = 123456789.123456789;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");//格式化设置
        System.out.println(decimalFormat.format(double1));
        System.out.println(double1);


        //不使用科学计数法，默认保留6位小数，会使用四舍五入
        double dd = 123456789.123;
        System.out.println(String.format("%f", dd));
        System.out.println(df.format(dd));

    }
}
