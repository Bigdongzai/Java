package com.xhd.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * 作者: xhd
 * 创建时间: 2019/8/22 8:44
 * 版本: V1.0
 */
public class PDFUtils {
    public static void createPDF(String content) throws Exception {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.dir") + "/test.pdf"));
        writer.flush();

        writer.close();

        // 3.打开文档
        document.open();

        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese, 12,Font.NORMAL);
        // 4.添加一个内容段落
        document.add(new Paragraph(content,font));

        // 5.关闭文档
        document.close();
    }
}
