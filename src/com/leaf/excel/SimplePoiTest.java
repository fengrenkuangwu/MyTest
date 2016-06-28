package com.leaf.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

public class SimplePoiTest {

	public static List<String> fileList = new ArrayList<>();

	@Test
	public void findQueryMethod() {
		String path = "E://pekall//mdm_server//mdm-reactor";
		File dir = new File(path);
		ergodicFile(dir);
		System.out.println(fileList.size() + "个*DaoImpl.java");
		int j = 1;

		// 放入excel
		String sFilename = "E://findQueryMethod.xls";
		// 创建新的工作薄
		HSSFWorkbook wordbook = new HSSFWorkbook();
		// 在Excel工作薄中创建一个名为FIRST的工作表
		HSSFSheet sheet = wordbook.createSheet("first");
		int rowNum = 0;

		for (String filePath : fileList) {
			System.out.println("第" + j + "\t个Dao：" + filePath);
			String line = "";
			try {
				File file = new File(filePath);
				BufferedReader bf = new BufferedReader(new FileReader(file));

				int i = 1;
				while ((line = bf.readLine()) != null) {
					if (line.contains(".list()")) {
						System.out.println(i + "\t行：" + line);

						HSSFRow row = sheet.createRow((short) rowNum);
						// 在索引0的位置创建单元格,对应着第一行第一列的单元格
						row.createCell(0).setCellValue(file.getName());
						row.createCell(1).setCellValue(i + "行");
						row.createCell(2).setCellValue(line);
						row.createCell(3).setCellValue(filePath);
						rowNum++;
					}else if(line.contains(".createQuery")){
						System.out.println(i + "\t行：" + line);

						HSSFRow row = sheet.createRow((short) rowNum);
						// 在索引0的位置创建单元格,对应着第一行第一列的单元格
						row.createCell(0).setCellValue(file.getName());
						row.createCell(1).setCellValue(i + "行");
						row.createCell(2).setCellValue(line);
						row.createCell(3).setCellValue(filePath);
						rowNum++;
					}else if(line.contains(".createSQLQuery")){
						System.out.println(i + "\t行：" + line);

						HSSFRow row = sheet.createRow((short) rowNum);
						// 在索引0的位置创建单元格,对应着第一行第一列的单元格
						row.createCell(0).setCellValue(file.getName());
						row.createCell(1).setCellValue(i + "行");
						row.createCell(2).setCellValue(line);
						row.createCell(3).setCellValue(filePath);
						rowNum++;
					}else if(line.contains(".createCriteria")){
						System.out.println(i + "\t行：" + line);

						HSSFRow row = sheet.createRow((short) rowNum);
						// 在索引0的位置创建单元格,对应着第一行第一列的单元格
						row.createCell(0).setCellValue(file.getName());
						row.createCell(1).setCellValue(i + "行");
						row.createCell(2).setCellValue(line);
						row.createCell(3).setCellValue(filePath);
						rowNum++;
					}
					i++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			j++;

			System.out.println("*************************************************************************************");
		}
		// 新建一输出流
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(sFilename);
			// 把响应的Excel工作薄存盘
			wordbook.write(fOut);
			fOut.flush();
			// 操作结束关闭文件
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ok");

	}

	void ergodicFile(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				ergodicFile(new File(dir, children[i]));
			}
		}
		// 目录此时为空，可以删除
		String fileName = dir.getName();
		if (fileName.length() > 12 && "DaoImpl.java".equals(fileName.substring(fileName.length() - 12))) {
			fileList.add(dir.getPath());
		}
	}

	public static void main(String[] args) {
		//
		//
		// JAVA操作Excel,写入
		//
		//
		Date date = new Date();
		String dt = new String(new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(date));
		// Excel工作薄创建的位置
		String sFilename = "E://" + dt + ".xls";
		try {
			// 创建新的工作薄
			HSSFWorkbook wordbook = new HSSFWorkbook();
			// 在Excel工作薄中创建一个名为FIRST的工作表
			HSSFSheet sheet = wordbook.createSheet("first");
			// 在索引0的位置创建行，对象着第一行
			HSSFRow row = sheet.createRow((short) 0);
			// 在索引0的位置创建单元格,对应着第一行第一列的单元格
			HSSFCell cell = row.createCell(0);
			// 在单元格输入内容
			cell.setCellValue("时间");
			// 在索引0的位置创建单元格,对应着第一行第一列的单元格
			HSSFCell cell1 = row.createCell(1);
			// 在单元格输入内容
			cell1.setCellValue("aaaaaaaaa");

			// 在索引0的位置创建行，对象着第一行
			HSSFRow row2 = sheet.createRow((short) 1);
			// 在索引0的位置创建单元格,对应着第一行第一列的单元格
			HSSFCell cell2 = row2.createCell((short) 0);
			// 在单元格输入内容
			cell2.setCellValue("ssssssss");
			// 在索引0的位置创建单元格,对应着第一行第一列的单元格
			HSSFCell cell3 = row2.createCell((short) 1);
			// 在单元格输入内容
			cell3.setCellValue("dddddddddd");

			// 新建一输出流
			FileOutputStream fOut = new FileOutputStream(sFilename);
			// 把响应的Excel工作薄存盘
			wordbook.write(fOut);
			fOut.flush();
			// 操作结束关闭文件
			System.out.println("ok");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
