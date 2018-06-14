package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.PreparedStatement;

import DBConnection.DBConnection;

//InputStream ExcelFileToRead = new FileInputStream("C:/Users/DAO_THI_MY/Desktop/Book1.xlsx");

public class ReadExcel {

	String path;
    public FileInputStream fis = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;
    PreparedStatement pstm = null;
    
    public ReadExcel()throws IOException{
    }
    //đọc update điểm
	public void ExelWorks(String string, int class_id) throws IOException, SQLException
    {
		//đường dẫn
		path = string;
    	fis = new FileInputStream(path); 
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        //
    	 Connection conn=DBConnection.CreateConnection();
		int index = workbook.getSheetIndex("Sheet0");
		sheet = workbook.getSheetAt(index);
		int rownumber=sheet.getLastRowNum()+1;  
		//sử dụng DataFormatter để đưa các biến về định dạng String 
		DataFormatter formatter = new DataFormatter();
		for (int i=1; i<rownumber; i++ )
		{
		    row = sheet.getRow(i);
		    //lấy mã số: account_id
		    int acc_id = (int) row.getCell(1).getNumericCellValue();
		    //mã class_id
		    int clas = class_id;

		    int  point = (int) row.getCell(6).getNumericCellValue();
            String sql = "UPDATE student_class SET point=? WHERE account_id=? and class_id=? ";
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, point);
			pstm.setInt(2, acc_id);
			pstm.setInt(3, clas);
		    pstm.executeUpdate();
		}
		conn.close();
        
    }   
    public static void xuly(String string, int id) throws IOException, SQLException 
    {
    	ReadExcel excelwork = new ReadExcel();
        excelwork.ExelWorks(string, id);
    }
    
}