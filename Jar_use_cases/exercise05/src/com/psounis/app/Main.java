package com.psounis.app;

import com.psounis.utils.Resources;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;

import java.io.*;

public class Main {
    public static void makeHeader(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setStyle("Heading1");
        XWPFRun run = paragraph.createRun();
        run.setText(text);
    }

    public static void makeParagraph(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setFirstLineIndent(5);
        XWPFRun run = paragraph.createRun();
        run.addBreak();
        run.setFontFamily("Verdana");
        run.setFontSize(12);
        run.setSmallCaps(true);
        run.setText(text);
    }

    public static void addImageParagraph(XWPFDocument document, String imageFileName) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        try (InputStream inputStream = Resources.getInputStream(imageFileName)) {
            run.addPicture(inputStream, XWPFDocument.PICTURE_TYPE_JPEG,
                           imageFileName, Units.toEMU(300), Units.toEMU(200));
        }
        catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("word.docx")){
            // The styles should be copied from another document that is *using* the styles
            XWPFDocument template = new XWPFDocument(Resources.getInputStream("template.docx"));
            XWPFDocument document = new XWPFDocument();
            document.createStyles().setStyles(template.getStyle());

            makeHeader(document, "An image");
            addImageParagraph(document, "tree.jpg");
            document.write(os);
        } catch (IOException | XmlException e) {
            e.printStackTrace();
        }
    }
}
