package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	Utility(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws IOException
	{ 
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}
	public int getColCount(String sheetname,int rowcount) throws IOException
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rowcount);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	public String getCellData(String sheetname, int rowcount, int cellcount) throws IOException
	{
		fi=new FileInputStream(path);
		workbook =new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rowcount);
		cell=row.getCell(cellcount);
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data=" ";
		}
		workbook.close();
		fi.close();
		return data;
		
		
	}

}
