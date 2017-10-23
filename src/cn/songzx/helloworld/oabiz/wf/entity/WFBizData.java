package cn.songzx.helloworld.oabiz.wf.entity;

import java.io.Serializable;
import java.util.Date;

public class WFBizData implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 5319076083870183555L;

	private String wfBizDataId;

	private String bizBillId;

	private String bizBillAuditStatus;

	private String bizBillNo;

	private String bizBillName;

	private String bizBillKindId;

	private String bizBillKindName;

	private String processInstanceId;

	private String bizBillEditorName;

	private String bizBillEditorPartyid;

	private String bizBillEditorCode;

	private String bizBillEditorDeptName;

	private String bizBillEditorDeptCode;

	private String usableStatus;

	private Date createDatetime;

	private Date modifyDatetime;

	private String wfEngineType;

	private String reservedAttribute1;

	private String reservedAttribute2;

	private String reservedAttribute3;

	private String reservedAttribute4;

	private String reservedAttribute5;

	public String getWfBizDataId() {
		return wfBizDataId;
	}

	public void setWfBizDataId(String wfBizDataId) {
		this.wfBizDataId = wfBizDataId == null ? null : wfBizDataId.trim();
	}

	public String getBizBillId() {
		return bizBillId;
	}

	public void setBizBillId(String bizBillId) {
		this.bizBillId = bizBillId == null ? null : bizBillId.trim();
	}

	public String getBizBillAuditStatus() {
		return bizBillAuditStatus;
	}

	public void setBizBillAuditStatus(String bizBillAuditStatus) {
		this.bizBillAuditStatus = bizBillAuditStatus == null ? null : bizBillAuditStatus.trim();
	}

	public String getBizBillNo() {
		return bizBillNo;
	}

	public void setBizBillNo(String bizBillNo) {
		this.bizBillNo = bizBillNo == null ? null : bizBillNo.trim();
	}

	public String getBizBillName() {
		return bizBillName;
	}

	public void setBizBillName(String bizBillName) {
		this.bizBillName = bizBillName == null ? null : bizBillName.trim();
	}

	public String getBizBillKindId() {
		return bizBillKindId;
	}

	public void setBizBillKindId(String bizBillKindId) {
		this.bizBillKindId = bizBillKindId == null ? null : bizBillKindId.trim();
	}

	public String getBizBillKindName() {
		return bizBillKindName;
	}

	public void setBizBillKindName(String bizBillKindName) {
		this.bizBillKindName = bizBillKindName == null ? null : bizBillKindName.trim();
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
	}

	public String getBizBillEditorName() {
		return bizBillEditorName;
	}

	public void setBizBillEditorName(String bizBillEditorName) {
		this.bizBillEditorName = bizBillEditorName == null ? null : bizBillEditorName.trim();
	}

	public String getBizBillEditorPartyid() {
		return bizBillEditorPartyid;
	}

	public void setBizBillEditorPartyid(String bizBillEditorPartyid) {
		this.bizBillEditorPartyid = bizBillEditorPartyid == null ? null : bizBillEditorPartyid.trim();
	}

	public String getBizBillEditorCode() {
		return bizBillEditorCode;
	}

	public void setBizBillEditorCode(String bizBillEditorCode) {
		this.bizBillEditorCode = bizBillEditorCode == null ? null : bizBillEditorCode.trim();
	}

	public String getBizBillEditorDeptName() {
		return bizBillEditorDeptName;
	}

	public void setBizBillEditorDeptName(String bizBillEditorDeptName) {
		this.bizBillEditorDeptName = bizBillEditorDeptName == null ? null : bizBillEditorDeptName.trim();
	}

	public String getBizBillEditorDeptCode() {
		return bizBillEditorDeptCode;
	}

	public void setBizBillEditorDeptCode(String bizBillEditorDeptCode) {
		this.bizBillEditorDeptCode = bizBillEditorDeptCode == null ? null : bizBillEditorDeptCode.trim();
	}

	public String getUsableStatus() {
		return usableStatus;
	}

	public void setUsableStatus(String usableStatus) {
		this.usableStatus = usableStatus == null ? null : usableStatus.trim();
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

	public String getWfEngineType() {
		return wfEngineType;
	}

	public void setWfEngineType(String wfEngineType) {
		this.wfEngineType = wfEngineType == null ? null : wfEngineType.trim();
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
}