/**
* @Title: WorkflowBizI.java
* @Package cn.songzx.helloworld.workflow.biz
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:42:22
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz;

import java.util.List;

import cn.songzx.helloworld.workflow.pagemodel.WorkflowTask;

/**
 * @ClassName: WorkflowBizI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 上午9:42:22
 *
 */
public interface WorkflowBizI {

	/**
	 *
	 * @Date: 2017年10月19日上午9:54:01
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(根据流程定义的key启动流程实例)
	 * @param processKey
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public void startProcessInstanceByKey(String processDefinitionKey) throws Exception;

	/**
	 *
	 * @Date: 2017年10月19日上午10:00:44
	 * @Title: completeTask
	 * @Description: TODO(根据taskId提交待办事项)
	 * @param taskId
	 * @throws Exception
	 * @return void 返回值类型
	 */
	public void completeTask(String taskId) throws Exception;

	/**
	 *
	 * @Date: 2017年10月19日上午10:56:04
	 * @Title: getTasksById
	 * @Description: TODO(根据taskId获取待办事项列表)
	 * @param taskId
	 * @return
	 * @throws Exception
	 * @return List<WorkflowTask> 返回值类型
	 */
	public List<WorkflowTask> getTasksById(String taskId) throws Exception;
}
