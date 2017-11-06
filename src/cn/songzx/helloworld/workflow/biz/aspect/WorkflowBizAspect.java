package cn.songzx.helloworld.workflow.biz.aspect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.enmu.WFEngineType;
import cn.songzx.helloworld.oabiz.wf.enmu.WFStepType;
import cn.songzx.helloworld.oabiz.wf.enmu.WFVariableType;
import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.biz.impl.WorkflowBizActBpm518Impl;

@Aspect
@Component
public class WorkflowBizAspect {

	/**
	 *
	 * @Date: 2017年11月2日上午10:30:17
	 * @Title: aroundStartKindMethod
	 * @Description: TODO(类WorkflowBizActBpm518Impl的启动流程方法的环绕通知方法)
	 * @param pjp
	 * @return
	 * @return Object 返回值类型
	 */
	@SuppressWarnings("unchecked")
	@Around(value = "execution(* cn.songzx.helloworld.workflow.biz.impl.WorkflowBizActBpm518Impl.startProcessInstance*(..))")
	public Object aroundStartProcessInstanceKindMethod(ProceedingJoinPoint pjp) {

		Object[] args = pjp.getArgs();// 获取代理目标对象的方法执行参数
		if (args == null || args.length < 2 || args[0] == null || args[1] == null) {
			throw new RuntimeException("目标方法【" + pjp.getSignature().getName() + "(..)】执行失败，方法参数不符合规范！");
		}
		Object returnValue = null;
		try {
			returnValue = pjp.proceed(args);// 执行代理的目标方法
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (returnValue != null && returnValue instanceof WFBizData) {
			WFBizData pretreatment = (WFBizData) returnValue;
			String newProcInstId = pretreatment.getProcessInstanceId();
			pretreatment = initWFBizDataRefNewProcInst((String) args[0], (Map<String, Object>) args[1], newProcInstId, (WorkflowBizActBpm518Impl) pjp.getTarget());
			OABizUtil.copyProperties(pretreatment, returnValue);
		}
		return returnValue;
	}

	/**
	 *
	 * @Date: 2017年11月3日上午9:37:57
	 * @Title: aroundCompleteWorkitemKindMethod
	 * @Description: TODO(类WorkflowBizActBpm518Impl的提交工作项方法的环绕通知方法)
	 * @param pjp
	 * @return
	 * @return Object 返回值类型
	 */
	@SuppressWarnings("unchecked")
	@Around(value = "execution(* cn.songzx.helloworld.workflow.biz.impl.WorkflowBizActBpm518Impl.completeWorkitem*(..))")
	public Object aroundCompleteWorkitemKindMethod(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();// 获取代理目标对象的方法执行参数
		if (args == null || args.length < 2 || args[0] == null || args[1] == null) {
			throw new RuntimeException("目标方法【" + pjp.getSignature().getName() + "(..)】执行失败，方法参数不符合规范！");
		}
		Object returnValue = null;
		try {
			returnValue = pjp.proceed(args);// 执行代理的目标方法
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (returnValue != null && returnValue instanceof WFWorkitem) {
			WFWorkitem pretreatment = (WFWorkitem) returnValue;
			pretreatment = initWFWorkitemRefNewTask((String) args[0], (Map<String, Object>) args[1], (WorkflowBizActBpm518Impl) pjp.getTarget());
			OABizUtil.copyProperties(pretreatment, returnValue);
		}
		return returnValue;
	}

	/**
	 *
	 * @Date: 2017年11月2日上午10:32:38
	 * @Title: initWFBizDataRefNewProcInst
	 * @Description: TODO(加工流程引擎回执的预处理数据)
	 * @param processDefinitionKey
	 * @param variables
	 * @param newProcInstId
	 * @param targetObj
	 * @return
	 * @return WFBizData 返回值类型
	 */
	private WFBizData initWFBizDataRefNewProcInst(String processDefinitionKey, Map<String, Object> variables, String newProcInstId, WorkflowBizActBpm518Impl targetObj) {
		WFBizData newWFBizData = null;
		if (newProcInstId != null && newProcInstId.length() > 0) {
			newWFBizData = new WFBizData();
			/* step1.根据新发起的流程实例初始化【业务模块-流程业务关联信息】数据 */
			newWFBizData.setWfBizDataId(OABizUtil.generateThirtySixUUIDPK());// 数据主键
			newWFBizData.setProcessInstanceId(newProcInstId);// 流程实例ID
			newWFBizData.setProcessDefinitionKey(processDefinitionKey);// 流程定义Key
			newWFBizData.setProcessDefinitionName(processDefinitionKey);// 流程定义名称，即：流程名称
			newWFBizData.setCreateDatetime(OABizUtil.getCurrentTimestamp());// 数据创建日期
			newWFBizData.setUsableStatus("1");// 逻辑删除标识，1是否，0是被标记为逻辑删除
			newWFBizData.setWfEngineType(WFEngineType.ACTIVITI518.name());// 流程引擎类型
			newWFBizData.setBizBillAuditStatus(WorkflowBizI.APPROVAL_UNDERWAY);// 流程实例审批状态为：进行中
			newWFBizData.setBizBillEditorName((String) variables.get(WFVariableType.current_participant_name.getKey()));// 参与者人员姓名
			newWFBizData.setBizBillEditorPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));// 参与者人员partyid
			newWFBizData.setBizBillEditorCode((String) variables.get(WFVariableType.current_participant_code.getKey()));// 参与者人员CODE
			newWFBizData.setBizBillEditorDeptName((String) variables.get(WFVariableType.current_participant_dept_name.getKey()));// 参与者所在部门名称
			newWFBizData.setBizBillEditorDeptCode((String) variables.get(WFVariableType.current_participant_dept_code.getKey()));// 参与者所在部门CODE
			newWFBizData.setBizBillId((String) variables.get(WFVariableType.business_bill_id.getKey()));// 业务单据主键
			newWFBizData.setBizBillName((String) variables.get(WFVariableType.business_bill_name.getKey()));// 业务单据名称
			newWFBizData.setBizBillNo((String) variables.get(WFVariableType.business_bill_no.getKey()));// 业务单据编号
			newWFBizData.setBizBillKindId((String) variables.get(WFVariableType.business_bill_kind_id.getKey()));// 业务类型ID
			newWFBizData.setBizBillKindName((String) variables.get(WFVariableType.business_bill_kind_name.getKey()));// 业务类型名称
			/* step2.初始化业务模块流程实例关联的工作项信息 */
			List<WFWorkitem> newWFWorkitems = new ArrayList<WFWorkitem>();
			String queryCurrentTask = "SELECT * FROM " + targetObj.getWorkflowManagementBiz().getTableName(Task.class) + " WHERE PROC_INST_ID_=#{procInstId}";
			Task currentTask = targetObj.getWorkflowTaskBiz().createNativeTaskQuery().sql(queryCurrentTask).parameter("procInstId", newProcInstId).singleResult();
			if (currentTask != null) {
				WFWorkitem newWFWorkitem = new WFWorkitem();
				newWFWorkitem.setWfWorkitemId(currentTask.getId());
				newWFWorkitem.setProcessInstanceId(newProcInstId);
				newWFWorkitem.setProcessName(targetObj.getWorkflowRepositoryBiz().getProcessDefinition(currentTask.getProcessDefinitionId()).getName());
				newWFWorkitem.setWfEngineType(WFEngineType.ACTIVITI518.name());
				newWFWorkitem.setWfStepId(currentTask.getTaskDefinitionKey());
				newWFWorkitem.setWfStepName(currentTask.getName());
				newWFWorkitem.setWfStepType("" + WFStepType.GENERALSIGN.getIndex());
				newWFWorkitem.setCreateDatetime(currentTask.getCreateTime());
				newWFWorkitem.setSenderCompletedDatetime(currentTask.getCreateTime());
				newWFWorkitem.setSenderName((String) variables.get(WFVariableType.current_participant_name.getKey()));
				newWFWorkitem.setSenderPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
				newWFWorkitem.setSenderCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
				newWFWorkitem.setPerformerName((String) variables.get(WFVariableType.current_participant_name.getKey()));
				newWFWorkitem.setPerformerPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
				newWFWorkitem.setPerformerCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
				newWFWorkitem.setUsableStatus("1");
				newWFWorkitem.setDoneStatus("0");
				newWFWorkitem.setReadStatus("1");
				newWFWorkitem.setAuthorizeStatus("0");
				/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
				newWFWorkitems.add(newWFWorkitem);
				newWFBizData.setWfWorkitems(newWFWorkitems);
			}
			/* step3.初始化业务模块流程实例关联的审批记录信息 */
			List<WFAuditRecord> newWFAuditRecords = new ArrayList<WFAuditRecord>();
			List<HistoricActivityInstance> histActiInsts = targetObj.getWorkflowHistoryBiz().createHistoricActivityInstanceQuery().processInstanceId(newProcInstId).orderByHistoricActivityInstanceStartTime().asc().list();
			if (histActiInsts != null && histActiInsts.size() == 2) {
				HistoricActivityInstance firstRecord = histActiInsts.get(0);
				HistoricActivityInstance secondRecord = histActiInsts.get(1);
				/* 业务模块流程实例关联的审批记录第一条数据 */
				WFAuditRecord newFirstWFAuditRecord = new WFAuditRecord();
				newFirstWFAuditRecord.setCreateDatetime(firstRecord.getStartTime());
				newFirstWFAuditRecord.setCurrentApproverAuditTime(firstRecord.getEndTime());
				newFirstWFAuditRecord.setModifyDatetime(OABizUtil.getCurrentTimestamp());
				newFirstWFAuditRecord.setWfAuditRecordId(firstRecord.getId());
				newFirstWFAuditRecord.setProcessInstanceId(newProcInstId);
				newFirstWFAuditRecord.setProcessName(targetObj.getWorkflowRepositoryBiz().getProcessDefinition(firstRecord.getProcessDefinitionId()).getName());
				newFirstWFAuditRecord.setCurrentStepId(firstRecord.getActivityId());
				newFirstWFAuditRecord.setCurrentStepName(firstRecord.getActivityName());
				newFirstWFAuditRecord.setCurrentStepType(firstRecord.getActivityType());
				newFirstWFAuditRecord.setCurrentApproverName((String) variables.get(WFVariableType.current_participant_name.getKey()));
				newFirstWFAuditRecord.setCurrentApproverPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
				newFirstWFAuditRecord.setCurrentApproverCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
				newFirstWFAuditRecord.setCurrentApproverDeptName((String) variables.get(WFVariableType.current_participant_dept_name.getKey()));
				newFirstWFAuditRecord.setCurrentApproverDeptCode((String) variables.get(WFVariableType.current_participant_dept_code.getKey()));
				newFirstWFAuditRecord.setCurrentWorkitemId("PLACEHOLDER-" + OABizUtil.generateNineteenUUIDPK());
				newFirstWFAuditRecord.setNextStepId(secondRecord.getActivityId());
				newFirstWFAuditRecord.setNextStepName(secondRecord.getActivityName());
				newFirstWFAuditRecord.setNextStepType(secondRecord.getActivityType());
				newFirstWFAuditRecord.setNextApproverName((String) variables.get(WFVariableType.current_participant_name.getKey()));
				newFirstWFAuditRecord.setNextApproverPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
				newFirstWFAuditRecord.setNextApproverCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
				newFirstWFAuditRecord.setUsableStatus("1");
				/* 业务模块流程实例关联的审批记录第二条数据 */
				WFAuditRecord newSecondWFAuditRecord = new WFAuditRecord();
				newSecondWFAuditRecord.setWfAuditRecordId(secondRecord.getId());
				newSecondWFAuditRecord.setCreateDatetime(secondRecord.getStartTime());
				newSecondWFAuditRecord.setProcessInstanceId(newProcInstId);
				newSecondWFAuditRecord.setProcessName(targetObj.getWorkflowRepositoryBiz().getProcessDefinition(secondRecord.getProcessDefinitionId()).getName());
				newSecondWFAuditRecord.setCurrentStepId(secondRecord.getActivityId());
				newSecondWFAuditRecord.setCurrentStepName(secondRecord.getActivityName());
				newSecondWFAuditRecord.setCurrentStepType(secondRecord.getActivityType());
				newSecondWFAuditRecord.setCurrentApproverName((String) variables.get(WFVariableType.current_participant_name.getKey()));
				newSecondWFAuditRecord.setCurrentApproverPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
				newSecondWFAuditRecord.setCurrentApproverCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
				newSecondWFAuditRecord.setCurrentApproverDeptName((String) variables.get(WFVariableType.current_participant_dept_name.getKey()));
				newSecondWFAuditRecord.setCurrentApproverDeptCode((String) variables.get(WFVariableType.current_participant_dept_code.getKey()));
				newSecondWFAuditRecord.setCurrentWorkitemId(secondRecord.getTaskId());
				newSecondWFAuditRecord.setUsableStatus("1");
				/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
				newWFAuditRecords.add(newFirstWFAuditRecord);
				newWFAuditRecords.add(newSecondWFAuditRecord);
				newWFBizData.setWfAuditRecords(newWFAuditRecords);
			}
		}
		return newWFBizData;
	}

	/**
	 *
	 * @Date: 2017年11月3日上午9:41:56
	 * @Title: initWFWorkitemRefNewTask
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param histTaskId
	 * @param variables
	 * @param targetObj
	 * @return
	 * @return WFWorkitem 返回值类型
	 */
	private WFWorkitem initWFWorkitemRefNewTask(String histTaskId, Map<String, Object> variables, WorkflowBizActBpm518Impl targetObj) {
		WFWorkitem newWFWorkitem = new WFWorkitem();
		String procInstId = targetObj.getWorkflowHistoryBiz().createHistoricTaskInstanceQuery().taskId(histTaskId).singleResult().getProcessInstanceId();
		String queryCurrentTask = "SELECT * FROM " + targetObj.getWorkflowManagementBiz().getTableName(Task.class) + " WHERE PROC_INST_ID_=#{procInstId}";
		Task currentTask = targetObj.getWorkflowTaskBiz().createNativeTaskQuery().sql(queryCurrentTask).parameter("procInstId", procInstId).singleResult();
		if (currentTask != null) {
			/* 初始化业务模块新工作项的相关信息 */
			newWFWorkitem.setWfWorkitemId(currentTask.getId());
			newWFWorkitem.setProcessInstanceId(currentTask.getProcessInstanceId());
			newWFWorkitem.setProcessName(targetObj.getWorkflowRepositoryBiz().getProcessDefinition(currentTask.getProcessDefinitionId()).getName());
			newWFWorkitem.setWfEngineType(WFEngineType.ACTIVITI518.name());
			newWFWorkitem.setWfStepId(currentTask.getTaskDefinitionKey());
			newWFWorkitem.setWfStepName(currentTask.getName());
			newWFWorkitem.setWfStepType("" + WFStepType.GENERALSIGN.getIndex());
			newWFWorkitem.setCreateDatetime(currentTask.getCreateTime());
			newWFWorkitem.setPerformerName((String) variables.get(WFVariableType.current_participant_name.getKey()));
			newWFWorkitem.setPerformerPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
			newWFWorkitem.setPerformerCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
			newWFWorkitem.setSenderCompletedDatetime((Date) variables.get(WFVariableType.previous_participant_completed_datetime.getKey()));
			newWFWorkitem.setSenderName((String) variables.get(WFVariableType.previous_participant_name.getKey()));
			newWFWorkitem.setSenderPartyid((String) variables.get(WFVariableType.previous_participant_partyid.getKey()));
			newWFWorkitem.setSenderCode((String) variables.get(WFVariableType.previous_participant_code.getKey()));
			newWFWorkitem.setUsableStatus("1");
			newWFWorkitem.setDoneStatus("0");
			newWFWorkitem.setReadStatus("0");
			newWFWorkitem.setAuthorizeStatus("0");
			/* 业务模块新工作项关联的审批记录 */
			String queryHistActiInst = "SELECT * FROM " + targetObj.getWorkflowManagementBiz().getTableName(HistoricActivityInstance.class) + " WHERE PROC_INST_ID_=#{procInstId} AND TASK_ID_=#{taskId} AND END_TIME_ IS NULL";
			HistoricActivityInstance histActiInst = targetObj.getWorkflowHistoryBiz().createNativeHistoricActivityInstanceQuery().sql(queryHistActiInst).parameter("procInstId", procInstId).parameter("taskId", currentTask.getId()).singleResult();
			WFAuditRecord newWFAuditRecord = new WFAuditRecord();
			newWFAuditRecord.setWfAuditRecordId(histActiInst.getId());
			newWFAuditRecord.setCreateDatetime(histActiInst.getStartTime());
			newWFAuditRecord.setProcessInstanceId(procInstId);
			newWFAuditRecord.setProcessName(targetObj.getWorkflowRepositoryBiz().getProcessDefinition(histActiInst.getProcessDefinitionId()).getName());
			newWFAuditRecord.setCurrentStepId(histActiInst.getActivityId());
			newWFAuditRecord.setCurrentStepName(histActiInst.getActivityName());
			newWFAuditRecord.setCurrentStepType(histActiInst.getActivityType());
			newWFAuditRecord.setCurrentApproverName((String) variables.get(WFVariableType.current_participant_name.getKey()));
			newWFAuditRecord.setCurrentApproverPartyid((String) variables.get(WFVariableType.current_participant_partyid.getKey()));
			newWFAuditRecord.setCurrentApproverCode((String) variables.get(WFVariableType.current_participant_code.getKey()));
			newWFAuditRecord.setCurrentApproverDeptName((String) variables.get(WFVariableType.current_participant_dept_name.getKey()));
			newWFAuditRecord.setCurrentApproverDeptCode((String) variables.get(WFVariableType.current_participant_dept_code.getKey()));
			newWFAuditRecord.setCurrentWorkitemId(histActiInst.getTaskId());
			newWFAuditRecord.setUsableStatus("1");
			/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
			newWFWorkitem.setOwnWFAuditRecord(newWFAuditRecord);
		} else {
			String isEndProcInst = "SELECT * FROM " + targetObj.getWorkflowManagementBiz().getTableName(HistoricProcessInstance.class) + " WHERE PROC_INST_ID_=#{procInstId} AND END_TIME_ IS NOT NULL AND END_ACT_ID_ IS NOT NULL";
			HistoricProcessInstance histProcInst = targetObj.getWorkflowHistoryBiz().createNativeHistoricProcessInstanceQuery().sql(isEndProcInst).parameter("procInstId", procInstId).singleResult();
			if (histProcInst != null) {// 当前流程实例已结束

			}
		}
		return newWFWorkitem;
	}

}
