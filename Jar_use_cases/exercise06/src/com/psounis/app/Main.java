package com.psounis.app;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException {
        if(Files.notExists(Path.of("images")))
            Files.createDirectory(Path.of("images"));

        try (PDDocument pdf = PDDocument.load(new File("file.pdf"))) {
            PDPage page = pdf.getPage(0);
            PDResources resources = page.getResources();

            int i=1;
            for (var name : resources.getXObjectNames()) {
                PDXObject object = resources.getXObject(name);
                if (object instanceof PDImageXObject) {
                    ImageIO.write(((PDImageXObject) object).getImage(),
                            "jpg", new File("images\\image" + i + ".jpg"));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
