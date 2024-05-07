package com.example.demo;

import java.io.IOException;
import java.util.regex.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Pdf_parser {
    String path;

    public Pdf_parser(String path) {
        this.path = path;
    }

    public String parce_pdf() throws IOException {
        PdfReader reader = new PdfReader(this.path);
        int pages = reader.getNumberOfPages();
        for (int i = 1; i <= pages; i++) {
            StringBuilder text = new StringBuilder();
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
            Pattern pattern = Pattern.compile(".*BDU:\\d{4}-\\d{5}.*"); //:\\d{4}-\\d{5}


            String text_str = "пвп BDU:2228-22228 сканирования провести анализ о\n\r" ; //

            Matcher matcher = pattern.matcher(text_str);
            System.out.println(matcher.matches());

        }
        reader.close();
        return "BDU:2014-00001";
    }



}



