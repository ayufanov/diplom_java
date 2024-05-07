package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Xlsx_parser {

    MeasureList bdu_ids;

    public Xlsx_parser(MeasureList bdu_ids) {
        this.bdu_ids = bdu_ids;

    }
    public ObservableList<Vul> parse(List<String> vendorList, String meas_num, Workbook res, ObservableList<String> status, ObservableList<Vul> vul_list) throws IOException {

        String[] params = new String[6];


        Workbook wb = new XSSFWorkbook(new FileInputStream("vullist.xlsx"));

        //ObservableList<Vul> vul_list = FXCollections.observableArrayList();

        for(Row row : wb.getSheetAt(0)){
            String row_str = row.getCell(0).getStringCellValue();
            for(int i = 0; i < bdu_ids.size(); i++){
                    if (row_str.equals(bdu_ids.get(i).idBDU)){
//                        System.out.println(row.getCell(3).getCellType());
//                        System.out.println(vendorList.getFirst().getClass());
//                        System.out.println(vendorList.getFirst().length());
                            String vendor = String.valueOf(row.getCell(3));
                            String vedors_string = vendorList.getFirst();
                            System.out.println(vedors_string);
                        if(vedors_string.contains(vendor)){

                            Sheet sheet =  res.getSheetAt(0);
                            Row row_res = sheet.createRow(sheet.getLastRowNum()+1);

                            row_res.createCell(0).setCellValue(sheet.getLastRowNum()+1);
                            row_res.createCell(1).setCellValue(meas_num);
                            row_res.createCell(2).setCellValue(row.getCell(0).getStringCellValue());
                            row_res.createCell(3).setCellValue(row.getCell(4).getStringCellValue());
                            row_res.createCell(4).setCellValue(row.getCell(6).getStringCellValue());
                            row_res.createCell(5).setCellValue(row.getCell(5).getStringCellValue());


                            ComboBox statusbox = new ComboBox<String>(status);
                            statusbox.setValue("");
                            res.write(new FileOutputStream(new File("result.xlsx")));
                            vul_list.add(new Vul(sheet.getLastRowNum(),meas_num, row.getCell(0).getStringCellValue(),row.getCell(4).getStringCellValue(),row.getCell(6).getStringCellValue(),row.getCell(5).getStringCellValue(), statusbox));
                        }

                        //System.out.println(vendorList.getFirst().contains((row.getCell(3)));

                    }
            }


            }

        return vul_list;
    }
}
