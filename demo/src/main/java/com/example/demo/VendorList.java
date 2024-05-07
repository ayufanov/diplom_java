package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.File;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class VendorList{
    public List<String> vendorList;
    static final Boolean DEBUG = true;
    public Path path;

    public void setPath(Path path) {
        this.path = path;
    }

    public List<String> getVendorList() {
        return vendorList;
    }

    public VendorList(String path) throws IOException{
        this.vendorList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(path);
        if (jsonFile.exists() && !jsonFile.isDirectory()){
            JsonNode jsonNode = objectMapper.readTree(jsonFile);
            ObjectReader reader = objectMapper.readerFor(new TypeReference<List<String>>() {});
            this.vendorList = reader.readValue(jsonNode.get("vendors"));
        }
        else{
            getVendorListPath();
            getVendorListFromFile();
            saveVEndorstoJSON();
        }
    }

    public void saveVEndorstoJSON(){
        Map <String, Object> map = new HashMap<>();
        map.put("vendors", this.vendorList);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("vendors.json"), map);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> getVendorListFromFile() throws IOException{
        BufferedReader reader = Files.newBufferedReader(this.path, StandardCharsets.UTF_8);
        Stream<String> stream = reader.lines();
        List<String> vendors = new ArrayList<>();
        stream.forEach(vendors::add);
        reader.close();
        this.vendorList = vendors;
        return vendors;
    }

    public void getVendorListPath(){
        if (DEBUG) {
            this.path = FileSystems.getDefault().getPath("D:\\gradYuAIChED\\test.txt");
        }
        else{
            System.out.println("Составление списка вендоров, используемых в организации.\nУкажите полный путь до файла в формате .txt, который содержит список используемых вендоров, разделенных новыми строками. ");
            Scanner scanner = new Scanner(System.in);
            String pathToVendors = scanner.nextLine();
            scanner.close();
            this.path = FileSystems.getDefault().getPath(pathToVendors);
        }
    }
}
