package lib;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelReader {
    public FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;
    String path = null;

    public excelReader() throws IOException {
        path = System.getProperty("user.dir") + "\\TestDATA\\SeleniumTestDATA.xlsx";
        fis = new FileInputStream(path);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
    }

    public int sheetRowCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        return (sheet.getLastRowNum() + 1);


    }

    public int sheetColumnsCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(0);
        return (row.getLastCellNum());

    }

    // Get data from excel by cell index
    public String getDataExcel(String sheetName, int colNum, int rowNum) {
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        return (cell.getStringCellValue());

    }

    // Get data from excel using for loop for given sheet name and column name and row index
    public String getDataExcelbyColumnName(String sheetName, String colName, int rowNum) {
        int colNum = -1;
        int index = workbook.getSheetIndex(sheetName);
        sheet = workbook.getSheetAt(index);
        for (int i = 0; i < sheetColumnsCount(sheetName); i++) {
            row = sheet.getRow(0);
            cell = row.getCell(i);

            if (cell.getStringCellValue().equals(colName)) {
                colNum = cell.getColumnIndex();
                break;

            }

        }
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        return (cell.getStringCellValue());

    }

    public void readExcel() throws InterruptedException, IOException {

        Thread.sleep(10000);
        File dir = new File(System.getProperty("user.dir") + "\\TestDATA\\SeleniumTestDATA.xlsx");
        File[] dirContents = dir.listFiles();
        String fileName = dirContents[0].getName();
        String url = System.getProperty("user.dir") + "\\TestDATA\\SeleniumTestDATA.xlsx\\" + fileName;
        File file = new File(url);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        //Iterate through rows and columns to read data
        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();  //move to next row
        }
        fis.close();

    }









    @Test
    public void row_Column_Count() throws IOException {
        excelReader red = new excelReader();
        System.out.println("LoginTestData sheet hase row");
        System.out.println(red.sheetRowCount("LoginTestData"));

        System.out.println("SignupDATA sheet hase row");
        System.out.println(red.sheetRowCount("SignupDATA"));

        System.out.println("LoginTestData sheet hase columns");
        System.out.println(red.sheetColumnsCount("LoginTestData"));

        System.out.println("SignupDATA sheet hase columns");
        System.out.println(red.sheetColumnsCount("SignupDATA"));

        System.out.print("Selected cell data >> ");
        System.out.println(red.getDataExcel("LoginTestData", 0, 1));


        System.out.print("Selected column and row data >> ");
        System.out.println(red.getDataExcelbyColumnName("LoginTestData", "Password", 4));

        System.out.println();


    }
}





