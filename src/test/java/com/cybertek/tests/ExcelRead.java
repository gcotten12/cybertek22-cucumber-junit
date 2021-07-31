package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    /*
    In this method we will learn how to read from Excel file step by step
     */

    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

        //To be able to read from excel file we need to load it into FileInputStream
        FileInputStream file = new FileInputStream(path);

        //workbook -> sheet -> row -> cell

        //1. Create new workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //2. We need to get the specific sheet from recently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3. Select row and cell
        //Print out Steven's cell
        //Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        //Print out Singer
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        //Returns number of rows used from top to bottom
        //Will not count unused cells
        //Starts from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        //Returns the number of cells from top to bottom
        //Doesn't care if cells are unused
        //Starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();

        //TODO: Create a logic to print out Neena's name dynamically

        for(int rowNum = 0; rowNum < usedRows; rowNum++) {

           if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")) {

               System.out.println("Neena's name = " + sheet.getRow(rowNum).getCell(0));
           }

        }


        //TODO: Create another logic to print out Steven King's JOB_ID
        // Check for Steven's name, If its Steven -> Print out JOB_ID

        for(int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                System.out.println("Steven's JOB_ID is = " + sheet.getRow(rowNum).getCell(2));
            }

        }


    }

}
