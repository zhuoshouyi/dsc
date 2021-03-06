package com.dcs.pojo;

public class GloryInfo {
	private Integer id;

	private Integer infoId;

	private String name;

	private Integer studentId;

	private String classroom;

	private String contestName;

	private String contestGrade;

	private String rewardTime;

	private String remark;

	private String rewardNature;

	public GloryInfo() {
		this.name = "张三";
		this.studentId = 1405;
		this.classroom = "机械1401";
		this.contestName = "篮球";
		this.contestGrade = "一等奖";
		this.rewardTime = "2016.1.1";
		this.remark = "";
		this.rewardNature = "省奖";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom == null ? null : classroom.trim();
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName == null ? null : contestName.trim();
	}

	public String getContestGrade() {
		return contestGrade;
	}

	public void setContestGrade(String contestGrade) {
		this.contestGrade = contestGrade == null ? null : contestGrade.trim();
	}

	public String getRewardTime() {
		return rewardTime;
	}

	public void setRewardTime(String rewardTime) {
		this.rewardTime = rewardTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getRewardNature() {
		return rewardNature;
	}

	public void setRewardNature(String rewardNature) {
		this.rewardNature = rewardNature == null ? null : rewardNature.trim();
	}

	@Override
	public String toString() {
		return "GloryInfo [id=" + id + ", infoId=" + infoId + ", name=" + name + ", studentId=" + studentId
				+ ", classroom=" + classroom + ", contestName=" + contestName + ", contestGrade=" + contestGrade
				+ ", rewardTime=" + rewardTime + ", remark=" + remark + ", rewardNature=" + rewardNature + "]";
	}

}