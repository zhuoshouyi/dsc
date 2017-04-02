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

import com.dcs.pojo.LectureInfo;

public class ExcelLectureInfo {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 6; // All column is 6.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 机械工程学院讲座统计表
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<LectureInfo> upload() throws IOException {

		ArrayList<LectureInfo> lectureInfoList = new ArrayList<LectureInfo>();

		// 1.导入excel文件
		file = new File("excel/机械工程学院讲座统计表.xls");

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

			LectureInfo lectureInfo = new LectureInfo();
			lectureInfo.setPlay(cell[0].getStringCellValue());
			lectureInfo.setTime(cell[1].getStringCellValue());
			lectureInfo.setPlace(cell[2].getStringCellValue());
			lectureInfo.setObject(cell[3].getStringCellValue());
			lectureInfo.setTalker(cell[4].getStringCellValue());
			lectureInfo.setParticipants(cell[5].getStringCellValue());
			lectureInfoList.add(lectureInfo);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("LectureInfo中数据导入完毕.");
		System.out.println(lectureInfoList);
		return lectureInfoList;
	}

	public File download(ArrayList<LectureInfo> lectureInfoList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("tempExcel/机械工程学院讲座统计表.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = lectureInfoList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			LectureInfo lectureInfo = lectureInfoList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(lectureInfo.getPlay());
			cell = row.createCell(1);
			cell.setCellValue(lectureInfo.getTime());
			cell = row.createCell(2);
			cell.setCellValue(lectureInfo.getPlace());
			cell = row.createCell(3);
			cell.setCellValue(lectureInfo.getObject());
			cell = row.createCell(4);
			cell.setCellValue(lectureInfo.getTalker());
			cell = row.createCell(5);
			cell.setCellValue(lectureInfo.getParticipants());

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
