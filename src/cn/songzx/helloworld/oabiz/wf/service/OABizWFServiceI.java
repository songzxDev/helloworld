/**
* @Title: OABizWFServiceI.java
* @Package cn.songzx.helloworld.oabiz.wf.service
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 上午9:22:07
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service;

import java.util.Map;

import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFAuditRecordPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFWorkitemPM;

/**
 * @ClassName: OABizWFServiceI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 上午9:22:07
 *
 */
public interface OABizWFServiceI {

	/**
	 *
	 * @Date: 2017年10月23日上午9:39:27
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(启动一个新的流程实例)
	 * @param processDefinitionKey
	 *            流程定义的key值
	 * @param variables
	 *            流程实例公共变量
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM 返回一个新的流程实例
	 */
	public WFBizDataPM startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception;

	/**
	 *
	 * @Date: 2017年10月23日上午9:33:44
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(根据工作项的主键获取工作项的信息)
	 * @param workitemId
	 *            工作项的主键
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM 工作项详细信息
	 */
	public WFWorkitemPM getWFWorkitemByPK(String workitemId) throws Exception;

	/**
	 *
	 * @Date: 2017年11月6日上午11:21:55
	 * @Title: getWFBizDataByProcInstId
	 * @Description: TODO(根据流程实例ID获取业务模块和流程实例信息关联信息数据)
	 * @param procInstId
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM 返回值类型
	 */
	public WFBizDataPM getWFBizDataByProcInstId(String procInstId) throws Exception;

	/**
	 *
	 * @Date: 2017年10月23日上午10:00:47
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(提交当前工作项，并返回新增的工作项)
	 * @param workitemId
	 *            当前工作项主键
	 * @param variables
	 *            流程实例公共变量
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM 返回值类型：新增的工作项
	 */
	public WFWorkitemPM completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception;

	/**
	 *
	 * @Date: 2017年11月3日下午12:33:12
	 * @Title: addWFBizData
	 * @Description: TODO(新增业务模块和流程模块关联信息)
	 * @param wfBizData
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM 返回值类型
	 */
	public WFBizDataPM addWFBizData(WFBizData wfBizData) throws Exception;

	/**
	 *
	 * @Date: 2017年10月30日下午6:33:13
	 * @Title: addWFWorkitem
	 * @Description: TODO(新增工作项信息)
	 * @param wfWorkitem
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM 返回值类型
	 */
	public WFWorkitemPM addWFWorkitem(WFWorkitem wfWorkitem) throws Exception;

	/**
	 *
	 * @Date: 2017年10月30日下午6:33:19
	 * @Title: addWFAuditRecord
	 * @Description: TODO(新增审批记录信息)
	 * @param wfAuditRecord
	 * @return
	 * @throws Exception
	 * @return WFAuditRecordPM 返回值类型
	 */
	public WFAuditRecordPM addWFAuditRecord(WFAuditRecord wfAuditRecord) throws Exception;

	/**
	 *
	 * @Date: 2017年11月3日上午11:56:28
	 * @Title: modifyWFWorkitem
	 * @Description: TODO(更新工作项的相关信息)
	 * @param wfWorkitem
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM 返回值类型
	 */
	public WFWorkitemPM modifyWFWorkitem(WFWorkitem wfWorkitem) throws Exception;

	/**
	 *
	 * @Date: 2017年11月3日上午11:56:33
	 * @Title: modifyWFAuditRecord
	 * @Description: TODO(更新审批记录的相关信息)
	 * @param wfAuditRecord
	 * @return
	 * @throws Exception
	 * @return WFAuditRecordPM 返回值类型
	 */
	public WFAuditRecordPM modifyWFAuditRecord(WFAuditRecord wfAuditRecord) throws Exception;

	/**
	 *
	 * @Date: 2017年11月3日下午12:33:02
	 * @Title: modifyWFBizData
	 * @Description: TODO(更新业务模块和流程模块关联信息)
	 * @param wfBizData
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM 返回值类型
	 */
	public WFBizDataPM modifyWFBizData(WFBizData wfBizData) throws Exception;

	/**
	 *
	 * @Date: 2017年11月6日上午11:14:59
	 * @Title: modifyBizBillInfoAfterProcInstEnd
	 * @Description: TODO(流程实例结束后更新关联的业务单据相关信息)
	 * @param wfBizData
	 *            业务单据和流程实例关联信息表
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM 返回值类型
	 */
	public WFBizDataPM modifyBizBillInfoAfterProcInstEnd(WFBizData wfBizData) throws Exception;
}
