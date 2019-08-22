package com.huyouxiao.space.common.utils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class PDFWaterMark {
  private static int interval = -5;

  /**
   * 添加文字水印
   * @param inputFile 文件源地址
   * @param outputFile 文件输出地址
   * @param waterMarkName 水印文字
   */
  public static void waterMark(String inputFile,
      String outputFile, String waterMarkName) {
    try {
      PdfReader reader = new PdfReader(inputFile);
      PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
          outputFile));
      //这里获取一个默认的BaseFont
      BaseFont base = BaseFont.createFont();

      Rectangle pageRect;
      PdfGState gs = new PdfGState();
      //设置文字透明度
      gs.setFillOpacity(0.2f);
      gs.setStrokeOpacity(0.2f);
      //获取pdf总页数
      int total = reader.getNumberOfPages() + 1;

      JLabel label = new JLabel();
      FontMetrics metrics;
      int textH;
      int textW;
      label.setText(waterMarkName);
      metrics = label.getFontMetrics(label.getFont());
      //得到文字的宽高
      textH = metrics.getHeight();
      textW = metrics.stringWidth(label.getText());

      PdfContentByte under;
      for (int i = 1; i < total; i++) {
        pageRect = reader.getPageSizeWithRotation(i);
        //得到一个覆盖在上层的水印文字
        under = stamper.getOverContent(i);
        under.saveState();
        under.setGState(gs);
        under.beginText();
        //设置水印文字颜色
        under.setColorFill(BaseColor.LIGHT_GRAY);
        //设置水印文字和大小
        under.setFontAndSize(base, 30);

        //这个position主要是为了在换行加水印时能往右偏移起始坐标
        int position = 0;
        for (int height = interval + textH; height < pageRect.getHeight(); height = height + textH * 8) {
          for (int width = interval + textW + position * 50; width < pageRect.getWidth() + textW; width = width + textW * 3) {
            //添加水印文字，水印文字成30度角倾斜
            under.showTextAligned(Element.ALIGN_LEFT, waterMarkName, width - textW , height - textH, 30);
          }
          position++;
        }
        // 添加水印文字
        under.endText();
      }
      //一定不要忘记关闭流
      stamper.close();
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    File root = new File("/home/huxing/my-repo/space/space-dao/src/main/resources/python");
    String output = "/home/huxing/outputpdf/";
    File[] files = root.listFiles();
    for(File file:files){
       if (file.isFile() && file.getName().endsWith("pdf")) {
          String outputName = output + file.getName();
          waterMark(file.getAbsolutePath(), outputName, "https://huyouxiao.com");
       }
    }
/*      String fileIn = "/home/huxing/books/life/personal/诗经取名高分宝典之李姓两字版.pdf";
    String fileOut = "/home/huxing/books/life/personal/诗经取名高分宝典之李姓(两字版).pdf";
    waterMark(fileIn, fileOut, "https://huyouxiao.com");*/
  }
}
