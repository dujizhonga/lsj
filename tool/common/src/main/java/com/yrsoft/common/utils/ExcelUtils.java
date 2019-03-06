package com.yrsoft.common.utils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ExcelUtils {
	/**
	 * 设置标题
	 * @param workbook 导出工具类
	 * @param sheet 页签
	 * @param list 标题集合
	 */
	private static void setTitle(HSSFWorkbook workbook,HSSFSheet sheet,List<String> list){
		
        HSSFRow row = sheet.createRow(0);
        
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        HSSFCell cell;
        for(int i=0;i<list.size();i++) {
        	
        	//设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
            sheet.setColumnWidth(i, 10*256);
        	
        	//设置标题
        	cell = row.createCell(i);
            cell.setCellValue(list.get(i));
            cell.setCellStyle(style);
        }
    }
	
	/**
	 * 导出
	 * @param sheetName 文件名
	 * @param titleList 文档标题  例如[id,名字,电话]
	 * @param list 需要导出的数据 例如[{"id":"01","名字":"赵三","电话":"18829030556"}]
	 * @param response http响应
	 * @throws IOException
	 */
	public static void export(String sheetName,List<String> titleList,List<Map<String, Object>> list) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetName);
		
		
		//新增数据行，并且设置单元格数据
        int rowNum = 0;
		for(int i=0;i<list.size();i++) {
			rowNum = i%1000+1;
			
			//每1000条数据新增sheet
			if(i%1000==0) {
				workbook=new HSSFWorkbook();
				sheet = workbook.createSheet(sheetName+i/1000);
				setTitle(workbook, sheet,titleList);
				rowNum = 1;
			}
			
			//每一列添加数据
			HSSFRow row = sheet.createRow(rowNum);
			for(int j=0;j<titleList.size();j++) {
				row.createCell(j).setCellValue(list.get(i).get(titleList.get(j))+"");
			}
			
			
		}
		
        OutputStream os = new FileOutputStream("F://"+sheetName+".xls");  
        //将excel写入到输出流中
        workbook.write(os);
        os.close();
	}
	
	/**
	 * excel导入
	 * @param title 标题对应的实体类集合 例如user ["id","name","tel"]
	 * @param fileName 文件路径以及名称
	 * @return List<Map<String, Object>> map对象集合
	 * @throws Exception
	 */
	public static List<Map<String, Object>> importExcel(List<String> title,String fileName) throws Exception {
		File file=new File(fileName);
		HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file));
        int sheetNumber=book.getNumberOfSheets();
        List<Map<String, Object>> list=new ArrayList<>();
        //获取sheet
        for(int i=0;i<sheetNumber;i++) {
        	HSSFSheet sheet = book.getSheetAt(i);
        	
        	//获取每个sheet的行
        	for(int j=1;j<sheet.getLastRowNum() + 1;j++) {
        		HSSFRow row = sheet.getRow(j);
        		Map<String, Object> map=new HashMap<>();
        		//获取每个列并添加map
        		for(int z=0;z<title.size();z++) {
        			map.put(title.get(z), row.getCell(z).getStringCellValue());
        		}
        		list.add(map);
        	}
        }
        return list;
    }
}
