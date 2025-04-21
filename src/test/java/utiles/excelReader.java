package utiles;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excelReader {
    private static final String filePath = System.getProperty("user.dir") + "/src/main/resources/";

    public static Object[][] getExcelData(String filename, int sheetIndex) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(filePath + filename));
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            if (sheetIndex >= workbook.getNumberOfSheets()) {
                throw new IllegalArgumentException("Sheet index " + sheetIndex + " is out of bounds " + workbook.getNumberOfSheets());
            }

            XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
            return extractRowData(sheet);
        }
    }
    private static Object[][] extractRowData(XSSFSheet sheet) {
        int totalRows = sheet.getPhysicalNumberOfRows();
        if (totalRows == 0) {
            return new Object[0][0];
        }
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[totalRows][totalCols];
        for (int i = 0; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < totalCols; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i][j] = cell.toString().trim();
                }
            }
        }
        return data;
    }
}
