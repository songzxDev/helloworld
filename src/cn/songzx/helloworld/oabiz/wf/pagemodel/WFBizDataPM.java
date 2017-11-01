package cn.songzx.helloworld.oabiz.wf.pagemodel;

import java.util.List;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;

public class WFBizDataPM extends WFBizData {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -6019341948613892966L;

	private List<WFAuditRecordPM> wfAuditRecordsPM;

	private List<WFWorkitemPM> wfWorkitemsPM;

	/**
	 * @return the wfAuditRecordsPM
	 */
	public List<WFAuditRecordPM> getWfAuditRecordsPM() {
		return wfAuditRecordsPM;
	}

	/**
	 * @param wfAuditRecordsPM
	 *            the wfAuditRecordsPM to set
	 */
	public void setWfAuditRecordsPM(List<WFAuditRecordPM> wfAuditRecordsPM) {
		this.wfAuditRecordsPM = wfAuditRecordsPM;
	}

	/**
	 * @return the wfWorkitemsPM
	 */
	public List<WFWorkitemPM> getWfWorkitemsPM() {
		return wfWorkitemsPM;
	}

	/**
	 * @param wfWorkitemsPM
	 *            the wfWorkitemsPM to set
	 */
	public void setWfWorkitemsPM(List<WFWorkitemPM> wfWorkitemsPM) {
		this.wfWorkitemsPM = wfWorkitemsPM;
	}

}