package OrangeHrm.data;

import OrangeHrm.pageaction.AbstractPageAction;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Slf4j
public enum ExcelDataLoader {
    INSTANCE;

    final Workbook workbook;

    ExcelDataLoader() {

        String dataFile = "src/test/resources/data/TestData.xlsx";
        File file = new File(dataFile);

        try (FileInputStream inputStream = new FileInputStream(file)) {

            String fileExtensionName = file.getName().substring(file.getName().indexOf('.'));
            if (fileExtensionName.equals(".xlsx")) {
                this.workbook = new XSSFWorkbook(inputStream);
            } else if (fileExtensionName.equals(".xls")) {
                this.workbook = new HSSFWorkbook(inputStream);
            } else {
                throw new DataLoaderException("The Workbook has an undefined extension!");
            }
        } catch (IOException e) {
            throw new DataLoaderException("Unable to load the Workbook!", e);
        }
    }

    public PageDataFoctory loadDataFactory(String scenarioName) {
        Map<String, PageData> pages = new HashMap<>();

        Row r = workbook.getSheet("LoginPage").getRow(0);
        r.getLastCellNum();

        for (int i = 2; i < r.getLastCellNum(); i++) {
            String columnName = r.getCell(i).getStringCellValue().trim();
            pages.put(STR."LoginPage:\{columnName}", new PageData(getTestData("LoginPage", columnName)));

        }

        String referenceSheetName = getReferenceSheetName(scenarioName).replace("\n", "");
        if (!referenceSheetName.trim().isEmpty()) {

            String[] dataPageToLoad = referenceSheetName.split(";");
            Arrays.asList(dataPageToLoad).forEach(dp -> {
                String[] sheetAndColumnName = dp.split(":");
                String pageSheetName = sheetAndColumnName[0].trim();
                String testDataColumn = sheetAndColumnName[1].trim();
                Map<String, String> data = new HashMap<>();
                data.putAll(getTestData(pageSheetName, testDataColumn));
                PageData pageStep = new PageData(data);
                pages.put(pageSheetName, pageStep);
            });
        }


        return new PageDataFoctory(pages);
    }


    private Map<String, String> getTestData(String pageSheetName, String testDataColumn) {

        Sheet sheetObj = workbook.getSheet(pageSheetName);
        // get the column name - column name is always the first row

        Row columnNameRow = sheetObj.getRow(0);
        int cellCount = columnNameRow.getLastCellNum() - columnNameRow.getFirstCellNum();
        int testDataCellIndex = 0;
        for (int cellIndex = 0; cellIndex < cellCount + 1; cellIndex++) {
            String columnName = columnNameRow.getCell(cellIndex).getStringCellValue();
            if (testDataColumn.equalsIgnoreCase(columnName)) {
                testDataCellIndex = cellIndex;
                break;
            }
        }

        Map<String, String> testData = new HashMap<>();
        int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
        for (int rowIndex = 1; rowIndex < rowCount + 1; rowIndex++) {
            Row row = sheetObj.getRow(rowIndex);


            String elementKey = row.getCell(1).getStringCellValue();
            String value = row.getCell(testDataCellIndex).getStringCellValue().trim();
            String inputvalue = "";
            if (value.contains("Random") || value.contains("CurrentDate")) {
                if (value.split(":")[0].contains("RandomString")) {
                    inputvalue = AbstractPageAction.getRandomString(Integer.parseInt(value.split(":")[1])).toUpperCase();
                    if (value.split(":").length == 3) {

                        inputvalue = inputvalue + value.split(":")[2];

                    }
                } else if (value.split(":")[0].contains("RandomNumber")) {
                    inputvalue = AbstractPageAction.getRandomNumber(Integer.parseInt(value.split(":")[1]));
                } else if (value.split(":")[0].contains("CurrentDate")) {
                    inputvalue = AbstractPageAction.getCurrentDate(value.split(":")[1], value.split(":")[2]);
                }


            } else {

                inputvalue = value;
            }
            testData.put(elementKey, inputvalue);

        }
        return testData;
    }


    public String getReferenceSheetName(String scenarioName) {
        String referenceSheetName = null;

        Sheet sheetObj = workbook.getSheet("Master");
        int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheetObj.getRow(i);
            String tempText = row.getCell(2).getStringCellValue();
            if (tempText.equalsIgnoreCase(scenarioName)) {
                referenceSheetName = row.getCell(3).getStringCellValue();
                break;

            }
        }

        if (referenceSheetName == null) {

            throw new DataLoaderException(STR."The data file Doesn't have the define scenario name\{scenarioName}");
        }

        return referenceSheetName;
    }

}

