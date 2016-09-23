package com.leaf.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by pekall on 16-9-23.
 * 创建一个pdf文档
 */
public class Pdf1Simple {
    public static String FILE_DIR = "/home/pekall/桌面/";

    /**
     * 简单的创建一个pdf
     */
    @Test
    public void createSimplePdf(){
        try{
            //Step 1—Create a Document.
            Document document = new Document();
            //Step 2—Get a PdfWriter instance.
            PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createSamplePDF.pdf"));
            //Step 3—Open the Document.
            document.open();
            //Step 4—Add content.
            document.add(new Paragraph("Hello World"));
            //Step 5—Close the Document.
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建一个pdf
     * 页面大小,页面背景色,页边空白,Title,Author,Subject,Keywords
     *
     */
    @Test
    public void createPdf(){
        try {
            //页面大小
            Rectangle rect = new Rectangle(PageSize.B5.rotate());
            //页面背景色
            rect.setBackgroundColor(BaseColor.ORANGE);
            Document doc = new Document(rect);
            //new FileOutputStream(FILE_DIR + "createSamplePDF1.pdf")是OutputStream
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(FILE_DIR + "createSamplePDF1.pdf"));
            //PDF版本(默认1.4)
            writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);

            //文档属性
            doc.addTitle("Title@samplePdf");
            doc.addAuthor("Author@Leaf");
            doc.addSubject("Subject@iText sample");
            doc.addKeywords("Keywords@iText");
            doc.addCreator("Creator@iText");
            //页边空白
            doc.setMargins(10, 20, 30, 40);
            doc.open();
            doc.add(new Paragraph("Hello World"));
            doc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    /**
     * 加密pdf
     * 本机linux没跑起来
     */
    @Test
    public void createPdfWithPwd(){
        try{
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createSamplePDFWithPwd.pdf"));
            // 设置密码为："World"
            writer.setEncryption("Hello".getBytes(), "World".getBytes(),
                    PdfWriter.ALLOW_SCREENREADERS,
                    PdfWriter.STANDARD_ENCRYPTION_128);
            document.open();
            document.add(new Paragraph("Hello World"));
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    /**
     * 加页面
     */
    @Test
    public void createPdfAddPage(){
        try{
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE_DIR + "createPDFAndPage.pdf"));
            document.open();
            document.add(new Paragraph("First page"));
            // 加入图片Deepinpl.jpg
            Image jpg = Image.getInstance("/home/pekall/桌面/picAndFont1.png");
            jpg.setAlignment(Image.ALIGN_CENTER);
            document.add(jpg);

            document.newPage();
            writer.setPageEmpty(false);

            document.newPage();
            document.add(new Paragraph("New page"));
            document.add(jpg);

            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
