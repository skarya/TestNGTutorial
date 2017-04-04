package com.my.TestNGTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL_Reader {
	
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	private  String path;

	
	public XL_Reader(String  filePath){
		this.path=filePath;
		try{
			fis= new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheetAt(0);
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getRowCount( String sheetName){
		
		int sheetIndex=workbook.getSheetIndex(sheetName);
		if(sheetIndex==-1){
			return sheetIndex;
		}else{
		  
			sheet = workbook.getSheetAt(sheetIndex);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
		
	}
	
	
	public int getColumnCount(String sheetName){
		
		int sheetIndex=workbook.getSheetIndex(sheetName);
		if(sheetIndex==-1){
			return sheetIndex;
		}else{
		  
			sheet = workbook.getSheetAt(sheetIndex);
			row= sheet.getRow(0);
			return row.getLastCellNum();
			
		}
	}
	
	
	public String getCellData(String sheetName, int rowNum, int cellNum) {

		try {

			sheet = workbook.getSheet(sheetName);
			if (sheet == null)
				return "";

			row = sheet.getRow(rowNum-1);
			cell = row.getCell(cellNum);
			return cell.getRawValue();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "";
	}
	

	public static void main(String ...strings){
		XL_Reader reader = new XL_Reader("./test.xlsx");
		int row= reader.getRowCount("Sheet1");
		int column= reader.getColumnCount("Sheet1");

		System.out.println("row  :"+ row +"  coulmn  "+ column);
		
		for (int rowNum=1; rowNum<=row;rowNum++){
			for(int cellNum=0;cellNum<column;cellNum++){
				String data=reader.getCellData("Sheet1", rowNum, cellNum);
				System.out.println("-------------------------->"+data);
				int doubleNumber=Integer.parseInt(data);
				doubleNumber+=2;
				System.out.println("doubleNumber-------------------------->"+doubleNumber);
				reader.setCellData("Sheet1",rowNum,cellNum,String.valueOf(doubleNumber));
				
			}
			
		}
		
		for (int rowNum=1; rowNum<=row;rowNum++){
			for(int cellNum=0;cellNum<column;cellNum++){
				String data=reader.getCellData("Sheet1", rowNum, cellNum);
				System.out.println("******* "+data);
				
			}
	}
		
	}

	
		public boolean setCellData(String sheetName,String colName,int rowNum, String data){
			try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);

			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			sheet = workbook.getSheetAt(index);
			

			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;

			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);

		    // cell style
		    //CellStyle cs = workbook.createCellStyle();
		    //cs.setWrapText(true);
		    //cell.setCellStyle(cs);
		    cell.setCellValue(data);

		    fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

		    fileOut.close();	

			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		return true;
		
		
	}
}
