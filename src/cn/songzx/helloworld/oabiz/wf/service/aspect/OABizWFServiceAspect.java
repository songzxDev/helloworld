/**
* @Title: OABizWFServiceAspect.java
* @Package cn.songzx.helloworld.oabiz.wf.service.aspect
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月26日 上午10:37:16
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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

	/**
	 *
	 * @Date: 2017年10月26日下午2:42:23
	 * @Title: startKindMethodAround
	 * @Description: TODO(对启动流程实例方法进行环绕通知)
	 * @param pjp
	 * @return
	 * @return Object 返回值类型
	 */
	@Around(value = "execution(* cn.songzx.helloworld.oabiz.wf.service..*.startProcessInstance*(..))")
	public Object startKindMethodAround(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();// 方法名称
		Object[] args = pjp.getArgs();// 方法调用参数
		Object methodResult = null;// 方法调用后的返回值
		try {
			// before
			System.out.println("method:  " + methodName + "  begins");
			// AfterReturning
			methodResult = pjp.proceed(args);
			System.out.println("method:  " + methodName + "  return result:" + methodResult);
		} catch (Throwable e) {
			// AfterThrowing
			System.out.println("method:  " + methodName + "occurs exception:" + e);
		}
		// After
		System.out.println("method:  " + methodName + "  ends");
		return methodResult;
	}

}
