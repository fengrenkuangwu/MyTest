package com.leaf.picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by pekall on 16-9-22.
 */
public class WriteToPic {
    public static final String TEMP_PIC_APP_PATH = "/home/pekall/桌面";

    public static void main(String[] args) {
        int width = 100;
        int height = 100;
        String text = "爱我中华";
        Font font = new Font("宋体", Font.BOLD, 12);
        int x = 0;
        int y = 0;
        //BufferedImage bufImg = new BufferedImage(100, 100,BufferedImage.TYPE_INT_ARGB);
        BufferedImage bufImg = new BufferedImage(100, 100,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufImg.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, width, height);
        g.setFont(font);
        g.setColor(Color.BLACK);
        FontMetrics fontMetrics = g.getFontMetrics();
        int textX = x + ((width - fontMetrics.stringWidth(text)) / 2);
        int textY = y + ((height - fontMetrics.getHeight()) / 2)
                + fontMetrics.getHeight();
        g.drawString(text, textX, textY);
        File outFile = new File(TEMP_PIC_APP_PATH + "/newfile1.png");
        try {
            ImageIO.write(bufImg, "png", outFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 写图片
    }
}
