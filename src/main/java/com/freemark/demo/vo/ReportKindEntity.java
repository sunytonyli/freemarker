package com.freemark.demo.vo;

import java.io.Serializable;

/**
 * @author syli
 *
 */
public class ReportKindEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9087338147516242778L;

	private long reportKindId;
	private int levelOne;//一级数量
	private int levelTwo;//二级数量
	private String levelRemark;//补充说明
	private long kindId;//类别ID
	private String kindName;//类别简称
	private long reportId;//资源报告ID
	public long getReportKindId() {
		return reportKindId;
	}
	public void setReportKindId(long reportKindId) {
		this.reportKindId = reportKindId;
	}
	public int getLevelOne() {
		return levelOne;
	}
	public void setLevelOne(int levelOne) {
		this.levelOne = levelOne;
	}
	public int getLevelTwo() {
		return levelTwo;
	}
	public void setLevelTwo(int levelTwo) {
		this.levelTwo = levelTwo;
	}
	public String getLevelRemark() {
		return levelRemark;
	}
	public void setLevelRemark(String levelRemark) {
		this.levelRemark = levelRemark;
	}
	public long getKindId() {
		return kindId;
	}
	public void setKindId(long kindId) {
		this.kindId = kindId;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
}

