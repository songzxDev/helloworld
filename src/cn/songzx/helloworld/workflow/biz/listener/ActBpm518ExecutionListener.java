/**
* @Title: ActBpm518ExecutionListener.java
* @Package cn.songzx.helloworld.workflow.biz.listener
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年11月6日 上午10:18:32
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * @ClassName: ActBpm518ExecutionListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年11月6日 上午10:18:32
 *
 */
public class ActBpm518ExecutionListener implements ExecutionListener {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -6660322812161431408L;

	/**
	 * @Date: 2017年11月6日上午10:18:32
	 * @Title: notify
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param execution
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		if (execution.getEventName().equals(EVENTNAME_END)) {
			// FIXME ......
			Thread.sleep(5000L);// 模拟流程实例结束后，业务模块一些后续执行操作
			System.out.println("流程实例：☆" + execution.getProcessInstanceId() + "★结束了！");
		}
	}

}
