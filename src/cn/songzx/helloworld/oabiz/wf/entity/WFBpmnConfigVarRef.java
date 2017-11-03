package cn.songzx.helloworld.oabiz.wf.entity;

import java.io.Serializable;
import java.util.Date;

public class WFBpmnConfigVarRef implements Serializable {

	/**
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 4075870582011966170L;

	private String wfBpmnConfigVarRefId;

	private String bpmnVariableKey;

	private String bpmnVariableName;

	private String bpmnVariableIntro;

	private String bpmnEngineType;

	private String refBizVariableKey;

	private String refBizVariableName;

	private String refBizVariableIntro;

	private Date createDatetime;

	private Date modifyDatetime;

	private String usableStatus;

	private String reservedAttribute1;

	private String reservedAttribute2;

	private String reservedAttribute3;

	private String reservedAttribute4;

	private String reservedAttribute5;

	private String reservedAttribute6;

	public String getWfBpmnConfigVarRefId() {
		return wfBpmnConfigVarRefId;
	}

	public void setWfBpmnConfigVarRefId(String wfBpmnConfigVarRefId) {
		this.wfBpmnConfigVarRefId = wfBpmnConfigVarRefId == null ? null : wfBpmnConfigVarRefId.trim();
	}

	public String getBpmnVariableKey() {
		return bpmnVariableKey;
	}

	public void setBpmnVariableKey(String bpmnVariableKey) {
		this.bpmnVariableKey = bpmnVariableKey == null ? null : bpmnVariableKey.trim();
	}

	public String getBpmnVariableName() {
		return bpmnVariableName;
	}

	public void setBpmnVariableName(String bpmnVariableName) {
		this.bpmnVariableName = bpmnVariableName == null ? null : bpmnVariableName.trim();
	}

	public String getBpmnVariableIntro() {
		return bpmnVariableIntro;
	}

	public void setBpmnVariableIntro(String bpmnVariableIntro) {
		this.bpmnVariableIntro = bpmnVariableIntro == null ? null : bpmnVariableIntro.trim();
	}

	public String getBpmnEngineType() {
		return bpmnEngineType;
	}

	public void setBpmnEngineType(String bpmnEngineType) {
		this.bpmnEngineType = bpmnEngineType == null ? null : bpmnEngineType.trim();
	}

	public String getRefBizVariableKey() {
		return refBizVariableKey;
	}

	public void setRefBizVariableKey(String refBizVariableKey) {
		this.refBizVariableKey = refBizVariableKey == null ? null : refBizVariableKey.trim();
	}

	public String getRefBizVariableName() {
		return refBizVariableName;
	}

	public void setRefBizVariableName(String refBizVariableName) {
		this.refBizVariableName = refBizVariableName == null ? null : refBizVariableName.trim();
	}

	public String getRefBizVariableIntro() {
		return refBizVariableIntro;
	}

	public void setRefBizVariableIntro(String refBizVariableIntro) {
		this.refBizVariableIntro = refBizVariableIntro == null ? null : refBizVariableIntro.trim();
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