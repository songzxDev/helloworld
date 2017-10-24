/**
* @Title: DynamicDataSource.java
* @Package cn.songzx.helloworld.workflow.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午4:54:06
* @version V1.0
*/
package cn.songzx.helloworld.workflow.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;

/**
 * @ClassName: DynamicDataSource
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午4:54:06
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * @Date: 2017年10月19日下午4:54:06
	 * @Title: determineCurrentLookupKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @return 返回值类型
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getCustomerType();
	}

	/**
	 * @Date: 2017年10月24日下午6:36:03
	 * @Title: afterPropertiesSet
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return 返回值类型
	 */
	@Override
	public void afterPropertiesSet() {
		System.out.println("");
		System.out.println("");
		System.out.println("类【DynamicDataSource】的afterPropertiesSet()方法被调用了！");
		System.out.println("");
		super.afterPropertiesSet();
	}

	public void init() {
		System.out.println("");
		System.out.println("");
		System.out.println("类【DynamicDataSource】的init()方法被调用了！");
		System.out.println("");
	}

	public void destroy() {
		System.out.println("");
		System.out.println("");
		System.out.println("类【DynamicDataSource】的destroy()方法被调用了！");
		System.out.println("");
	}

}
