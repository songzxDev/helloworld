/**
* @Title: DynamicDataSourceLookupKey.java
* @Package cn.songzx.helloworld.workflow.dao.enmu
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月20日 下午2:10:16
* @version V1.0
*/
package cn.songzx.helloworld.workflow.dao.enmu;

/**
 * @ClassName: DynamicDataSourceLookupKey
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月20日 下午2:10:16
 *
 */
public enum DynamicDataSourceLookupKey {

	BPM_DATASOURCE("dataSourceActiviti518"), BIZ_DATASOURCE("dataSourceOABiz");

	private String lookupKey;

	/**
	 * @Date: 2017年10月20日下午2:29:30
	 * @Title: DynamicDataSourceLookupKey.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param lookupKey
	 */
	private DynamicDataSourceLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	/**
	 * @return the lookupKey
	 */
	public String getLookupKey() {
		return lookupKey;
	}

	/**
	 * @param lookupKey
	 *            the lookupKey to set
	 */
	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

}
