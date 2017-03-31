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

import com.dcs.pojo.CampusActivities;

public class ExcelCampusActivities {
	private int rowIndex = 3; // The row index start from 4 row.
	private final int column = 9; // All column is 9.

	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell[] cell = new HSSFCell[column];
	private File file;

	/**
	 * 校园活动获奖名单模板
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	@Test
	public ArrayList<CampusActivities> upload() throws IOException {

		ArrayList<CampusActivities> campusActivitiesList = new ArrayList<CampusActivities>();

		// 1.导入excel文件
		file = new File("excel/校园活动获奖名单模板.xls");

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

			CampusActivities campusActivities = new CampusActivities();
			campusActivities.setContextName(cell[0].getStringCellValue());
			campusActivities.setProject(cell[1].getStringCellValue());
			campusActivities.setContextGrade(cell[2].getStringCellValue());

			campusActivities.setStudentId((int) cell[3].getNumericCellValue());
			campusActivities.setReward(cell[4].getStringCellValue());
			campusActivities.setStudentName(cell[5].getStringCellValue());
			campusActivities.setGrade(cell[6].getStringCellValue());
			campusActivities.setClassroom(cell[7].getStringCellValue());
			campusActivities.setRemark(cell[8].getStringCellValue());
			campusActivitiesList.add(campusActivities);
			rowIndex++;
			row = sheet.getRow(rowIndex);
		}
		System.out.println("CampusActivities中数据导入完毕.");
		System.out.println(campusActivitiesList);
		return campusActivitiesList;
	}

	public void download(ArrayList<CampusActivities> campusActivitiesList) throws FileNotFoundException, IOException {
		// 选择文件
		file = new File("excel/校园活动获奖名单模板.xls");
		workbook = new HSSFWorkbook(new FileInputStream(file));// 创建操作Excel的HSSFWorkbook对象
		sheet = workbook.getSheetAt(0);

		int size = campusActivitiesList.size();
		for (int i = 0; i < size; i++) {// 循环，控制总行数
			HSSFRow row = sheet.createRow(i + rowIndex);
			CampusActivities campusActivities = campusActivitiesList.get(i);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(campusActivities.getContextName());
			cell = row.createCell(1);
			cell.setCellValue(campusActivities.getProject());
			cell = row.createCell(2);
			cell.setCellValue(campusActivities.getContextGrade());
			cell = row.createCell(3);
			cell.setCellValue(campusActivities.getStudentId());
			cell = row.createCell(4);
			cell.setCellValue(campusActivities.getReward());
			cell = row.createCell(5);
			cell.setCellValue(campusActivities.getStudentName());
			cell = row.createCell(6);
			cell.setCellValue(campusActivities.getGrade());
			cell = row.createCell(7);
			cell.setCellValue(campusActivities.getClassroom());
			cell = row.createCell(8);
			cell.setCellValue(campusActivities.getRemark());

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

	}
}
