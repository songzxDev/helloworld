/**
* @Title: WorkflowBizImpl.java
* @Package cn.songzx.helloworld.workflow.biz.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:46:17
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;
import cn.songzx.helloworld.workflow.pagemodel.WorkflowTask;

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
	 *
	 * @Date: 2017年10月19日上午9:54:01
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(根据流程定义的key启动流程实例)
	 * @param processKey
	 * @throws Exception
	 * @return void 返回值类型
	 */
	@Override
	public void startProcessInstanceByKey(String processDefinitionKey) throws Exception {
		try {
			workflowRuntimeBiz.startProcessInstanceByKey(processDefinitionKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @Date: 2017年10月19日上午10:00:44
	 * @Title: completeTask
	 * @Description: TODO(根据taskId提交待办事项)
	 * @param taskId
	 * @throws Exception
	 * @return void 返回值类型
	 */
	@Override
	public void completeTask(String taskId) throws Exception {
		try {
			workflowTaskBiz.complete(taskId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Date: 2017年10月19日上午10:14:34
	 * @Title: getTasksById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param taskId
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public List<WorkflowTask> getTasksById(String taskId) throws Exception {
		List<WorkflowTask> list = new ArrayList<WorkflowTask>();
		try {
			String querySql = "SELECT * FROM " + workflowManagementBiz.getTableName(Task.class) + " WHERE ID_=#{taskId}";
			List<Task> tasks = workflowTaskBiz.createNativeTaskQuery().sql(querySql).parameter("taskId", taskId).list();
			if (tasks != null && tasks.size() == 1) {
				// 将Activiti流程引擎的待办信息转换成WorkflowTask对象
				// TODO ................................
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
