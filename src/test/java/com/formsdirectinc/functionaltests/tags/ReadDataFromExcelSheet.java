package com.formsdirectinc.functionaltests.tags;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Orina<br>
 *         For reading the row number and its value from excel-sheet
 *
 */
public class ReadDataFromExcelSheet {

	private FileInputStream appFlowLocation;
	private HSSFWorkbook appBook;
	private HSSFSheet appSheet;
	private HSSFCell cellContent;

	public ReadDataFromExcelSheet initializeWorkbook(String sheetName)
			throws IOException {

		String filePath = "src/test/resources/flowsheet/Product_Flows.xls";

		appFlowLocation = new FileInputStream(new File(filePath));

		appBook = new HSSFWorkbook(appFlowLocation);

		appSheet = appBook.getSheet(sheetName);

		return this;

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

	public double getCellIntegerContent(int rowNum, int colNum)
			throws Exception {

		cellContent = appSheet.getRow(rowNum).getCell(colNum);

		double cellData = cellContent.getNumericCellValue();

		return cellData;

	}

	public ReadDataFromExcelSheet closeWorkbook() throws IOException {
		appBook.close();
		appFlowLocation.close();
		return this;

	}
}