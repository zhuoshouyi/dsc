package com.dcs.pojo;

public class PartyBuild {
	private Integer id;

	private Integer infoId;

	private Integer studentId;

	private String name;

	private String classroom;

	private String sex;

	private String partyBranch;

	private String birthday;

	private String probationaryPartyMemberDate;

	private String regularPartyMemberDate;

	private String nation;

	private String idCard;

	private String numParty;

	private String partyNature;

	public PartyBuild() {
		this.studentId = 1405;
		this.name = "张三";
		this.classroom = "机械1401";
		this.sex = "男";
		this.partyBranch = "";
		this.birthday = "2016.1.1";
		this.probationaryPartyMemberDate = "2016.1.1";
		this.regularPartyMemberDate = "2016.1.1";
		this.nation = "汉";
		this.idCard = "420982";
		this.numParty = "2";
		this.partyNature = "正式党员";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getPartyBranch() {
		return partyBranch;
	}

	public void setPartyBranch(String partyBranch) {
		this.partyBranch = partyBranch == null ? null : partyBranch.trim();
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public String getProbationaryPartyMemberDate() {
		return probationaryPartyMemberDate;
	}

	public void setProbationaryPartyMemberDate(String probationaryPartyMemberDate) {
		this.probationaryPartyMemberDate = probationaryPartyMemberDate;
	}

	public String getRegularPartyMemberDate() {
		return regularPartyMemberDate;
	}

	public void setRegularPartyMemberDate(String regularPartyMemberDate) {
		this.regularPartyMemberDate = regularPartyMemberDate;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation == null ? null : nation.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getNumParty() {
		return numParty;
	}

	public void setNumParty(String numParty) {
		this.numParty = numParty == null ? null : numParty.trim();
	}

	public String getPartyNature() {
		return partyNature;
	}

	public void setPartyNature(String partyNature) {
		this.partyNature = partyNature;
	}

	@Override
	public String toString() {
		return "PartyBuild [id=" + id + ", infoId=" + infoId + ", studentId=" + studentId + ", name=" + name
				+ ", classroom=" + classroom + ", sex=" + sex + ", partyBranch=" + partyBranch + ", birthday="
				+ birthday + ", probationaryPartyMemberDate=" + probationaryPartyMemberDate
				+ ", regularPartyMemberDate=" + regularPartyMemberDate + ", nation=" + nation + ", idCard=" + idCard
				+ ", numParty=" + numParty + "]";
	}

}