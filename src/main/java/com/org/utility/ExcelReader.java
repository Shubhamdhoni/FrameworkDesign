package com.org.utility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String getTestData(String testCaseToSearch,String labelToSearch) {
		
		String filePath = "./UserData.xlsx"; // Provide the path to your Excel file
		String result = null ;

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming your data is in the first sheet

            int rowIdx = findRowIdx(sheet, testCaseToSearch);
            if (rowIdx != -1) {
                int labelColumnIdx = findColumnIdx(sheet, labelToSearch);

                if (labelColumnIdx != -1) {
                    Row row = sheet.getRow(rowIdx);
                    Cell cell = row.getCell(labelColumnIdx);

                    if (cell != null) {
                         result = cell.getStringCellValue();
                        System.out.println("Result: " + result);
                        
                    } else {
                        System.out.println("Label not found for the given Test Case.");
                    }
                } else {
                    System.out.println("Label column not found in the sheet.");
                }
            } else {
                System.out.println("Test Case not found in the sheet.");
            }
            
             

        } catch (IOException e) {
            e.printStackTrace();
        }
		return result;

		
       
	}

    public static void main(String[] args) {
            }

    private static int findRowIdx(Sheet sheet, String testCase) {
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Assuming TestCases are in the first column

            if (cell != null && cell.getStringCellValue().equals(testCase)) {
                return row.getRowNum();
            }
        }
        return -1; // Test Case not found
    }

    private static int findColumnIdx(Sheet sheet, String label) {
        Row headerRow = sheet.getRow(0); // Assuming headers are in the first row

        for (Cell cell : headerRow) {
            if (cell != null && cell.getStringCellValue().equals(label)) {
                return cell.getColumnIndex();
            }
        }
        return -1; // Label not found
    }
}
