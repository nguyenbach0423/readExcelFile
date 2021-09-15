package dev.helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelHelper {
    public ExcelHelper() {}

    public ArrayList<Sheet> readExcelFile (InputStream inputStream)
    {
        try {
            ArrayList<Sheet> sheets = new ArrayList<>();

            Workbook workbook = new XSSFWorkbook(inputStream);

            Iterator iterator = workbook.sheetIterator();
            while (iterator.hasNext())
            {
                Sheet sheet = (Sheet) iterator.next();
                sheets.add(sheet);
            }

            workbook.close();

            return sheets;
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}