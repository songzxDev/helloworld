/**
* @Title: WFStepType.java
* @Package cn.songzx.helloworld.workflow.dao.enmu
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年11月1日 上午10:21:23
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.enmu;

/**
 * @ClassName: WFStepType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年11月1日 上午10:21:23
 *
 */
public enum WFStepType {
	GENERALSIGN("常规环节", 0), COUNTERSIGN("会签环节", 1), PARALLELSIGN("并签环节", 2);

	private String description;

	private int index;

	/**
	 * @Date: 2017年11月1日上午10:50:33
	 * @Title: WFStepType.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param description
	 * @param index
	 */
	private WFStepType(String description, int index) {
		this.description = description;
		this.index = index;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

}
