package cn.songzx.helloworld.oabiz.wf.entity;

import java.util.Date;

public class WFWorkitem {
    private String wfWorkitemId;

    private String processInstanceId;

    private String wfStepId;

    private String wfStepName;

    private String wfStepType;

    private String senderName;

    private String senderPartyid;

    private String senderCode;

    private Date senderCompletedDatetime;

    private String performerName;

    private String performerPartyid;

    private String performerCode;

    private Date performerCompletedDatetime;

    private String readStatus;

    private String doneStatus;

    private String authorizeStatus;

    private String usableStatus;

    private Date createDatetime;

    private Date modifyDatetime;

    private String wfEngineType;

    private String reservedAttribute1;

    private String reservedAttribute2;

    private String reservedAttribute3;

    private String reservedAttribute4;

    private String reservedAttribute5;

    public String getWfWorkitemId() {
        return wfWorkitemId;
    }

    public void setWfWorkitemId(String wfWorkitemId) {
        this.wfWorkitemId = wfWorkitemId == null ? null : wfWorkitemId.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getWfStepId() {
        return wfStepId;
    }

    public void setWfStepId(String wfStepId) {
        this.wfStepId = wfStepId == null ? null : wfStepId.trim();
    }

    public String getWfStepName() {
        return wfStepName;
    }

    public void setWfStepName(String wfStepName) {
        this.wfStepName = wfStepName == null ? null : wfStepName.trim();
    }

    public String getWfStepType() {
        return wfStepType;
    }

    public void setWfStepType(String wfStepType) {
        this.wfStepType = wfStepType == null ? null : wfStepType.trim();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    public String getSenderPartyid() {
        return senderPartyid;
    }

    public void setSenderPartyid(String senderPartyid) {
        this.senderPartyid = senderPartyid == null ? null : senderPartyid.trim();
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode == null ? null : senderCode.trim();
    }

    public Date getSenderCompletedDatetime() {
        return senderCompletedDatetime;
    }

    public void setSenderCompletedDatetime(Date senderCompletedDatetime) {
        this.senderCompletedDatetime = senderCompletedDatetime;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName == null ? null : performerName.trim();
    }

    public String getPerformerPartyid() {
        return performerPartyid;
    }

    public void setPerformerPartyid(String performerPartyid) {
        this.performerPartyid = performerPartyid == null ? null : performerPartyid.trim();
    }

    public String getPerformerCode() {
        return performerCode;
    }

    public void setPerformerCode(String performerCode) {
        this.performerCode = performerCode == null ? null : performerCode.trim();
    }

    public Date getPerformerCompletedDatetime() {
        return performerCompletedDatetime;
    }

    public void setPerformerCompletedDatetime(Date performerCompletedDatetime) {
        this.performerCompletedDatetime = performerCompletedDatetime;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus == null ? null : readStatus.trim();
    }

    public String getDoneStatus() {
        return doneStatus;
    }

    public void setDoneStatus(String doneStatus) {
        this.doneStatus = doneStatus == null ? null : doneStatus.trim();
    }

    public String getAuthorizeStatus() {
        return authorizeStatus;
    }

    public void setAuthorizeStatus(String authorizeStatus) {
        this.authorizeStatus = authorizeStatus == null ? null : authorizeStatus.trim();
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