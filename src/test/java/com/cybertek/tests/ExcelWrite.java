package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_writing_test() throws IOException {

        String path = "SampleData.xlsx";
        FileInputStream fileIn = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileIn);
        sheet = workbook.getSheet("Employees");

        //King's row
        row = sheet.getRow(1);

        //King's cell
        cell = row.getCell(1);

        //Create and store Adam's cell
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before = " + adamsCell);

        //This method will override existing cell
        adamsCell.setCellValue("Madam");

        System.out.println("After = " + adamsCell);


        //TODO: CHANGE STEVEN'S NAME TO TOM
        XSSFCell stevensCell = sheet.getRow(1).getCell(0);
        System.out.println("Before = " + stevensCell);

        for(int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }

        }

        System.out.println("After = " + stevensCell);



//     ----------------------------------------------------------------

        //BELOW LINES ARE GOOD A PRACTICE TO IMPLEMENT AT THE END

        //Use fileOutputStream to push changes
        FileOutputStream fileOut = new FileOutputStream(path);

        //Write to file using fileOutputStream
        workbook.write(fileOut);

        fileIn.close();
        fileOut.close();
        workbook.close();

    }


}
