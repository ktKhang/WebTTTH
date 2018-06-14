package DAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Bean.ViewListStudent;


public class WriteExcel {

	static int count=1;
    
    /*1*/
    public static void writeExcel(List<ViewListStudent> listBook, String excelFilePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        sheet.setColumnWidth(2, 8*256*2);
        sheet.setColumnWidth(5, 8*256*4);
        sheet.setColumnWidth(3, 8*256*2);
        //tạo tiêu đề
        createHeaderRow(sheet);
        int rowCount = 0;
     
        for (ViewListStudent aBook : listBook) {
            Row row = sheet.createRow(++rowCount);
            //
            writeBook(aBook, row);
        }
     
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
            workbook.close();
        }
    }
    
    //Thêm row
    private static void writeBook(ViewListStudent aBook, Row row) {
        
        Cell cell = row.createCell(0);
        cell.setCellValue(count++);
        
        cell = row.createCell(1);
        cell.setCellValue(Integer.parseInt(aBook.getAccount_id()));
        
        cell = row.createCell(2);
        cell.setCellValue(aBook.getName());
     
        cell = row.createCell(3);
        cell.setCellValue(aBook.getBirthday());
     
        cell = row.createCell(4);
        cell.setCellValue(aBook.getSex());
        
        cell = row.createCell(5);
        cell.setCellValue(aBook.getMail());
        
        cell = row.createCell(6);
        cell.setCellValue(Double.parseDouble(aBook.getPoint()));
        
    }
    
    //Có thể format được như in đậm, set font
    //Tạo hearder
    private static void createHeaderRow(Sheet sheet) {
         
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);
     
        Row row = sheet.createRow(0);
        
        Cell cellSTT = row.createCell(0);
        cellSTT.setCellStyle(cellStyle);
        cellSTT.setCellValue("STT");
        
        Cell cellName = row.createCell(1);
        cellName.setCellStyle(cellStyle);
        cellName.setCellValue("Mã số");
        
        Cell cellMaSo = row.createCell(2);
        cellMaSo.setCellStyle(cellStyle);
        cellMaSo.setCellValue("Họ và Tên");
     
        Cell cellBirthDay = row.createCell(3);
        cellBirthDay.setCellStyle(cellStyle);
        cellBirthDay.setCellValue("Ngày sinh");
     
        Cell cellSex = row.createCell(4);
        cellSex.setCellStyle(cellStyle);
        cellSex.setCellValue("Giới tính");
        
        Cell cellEmail = row.createCell(5);
        cellEmail.setCellStyle(cellStyle);
        cellEmail.setCellValue("Email");
        
        Cell cellPoint = row.createCell(6);
        cellPoint.setCellStyle(cellStyle);
        cellPoint.setCellValue("Điểm");
    }
    
    
    
    
    
}
