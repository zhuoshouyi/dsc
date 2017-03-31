package com.dcs.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.dcs.pojo.CadresInfo;

public class mainTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<CadresInfo> cadresInfoList = new ArrayList<CadresInfo>();
		CadresInfo cadresInfo = new CadresInfo();
		cadresInfo.setNameChairman("张三");
		cadresInfo.setFunctionChairman("主席");
		cadresInfo.setContactsChairman("123");
		cadresInfo.setDepartmentCharge("青协");
		cadresInfo.setNameSecretary("李四");
		cadresInfo.setFunctionSecretary("部长");
		cadresInfo.setContactsSecretary("321");
		cadresInfo.setStudentOrganization("青协");
		cadresInfo.setRemark("无");
		cadresInfoList.add(cadresInfo);

		CadresInfo cadresInfo1 = new CadresInfo();
		cadresInfo1.setNameChairman("张");
		cadresInfo1.setFunctionChairman("主");
		cadresInfo1.setContactsChairman("1234");
		cadresInfo1.setDepartmentCharge("青");
		cadresInfo1.setNameSecretary("李");
		cadresInfo1.setFunctionSecretary("部");
		cadresInfo1.setContactsSecretary("3214");
		cadresInfo1.setStudentOrganization("青");
		cadresInfo1.setRemark("无");
		cadresInfoList.add(cadresInfo1);

		ExcelCadresInfo excelCadresInfo = new ExcelCadresInfo();
		excelCadresInfo.download(cadresInfoList);
	}
}
