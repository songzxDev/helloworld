/**
* @Title: WorkflowBizImpl.java
* @Package cn.songzx.helloworld.workflow.biz.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:46:17
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.enmu.WFEngineType;

/**
 * @ClassName: WorkflowBizImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 上午9:46:17
 *
 */
@org.springframework.stereotype.Service(value = "workflowActBpmBiz")
public class WorkflowActBpmBizImpl implements WorkflowBizI {

	@Resource(name = "runtimeService")
	private RuntimeService workflowRuntimeBiz;

	@Resource(name = "taskService")
	private TaskService workflowTaskBiz;

	@Resource(name = "historyService")
	private HistoryService workflowHistoryBiz;

	@Resource(name = "managementService")
	private ManagementService workflowManagementBiz;

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
				wfBizData = new WFBizData();
				wfBizData.setWfBizDataId(OABizUtil.generateThirtySixUUIDPK());// 数据主键
				wfBizData.setProcessInstanceId(newProcessInstance.getProcessInstanceId());// 流程实例ID
				wfBizData.setCreateDatetime(OABizUtil.getCurrentTimestamp());// 数据创建日期
				wfBizData.setUsableStatus("1");// 逻辑删除标识，1是否，0是被标记为逻辑删除
				wfBizData.setWfEngineType(WFEngineType.ACTIVITI518.name());// 流程引擎类型
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

}
