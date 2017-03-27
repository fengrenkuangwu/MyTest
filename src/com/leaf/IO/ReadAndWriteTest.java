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

    /**
     * 剔除日志中的东西
     */
    @Test
    public void test2(){
        String path = "/home/pekall/桌面/debug-20170314.log";
        File dir = new File(path);
        ergodicFile(dir);
        System.out.println(fileList.toString());
        for (String filePath : fileList) {
            File oldLog = new File(filePath);
            FileWriter fw= null;
            try {
                File newLog = new File(filePath+".new");
                if(!newLog.exists()){
                    newLog.createNewFile();
                }
                fw = new FileWriter(newLog);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //写入中文字符时会出现乱码
            BufferedWriter bw=new BufferedWriter(fw);

            BufferedReader bf = null;
            try {
                bf = new BufferedReader(new FileReader(oldLog));
                String line = null;
                while ((line = bf.readLine()) != null) {
                    if(!line.contains("DEBUG org.apache.kafka.clients.NetworkClient.handleDisconnections:463 -Node -1 disconnected.") &&
                            !line.contains("DEBUG org.apache.kafka.clients.NetworkClient.maybeUpdate:644 -Initialize connection to node -1 for sending metadata request") &&
                            !line.contains("DEBUG org.apache.kafka.clients.NetworkClient.initiateConnect:496 -Initiating connection to node -1 at 10.112.57.239:9092.") &&
                            !line.contains("DEBUG org.apache.kafka.common.network.Selector.pollSelectionKeys:345 -Connection with /10.112.57.239 disconnected") &&
                            !line.contains("java.net.ConnectException: 拒绝连接") &&
                            !line.contains("at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)") &&
                            !line.contains("at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:739)") &&
                            !line.contains("at org.apache.kafka.common.network.PlaintextTransportLayer.finishConnect(PlaintextTransportLayer.java:51)") &&
                            !line.contains("at org.apache.kafka.common.network.KafkaChannel.finishConnect(KafkaChannel.java:73)") &&
                            !line.contains("at org.apache.kafka.common.network.Selector.pollSelectionKeys(Selector.java:309)") &&
                            !line.contains("at org.apache.kafka.common.network.Selector.poll(Selector.java:283)") &&
                            !line.contains("at org.apache.kafka.clients.NetworkClient.poll(NetworkClient.java:260)") &&
                            !line.contains("at org.apache.kafka.clients.producer.internals.Sender.run(Sender.java:229)") &&
                            !line.contains("at org.apache.kafka.clients.producer.internals.Sender.run(Sender.java:134)") &&
                            !line.contains("at java.lang.Thread.run(Thread.java:744)")){
                        bw.write(line+"\t\n");
                    }
                }

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


    private List<String> fileList = new ArrayList<>();
    void ergodicFile(File dir,String suffixStr){
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                ergodicFile(new File(dir, children[i]),suffixStr);
            }
        }
        String fileName = dir.getName();
        if(fileName.length()>suffixStr.length() && suffixStr.equals(fileName.substring(fileName.length() - suffixStr.length()))){
            fileList.add(dir.getPath());
        }
    }

    void ergodicFile(File dir){
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                ergodicFile(new File(dir, children[i]));
            }
        }else{
            fileList.add(dir.getPath());
        }
    }
}
