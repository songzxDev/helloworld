/**
* @Title: ActBpm518TaskListener.java
* @Package cn.songzx.helloworld.workflow.biz.listener
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月26日 下午3:48:34
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.listener;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @ClassName: ActBpm518TaskListener
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月26日 下午3:48:34
 *
 */
public class ActBpm518TaskListener implements TaskListener, Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -4410414867496922486L;

	/**
	 * @Date: 2017年10月26日下午3:48:34
	 * @Title: notify
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param delegateTask
	 * @return 返回值类型
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
	}

}
