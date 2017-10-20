/**
* @Title: WorkflowHistoryBizI.java
* @Package cn.songzx.helloworld.workflow.biz
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:37:25
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricDetailQuery;
import org.activiti.engine.history.HistoricIdentityLink;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.history.HistoricVariableInstanceQuery;
import org.activiti.engine.history.NativeHistoricActivityInstanceQuery;
import org.activiti.engine.history.NativeHistoricDetailQuery;
import org.activiti.engine.history.NativeHistoricProcessInstanceQuery;
import org.activiti.engine.history.NativeHistoricTaskInstanceQuery;
import org.activiti.engine.history.NativeHistoricVariableInstanceQuery;
import org.activiti.engine.history.ProcessInstanceHistoryLog;
import org.activiti.engine.history.ProcessInstanceHistoryLogQuery;
import org.activiti.engine.task.IdentityLink;

/**
 * @ClassName: WorkflowHistoryBizI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 上午9:37:25
 *
 */
public interface WorkflowHistoryBizI {
	/**
	 * Creates a new programmatic query to search for
	 * {@link HistoricProcessInstance}s.
	 */
	HistoricProcessInstanceQuery createHistoricProcessInstanceQuery();

	/**
	 * Creates a new programmatic query to search for
	 * {@link HistoricActivityInstance}s.
	 */
	HistoricActivityInstanceQuery createHistoricActivityInstanceQuery();

	/**
	 * Creates a new programmatic query to search for
	 * {@link HistoricTaskInstance}s.
	 */
	HistoricTaskInstanceQuery createHistoricTaskInstanceQuery();

	/**
	 * Creates a new programmatic query to search for {@link HistoricDetail}s.
	 */
	HistoricDetailQuery createHistoricDetailQuery();

	/**
	 * Returns a new {@link org.activiti.engine.query.NativeQuery} for process
	 * definitions.
	 */
	NativeHistoricDetailQuery createNativeHistoricDetailQuery();

	/**
	 * Creates a new programmatic query to search for
	 * {@link HistoricVariableInstance}s.
	 */
	HistoricVariableInstanceQuery createHistoricVariableInstanceQuery();

	/**
	 * Returns a new {@link org.activiti.engine.query.NativeQuery} for process
	 * definitions.
	 */
	NativeHistoricVariableInstanceQuery createNativeHistoricVariableInstanceQuery();

	/**
	 * Deletes historic task instance. This might be useful for tasks that are
	 * {@link TaskService#newTask() dynamically created} and then
	 * {@link TaskService#complete(String) completed}. If the historic task
	 * instance doesn't exist, no exception is thrown and the method returns
	 * normal.
	 */
	void deleteHistoricTaskInstance(String taskId);

	/**
	 * Deletes historic process instance. All historic activities, historic task
	 * and historic details (variable updates, form properties) are deleted as
	 * well.
	 */
	void deleteHistoricProcessInstance(String processInstanceId);

	/**
	 * creates a native query to search for {@link HistoricProcessInstance}s via
	 * SQL
	 */
	NativeHistoricProcessInstanceQuery createNativeHistoricProcessInstanceQuery();

	/**
	 * creates a native query to search for {@link HistoricTaskInstance}s via
	 * SQL
	 */
	NativeHistoricTaskInstanceQuery createNativeHistoricTaskInstanceQuery();

	/**
	 * creates a native query to search for {@link HistoricActivityInstance}s
	 * via SQL
	 */
	NativeHistoricActivityInstanceQuery createNativeHistoricActivityInstanceQuery();

	/**
	 * Retrieves the {@link HistoricIdentityLink}s associated with the given
	 * task. Such an {@link IdentityLink} informs how a certain identity (eg.
	 * group or user) is associated with a certain task (eg. as candidate,
	 * assignee, etc.), even if the task is completed as opposed to
	 * {@link IdentityLink}s which only exist for active tasks.
	 */
	List<HistoricIdentityLink> getHistoricIdentityLinksForTask(String taskId);

	/**
	 * Retrieves the {@link HistoricIdentityLink}s associated with the given
	 * process instance. Such an {@link IdentityLink} informs how a certain
	 * identity (eg. group or user) is associated with a certain process
	 * instance, even if the instance is completed as opposed to
	 * {@link IdentityLink}s which only exist for active instances.
	 */
	List<HistoricIdentityLink> getHistoricIdentityLinksForProcessInstance(String processInstanceId);

	/**
	 * Allows to retrieve the {@link ProcessInstanceHistoryLog} for one process
	 * instance.
	 */
	ProcessInstanceHistoryLogQuery createProcessInstanceHistoryLogQuery(String processInstanceId);
}
