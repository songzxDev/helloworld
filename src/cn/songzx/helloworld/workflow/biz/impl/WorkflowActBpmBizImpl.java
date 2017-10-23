/**
* @Title: WorkflowBizImpl.java
* @Package cn.songzx.helloworld.workflow.biz.impl
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��19�� ����9:46:17
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
import cn.songzx.helloworld.workflow.pagemodel.WorkflowTask;

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
	 *
	 * @Date: 2017��10��19������9:54:01
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(�������̶����key��������ʵ��)
	 * @param processKey
	 * @throws Exception
	 * @return void ����ֵ����
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
	 * @Date: 2017��10��19������10:00:44
	 * @Title: completeTask
	 * @Description: TODO(����taskId�ύ��������)
	 * @param taskId
	 * @throws Exception
	 * @return void ����ֵ����
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
	 * @Date: 2017��10��19������10:14:34
	 * @Title: getTasksById
	 * @Description: TODO(������һ�仰�����������������)
	 * @param taskId
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public List<WorkflowTask> getTasksById(String taskId) throws Exception {
		List<WorkflowTask> list = new ArrayList<WorkflowTask>();
		try {
			String querySql = "SELECT * FROM " + workflowManagementBiz.getTableName(Task.class) + " WHERE ID_=#{taskId}";
			List<Task> tasks = workflowTaskBiz.createNativeTaskQuery().sql(querySql).parameter("taskId", taskId).list();
			if (tasks != null && tasks.size() == 1) {
				// ��Activiti��������Ĵ�����Ϣת����WorkflowTask����
				// TODO ................................
				for (int i = 0; i < 100; i++) {
					System.out.print("��");
				}
				System.out.println("��ϲ�����������ҵ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
