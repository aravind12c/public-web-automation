package Stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelData {
	
	File source = new File("C:\\Users\\metrouser\\eclipse-workspace\\shopping_auto\\Data.xlsx");
	XSSFWorkbook wrk_bk;
	XSSFSheet wrk_sht;
	
	public void excelsData() throws IOException {
	
	FileInputStream files = new FileInputStream(source);
	wrk_bk = new XSSFWorkbook(files);
	wrk_sht = wrk_bk.getSheetAt(0);
	
	
	}
	
	public int last_row_count() {
		int last_row_no = wrk_sht.getLastRowNum()-wrk_sht.getFirstRowNum();
		System.out.println(last_row_no);
		return last_row_no;
	}

	public String mail(int row_info) {
		String ex_data = wrk_sht.getRow(row_info).getCell(0).getStringCellValue();
		return ex_data;
	}

	public CharSequence login_Email() {
		String ex_data = wrk_sht.getRow(1).getCell(2).getStringCellValue();
		return ex_data;
	}
	
	public CharSequence login_Password() {
		String ex_data = wrk_sht.getRow(2).getCell(2).getStringCellValue();
		return ex_data;
	}
	
	public CharSequence data_fName() {
		String ex_data = wrk_sht.getRow(1).getCell(1).getStringCellValue();
		return ex_data;
		
	}
	public CharSequence data_lName() {
		String ex_data = wrk_sht.getRow(2).getCell(1).getStringCellValue();
		return ex_data;
		
	}
	
	public CharSequence data_password() {
		String ex_data = wrk_sht.getRow(3).getCell(1).getStringCellValue();
		return ex_data;
	}
	public CharSequence data_company() {
		String ex_data = wrk_sht.getRow(4).getCell(1).getStringCellValue();
		return ex_data;
		
	}
	public CharSequence data_address1() {
		String ex_data = wrk_sht.getRow(5).getCell(1).getStringCellValue();
		return ex_data;
		
	}
	
	public CharSequence data_address2() {
		String ex_data = wrk_sht.getRow(6).getCell(1).getStringCellValue();
		return ex_data;
	}
	public CharSequence data_city() {
		String ex_data = wrk_sht.getRow(7).getCell(1).getStringCellValue();
		return ex_data;
	}
	
	public int data_post() {
		int ex_data = (int) wrk_sht.getRow(8).getCell(1).getNumericCellValue();
		return ex_data;
	}

	public CharSequence data_otherinfo() {
		String ex_data = wrk_sht.getRow(9).getCell(1).getStringCellValue();
		return ex_data;
	}
	
	public int data_mobile() {
		int ex_data = (int) wrk_sht.getRow(10).getCell(1).getNumericCellValue();
		return ex_data;
	}
	
	public CharSequence data_adressnme() {
		String ex_data = wrk_sht.getRow(11).getCell(1).getStringCellValue();
		return ex_data;
	}
	
	public CharSequence data_verification() {
		String ex_data = wrk_sht.getRow(13).getCell(1).getStringCellValue();
		return ex_data;
	}


}
	
	









