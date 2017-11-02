package cn.songzx.helloworld.oabiz.wf.entity;

import java.io.Serializable;
import java.util.Date;

public class WFBaseInfo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -8989545289385537882L;

	private String wfBaseInfo;

	private String processKey;

	private String processName;

	private String processTypeId;

	private String processTypeName;

	private String processAuthorizedDeptName;

	private String processAuthorizedDeptCode;

	private String processPublishStatus;

	private String processNamespace;

	private String processDescription;

	private String processEngineType;

	private String processUrl;

	private Date createDatetime;

	private Date modifyDatetime;

	private String usableStatus;

	private String reservedAttribute1;

	private String reservedAttribute2;

	private String reservedAttribute3;

	private String reservedAttribute4;

	private String reservedAttribute5;

	private String reservedAttribute6;

	public String getWfBaseInfo() {
		return wfBaseInfo;
	}

	public void setWfBaseInfo(String wfBaseInfo) {
		this.wfBaseInfo = wfBaseInfo == null ? null : wfBaseInfo.trim();
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

	public String getProcessTypeId() {
		return processTypeId;
	}

	public void setProcessTypeId(String processTypeId) {
		this.processTypeId = processTypeId == null ? null : processTypeId.trim();
	}

	public String getProcessTypeName() {
		return processTypeName;
	}

	public void setProcessTypeName(String processTypeName) {
		this.processTypeName = processTypeName == null ? null : processTypeName.trim();
	}

	public String getProcessAuthorizedDeptName() {
		return processAuthorizedDeptName;
	}

	public void setProcessAuthorizedDeptName(String processAuthorizedDeptName) {
		this.processAuthorizedDeptName = processAuthorizedDeptName == null ? null : processAuthorizedDeptName.trim();
	}

	public String getProcessAuthorizedDeptCode() {
		return processAuthorizedDeptCode;
	}

	public void setProcessAuthorizedDeptCode(String processAuthorizedDeptCode) {
		this.processAuthorizedDeptCode = processAuthorizedDeptCode == null ? null : processAuthorizedDeptCode.trim();
	}

	public String getProcessPublishStatus() {
		return processPublishStatus;
	}

	public void setProcessPublishStatus(String processPublishStatus) {
		this.processPublishStatus = processPublishStatus == null ? null : processPublishStatus.trim();
	}

	public String getProcessNamespace() {
		return processNamespace;
	}

	public void setProcessNamespace(String processNamespace) {
		this.processNamespace = processNamespace == null ? null : processNamespace.trim();
	}

	public String getProcessDescription() {
		return processDescription;
	}

	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription == null ? null : processDescription.trim();
	}

	public String getProcessEngineType() {
		return processEngineType;
	}

	public void setProcessEngineType(String processEngineType) {
		this.processEngineType = processEngineType == null ? null : processEngineType.trim();
	}

	public String getProcessUrl() {
		return processUrl;
	}

	public void setProcessUrl(String processUrl) {
		this.processUrl = processUrl == null ? null : processUrl.trim();
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