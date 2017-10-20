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
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.workflow.dao.enmu.DynamicDataSourceLookupKey;
import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;

/**
 * @ClassName: WorkflowDataSourceAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午5:14:23
 *
 */
@Order(0)
@Aspect
@Component
public class WorkflowDataSourceAspect {

	@Before("execution(* cn.songzx.helloworld.workflow.biz.*.*(..))")
	public void setBpmDataSource(JoinPoint jp) {
		System.out.println("当前线程【" + Thread.currentThread().getName() + "】执行了：setBpmDataSource(String value)方法，动态指定了数据源！");
		DataSourceContextHolder.setCustomerType(DynamicDataSourceLookupKey.BPM_DATASOURCE.getLookupKey());
	}

	@After("execution(* cn.songzx.helloworld.workflow.biz.*.*(..))")
	public void removeBpmDataSource(JoinPoint jp) {
		System.out.println("当前线程【" + Thread.currentThread().getName() + "】执行了：clearCustomerType()方法，清除了数据源！");
		DataSourceContextHolder.clearCustomerType();
	}

	public void setBizDataSource(JoinPoint jp) {
		DataSourceContextHolder.setCustomerType("dataSourceActiviti518");
	}

}
