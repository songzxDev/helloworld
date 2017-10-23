/**
* @Title: OABizWFServiceImpl.java
* @Package cn.songzx.helloworld.oabiz.wf.service.impl
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��23�� ����9:44:21
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.songzx.helloworld.oabiz.wf.dao.WFAuditRecordMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFBizDataMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFWorkitemMapper;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFWorkitemPM;
import cn.songzx.helloworld.oabiz.wf.service.OABizWFServiceI;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;

/**
 * @ClassName: OABizWFServiceImpl
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��23�� ����9:44:21
 *
 */
@org.springframework.stereotype.Service("oaBizWFService")
public class OABizWFServiceImpl implements OABizWFServiceI {

	private WFBizDataMapper wfBizDataMapper;

	private WFWorkitemMapper wfWorkitemMapper;

	private WFAuditRecordMapper wfAuditRecordMapper;

	/**
	 * ��������������ͷ����仯�������޸������ǩ�е�nameֵ
	 */
	@Resource(name = "workflowActBpmBiz")
	private WorkflowBizI workflowBiz;

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

	/**
	 * @Date: 2017��10��23������10:03:25
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(������һ�仰�����������������)
	 * @param processDefinitionKey
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFBizDataPM startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception {
		WFBizDataPM newWFBizDataPM = new WFBizDataPM();
		// step1.�������������������һ������ʵ��
		WFBizData newWFBizData = workflowBiz.startProcessInstanceByKey(processDefinitionKey, variables);
		// step2.������������ʵ������ͬ����ҵ��ϵͳ������ҵ�������Ϣ���У����ӹ�ǰ��ҳ��չʾ����Ҫ��PageModel
		if (newWFBizData != null) {
			try {
				wfBizDataMapper.insertSelective(newWFBizData);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// ��������쳣��ҲҪ��֤ҳ��������ʾ���쳣�ɺ�̨���д���
				org.springframework.beans.BeanUtils.copyProperties(newWFBizData, newWFBizDataPM);
				// TODO �ӹ�PageModel......................
				Thread.sleep(50L);// ģ��ӹ���������Ҫ����ʵ��ҵ���߼���д
			}
		}
		return newWFBizDataPM;
	}

	/**
	 * @Date: 2017��10��23������10:03:25
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(������һ�仰�����������������)
	 * @param workitemId
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFWorkitemPM getWFWorkitemByPK(String workitemId) throws Exception {
		WFWorkitemPM wfWorkitemPM = new WFWorkitemPM();
		return wfWorkitemPM;
	}

	/**
	 * @Date: 2017��10��23������10:03:25
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(������һ�仰�����������������)
	 * @param workitemId
	 * @param variables
	 * @return
	 * @throws Exception
	 * @return ����ֵ����
	 */
	@Override
	public WFWorkitemPM completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception {
		WFWorkitemPM newWFWorkitemPM = new WFWorkitemPM();
		return newWFWorkitemPM;
	}

}
