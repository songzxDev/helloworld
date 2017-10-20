/**
* @Title: DataSourceContextHolder.java
* @Package cn.songzx.helloworld.workflow.dao.holder
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午4:56:03
* @version V1.0
*/
package cn.songzx.helloworld.workflow.dao.holder;

/**
 * @ClassName: DataSourceContextHolder
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午4:56:03
 *
 */
public class DataSourceContextHolder {
	/**
	 * 注意：数据源标识保存在线程变量中，避免多线程操作数据源时互相干扰
	 */
	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		CONTEXT_HOLDER.set(customerType);
	}

	public static String getCustomerType() {
		return CONTEXT_HOLDER.get();
	}

	public static void clearCustomerType() {
		CONTEXT_HOLDER.remove();
	}
}
