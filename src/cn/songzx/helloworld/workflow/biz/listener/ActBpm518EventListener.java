package cn.songzx.helloworld.workflow.biz.listener;

import java.io.Serializable;

import org.activiti.engine.EngineServices;
import org.activiti.engine.ManagementService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.task.Task;

public class ActBpm518EventListener implements ActivitiEventListener, Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 8217370115363802174L;

	/**
	 * @Date: 2017年10月26日上午11:05:12
	 * @Title: onEvent
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param event
	 * @return 返回值类型
	 */
	@Override
	public void onEvent(ActivitiEvent event) {
		ActivitiEventType eventType = event.getType();// 流程引擎事件类型
		EngineServices engineServices = event.getEngineServices();// 包含流程引擎定义的对外提供的所有服务的接口方法
		/*
		 * execution 即流程执行线路，或者执行环境
		 *
		 * 当流程中没有分支时，Execution等同于ProcessInstance，甚至连ID也相同； 当流程中存在分支(fork,
		 * parallel gateway)，则在分支口会形成子Execution，在下一个gateway才会合并(joined)。
		 *
		 * execution其实就是分支的执行线。
		 * 有的文章说task与execution是一对一的关系，这个是不准确的，应该是execution和分支是一对一的关系，
		 * 有多少个分支就有多少个execution。
		 * 从数量上来说，task是始终小于等于execution，每个task总是对应一个execution，
		 * 而execution不一定对应一个task。
		 * 从级别上来说，execution相当于task的执行环境，execution是包含task的。
		 */
		String executionId = event.getExecutionId();// 流程实例的分支流程ID
		String processInstanceId = event.getProcessInstanceId();// 流程实例ID
		switch (eventType) {
		case TASK_CREATED:
			try {
				TaskService taskService = engineServices.getTaskService();
				ManagementService managementService = engineServices.getManagementService();
				if (taskService != null) {
					String queryTaskSql = "SELECT * FROM " + managementService.getTableName(Task.class) + " WHERE PROC_INST_ID_=#{processInstanceId}";
					Task currentTask = taskService.createNativeTaskQuery().sql(queryTaskSql).parameter("processInstanceId", processInstanceId).singleResult();
					System.out.println();
					StringBuilder stbu = new StringBuilder("Activiti518流程引擎流程新创建了一个待办任务！\r\n");
					if (currentTask != null) {
						stbu.append("流程实例ID: " + processInstanceId + "\r\n");
						stbu.append("新增待办ID: " + currentTask.getId() + "\r\n");
						stbu.append("当前处理环节ID: " + currentTask.getTaskDefinitionKey() + ", 当前处理环节名称: " + currentTask.getName() + "\r\n");
					}
					System.out.println(stbu.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case TASK_ASSIGNED:
			System.out.println("Activiti518流程引擎待办任务已指派了参与者！");
			break;
		case TASK_COMPLETED:
			System.out.println("Activiti518流程引擎待办任务已提交完成！");
			break;
		case PROCESS_COMPLETED:
			// FIXME ......
			try {
				System.out.println("流程实例：☆" + processInstanceId + "★结束了！");
				System.out.println("流程实例：☆" + processInstanceId + "★结束了，开始执行业务模块相关后续操作！");
				Thread.sleep(5000L);// 模拟流程实例结束后，业务模块一些后续执行操作
				System.out.println("已结束的流程实例：☆" + processInstanceId + "★对应的业务单据后续操作执行完成！");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	/**
	 * @Date: 2017年10月26日上午11:05:12
	 * @Title: isFailOnException
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @return 返回值类型
	 */
	@Override
	public boolean isFailOnException() {
		// TODO Auto-generated method stub
		return false;
	}

}
