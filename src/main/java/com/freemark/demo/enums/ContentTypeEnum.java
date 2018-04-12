package com.freemark.demo.enums;

/**
 * 文件content-type
 * @author lisy
 *
 */
public enum ContentTypeEnum {

	PDF("application/pdf", "pdf"), DOC("application/msword", "doc"), DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx"),
	XLS("application/vnd.ms-excel", "xls"), XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
	
	public String type;
	public String msg;
	
	ContentTypeEnum(String type, String msg){
		this.type = type;
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
