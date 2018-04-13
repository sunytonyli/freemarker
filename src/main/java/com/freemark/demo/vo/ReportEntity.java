package com.freemark.demo.vo;

import java.io.Serializable;
import java.util.List;

public class ReportEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -649700072100915133L;

	private long reportId;
	private long biaowuId;//标物ID
	private String armamentariumNo;//国家标准物质编号
	private String zhName;//标准物质名称
	private String enName;//标准物质名称(英文)
	private String certificateNo;//定级证书编号
	private String ceritificateTime;//定级证书批准日期
	private String developmentUnit;//研制（生产）单位名称
	private int feature;//类别（纯度、基体、气体、溶液、其他）
	private int status;//状态 1-持续供应; 0-已注销
	private int eachProductionState;//当前特性量值否与批准时一致 1-一至; 2-不一至
	private int onenessState;//是否与联合单位各自独立生产
	private String eORemark;//持续供应备注
	private int stopProState;//停止生产供应
	private int notProState;//不具备生产条件
	private int charValueChange;//特性量值有变化
	private String stopReason;//停止生产原因
	private String developmentEmail;//研制单位邮箱地址
	private String legalName;//法人姓名
	private String unitContacts;//单位联系人
	private String developmentAddress;//研制（生产）单位地址
	private String baowuProductAddress;//标准物质生产地址
	private int approvedLevelOne;//获批国家标准物质总数 一级
	private int approvedLevelTwo;//获批国家标准物质总数 二级
	private String approvedRemark;//获批国家标准物质总数 补充说明
	private int logoutLevelOne;//申请注销国家标准物质数量 一级
	private int logoutLevelTwo;//申请注销国家标准物质数量 二级
	private String logoutRemark;//申请注销国家标准物质数量 补充说明
	private int continueProductLevelOne;//持续生产和供应国家标准物质数量 一级
	private int continueProductLevelTwo;//持续生产和供应国家标准物质数量 二级
	private String continueRemark;//持续生产和供应国家标准物质数量 补充说明
	private List<ReportKindEntity> kinds;//持续供应各类国家标准物质数量
	private String otherRemark;//需要说明的其他问题
	private int qualityEnsureState;//具有生产标准物质所需要的质量保证体系 1-是 2-否
	private int facilityState;//具有生产相应标准物质所需要的测量仪器及设施 1-是 2-否
	private int technicalStaffState;//具有专职管理和相应能力的技术人员
	private int fixedValueState;//具有内部定值的能力
	private int placeState;//具有满足储存标准物质环境条件要求的专用场所
	private int custodyState;//标准物质的相关资料均妥善保管
	private int originalRecord;//具有制备、定值的原始记录
	private int evidenceState;//具有量值溯源的相关证明材料
	private int otherProveState;//具有其他可以说明量值特性符合要求的证明（包括本单位定期对量值进行复核或比对等相关材料)
	private String mainProblem;//当前管理中存在的主要问题
	private String checkConclusion;//自查结论

	public long getReportId() {
		return reportId;
	}
	public void setReportId(long reportId) {
		this.reportId = reportId;
	}
	public long getBiaowuId() {
		return biaowuId;
	}
	public void setBiaowuId(long biaowuId) {
		this.biaowuId = biaowuId;
	}
	public String getArmamentariumNo() {
		return armamentariumNo;
	}
	public void setArmamentariumNo(String armamentariumNo) {
		this.armamentariumNo = armamentariumNo;
	}
	public String getZhName() {
		return zhName;
	}
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getCeritificateTime() {
		return ceritificateTime;
	}
	public void setCeritificateTime(String ceritificateTime) {
		this.ceritificateTime = ceritificateTime;
	}
	public String getDevelopmentUnit() {
		return developmentUnit;
	}
	public void setDevelopmentUnit(String developmentUnit) {
		this.developmentUnit = developmentUnit;
	}
	public int getFeature() {
		return feature;
	}
	public void setFeature(int feature) {
		this.feature = feature;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEachProductionState() {
		return eachProductionState;
	}
	public void setEachProductionState(int eachProductionState) {
		this.eachProductionState = eachProductionState;
	}
	public int getOnenessState() {
		return onenessState;
	}
	public void setOnenessState(int onenessState) {
		this.onenessState = onenessState;
	}
	public String geteORemark() {
		return eORemark;
	}
	public void seteORemark(String eORemark) {
		this.eORemark = eORemark;
	}
	public int getStopProState() {
		return stopProState;
	}
	public void setStopProState(int stopProState) {
		this.stopProState = stopProState;
	}
	public int getNotProState() {
		return notProState;
	}
	public void setNotProState(int notProState) {
		this.notProState = notProState;
	}
	public int getCharValueChange() {
		return charValueChange;
	}
	public void setCharValueChange(int charValueChange) {
		this.charValueChange = charValueChange;
	}
	public String getDevelopmentEmail() {
		return developmentEmail;
	}
	public void setDevelopmentEmail(String developmentEmail) {
		this.developmentEmail = developmentEmail;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getUnitContacts() {
		return unitContacts;
	}
	public void setUnitContacts(String unitContacts) {
		this.unitContacts = unitContacts;
	}
	public String getDevelopmentAddress() {
		return developmentAddress;
	}
	public void setDevelopmentAddress(String developmentAddress) {
		this.developmentAddress = developmentAddress;
	}
	public String getBaowuProductAddress() {
		return baowuProductAddress;
	}
	public void setBaowuProductAddress(String baowuProductAddress) {
		this.baowuProductAddress = baowuProductAddress;
	}
	public int getApprovedLevelOne() {
		return approvedLevelOne;
	}
	public void setApprovedLevelOne(int approvedLevelOne) {
		this.approvedLevelOne = approvedLevelOne;
	}
	public int getApprovedLevelTwo() {
		return approvedLevelTwo;
	}
	public void setApprovedLevelTwo(int approvedLevelTwo) {
		this.approvedLevelTwo = approvedLevelTwo;
	}
	public String getApprovedRemark() {
		return approvedRemark;
	}
	public void setApprovedRemark(String approvedRemark) {
		this.approvedRemark = approvedRemark;
	}
	public int getLogoutLevelOne() {
		return logoutLevelOne;
	}
	public void setLogoutLevelOne(int logoutLevelOne) {
		this.logoutLevelOne = logoutLevelOne;
	}
	public int getLogoutLevelTwo() {
		return logoutLevelTwo;
	}
	public void setLogoutLevelTwo(int logoutLevelTwo) {
		this.logoutLevelTwo = logoutLevelTwo;
	}
	public String getLogoutRemark() {
		return logoutRemark;
	}
	public void setLogoutRemark(String logoutRemark) {
		this.logoutRemark = logoutRemark;
	}
	public int getContinueProductLevelOne() {
		return continueProductLevelOne;
	}
	public void setContinueProductLevelOne(int continueProductLevelOne) {
		this.continueProductLevelOne = continueProductLevelOne;
	}
	public int getContinueProductLevelTwo() {
		return continueProductLevelTwo;
	}
	public void setContinueProductLevelTwo(int continueProductLevelTwo) {
		this.continueProductLevelTwo = continueProductLevelTwo;
	}
	public String getContinueRemark() {
		return continueRemark;
	}
	public void setContinueRemark(String continueRemark) {
		this.continueRemark = continueRemark;
	}
	public List<ReportKindEntity> getKinds() {
		return kinds;
	}
	public void setKinds(List<ReportKindEntity> kinds) {
		this.kinds = kinds;
	}
	public String getOtherRemark() {
		return otherRemark;
	}
	public void setOtherRemark(String otherRemark) {
		this.otherRemark = otherRemark;
	}
	public int getQualityEnsureState() {
		return qualityEnsureState;
	}
	public void setQualityEnsureState(int qualityEnsureState) {
		this.qualityEnsureState = qualityEnsureState;
	}
	public int getFacilityState() {
		return facilityState;
	}
	public void setFacilityState(int facilityState) {
		this.facilityState = facilityState;
	}
	public int getTechnicalStaffState() {
		return technicalStaffState;
	}
	public void setTechnicalStaffState(int technicalStaffState) {
		this.technicalStaffState = technicalStaffState;
	}
	public int getFixedValueState() {
		return fixedValueState;
	}
	public void setFixedValueState(int fixedValueState) {
		this.fixedValueState = fixedValueState;
	}
	public int getPlaceState() {
		return placeState;
	}
	public void setPlaceState(int placeState) {
		this.placeState = placeState;
	}
	public int getCustodyState() {
		return custodyState;
	}
	public void setCustodyState(int custodyState) {
		this.custodyState = custodyState;
	}
	public int getOriginalRecord() {
		return originalRecord;
	}
	public void setOriginalRecord(int originalRecord) {
		this.originalRecord = originalRecord;
	}
	public int getEvidenceState() {
		return evidenceState;
	}
	public void setEvidenceState(int evidenceState) {
		this.evidenceState = evidenceState;
	}
	public int getOtherProveState() {
		return otherProveState;
	}
	public void setOtherProveState(int otherProveState) {
		this.otherProveState = otherProveState;
	}
	public String getMainProblem() {
		return mainProblem;
	}
	public void setMainProblem(String mainProblem) {
		this.mainProblem = mainProblem;
	}
	public String getCheckConclusion() {
		return checkConclusion;
	}
	public void setCheckConclusion(String checkConclusion) {
		this.checkConclusion = checkConclusion;
	}
	public String getStopReason() {
		return stopReason;
	}
	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}
}
