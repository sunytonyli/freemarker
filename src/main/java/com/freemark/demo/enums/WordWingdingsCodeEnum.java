package com.freemark.demo.enums;

public enum WordWingdingsCodeEnum {

	WINDINGS_YES("F052", "方框对勾"),
	WINDINGS_NO("F051", "方框叉"),
	WINDINGS_NULL("F0A3", "空方框");
	
	public String code;
	public String msg;
	WordWingdingsCodeEnum(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
