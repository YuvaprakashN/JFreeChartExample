package org.srishti.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PieChartService {



    public  DefaultPieDataset<String> getDataSet() throws IOException {

        //Get root path : src/main/resources
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println("ROOT path: "+rootPath);

      //Get application.properties path: src/main/resources/application.properties
        String appConfigPath = rootPath + "application.properties";
        System.out.println("application.properties path: "+appConfigPath);

        // Read application properties
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        // Read data from file
        FileInputStream file = new FileInputStream(new File(appProps.getProperty("READ_EXCEL_FILE_PATH")));


        //Read excel file
        Workbook workbook = new XSSFWorkbook(file);

//Get first sheet from excel
        Sheet sheet = workbook.getSheetAt(0);


//Create data set for barchart
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();


        for (Row row : sheet) {     //Read values row by row in excel sheet

            if (row.getRowNum() == 0) {     //Skip first row (headers)
                continue;
            }
            int label = ((int) row.getCell(0).getNumericCellValue());// read first column in row
            int value = ((int) row.getCell(1).getNumericCellValue());//  read second column in row
dataset.setValue(String.valueOf(label),value);
        }
return dataset;


}}
