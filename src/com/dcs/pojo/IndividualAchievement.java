package com.dcs.pojo;

public class IndividualAchievement {
	private Integer id;

	private Integer infoId;

	private String achievement;

	private String reward;

	private String rewardTime;

	private String remark;

	public IndividualAchievement() {
		this.achievement = "国家奖";
		this.reward = "一等奖";
		this.rewardTime = "2016.11.1";
		this.remark = "";
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

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement == null ? null : achievement.trim();
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward == null ? null : reward.trim();
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

	@Override
	public String toString() {
		return "IndividualAchievement [id=" + id + ", infoId=" + infoId + ", achievement=" + achievement + ", reward="
				+ reward + ", rewardTime=" + rewardTime + ", remark=" + remark + "]";
	}

}