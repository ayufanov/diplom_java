package com.example.demo;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.util.regex.Matcher;

public class MeasureLetter {
    public String strContent;
    static final Boolean DEBUG = true;
    public String path;
    public MeasureList measures;


    public MeasureList getMeasures() {
        return measures;
    }



    public MeasureLetter(String path) throws IOException{
        this.measures = new MeasureList();
        this.path = path;
    }

    public void getMeasuresIDs() throws IOException{
        PdfReader reader = new PdfReader(this.path);
        int pages = reader.getNumberOfPages();
        for (int i = 1; i <= pages; i++) {
            StringBuilder text = new StringBuilder();
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
            Pattern idPattern = Pattern.compile("BDU:\\d{4}-\\d{5}");
            Matcher idMatcher = idPattern.matcher(text);
            while (idMatcher.find()){
                String id = idMatcher.group();
                Measure newMeasure = new Measure(id);
                this.measures.add(newMeasure);
            }
        }
        reader.close();
    }

    public void getLetterPath(){
        if (DEBUG){
            this.path = "D:\\Dwnld\\BDU_TEST.pdf";
        }
        else {
            System.out.println("Укажите полный путь до файла письма в формате .pdf");
            Scanner scanner = new Scanner(System.in);
            String pathToVendors = scanner.nextLine();
            scanner.close();
            this.path = pathToVendors;
        }
    }

}
