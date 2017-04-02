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

import com.dcs.pojo.TeacherReward;

public class ExcelTeacherReward {
	private int rowIndex = 2; // The row index start from 3 row.
	private final int column = 6; // All column is 6.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 教师表彰名单
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<TeacherReward> upload() throws IOException {

		ArrayList<TeacherReward> teacherRewardList = new ArrayList<TeacherReward>();

		// 1.导入excel文件
		file = new File("excel/学工办/教师表彰名单.xls");

		if (!file.exists())
			System.out.println("The file is not exist!");
		InputStream in = new FileInputStream(file);

		workbook = new HSSFWorkbook(in);// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);// 创建HSSFsheet对象。

		row = sheet.getRow(rowIndex);
		/* 配合表格中的格式，从第rowIndex行开始读取 */
		// 用HSSFCell对象的getCell()方法取出每一个的值 sheet.getLastRowNum()
		while (row != null && row.getCell(1).getStringCellValue() != "") {
			for (int i = 0; i < column; i++) {
				if (row.getCell(i) != null)
					cell[i] = row.getCell(i);
				else
					cell[i] = null;
			}

			TeacherReward teacherReward = new TeacherReward();
			teacherReward.setName(cell[1].getStringCellValue());
			teacherReward.setRewardName(cell[2].getStringCellValue());
			teacherReward.setRewardGrade(cell[3].getStringCellValue());
			teacherReward.setRewardTime(cell[4].getStringCellValue());
			teacherReward.setRemark(cell[5].getStringCellValue());
			teacherReward.setRewardNature(cell[0].getStringCellValue());
			teacherRewardList.add(teacherReward);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("TeacherReward中数据导入完毕.");
		System.out.println(teacherRewardList);
		return teacherRewardList;
	}

	public File download(ArrayList<TeacherReward> teacherRewardList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("excel/学工办/教师表彰名单.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = teacherRewardList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			TeacherReward teacherReward = teacherRewardList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(teacherReward.getName());
			cell = row.createCell(1);
			cell.setCellValue(teacherReward.getRewardName());
			cell = row.createCell(2);
			cell.setCellValue(teacherReward.getRewardGrade());
			cell = row.createCell(3);
			cell.setCellValue(teacherReward.getRewardTime());
			cell = row.createCell(4);
			cell.setCellValue(teacherReward.getRemark());
			cell = row.createCell(5);
			cell.setCellValue(teacherReward.getRewardNature());

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
