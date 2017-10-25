package cn.songzx.helloworld.workflow.biz.impl;

import java.io.FileInputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.util.WFInitializingBean;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.enmu.CommonExecuteStatus;
import cn.songzx.helloworld.workflow.dao.enmu.WFEngineType;
import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;

/**
 *
 * @ClassName: WorkflowBizActBpm518Impl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月24日 下午12:21:50
 *
 */
public class WorkflowBizActBpm518Impl extends WFInitializingBean implements WorkflowBizI {

	private RuntimeService workflowRuntimeBiz;

	private TaskService workflowTaskBiz;

	private HistoryService workflowHistoryBiz;

	private ManagementService workflowManagementBiz;

	private RepositoryService workflowRepositoryBiz;

	/**
	 * @Date: 2017年10月23日上午10:21:07
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param processDefinitionKey
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFBizData startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception {
		WFBizData wfBizData = null;
		System.out.println("警告：当前数据源☆【" + DataSourceContextHolder.getCustomerType() + "】★类型为业务系统，非流程系统指定数据源！");
		try {
			ProcessInstance newProcessInstance = workflowRuntimeBiz.startProcessInstanceByKey(processDefinitionKey, variables);
			if (newProcessInstance != null) {
				wfBizData = new WFBizData();
				wfBizData.setWfBizDataId(OABizUtil.generateThirtySixUUIDPK());// 数据主键
				wfBizData.setProcessInstanceId(newProcessInstance.getProcessInstanceId());// 流程实例ID
				wfBizData.setProcessDefinitionKey(processDefinitionKey);// 流程定义Key
				wfBizData.setProcessDefinitionName(newProcessInstance.getProcessDefinitionName());// 流程定义名称，即：流程名称
				wfBizData.setCreateDatetime(OABizUtil.getCurrentTimestamp());// 数据创建日期
				wfBizData.setUsableStatus("1");// 逻辑删除标识，1是否，0是被标记为逻辑删除
				wfBizData.setWfEngineType(WFEngineType.ACTIVITI518.name());// 流程引擎类型
				wfBizData.setBizBillAuditStatus(WorkflowBizI.APPROVAL_UNDERWAY);// 流程实例审批状态为：进行中
				if (variables != null && !variables.isEmpty()) {
					wfBizData.setBizBillEditorName((String) variables.get("dynamic_participant_name"));// 参与者人员姓名
					wfBizData.setBizBillEditorPartyid((String) variables.get("dynamic_participant_partyid"));// 参与者人员partyid
					wfBizData.setBizBillEditorCode((String) variables.get("dynamic_participant_code"));// 参与者人员CODE
					wfBizData.setBizBillEditorDeptName((String) variables.get("dynamic_participant_dept_name"));// 参与者所在部门名称
					wfBizData.setBizBillEditorDeptCode((String) variables.get("dynamic_participant_dept_code"));// 参与者所在部门CODE
					wfBizData.setBizBillId((String) variables.get("business_bill_id"));// 业务单据主键
					wfBizData.setBizBillName((String) variables.get("business_bill_name"));// 业务单据名称
					wfBizData.setBizBillNo((String) variables.get("business_bill_no"));// 业务单据编号
					wfBizData.setBizBillKindId((String) variables.get("business_bill_kind_id"));// 业务类型ID
					wfBizData.setBizBillKindName((String) variables.get("business_bill_kind_name"));// 业务类型名称
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return wfBizData;
	}

	/**
	 * @Date: 2017年10月23日上午10:21:07
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param workitemId
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFWorkitem getWFWorkitemByPK(String workitemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Date: 2017年10月23日上午10:21:07
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param workitemId
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFWorkitem completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Date: 2017年10月23日下午6:15:38
	 * @Title: deployDiagramByZipFile
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param zipFilePath
	 * @param zipFileName
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public String deployDiagramByZipFile(String zipFilePath, String zipFileName) throws Exception {
		String deployStatus = "";
		ZipInputStream inputStream = null;
		try {
			inputStream = new ZipInputStream(new FileInputStream(zipFilePath));
			if (inputStream != null) {
				Deployment deployment = workflowRepositoryBiz.createDeployment().name(zipFileName).addZipInputStream(inputStream).deploy();
				if (deployment != null) {
					deployStatus = CommonExecuteStatus.SUCCESS.name() + ": " + deployment.getId();
				} else {
					deployStatus = CommonExecuteStatus.FAILURE.name();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return deployStatus;
	}

	/**
	 * @Date: 2017年10月25日上午9:53:16
	 * @Title: afterPropertiesSet
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
	}

	/**
	 * @return the workflowRuntimeBiz
	 */
	public RuntimeService getWorkflowRuntimeBiz() {
		return workflowRuntimeBiz;
	}

	/**
	 * @param workflowRuntimeBiz
	 *            the workflowRuntimeBiz to set
	 */
	public void setWorkflowRuntimeBiz(RuntimeService workflowRuntimeBiz) {
		this.workflowRuntimeBiz = workflowRuntimeBiz;
	}

	/**
	 * @return the workflowTaskBiz
	 */
	public TaskService getWorkflowTaskBiz() {
		return workflowTaskBiz;
	}

	/**
	 * @param workflowTaskBiz
	 *            the workflowTaskBiz to set
	 */
	public void setWorkflowTaskBiz(TaskService workflowTaskBiz) {
		this.workflowTaskBiz = workflowTaskBiz;
	}

	/**
	 * @return the workflowHistoryBiz
	 */
	public HistoryService getWorkflowHistoryBiz() {
		return workflowHistoryBiz;
	}

	/**
	 * @param workflowHistoryBiz
	 *            the workflowHistoryBiz to set
	 */
	public void setWorkflowHistoryBiz(HistoryService workflowHistoryBiz) {
		this.workflowHistoryBiz = workflowHistoryBiz;
	}

	/**
	 * @return the workflowManagementBiz
	 */
	public ManagementService getWorkflowManagementBiz() {
		return workflowManagementBiz;
	}

	/**
	 * @param workflowManagementBiz
	 *            the workflowManagementBiz to set
	 */
	public void setWorkflowManagementBiz(ManagementService workflowManagementBiz) {
		this.workflowManagementBiz = workflowManagementBiz;
	}

	/**
	 * @return the workflowRepositoryBiz
	 */
	public RepositoryService getWorkflowRepositoryBiz() {
		return workflowRepositoryBiz;
	}

	/**
	 * @param workflowRepositoryBiz
	 *            the workflowRepositoryBiz to set
	 */
	public void setWorkflowRepositoryBiz(RepositoryService workflowRepositoryBiz) {
		this.workflowRepositoryBiz = workflowRepositoryBiz;
	}

}
