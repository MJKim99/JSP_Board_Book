package com.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookDTO {

	private int uid; // bk_uid
	private String title; // bk_title
	private String summary; // bk_summary
	private int price; // bk_price
	private int viewCnt; // bk_viewcnt
	private LocalDateTime regDate; // bk_regdate

	public BookDTO() {
		super();
	}

	public BookDTO(int uid, String title, String summary, int price, int viewCnt, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.title = title;
		this.summary = summary;
		this.price = price;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
	public String getRegDateTime() {
		if (this.regDate == null) return "";
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
	}

}