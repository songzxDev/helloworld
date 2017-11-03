/**
* @Title: OABizWFServiceImpl.java
* @Package cn.songzx.helloworld.oabiz.wf.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 上午9:44:21
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.dao.WFAuditRecordMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFBaseInfoMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFBizDataMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFStepInfoMapper;
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

	/**
	 * 业务系统：流程基本信息表
	 */
	private WFBaseInfoMapper wfBaseInfoMapper;

	/**
	 * 业务系统：流程环节信息表
	 */
	private WFStepInfoMapper wfStepInfoMapper;

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

	public WFBaseInfoMapper getWfBaseInfoMapper() {
		return wfBaseInfoMapper;
	}

	@Autowired
	public void setWfBaseInfoMapper(WFBaseInfoMapper wfBaseInfoMapper) {
		this.wfBaseInfoMapper = wfBaseInfoMapper;
	}

	public WFStepInfoMapper getWfStepInfoMapper() {
		return wfStepInfoMapper;
	}

	@Autowired
	public void setWfStepInfoMapper(WFStepInfoMapper wfStepInfoMapper) {
		this.wfStepInfoMapper = wfStepInfoMapper;
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
			newWFBizDataPM = addWFBizData(newWFBizData);
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
		// step1.调用流程引擎服务接口提交当前工作项并返回一个新的工作项信息
		WFWorkitem newWFWorkitem = workflowBiz.completeWorkitemByPK(workitemId, variables);
		// step2.将新工作项信息和新工作项信息关联的审批记录信息新增至数据表中
		if (newWFWorkitem != null && newWFWorkitem.getOwnWFAuditRecord() != null) {
			addWFWorkitem(newWFWorkitem);
			addWFAuditRecord(newWFWorkitem.getOwnWFAuditRecord());
		}
		// step3.返回前端页面展示所需要的PageModel
		OABizUtil.copyProperties(newWFWorkitem, newWFWorkitemPM);
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

	/**
	 * @Date: 2017年11月3日上午11:57:03
	 * @Title: modifyWFWorkitem
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param wfWorkitem
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFWorkitemPM modifyWFWorkitem(WFWorkitem wfWorkitem) throws Exception {
		WFWorkitemPM wfWorkitemPM = null;
		if (wfWorkitem != null) {
			wfWorkitemMapper.updateByPrimaryKey(wfWorkitem);
			wfWorkitemPM = new WFWorkitemPM();
			OABizUtil.copyProperties(wfWorkitem, wfWorkitemPM);
		}
		return wfWorkitemPM;
	}

	/**
	 * @Date: 2017年11月3日上午11:57:03
	 * @Title: modifyWFAuditRecord
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param wfAuditRecord
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFAuditRecordPM modifyWFAuditRecord(WFAuditRecord wfAuditRecord) throws Exception {
		WFAuditRecordPM wfAuditRecordPM = null;
		if (wfAuditRecord != null) {
			wfAuditRecordMapper.updateByPrimaryKey(wfAuditRecord);
			wfAuditRecordPM = new WFAuditRecordPM();
			OABizUtil.copyProperties(wfAuditRecord, wfAuditRecordPM);
		}
		return wfAuditRecordPM;
	}

	/**
	 * @Date: 2017年11月3日下午12:33:48
	 * @Title: addWFBizData
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param wfBizData
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFBizDataPM addWFBizData(WFBizData wfBizData) throws Exception {
		WFBizDataPM newWFBizDataPM = new WFBizDataPM();
		List<WFWorkitemPM> newWFWorkitemsPM = new ArrayList<WFWorkitemPM>();
		List<WFAuditRecordPM> newWFAuditRecordsPM = new ArrayList<WFAuditRecordPM>();
		try {
			wfBizDataMapper.insertSelective(wfBizData);// 新增业务模块和流程实例关联信息
			List<WFWorkitem> newWFWorkitems = wfBizData.getWfWorkitems();
			if (newWFWorkitems != null && newWFWorkitems.size() == 1) {// 启动流程成功后，当前流程实例新增的工作项数目只能是一个
				addWFWorkitem(newWFWorkitems.get(0));// 新增当前流程实例的工作项信息
				OABizUtil.copyProperties(newWFWorkitems, newWFWorkitemsPM, WFWorkitemPM.class);
			}
			List<WFAuditRecord> newWFAuditRecords = wfBizData.getWfAuditRecords();
			if (newWFAuditRecords != null && newWFAuditRecords.size() == 2) {// 启动流程成功后，当前流程实例新增的审批记录数目为两个
				for (WFAuditRecord wfAuditRecord : newWFAuditRecords) {
					addWFAuditRecord(wfAuditRecord);// 新增当前流程实例的审批记录信息
				}
				OABizUtil.copyProperties(newWFAuditRecords, newWFAuditRecordsPM, WFAuditRecordPM.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 如果出现异常，也要保证页面正常显示，异常由后台进行处理
			OABizUtil.copyProperties(wfBizData, newWFBizDataPM);
			newWFBizDataPM.setWfWorkitemsPM(newWFWorkitemsPM);
			newWFBizDataPM.setWfAuditRecordsPM(newWFAuditRecordsPM);
		}
		return newWFBizDataPM;
	}

	/**
	 * @Date: 2017年11月3日下午12:33:48
	 * @Title: modifyWFBizData
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param wfBizData
	 * @return
	 * @throws Exception
	 * @return 返回值类型
	 */
	@Override
	public WFBizDataPM modifyWFBizData(WFBizData wfBizData) throws Exception {
		return null;
	}

}
