/**
* @Title: DynamicDataSourceLookupKey.java
* @Package cn.songzx.helloworld.workflow.dao.enmu
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��20�� ����2:10:16
* @version V1.0
*/
package cn.songzx.helloworld.workflow.dao.enmu;

/**
 * @ClassName: DynamicDataSourceLookupKey
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��20�� ����2:10:16
 *
 */
public enum DynamicDataSourceLookupKey {

	BPM_DATASOURCE("dataSourceActiviti518"), BIZ_DATASOURCE("dataSourceOABiz");

	private String lookupKey;

	/**
	 * @Date: 2017��10��20������2:29:30
	 * @Title: DynamicDataSourceLookupKey.java
	 * @Description: TODO(������һ�仰�����������������)
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
