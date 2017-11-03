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

import cn.songzx.helloworld.oabiz.util.WFInitializingBean;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.enmu.CommonExecuteStatus;

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

	// ☆☆☆☆☆☆☆☆☆☆【开始属性注入】☆☆☆☆☆☆☆☆☆☆
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
	// ★★★★★★★★★★【结束属性注入】★★★★★★★★★★

	//

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
		try {
			ProcessInstance newProcessInstance = workflowRuntimeBiz.startProcessInstanceByKey(processDefinitionKey, variables);
			if (newProcessInstance != null) {
				String newProcessInstanceId = newProcessInstance.getProcessInstanceId();
				wfBizData = new WFBizData();
				/*
				 * 后续初始化相关操作由切面类：
				 * 【cn.songzx.helloworld.workflow.biz.aspect.WorkflowBizAspect】
				 * 的环绕通知方法：aroundStartKindMethod(ProceedingJoinPoint pjp)实现
				 */
				wfBizData.setProcessInstanceId(newProcessInstanceId);

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return wfBizData;
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
		WFWorkitem newWFWorkitem = new WFWorkitem();
		workflowTaskBiz.complete(workitemId, variables, true);
		return newWFWorkitem;
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

}
