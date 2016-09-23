package com.leaf.picture;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by pekall on 16-7-29.
 */
public class QrCodeUtil {

    public static final String TEMP_PIC_APP_PATH = "/home/pekall/桌面";
    //0为自动调整复杂度
    public static final int qrCodeVersion = 0;

    public static String makeQrPic(String content, String fileName){

        OutputStream out = null;
        String picURL = null;
        String picName = fileName + ".png";
        try {
            String filePath = TEMP_PIC_APP_PATH;
            File file = new File(filePath);
            if (!file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            System.out.println("Pictures are saved content is: " + filePath);
            File qrConde = new File(file + picName);
            System.out.println("Is qrCode has exists : " + qrConde.exists());
            if (!qrConde.exists()) {
                encoderQRCode(content, filePath + File.separator + picName, qrCodeVersion);
            }
            picURL = TEMP_PIC_APP_PATH + "/" + picName;
            System.out.println("Temporary picture URL path is: " + picURL);

        } catch (Exception ex) {
            System.out.println("Error saving temporary picture!");
            ex.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Abnormal closing flow!");
                }
            }
        }
        return picURL;
    }

    /**
     * 生成二维码的方法
     * @param content
     * @param imgPath
     * @param qrCodeVersion
     */
    public static void encoderQRCode(String content, String imgPath, int qrCodeVersion) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(qrCodeVersion);

            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            //设置每个点的大小
            int areaSize = 3;

            byte[] contentBytes = content.getBytes("utf8");
            System.out.println("QRCode content url is" + content);
            // 输出内容> 二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);

                int imgSize = areaSize * codeOut.length + pixoff*2;
                BufferedImage bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
                Graphics2D gs = bufImg.createGraphics();
                gs.setBackground(Color.WHITE);
                gs.clearRect(0, 0, imgSize, imgSize);
                // 设定图像颜色> BLACK
                gs.setColor(Color.BLACK);

                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * areaSize + pixoff, i * areaSize + pixoff, areaSize, areaSize);
                        }
                    }
                }

                gs.dispose();
                bufImg.flush();
                File imgFile = new File(imgPath);
                // 生成二维码QRCode图片
                ImageIO.write(bufImg, "png", imgFile);
            } else {
                System.out.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,800 ]. ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 生成二维码（在二维码上面加一行文字，由于文字有大小，所以qrCodeVersion建议给大于0的合适的确定值）
     * @param content
     * @param tittle
     * @param imgPath
     * @param qrCodeVersion
     */
    public static void encoderQRCode(String content, String tittle, String imgPath, int qrCodeVersion) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(qrCodeVersion);

            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            //设置每个点的大小
            int areaSize = 3;
            //12号字体14px
            Font font = new Font("宋体", Font.BOLD, 12);
            //字的Y高
            int fontSize = 14;

            byte[] contentBytes = content.getBytes("utf8");
            System.out.println("QRCode content url is" + content);

            // 输出内容> 二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);

                int imgSizeX = areaSize * codeOut.length + pixoff*2;
                //汉字和图片隔开2个偏移量好看，在加上底部的一个偏移量=3
                int imgSizeY = areaSize * codeOut.length + pixoff*3 + fontSize;
                BufferedImage bufImg = new BufferedImage(imgSizeX, imgSizeY, BufferedImage.TYPE_INT_RGB);

                Graphics2D gs = bufImg.createGraphics();
                gs.setBackground(Color.WHITE);
                gs.clearRect(0, 0, imgSizeX, imgSizeY);
                // 设定图像颜色> BLACK
                gs.setColor(Color.BLACK);
                gs.setFont(font);

                gs.drawString(tittle, pixoff, fontSize);

                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * areaSize + pixoff, i * areaSize + pixoff*2 + fontSize, areaSize, areaSize);
                        }
                    }
                }

                gs.dispose();
                bufImg.flush();
                File imgFile = new File(imgPath);
                // 生成二维码QRCode图片
                ImageIO.write(bufImg, "png", imgFile);
            } else {
                System.out.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,800 ]. ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 生成二维码（在二维码上面加一行文字，由于文字有大小，所以qrCodeVersion建议给大于0的合适的确定值），上个方法升级，可以多行汉字
     * @param content
     * @param tittles
     * @param imgPath
     * @param qrCodeVersion
     */
    public static void encoderQRCode(String content, String[] tittles, String imgPath, int qrCodeVersion) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            qrcodeHandler.setQrcodeErrorCorrect('M');
            qrcodeHandler.setQrcodeEncodeMode('B');
            qrcodeHandler.setQrcodeVersion(qrCodeVersion);

            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            //设置每个点的大小
            int areaSize = 3;
            //12号字体14px
            Font font = new Font("宋体", Font.BOLD, 12);
            int fontSize = 14;
            //加入文字行数
            int lineNum;
            if(tittles == null){
                lineNum = 0;
            }else{
                lineNum = tittles.length;
            }


            byte[] contentBytes = content.getBytes("utf8");
            System.out.println("QRCode content is" + content);

            // 输出内容> 二维码
            if (contentBytes.length > 0 && contentBytes.length < 800) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);

                int imgSizeX = areaSize * codeOut.length + pixoff*2;
                //汉字和图片隔开2个偏移量好看，在加上底部的一个偏移量=3
                int imgSizeY = areaSize * codeOut.length + pixoff*3 + fontSize*lineNum;
                BufferedImage bufImg = new BufferedImage(imgSizeX, imgSizeY, BufferedImage.TYPE_INT_RGB);

                //画图片
                Graphics2D gs = bufImg.createGraphics();
                //设定背景色
                gs.setBackground(Color.WHITE);
                //涂色
                gs.clearRect(0, 0, imgSizeX, imgSizeY);
                // 设定图像颜色-> BLACK
                gs.setColor(Color.BLACK);
                //设定文字格式
                gs.setFont(font);
                //写入文字
                for(int i=0; i<lineNum; i++){
                    gs.drawString(tittles[i], pixoff, fontSize*(i+1));

                }


                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * areaSize + pixoff, i * areaSize + pixoff*2 + fontSize*lineNum, areaSize, areaSize);
                        }
                    }
                }

                gs.dispose();
                bufImg.flush();
                File imgFile = new File(imgPath);
                // 生成二维码QRCode图片
                ImageIO.write(bufImg, "png", imgFile);
            } else {
                System.out.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,800 ]. ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args){
        //makeQrPic("我是一个测试用的图片，你扫一下看看是不是？","testPic");
        encoderQRCode("我也是来测试的，里面放了一个身份证号码，这个身份证号码是110101201609221945，同时我还要这个身份证号码显示在上面^_^",
                "110101201609221945",TEMP_PIC_APP_PATH + File.separator +"picAndFont.png",11);
        encoderQRCode("我也是来测试的，里面放了一个身份证号码，这个身份证号码是110101201609221945，同时我还要这个身份证号码显示在上面^_^",
                new String[]{"神经粒子研究院董事部","110101201609221945"},TEMP_PIC_APP_PATH + File.separator +"picAndFont1.png",11);
    }
}
