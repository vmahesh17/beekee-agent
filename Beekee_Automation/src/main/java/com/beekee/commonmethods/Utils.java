package com.beekee.commonmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {

	public static String getDataFromTestData(String autoTestCaseNameVal, String label) {
		String requiredCellVal = "";
		try {
			FileInputStream fis = new FileInputStream(Constants.TESTDATA);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");
			int rowNum = ws.getLastRowNum() + 1;

			Iterator rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}
			for (int index = 0; index < rowNum; index++) {

				XSSFRow row = ws.getRow(index);
				XSSFCell cell = row.getCell(0);
				String cellVal = cellToString(cell);
				// System.out.println(cellVal);
				if (cellVal.equals(autoTestCaseNameVal)) {
					// System.out.println("Entered"+cellVal+"Row Index:"+index);
					for (int cellIndex = 1; cellIndex < numberOfCells; cellIndex++) {
						XSSFCell findLable = row.getCell(cellIndex);
						String labelString = cellToString(findLable);
						if (labelString.equals(label)) {
							// System.out.println("Cell Index: "+cellIndex);
							XSSFRow nextRow = ws.getRow(index + 1);
							XSSFCell adjacentRowCell = nextRow.getCell(cellIndex);
							String adjacentRowCellVal = cellToString(adjacentRowCell);
							// System.out.println("Cell Val:
							// "+adjacentRowCellVal);
							requiredCellVal = adjacentRowCellVal;
							break;
						}
					}

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return requiredCellVal.trim();
	}

	/*
	 * public static String getDataFromTestData(String component, String Datavalue)
	 * { String requiredCellVal = "";
	 * 
	 * try {
	 * 
	 * FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
	 * "/SASRetail_FieldApp_Mobile/Data/TestData_ASM.xlsx");
	 * 
	 * XSSFWorkbook wb = new XSSFWorkbook(fis); XSSFSheet ws =
	 * wb.getSheet("Sheet1");
	 * 
	 * int rowNum = ws.getLastRowNum() + 1;
	 * 
	 * java.util.Iterator<Row> rowIterator = ws.rowIterator(); int numberOfCells =
	 * 0; if (rowIterator.hasNext()) { Row headerRow = (Row) rowIterator.next(); //
	 * get the number of cells in the header row numberOfCells =
	 * headerRow.getLastCellNum(); }
	 * 
	 * for (int index = 0; index < rowNum; index++) { XSSFRow row =
	 * ws.getRow(index);
	 * 
	 * for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) { XSSFCell
	 * cell = row.getCell(cellIndex); String cellVal = cellToString(cell); if
	 * (cellVal.equals(component)) { XSSFCell adjacentCell = row.getCell(cellIndex +
	 * 1); String adjacentCellVal = cellToString(adjacentCell); requiredCellVal =
	 * adjacentCellVal; break; } }
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return requiredCellVal; }
	 */
	public static String getDataFromTestConfig(String component) {
		String requiredCellVal = "";
		try {
			String currentDir = System.getProperty("user.dir");
			/*
			 * FileInputStream fis = new FileInputStream( System.getProperty(("user.dir") +
			 * "/Data/TestConfiguration.xlsx"));
			 */
			FileInputStream fis = new FileInputStream(currentDir + "/Data/TestConfiguration.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");

			int rowNum = ws.getLastRowNum() + 1;

			Iterator<Row> rowIterator = ws.rowIterator();
			int numberOfCells = 0;
			if (rowIterator.hasNext()) {
				Row headerRow = (Row) rowIterator.next();
				// get the number of cells in the header row
				numberOfCells = headerRow.getLastCellNum();
			}

			for (int index = 0; index < rowNum; index++) {
				XSSFRow row = ws.getRow(index);

				for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
					XSSFCell cell = row.getCell(cellIndex);
					String cellVal = cellToString(cell);
					if (cellVal.equals(component)) {
						XSSFCell adjacentCell = row.getCell(cellIndex + 1);
						String adjacentCellVal = cellToString(adjacentCell);
						requiredCellVal = adjacentCellVal;
						break;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return requiredCellVal;
	}

	public static String cellToString(XSSFCell cell) {
		int type;
		String result;
		// type = cell.getCellType();
		type = cell.getCellType();

		switch (type) {

		case Cell.CELL_TYPE_NUMERIC: // numeric value in Excel
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA: // precomputed value based on formula
			result = "" + cell.getNumericCellValue();
			break;
		case Cell.CELL_TYPE_STRING: // String Value in Excel
			result = "" + cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			result = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN: // boolean value
			result = "" + cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_ERROR:
			result = "Error";
		default:
			throw new RuntimeException("There is no support for this type of cell");
		}

		return result.toString();
	}

	/**
	 * This method is to write the test data to the Excel sheet in the specified
	 * cell
	 */

	public static void putCellData(String filePath, int sheetNo, int RowNum, int ColNum, String Value)
			throws Exception {
		XSSFSheet ExcelWSheet;
		XSSFWorkbook ExcelWBook = null;
		XSSFCell Cell;
		try {

			FileInputStream ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheetAt(sheetNo);

			ExcelWSheet = ExcelWBook.getSheetAt(sheetNo);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			Cell.setCellValue(Value);
			FileOutputStream out = new FileOutputStream(new File(filePath));
			ExcelWBook.write(out);
			out.flush();
			out.close();
//			System.out.println("Put cell data for " + Value);
		} catch (Exception e) {
			// Log.error("Error in Putting cell data!! Please close driver sheet and try
			// running....");
			System.out.println("Error in Putting cell data!! Please close driver sheet and try running....");
			e.printStackTrace();
		}
	}

	/**
	 * Get the Current Date and Time
	 * 
	 * @param Element
	 */
	public static String getCurrentDate() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		Date date = new Date();
		// date.after(getCurrentDate());
		String value = formatter.format(date);
		return value;
	}

	public static String getDates(int i) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		if (i == 0)
			return dateFormat.format(date);
		else
			return dateFormat.format(DateUtils.addDays(date, i));

	}

	public static String fullDate(int i) {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();

		if (i == 0)
			return dateFormat.format(date);
		else
			return dateFormat.format(DateUtils.addDays(date, i));

	}

	public static String getDay(int i) {

		DateFormat dateFormat = new SimpleDateFormat("d");

		Date date = new Date();

		if (i == 0)

			return dateFormat.format(date);
		else
			return dateFormat.format(DateUtils.addDays(date, i));

	}

	public static String DateFromCalendar(int i) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd"); // MMMM yyyy
		// Getting current date
		Calendar cal = Calendar.getInstance();
		// Displaying current date in the desired format
		System.out.println("Current Date: " + sdf.format(cal.getTime()));
		// Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH, i);
		// Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		// Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}

	public static String randomintValueGeneration() {
		// create instance of Random class
		Random rand = new Random();
		// Generate random integers in range 0 to 999999
		int rand_int1 = rand.nextInt(1000000);
		String random_intvalue = Integer.toString(rand_int1);
		// Print random integers
		System.out.println("Random Integers: " + random_intvalue);
		return random_intvalue;
	}

}
