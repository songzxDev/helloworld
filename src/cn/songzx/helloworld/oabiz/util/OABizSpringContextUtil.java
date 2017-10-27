/**
* @Title: OABizSpringContextUtil.java
* @Package cn.songzx.helloworld.oabiz.util
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月27日 下午2:24:30
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName: OABizSpringContextUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月27日 下午2:24:30
 *
 */
public class OABizSpringContextUtil implements ApplicationContextAware {

	private static ThreadLocal<ApplicationContext> APPCON_THREAD_LOCAL = new ThreadLocal<ApplicationContext>();

	public OABizSpringContextUtil() {
	}

	/**
	 * @Date: 2017年10月27日下午2:25:21
	 * @Title: setApplicationContext
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param applicationContext
	 * @throws BeansException
	 * @return 返回值类型
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (applicationContext == null) {
			throw new RuntimeException("ApplicationContext对象为空，请核实spring相关配置文件是否被加载！");
		}
		System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了set(new StringBuilder())方法！");
		APPCON_THREAD_LOCAL.set(applicationContext);
	}

	/**
	 *
	 * @Date: 2017年10月27日下午3:26:42
	 * @Title: getBean
	 * @Description: TODO(通过spring配置文件中bean名称获取目标对象)
	 * @param beanName
	 *            spring配置文件中注册的bean名称
	 * @param targetClazz
	 *            目标对象类型
	 * @return
	 * @throws BeansException
	 * @return T 返回值类型
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName, Class<T> targetClazz) throws BeansException, Exception {
		T t = targetClazz.newInstance();
		try {
			t = (T) APPCON_THREAD_LOCAL.get().getBean(beanName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			APPCON_THREAD_LOCAL.remove();
			System.out.println(Thread.currentThread().getName() + "--ThreadLocal<StringBuilder>执行了remove()方法！");
		}
		return t;
	}
}
