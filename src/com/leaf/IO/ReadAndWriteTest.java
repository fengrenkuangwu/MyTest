package com.leaf.IO;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pekall on 17-2-17.
 */
public class ReadAndWriteTest {

    @Test
    public void test(){
        FileWriter fw= null;
        try {
            File txtFile = new File("/home/pekall/桌面/paizhi_sql.txt");
            if(!txtFile.exists()){
                txtFile.createNewFile();
            }
            fw = new FileWriter(txtFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //写入中文字符时会出现乱码
        BufferedWriter bw=new BufferedWriter(fw);
        //BufferedWriter  bw=new BufferedWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/phsftp/evdokey/evdokey_201103221556.txt")), "UTF-8")));

        File file = new File("/home/pekall/桌面/peizhi.txt");
        String line = "";
        String sql1 = "";
        String sql2 = "";
        String column = "";
        String value = "";
        String column2 = "";
        String value2  = "";

        List<String> sqlList = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            while ((line = bf.readLine()) != null) {
                if(line.contains("谢谢关注斗鱼TV：434213")){
                    value = line.substring(0,line.indexOf("谢谢关注斗鱼TV：434213"));
                    value.trim();
                    sql1 = "";
                    sql2 = "";
                    sql1 +="insert pc_conf ( name ";
                    sql2 +="values ( '"+value+"' ";
                }else if(line.contains("CPU")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "cpu";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "cpu_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("散热")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "sanre";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "sanre_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("内存")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "neicun";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "neicun_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("固态")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "gutai";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "gutai_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("硬盘")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "yingpan";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "yingpan_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("主板")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "zhuban";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "zhuban_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("显卡")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "xianka";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "xianka_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("电源")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "dianyuan";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "dianyuan_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("机箱")&&(line.contains("："))&&(line.contains("＝"))){
                    column = "jixiang";
                    value = line.substring(line.indexOf("：")+1,line.indexOf("＝")).trim();
                    column2 = "jixiang_price";
                    value2 = line.substring(line.indexOf("＝")+1).trim();
                    sql1+=","+column+" ,"+column2+" ";
                    sql2+=",'"+value+"','"+value2+"' ";
                }else if(line.contains("合计")&&(line.contains("："))){
                    column = "total";
                    value = line.substring(line.indexOf("：")+1).trim();
                    sql1+=","+column+" )";
                    sql2+=",'"+value+"');";
                    sqlList.add(sql1+sql2);

                    sql1 = "";
                    sql2 = "";
                }

            }
            bw.write(sqlList.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
