package com.huyouxiao.space.poetry.utils;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;

public class BackGroundImage extends PdfPageEventHelper {
  private String picPath = "space-service-poetry/src/main/resources/bg-pdf.png";

  @Override
  public void onStartPage(PdfWriter pdfWriter, Document document) {
    try {
      Image image = Image.getInstance(picPath);
      image.setAlignment(image.UNDERLYING);
      image.setAbsolutePosition(0,0);
      image.scaleAbsolute(595,842);
      document.add(image);
    } catch (BadElementException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }

    super.onStartPage(pdfWriter, document);
  }
}
