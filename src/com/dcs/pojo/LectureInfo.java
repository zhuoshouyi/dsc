package com.dcs.pojo;

public class LectureInfo {
	private Integer id;

	private Integer infoId;

	private String play;

	private String time;

	private String place;

	private String object;

	private String talker;

	private String participants;

	public LectureInfo() {
		this.play = "一";
		this.time = "2016.1.1";
		this.place = "图书馆";
		this.object = "机械";
		this.talker = "张三";
		this.participants = "李四";
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

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play == null ? null : play.trim();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place == null ? null : place.trim();
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object == null ? null : object.trim();
	}

	public String getTalker() {
		return talker;
	}

	public void setTalker(String talker) {
		this.talker = talker == null ? null : talker.trim();
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants == null ? null : participants.trim();
	}

	@Override
	public String toString() {
		return "LectureInfo [id=" + id + ", infoId=" + infoId + ", play=" + play + ", time=" + time + ", place=" + place
				+ ", object=" + object + ", talker=" + talker + ", participants=" + participants + "]";
	}

}