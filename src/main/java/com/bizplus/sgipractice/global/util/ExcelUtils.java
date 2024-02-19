package com.bizplus.sgipractice.global.util;

import com.bizplus.sgipractice.account.dto.AccountExcelDto;
import com.bizplus.sgipractice.global.annotation.ExcelColumn;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public  class ExcelUtils {
    public void excelDownload(List<AccountExcelDto> data, HttpServletResponse response){
        Workbook workbook = new XSSFWorkbook();

        // 엑셀 파일 sheet 만들기
        Sheet sheet = workbook.createSheet("첫 번째 시트");

        Cell cell = null;

        Row row = null;

        List<String> excelHeaderList = getHeaderName(getClass(data));

        row = sheet.createRow(0);

        for (int i = 0; i < excelHeaderList.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(excelHeaderList.get(i));
        }

        renderExcelBody(data, sheet, row, cell);

        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=account.xlsx");

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("Workbook write 수행 중 IOException 발생!");
            throw new RuntimeException(e);
        } finally {
            closeWorkBook(workbook);
        }
    }

    private List<String> getHeaderName(Class<?> type) {
        LinkedList<String> excelHeaderNameList = Arrays.stream(type.getDeclaredFields())
                .filter(a -> a.isAnnotationPresent(ExcelColumn.class))
                .map(a -> a.getAnnotation(ExcelColumn.class).headerName())
                .collect(Collectors.toCollection(LinkedList::new));

        if(CollectionUtils.isEmpty(excelHeaderNameList)) {
            log.error("헤더 이름이 조회되지 않아 예외 발생!");
            throw new IllegalStateException("헤더 이름이 없습니다.");
        }

        return excelHeaderNameList;
    }


    private Class<?> getClass(List<?> data) {
        if (!CollectionUtils.isEmpty(data)) {
            return data.get(data.size() - 1).getClass();
        } else {
            log.error("리스트가 비어 있어서 예외 발생!");
            throw new IllegalStateException("조회된 리스트가 비어 있습니다. 확인 후 다시 진행해주세요.");
        }
    }

    private void renderExcelBody(List<AccountExcelDto> data, Sheet sheet, Row row, Cell cell) {
        int rowCount = 1;

        for (AccountExcelDto dto : data) {
            row = sheet.createRow(rowCount++);

            cell = row.createCell(0);
            cell.setCellValue(dto.getCode());
            cell = row.createCell(1);
            cell.setCellValue(dto.getType());
            cell = row.createCell(2);
            cell.setCellValue(dto.getName());
            cell = row.createCell(3);
            cell.setCellValue(dto.getBusinessNumber());
            cell = row.createCell(4);
            cell.setCellValue(dto.getCeo());
            cell = row.createCell(5);
            cell.setCellValue(dto.getEtc());
        }
    }

    private void closeWorkBook(Workbook workbook) {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
