package cn.songzx.helloworld.oabiz.wf.entity;

import java.io.Serializable;
import java.util.Date;

public class WFStepInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -1146264273375813127L;

	private String wfStepInfoId;

	private String processKey;

	private String processName;

	private String stepId;

	private String stepName;

	private String stepType;

	private String stepFilterUserType;

	private String stepFilterRoleId;

	private String stepFilterRoleName;

	private String stepDeptCode;

	private String stepDeptName;

	private String stepDeptType;

	private String stepDeptLevel;

	private String stepPath;

	private String stepFurtherPath;

	private String bizFormUrl;

	private String isImportance;

	private String filterPersonsTeamId;

	private String filterPersonsTeamName;

	private String switcheId;

	private String switcheName;

	private String mustAuditPersonName;

	private String mustAuditPersonCode;

	private String mustAuditPersonPartyid;

	private String isMustWriteAuditIdea;

	private Date createDatetime;

	private Date modifyDatetime;

	private String usableStatus;

	private String reservedAttribute1;

	private String reservedAttribute2;

	private String reservedAttribute3;

	private String reservedAttribute4;

	private String reservedAttribute5;

	private String reservedAttribute6;

	public String getWfStepInfoId() {
		return wfStepInfoId;
	}

	public void setWfStepInfoId(String wfStepInfoId) {
		this.wfStepInfoId = wfStepInfoId == null ? null : wfStepInfoId.trim();
	}

	public String getProcessKey() {
		return processKey;
	}

	public void setProcessKey(String processKey) {
		this.processKey = processKey == null ? null : processKey.trim();
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName == null ? null : processName.trim();
	}

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId == null ? null : stepId.trim();
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName == null ? null : stepName.trim();
	}

	public String getStepType() {
		return stepType;
	}

	public void setStepType(String stepType) {
		this.stepType = stepType == null ? null : stepType.trim();
	}

	public String getStepFilterUserType() {
		return stepFilterUserType;
	}

	public void setStepFilterUserType(String stepFilterUserType) {
		this.stepFilterUserType = stepFilterUserType == null ? null : stepFilterUserType.trim();
	}

	public String getStepFilterRoleId() {
		return stepFilterRoleId;
	}

	public void setStepFilterRoleId(String stepFilterRoleId) {
		this.stepFilterRoleId = stepFilterRoleId == null ? null : stepFilterRoleId.trim();
	}

	public String getStepFilterRoleName() {
		return stepFilterRoleName;
	}

	public void setStepFilterRoleName(String stepFilterRoleName) {
		this.stepFilterRoleName = stepFilterRoleName == null ? null : stepFilterRoleName.trim();
	}

	public String getStepDeptCode() {
		return stepDeptCode;
	}

	public void setStepDeptCode(String stepDeptCode) {
		this.stepDeptCode = stepDeptCode == null ? null : stepDeptCode.trim();
	}

	public String getStepDeptName() {
		return stepDeptName;
	}

	public void setStepDeptName(String stepDeptName) {
		this.stepDeptName = stepDeptName == null ? null : stepDeptName.trim();
	}

	public String getStepDeptType() {
		return stepDeptType;
	}

	public void setStepDeptType(String stepDeptType) {
		this.stepDeptType = stepDeptType == null ? null : stepDeptType.trim();
	}

	public String getStepDeptLevel() {
		return stepDeptLevel;
	}

	public void setStepDeptLevel(String stepDeptLevel) {
		this.stepDeptLevel = stepDeptLevel == null ? null : stepDeptLevel.trim();
	}

	public String getStepPath() {
		return stepPath;
	}

	public void setStepPath(String stepPath) {
		this.stepPath = stepPath == null ? null : stepPath.trim();
	}

	public String getStepFurtherPath() {
		return stepFurtherPath;
	}

	public void setStepFurtherPath(String stepFurtherPath) {
		this.stepFurtherPath = stepFurtherPath == null ? null : stepFurtherPath.trim();
	}

	public String getBizFormUrl() {
		return bizFormUrl;
	}

	public void setBizFormUrl(String bizFormUrl) {
		this.bizFormUrl = bizFormUrl == null ? null : bizFormUrl.trim();
	}

	public String getIsImportance() {
		return isImportance;
	}

	public void setIsImportance(String isImportance) {
		this.isImportance = isImportance == null ? null : isImportance.trim();
	}

	public String getFilterPersonsTeamId() {
		return filterPersonsTeamId;
	}

	public void setFilterPersonsTeamId(String filterPersonsTeamId) {
		this.filterPersonsTeamId = filterPersonsTeamId == null ? null : filterPersonsTeamId.trim();
	}

	public String getFilterPersonsTeamName() {
		return filterPersonsTeamName;
	}

	public void setFilterPersonsTeamName(String filterPersonsTeamName) {
		this.filterPersonsTeamName = filterPersonsTeamName == null ? null : filterPersonsTeamName.trim();
	}

	public String getSwitcheId() {
		return switcheId;
	}

	public void setSwitcheId(String switcheId) {
		this.switcheId = switcheId == null ? null : switcheId.trim();
	}

	public String getSwitcheName() {
		return switcheName;
	}

	public void setSwitcheName(String switcheName) {
		this.switcheName = switcheName == null ? null : switcheName.trim();
	}

	public String getMustAuditPersonName() {
		return mustAuditPersonName;
	}

	public void setMustAuditPersonName(String mustAuditPersonName) {
		this.mustAuditPersonName = mustAuditPersonName == null ? null : mustAuditPersonName.trim();
	}

	public String getMustAuditPersonCode() {
		return mustAuditPersonCode;
	}

	public void setMustAuditPersonCode(String mustAuditPersonCode) {
		this.mustAuditPersonCode = mustAuditPersonCode == null ? null : mustAuditPersonCode.trim();
	}

	public String getMustAuditPersonPartyid() {
		return mustAuditPersonPartyid;
	}

	public void setMustAuditPersonPartyid(String mustAuditPersonPartyid) {
		this.mustAuditPersonPartyid = mustAuditPersonPartyid == null ? null : mustAuditPersonPartyid.trim();
	}

	public String getIsMustWriteAuditIdea() {
		return isMustWriteAuditIdea;
	}

	public void setIsMustWriteAuditIdea(String isMustWriteAuditIdea) {
		this.isMustWriteAuditIdea = isMustWriteAuditIdea == null ? null : isMustWriteAuditIdea.trim();
	}

	public Date getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Date getModifyDatetime() {
		return modifyDatetime;
	}

	public void setModifyDatetime(Date modifyDatetime) {
		this.modifyDatetime = modifyDatetime;
	}

	public String getUsableStatus() {
		return usableStatus;
	}

	public void setUsableStatus(String usableStatus) {
		this.usableStatus = usableStatus == null ? null : usableStatus.trim();
	}

	public String getReservedAttribute1() {
		return reservedAttribute1;
	}

	public void setReservedAttribute1(String reservedAttribute1) {
		this.reservedAttribute1 = reservedAttribute1 == null ? null : reservedAttribute1.trim();
	}

	public String getReservedAttribute2() {
		return reservedAttribute2;
	}

	public void setReservedAttribute2(String reservedAttribute2) {
		this.reservedAttribute2 = reservedAttribute2 == null ? null : reservedAttribute2.trim();
	}

	public String getReservedAttribute3() {
		return reservedAttribute3;
	}

	public void setReservedAttribute3(String reservedAttribute3) {
		this.reservedAttribute3 = reservedAttribute3 == null ? null : reservedAttribute3.trim();
	}

	public String getReservedAttribute4() {
		return reservedAttribute4;
	}

	public void setReservedAttribute4(String reservedAttribute4) {
		this.reservedAttribute4 = reservedAttribute4 == null ? null : reservedAttribute4.trim();
	}

	public String getReservedAttribute5() {
		return reservedAttribute5;
	}

	public void setReservedAttribute5(String reservedAttribute5) {
		this.reservedAttribute5 = reservedAttribute5 == null ? null : reservedAttribute5.trim();
	}

	public String getReservedAttribute6() {
		return reservedAttribute6;
	}

	public void setReservedAttribute6(String reservedAttribute6) {
		this.reservedAttribute6 = reservedAttribute6 == null ? null : reservedAttribute6.trim();
	}
}