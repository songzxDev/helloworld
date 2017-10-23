/**
* @Title: WorkflowBizImpl.java
* @Package cn.songzx.helloworld.workflow.biz.impl
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��19�� ����9:46:17
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;

/**
 * @ClassName: WorkflowBizImpl
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��19�� ����9:46:17
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
	 * @Date: 2017��10��23������10:21:07
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(������һ�仰�����������������)
	 * @param processDefinitionKey
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFBizData startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Date: 2017��10��23������10:21:07
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(������һ�仰�����������������)
	 * @param workitemId
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFWorkitem getWFWorkitemByPK(String workitemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Date: 2017��10��23������10:21:07
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(������һ�仰�����������������)
	 * @param workitemId
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFWorkitem completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
