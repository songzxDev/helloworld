/**
* @Title: WFPostProcessor.java
* @Package cn.songzx.helloworld.oabiz.util
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月24日 下午6:46:32
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName: WFPostProcessor
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月24日 下午6:46:32
 *
 */
public class WFPostProcessor implements BeanPostProcessor {

	/**
	 * @Date: 2017年10月24日下午6:46:32
	 * @Title: postProcessBeforeInitialization
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 * @return 返回值类型
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆对象【" + beanName + "】开始实例化！☆☆☆☆☆☆☆☆☆☆☆☆");
		return bean;
	}

	/**
	 * @Date: 2017年10月24日下午6:46:32
	 * @Title: postProcessAfterInitialization
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 * @return 返回值类型
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("★★★★★★★★★★★★对象【" + beanName + "】结束实例化！★★★★★★★★★★★★");
		return bean;
	}

}
