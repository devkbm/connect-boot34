package com.like.excel.upload;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.web.multipart.MultipartFile;

// // https://velog.io/@jhoonkim92/DTO%EC%99%80-Custom-Anotation%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-Spring-Excel-Upload-%EA%B3%B5%ED%86%B5-%ED%81%B4%EB%9E%98%EC%8A%A4

public class ExcelUploader<T> {
	
	Class<T> type;
	
	public ExcelUploader(Class<T> clazz) {
		this.type = clazz;
	}
  
    public List<T> map(MultipartFile file/*, Class<T> clazz*/) {    	
    	List<T> dataList = null;
    	
    	try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
    		
    		XSSFSheet sheet = workbook.getSheetAt(0);
    					
    		Row headerRow = sheet.getRow(0);
    		List<String> headers = StreamSupport.stream(headerRow.spliterator(), false)
                    .map(Cell::getStringCellValue)
                    .toList();
    		
    		dataList = StreamSupport.stream(sheet.spliterator(), false)
    				.skip(1) // 첫 번째 행은 헤더이므로 건너뜁니다.
                    .filter(row -> isRowNotEmpty(row)) // 빈 행이 아닌 경우에만 처리합니다.
                    .map(row -> mapRowToDto(row, this.type, headers))
                    .toList();    		    		    
    	} catch(IOException e) {
			//new ExcelReaderFileException(e.getMessage(), e);
		} 
    	    	
    	return dataList;
    }   

    private boolean isRowNotEmpty(Row row) {
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if (cell.getCellType() != CellType.BLANK) {
                return true; // 빈 셀이 아닌 경우에만 true를 반환합니다.
            }
        }
        return false; // 모든 셀이 비어 있으면 false를 반환합니다.
    }

    private T mapRowToDto(Row row, Class<T> clazz, List<String> headers) {
        T dataDTO = null;
        try {
            dataDTO = clazz.getDeclaredConstructor().newInstance();

            Iterator<Cell> cellIterator = row.cellIterator();
            int cellIndex = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String header = headers.get(cellIndex);

                //각 필드를 순회하며 커스텀 어노테이션인 ExcelHeader값에 맞게 값을 넣어줌
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ExcelHeader.class)) {
                        ExcelHeader annotation = field.getAnnotation(ExcelHeader.class);
                        if (annotation.value().equals(header)) {
                            field.setAccessible(true);
                            setFieldValue(field, dataDTO, cell);
                            break;
                        }
                    }
                }

                cellIndex++;
            }
        } catch (Exception e) {
            // 예외 처리 로직 추가
            e.printStackTrace();
        }
        return dataDTO;
    }

    private void setFieldValue(Field field, T dataDTO, Cell cell) throws IllegalAccessException {
        Class<?> fieldType = field.getType();
        field.setAccessible(true);

        System.out.println(field.getName() + " : " + fieldType.toString());               
        
        if (fieldType == String.class) {
            DataFormatter formatter = new DataFormatter();
            field.set(dataDTO, formatter.formatCellValue(cell));
        } else if (fieldType == int.class || fieldType == Integer.class) {
            field.set(dataDTO, (int) cell.getNumericCellValue());
        } else if (fieldType == long.class || fieldType == Long.class) {
            field.set(dataDTO, (long) cell.getNumericCellValue());
        } else if (fieldType == double.class || fieldType == Double.class) {
            field.set(dataDTO, cell.getNumericCellValue());
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            field.set(dataDTO, cell.getBooleanCellValue());
        }
        // 다른 타입에 따른 맵핑을 추가할 수 있습니다.
                          
    }

}
