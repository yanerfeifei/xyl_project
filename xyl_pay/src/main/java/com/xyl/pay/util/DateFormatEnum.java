package com.xyl.pay.util;

public enum DateFormatEnum {
	YEAR("yyyy"),
	MONTH("MM"),
	DAY("dd"),
	DATEMONTH("yyyy-MM"),
	DATE("yyyy-MM-dd"),
	DATETIME("yyyy-MM-dd HH:mm:ss"),
	DATETIMENOSEG("yyyyMMddHHmmss"),
	DATA_YMD("yyyy年MM月dd日");
	private String formatstr;
	
	DateFormatEnum(String formatstr){
		this.formatstr = formatstr;
	}

	public String getFormatstr() {
		return formatstr;
	}

	public void setFormatstr(String formatstr) {
		this.formatstr = formatstr;
	}
}
