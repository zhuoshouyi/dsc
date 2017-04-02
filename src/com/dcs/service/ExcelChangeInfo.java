package com.dcs.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import com.dcs.pojo.ChangeInfo;

public class ExcelChangeInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 5; // All column is 5.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 年级学籍异动学生名单和原因
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<ChangeInfo> ChangeInfoServers() throws IOException {

		ArrayList<ChangeInfo> changeInfoList = new ArrayList<ChangeInfo>();

		// 1.导入excel文件
		file = new File("excel/年级学籍异动学生名单和原因.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(0).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			ChangeInfo changeInfo = new ChangeInfo();
			changeInfo.setName(cell[0].getStringCellValue());
			changeInfo.setStudentId((int) cell[1].getNumericCellValue());
			changeInfo.setClassroom(cell[2].getStringCellValue());
			changeInfo.setChangeReason(cell[3].getStringCellValue());
			changeInfo.setChangeTime(cell[4].getStringCellValue());
			changeInfoList.add(changeInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("ChangeInfo中数据导入完毕.");
		System.out.println(changeInfoList);
		return changeInfoList;
	}

	public File download(ArrayList<ChangeInfo> changeInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/年级学籍异动学生名单和原因.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = changeInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			ChangeInfo changeInfo = changeInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(changeInfo.getName());
			cell = row.createCell(1);
			cell.setCellValue(changeInfo.getStudentId());
			cell = row.createCell(2);
			cell.setCellValue(changeInfo.getClassroom());
			cell = row.createCell(3);
			cell.setCellValue(changeInfo.getChangeReason());
			cell = row.createCell(4);
			cell.setCellValue(changeInfo.getChangeTime());

		}

		// 利用数据流写入
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			workbook.write(out);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("数据已经写入excel中。");
		return file;
	}
}
