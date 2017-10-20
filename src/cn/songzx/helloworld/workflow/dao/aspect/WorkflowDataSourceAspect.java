/**
* @Title: DataSourceAspect.java
* @Package cn.songzx.helloworld.workflow.dao.aspect
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午5:14:23
* @version V1.0
*/
package cn.songzx.helloworld.workflow.dao.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;

/**
 * @ClassName: WorkflowDataSourceAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午5:14:23
 *
 */
@Component
public class WorkflowDataSourceAspect {

	public void setBpmDataSource(JoinPoint jp) {
		DataSourceContextHolder.setCustomerType("activitiDataSourceVXviii");
	}

	public void setBizDataSource(JoinPoint jp) {
		DataSourceContextHolder.setCustomerType("bizDataSource");
	}

}
