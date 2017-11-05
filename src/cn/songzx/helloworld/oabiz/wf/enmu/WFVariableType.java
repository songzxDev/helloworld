/**
* @Title: WFVariableType.java
* @Package cn.songzx.helloworld.oabiz.wf.enmu
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年11月3日 下午4:31:36
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.enmu;

/**
 * @ClassName: WFVariableType
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年11月3日 下午4:31:36
 *
 */
public enum WFVariableType {

	/** 当前参与者姓名 */
	current_participant_name("current_participant_name", "", "当前参与者姓名"),
	/** 当前参与者partyid */
	current_participant_partyid("current_participant_partyid", "", "当前参与者partyid"),
	/** 当前参与者code */
	current_participant_code("current_participant_code", "", "当前参与者code"),
	/** 当前参与者部门名称 */
	current_participant_dept_name("current_participant_dept_name", "", "当前参与者部门名称"),
	/** 当前参与者部门code */
	current_participant_dept_code("current_participant_dept_code", "", "当前参与者部门code"),
	/** 以前参与者姓名 */
	previous_participant_name("previous_participant_name", "", "以前参与者姓名"),
	/** 以前参与者partyid */
	previous_participant_partyid("previous_participant_partyid", "", "以前参与者partyid"),
	/** 以前参与者code */
	previous_participant_code("previous_participant_code", "", "以前参与者code"),
	/** 以前参与者部门名称 */
	previous_participant_dept_name("previous_participant_dept_name", "", "以前参与者部门名称"),
	/** 以前参与者部门code */
	previous_participant_dept_code("previous_participant_dept_code", "", "以前参与者部门code"),
	/** 业务单据主键 */
	business_bill_id("business_bill_id", "", "业务单据主键"),
	/** 业务单据名称 */
	business_bill_name("business_bill_name", "", "业务单据名称"),
	/** 业务单据编号 */
	business_bill_no("business_bill_no", "", "业务单据编号"),
	/** 业务单据类型id */
	business_bill_kind_id("business_bill_kind_id", "", "业务单据类型id"),
	/** 业务单据类型名称 */
	business_bill_kind_name("business_bill_kind_name", "", "业务单据类型名称"),
	/** 下一步执行环节id */
	next_step_id("next_step_id", "", "下一步执行环节id"),
	/** 下一步执行环节名称 */
	next_step_name("next_step_name", "", "下一步执行环节名称"),
	/** 当前审批人是否同意标识 */
	is_agreed("is_agreed", "", "当前审批人是否同意标识");

	private String key;
	private String name;
	private String intro;

	/**
	 * @Date: 2017年11月4日下午1:22:49
	 * @Title: WFVariableType.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	private WFVariableType() {
	}

	/**
	 * @Date: 2017年11月4日下午1:22:25
	 * @Title: WFVariableType.java
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param key
	 * @param name
	 * @param intro
	 */
	private WFVariableType(String key, String name, String intro) {
		this.key = key;
		this.name = name;
		this.intro = intro;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
