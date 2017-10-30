/**
* @Title: OABizWFServiceImpl.java
* @Package cn.songzx.helloworld.oabiz.wf.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 上午9:44:21
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.dao.WFAuditRecordMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFBizDataMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFWorkitemMapper;
import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFAuditRecordPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFWorkitemPM;
import cn.songzx.helloworld.oabiz.wf.service.OABizWFServiceI;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;

/**
 * @ClassName: OABizWFServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 上午9:44:21
 *
 */
@org.springframework.stereotype.Service("oaBizWFService")
@org.springframework.context.annotation.Lazy(value = true)
public class OABizWFServiceImpl implements OABizWFServiceI {

	/**
	 * 流程引擎相关的持久层接口，和业务系统不是同一个数据源
	 *
	 * 如果流程引擎类型发生变化，仅需修改下面标签中的name值
	 */
	@Resource(name = "workflowBizActBpm518")
	private WorkflowBizI workflowBiz;

	/**
	 * 业务系统：流程系统和业务系统关联信息表持久层接口
	 */
	private WFBizDataMapper wfBizDataMapper;

	/**
	 * 业务系统：流程工作项信息表持久层接口
	 */
	private WFWorkitemMapper wfWorkitemMapper;

	/**
	 * 业务系统：流程审批记录信息表持久层接口
	 */
	private WFAuditRecordMapper wfAuditRecordMapper;

	// ☆☆☆☆☆☆☆☆☆☆【开始属性注入】☆☆☆☆☆☆☆☆☆☆
	public WFBizDataMapper getWfBizDataMapper() {
		return wfBizDataMapper;
	}

	@Autowired
	public void setWfBizDataMapper(WFBizDataMapper wfBizDataMapper) {
		this.wfBizDataMapper = wfBizDataMapper;
	}

	public WFWorkitemMapper getWfWorkitemMapper() {
		return wfWorkitemMapper;
	}

	@Autowired
	public void setWfWorkitemMapper(WFWorkitemMapper wfWorkitemMapper) {
		this.wfWorkitemMapper = wfWorkitemMapper;
	}

	public WFAuditRecordMapper getWfAuditRecordMapper() {
		return wfAuditRecordMapper;
	}

	@Autowired
	public void setWfAuditRecordMapper(WFAuditRecordMapper wfAuditRecordMapper) {
		this.wfAuditRecordMapper = wfAuditRecordMapper;
	}
	// ★★★★★★★★★★【结束属性注入】★★★★★★★★★★

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
	@Override
	public WFBizDataPM startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception {
		WFBizDataPM newWFBizDataPM = new WFBizDataPM();
		// step1.调用流程引擎服务新增一个流程实例
		WFBizData newWFBizData = workflowBiz.startProcessInstanceByKey(processDefinitionKey, variables);
		// step2.将新增的流程实例数据同步到业务系统的流程业务关联信息表中，并加工前端页面展示所需要的PageModel
		if (newWFBizData != null) {
			try {
				wfBizDataMapper.insertSelective(newWFBizData);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 如果出现异常，也要保证页面正常显示，异常由后台进行处理
				OABizUtil.copyProperties(newWFBizData, newWFBizDataPM);
				// TODO 加工PageModel......................
				Thread.sleep(50L);// 模拟加工，后续需要根据实际业务逻辑编写
			}
		}
		return newWFBizDataPM;
	}

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
	@Override
	public WFWorkitemPM getWFWorkitemByPK(String workitemId) throws Exception {
		WFWorkitemPM wfWorkitemPM = new WFWorkitemPM();
		return wfWorkitemPM;
	}

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
	@Override
	public WFWorkitemPM completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception {
		WFWorkitemPM newWFWorkitemPM = new WFWorkitemPM();
		return newWFWorkitemPM;
	}

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
	@Override
	public WFWorkitemPM addWFWorkitem(WFWorkitem wfWorkitem) throws Exception {
		WFWorkitemPM wfWorkitemPM = null;
		if (wfWorkitem != null) {
			wfWorkitemMapper.insertSelective(wfWorkitem);
			wfWorkitemPM = new WFWorkitemPM();
			OABizUtil.copyProperties(wfWorkitem, wfWorkitemPM);
		}
		return wfWorkitemPM;
	}

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
	@Override
	public WFAuditRecordPM addWFAuditRecord(WFAuditRecord wfAuditRecord) throws Exception {
		WFAuditRecordPM wfAuditRecordPM = null;
		if (wfAuditRecord != null) {
			wfAuditRecordMapper.insertSelective(wfAuditRecord);
			wfAuditRecordPM = new WFAuditRecordPM();
			OABizUtil.copyProperties(wfAuditRecord, wfAuditRecordPM);
		}
		return wfAuditRecordPM;
	}

}
