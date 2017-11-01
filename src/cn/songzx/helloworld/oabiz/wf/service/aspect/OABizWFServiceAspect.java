/**
* @Title: OABizWFServiceAspect.java
* @Package cn.songzx.helloworld.oabiz.wf.service.aspect
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月26日 上午10:37:16
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.oabiz.wf.service.OABizWFServiceI;

/**
 * @ClassName: OABizWFServiceAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月26日 上午10:37:16
 *
 */
@Aspect
@Component
public class OABizWFServiceAspect {

	@Resource(name = "oaBizWFService")
	private OABizWFServiceI oaBizWFService;

	/**
	 *
	 * @Date: 2017年10月30日下午5:58:02
	 * @Title: startKindMethodAfterReturning
	 * @Description: TODO(启动流程方法执行后的增强处理方法)
	 * @param newWFBizData
	 *            目标方法的返回值
	 * @return void 返回值类型
	 */
	@AfterReturning(returning = "newWFBizDataPM", pointcut = "execution(* cn.songzx.helloworld.oabiz.wf.service..*.startProcessInstance*(..))")
	public void startKindMethodAfterReturning(final WFBizDataPM newWFBizDataPM) {
		/*
		 * AfterReturning增强处理可以访问到方法的返回值，但它无法改变目标方法的返回值
		 */
		System.out.println("启动流程方法执行后的增强处理方法【startKindMethodAfterReturning(..)】开始执行了!");
		// TODO ......
		try {
			Thread.sleep(2000L);// 模拟提交审批后，业务模块根据相应的业务类型做相关操作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("启动流程方法执行后的增强处理方法【startKindMethodAfterReturning(..)】执行结束了!");

	}

}
