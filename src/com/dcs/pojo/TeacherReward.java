package com.dcs.pojo;

public class TeacherReward {
	private Integer id;

	private Integer infoId;

	private String name;

	private String rewardName;

	private String rewardGrade;

	private String rewardTime;

	private String remark;

	private String rewardNature;

	public TeacherReward() {
		this.name = "张三";
		this.rewardName = "机械";
		this.rewardGrade = "一等奖";
		this.rewardTime = "2016.1.1";
		this.remark = "";
		this.rewardNature = "省级奖及以上";
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

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName == null ? null : rewardName.trim();
	}

	public String getRewardGrade() {
		return rewardGrade;
	}

	public void setRewardGrade(String rewardGrade) {
		this.rewardGrade = rewardGrade == null ? null : rewardGrade.trim();
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
		return "TeacherReward [id=" + id + ", infoId=" + infoId + ", name=" + name + ", rewardName=" + rewardName
				+ ", rewardGrade=" + rewardGrade + ", rewardTime=" + rewardTime + ", remark=" + remark
				+ ", rewardNature=" + rewardNature + "]";
	}

}