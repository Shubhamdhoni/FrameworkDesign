package com.org.testrunner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestNGXMLGenerator {

	public static void main(String[] args) {
		String excelFilePath = "./UserData.xlsx";// Provide the path to your Excel file

		try {
			List<String> testCasesToRun = getTestCasesToRun(excelFilePath);

			if (!testCasesToRun.isEmpty()) {
				generateTestNGXML(testCasesToRun);
				runTestNG();
				
				String xmlContent = readTestNGXML("testng_dynamic.xml");
	            System.out.println("Contents of testng_dynamic.xml:");
	            System.out.println(xmlContent);
			} else {
				System.out.println("No test cases marked to run in the Excel sheet.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<String> getTestCasesToRun(String excelFilePath) throws IOException {
		List<String> testCasesToRun = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(excelFilePath); 
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheetAt(0); // Assuming your data is in the first sheet

			for (Row row : sheet) {
				Cell runCell = row.getCell(5); // Assuming the "Run" column is the 6th column (index 5)

				if (runCell != null && runCell.getStringCellValue().equalsIgnoreCase("Yes")) {
					Cell testCaseCell = row.getCell(0); // Assuming the TestCases are in the first column
					if (testCaseCell != null) {
						testCasesToRun.add(testCaseCell.getStringCellValue());
					}
				}
			}

		}

		return testCasesToRun;
	}

	private static void runTestNG() {
		TestNG testNG = new TestNG();
		testNG.setTestSuites(new ArrayList<>(List.of("testng_dynamic.xml")));
		testNG.run();
	}

	 private static void generateTestNGXML(List<String> testCasesToRun) throws IOException {
	        XmlSuite suite = new XmlSuite();
	        suite.setName("DynamicSuite");

	        XmlTest test = new XmlTest(suite);
	        test.setName("DynamicTest");

	        List<XmlClass> xmlClasses = new ArrayList<>();

	        for (String testCase : testCasesToRun) {
	            XmlClass xmlClass = new XmlClass("com.org.loginfeature." + testCase); // Replace "your.package.name" with your actual package name
	            xmlClasses.add(xmlClass);
	        }

	        test.setXmlClasses(xmlClasses);

	        List<XmlSuite> xmlSuites = new ArrayList<>();
	        xmlSuites.add(suite);

	        
	        // Write to file
	        try (FileOutputStream fos = new FileOutputStream("testng_dynamic.xml")) {
	            writeXmlSuite(xmlSuites, fos);
	         // Print to console
	            
	            
		       
	            
	        }
	    }

	    private static void writeXmlSuite(List<XmlSuite> xmlSuites, OutputStream out) {
	        try {
	            PrintWriter writer = new PrintWriter(out);
	            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	            writer.println("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">");
	            for (XmlSuite suite : xmlSuites) {
	                writeXmlSuite(suite, writer, 0);
	            }
	            writer.flush();
	            writer.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static void writeXmlSuite(XmlSuite suite, PrintWriter writer, int indent) {
	        String prefix = "    ".repeat(indent);
	        writer.println(prefix + "<suite name=\"" + suite.getName() + "\">");
	        for (XmlTest test : suite.getTests()) {
	            writeXmlTest(test, writer, indent + 1);
	        }
	        writer.println(prefix + "</suite>");
	    }

	    private static void writeXmlTest(XmlTest test, PrintWriter writer, int indent) {
	        String prefix = "    ".repeat(indent);
	        writer.println(prefix + "<test name=\"" + test.getName() + "\">");
	        writer.println(prefix + "    <classes>");
	        for (XmlClass xmlClass : test.getXmlClasses()) {
	            
	            writeXmlClass(xmlClass, writer, indent + 2);
	            
	        }
	        writer.println(prefix + "    </classes>");
	        writer.println(prefix + "</test>");
	    }

	    private static void writeXmlClass(XmlClass xmlClass, PrintWriter writer, int indent) {
	        String prefix = "    ".repeat(indent);
	        writer.println(prefix + "<class name=\"" + xmlClass.getName() + "\"/>");
	    }
	    
	    
	    
	    
	    private static String readTestNGXML(String filePath) throws IOException {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        }
	        return content.toString();
	    }
}