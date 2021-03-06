package com.dcs.pojo;

public class PunishInfo {
	private Integer id;

	private Integer infoId;

	private String name;

	private Integer studentId;

	private String classroom;

	private String punishGrade;

	private String punishReason;

	private String punishTime;

	public PunishInfo() {
		this.name = "张三";
		this.studentId = 1405;
		this.classroom = "机械1401";
		this.punishGrade = "警告";
		this.punishReason = "警告";
		this.punishTime = "2016.1.1";
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

	public String getPunishGrade() {
		return punishGrade;
	}

	public void setPunishGrade(String punishGrade) {
		this.punishGrade = punishGrade == null ? null : punishGrade.trim();
	}

	public String getPunishReason() {
		return punishReason;
	}

	public void setPunishReason(String punishReason) {
		this.punishReason = punishReason == null ? null : punishReason.trim();
	}

	public String getPunishTime() {
		return punishTime;
	}

	public void setPunishTime(String punishTime) {
		this.punishTime = punishTime;
	}

	@Override
	public String toString() {
		return "PunishInfo [id=" + id + ", infoId=" + infoId + ", name=" + name + ", studentId=" + studentId
				+ ", classroom=" + classroom + ", punishGrade=" + punishGrade + ", punishReason=" + punishReason
				+ ", punishTime=" + punishTime + "]";
	}

}