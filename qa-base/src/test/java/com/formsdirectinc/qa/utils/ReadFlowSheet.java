package com.formsdirectinc.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Orina<br>
 *         For reading the row number and its value from excel-sheet
 *
 */
public class ReadFlowSheet {

	private InputStream appFlowLocation;
	private HSSFWorkbook appBook;
	private HSSFSheet appSheet;
	private HSSFCell cellContent;

	public ReadFlowSheet initializeWorkbook(String productname, String sheetName)
			throws IOException {

		String filePath = "build" + File.separator + "resources"
				+ File.separator + "test" + File.separator + "%s"
				+ File.separator + "flows.xls";

		appFlowLocation = new FileInputStream(new File(String.format(filePath,
				productname, productname)));

		appBook = new HSSFWorkbook(appFlowLocation);

		appSheet = appBook.getSheet(sheetName);

		return this;

	}

	public int getColumnNumberUsingContent(String colContent) {
		DataFormatter fmt = new DataFormatter();
		for (Row column : appSheet) {
			for (Cell cell : column) {
				if (colContent.trim().equalsIgnoreCase(
						fmt.formatCellValue(cell).trim())) {
					return cell.getColumnIndex();
				}
			}
		}
		return 0;
	}

	public int getRowNumberUsingContent(String cellContent) {

		for (Row row : appSheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim()
							.equals(cellContent)) {
						return row.getRowNum();
					}
				}
			}
		}
		return 0;
	}

	public int getRowNumberUsingContents(String cellContent) {
		DataFormatter fmt = new DataFormatter();
		for (Row row : appSheet) {
			for (Cell cell : row) {
				if (cellContent.trim().equalsIgnoreCase(
						fmt.formatCellValue(cell).trim())) {
					return cell.getRowIndex();
				}
			}
		}
		return 0;
	}

	public String getCellStringContent(int rowNum, int colNum) throws Exception {

		cellContent = appSheet.getRow(rowNum).getCell(colNum);

		String stringValueOfCell = cellContent.getStringCellValue();

		return stringValueOfCell;

	}

	public Date getCellDateContent(int rowNum, int colNum) throws Exception {

		cellContent = appSheet.getRow(rowNum).getCell(colNum);

		HSSFDateUtil.isCellDateFormatted(cellContent);

		Date dateValueOfCell = cellContent.getDateCellValue();

		return dateValueOfCell;

	}

	public int getCellIntegerContent(int rowNum, int colNum) throws Exception {

		cellContent = appSheet.getRow(rowNum).getCell(colNum);

		int cellData = (int) cellContent.getNumericCellValue();

		return cellData;

	}

	public ReadFlowSheet closeWorkbook() throws IOException {
		appBook.close();
		appFlowLocation.close();
		return this;

	}
}