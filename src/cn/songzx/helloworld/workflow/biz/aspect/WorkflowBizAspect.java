package cn.songzx.helloworld.workflow.biz.aspect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.biz.impl.WorkflowBizActBpm518Impl;
import cn.songzx.helloworld.workflow.dao.enmu.WFEngineType;
import cn.songzx.helloworld.workflow.dao.enmu.WFStepType;

@Aspect
@Component
public class WorkflowBizAspect {

	@SuppressWarnings("unchecked")
	@Around(value = "execution(* cn.songzx.helloworld.workflow.biz.impl.WorkflowBizActBpm518Impl.startProcessInstance*(..))")
	public Object aroundStartKindMethod(ProceedingJoinPoint pjp) {

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
			newWFBizData.setBizBillEditorName((String) variables.get("dynamic_participant_name"));// 参与者人员姓名
			newWFBizData.setBizBillEditorPartyid((String) variables.get("dynamic_participant_partyid"));// 参与者人员partyid
			newWFBizData.setBizBillEditorCode((String) variables.get("dynamic_participant_code"));// 参与者人员CODE
			newWFBizData.setBizBillEditorDeptName((String) variables.get("dynamic_participant_dept_name"));// 参与者所在部门名称
			newWFBizData.setBizBillEditorDeptCode((String) variables.get("dynamic_participant_dept_code"));// 参与者所在部门CODE
			newWFBizData.setBizBillId((String) variables.get("business_bill_id"));// 业务单据主键
			newWFBizData.setBizBillName((String) variables.get("business_bill_name"));// 业务单据名称
			newWFBizData.setBizBillNo((String) variables.get("business_bill_no"));// 业务单据编号
			newWFBizData.setBizBillKindId((String) variables.get("business_bill_kind_id"));// 业务类型ID
			newWFBizData.setBizBillKindName((String) variables.get("business_bill_kind_name"));// 业务类型名称

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
				newWFWorkitem.setSenderName((String) variables.get("dynamic_participant_name"));
				newWFWorkitem.setSenderPartyid((String) variables.get("dynamic_participant_partyid"));
				newWFWorkitem.setSenderCode((String) variables.get("dynamic_participant_code"));
				newWFWorkitem.setPerformerName((String) variables.get("dynamic_participant_name"));
				newWFWorkitem.setPerformerPartyid((String) variables.get("dynamic_participant_partyid"));
				newWFWorkitem.setPerformerCode((String) variables.get("dynamic_participant_code"));
				newWFWorkitem.setUsableStatus("1");
				newWFWorkitem.setDoneStatus("0");
				newWFWorkitem.setReadStatus("1");
				newWFWorkitem.setAuthorizeStatus("0");
				newWFWorkitems.add(newWFWorkitem);
				newWFBizData.setWfWorkitems(newWFWorkitems);
			}

			/* step3.初始化业务模块流程实例关联的审批记录信息 */
			// TODO ......
		}
		return newWFBizData;
	}

}
