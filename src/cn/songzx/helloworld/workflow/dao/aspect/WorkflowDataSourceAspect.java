/**
* @Title: DataSourceAspect.java
* @Package cn.songzx.helloworld.workflow.dao.aspect
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��19�� ����5:14:23
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
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��19�� ����5:14:23
 *
 */
@Order(0)
@Aspect
@Component
public class WorkflowDataSourceAspect {

	@Before("execution(* cn.songzx.helloworld.workflow.biz.*.*(..))")
	public void setBpmDataSource(JoinPoint jp) {
		System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "��ִ���ˣ�setCustomerType(String value)��������ָ̬��������Դ��");
		DataSourceContextHolder.setCustomerType(DynamicDataSourceLookupKey.BPM_DATASOURCE.getLookupKey());
	}

	@After("execution(* cn.songzx.helloworld.workflow.biz.*.*(..))")
	public void removeBpmDataSource(JoinPoint jp) {
		System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "��ִ���ˣ�clearCustomerType()���������������Դ��");
		DataSourceContextHolder.clearCustomerType();
	}

	@Before("execution(* cn.songzx.helloworld.oabiz.wf.service.*.*(..))")
	public void setBizDataSource(JoinPoint jp) {
		System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "��ִ���ˣ�setCustomerType(String value)��������ָ̬��������Դ��");
		DataSourceContextHolder.setCustomerType(DynamicDataSourceLookupKey.BIZ_DATASOURCE.getLookupKey());
	}

	@After("execution(* cn.songzx.helloworld.oabiz.wf.service.*.*(..))")
	public void removeBizDataSource(JoinPoint jp) {
		System.out.println("��ǰ�̡߳�" + Thread.currentThread().getName() + "��ִ���ˣ�clearCustomerType()���������������Դ��");
		DataSourceContextHolder.clearCustomerType();
	}

}
