package com.dcs.pojo;

public class ChangeInfo {
	private Integer id;

	private Integer infoId;

	private String name;

	private Integer studentId;

	private String classroom;

	private String changeReason;

	private String changeTime;

	public ChangeInfo() {
		this.name = "张三";
		this.studentId = 1405;
		this.classroom = "机械1401";
		this.changeReason = "不知道";
		this.changeTime = "2017.1.1";
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

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason == null ? null : changeReason.trim();
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	@Override
	public String toString() {
		return "ChangeInfo [id=" + id + ", infoId=" + infoId + ", name=" + name + ", studentId=" + studentId
				+ ", classroom=" + classroom + ", changeReason=" + changeReason + ", changeTime=" + changeTime + "]";
	}
}