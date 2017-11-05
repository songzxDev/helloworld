/**
* @Title: TestOABizWFService.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 下午8:21:30
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.dao.WFAuditRecordMapper;
import cn.songzx.helloworld.oabiz.wf.dao.WFBpmnConfigVarRefMapper;
import cn.songzx.helloworld.oabiz.wf.enmu.WFEngineType;
import cn.songzx.helloworld.oabiz.wf.enmu.WFVariableType;
import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;
import cn.songzx.helloworld.oabiz.wf.entity.WFBpmnConfigVarRef;
import cn.songzx.helloworld.oabiz.wf.service.OABizWFServiceI;
import cn.songzx.helloworld.workflow.dao.enmu.CommonExecuteStatus;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @ClassName: TestOABizWFService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 下午8:21:30
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-lazy-wf.xml", "classpath:/spring-lazy-biz.xml" })
public class TestOABizWFService {
	@Resource(name = "oaBizWFService")
	private OABizWFServiceI oaBizWFService;

	private WFAuditRecordMapper wfAuditRecordMapper;

	private WFBpmnConfigVarRefMapper wfBpmnConfigVarRefMapper;

	public WFAuditRecordMapper getWfAuditRecordMapper() {
		return wfAuditRecordMapper;
	}

	@Autowired
	public void setWfAuditRecordMapper(WFAuditRecordMapper wfAuditRecordMapper) {
		this.wfAuditRecordMapper = wfAuditRecordMapper;
	}

	public WFBpmnConfigVarRefMapper getWfBpmnConfigVarRefMapper() {
		return wfBpmnConfigVarRefMapper;
	}

	@Autowired
	public void setWfBpmnConfigVarRefMapper(WFBpmnConfigVarRefMapper wfBpmnConfigVarRefMapper) {
		this.wfBpmnConfigVarRefMapper = wfBpmnConfigVarRefMapper;
	}

	@Test
	public void testSelectByWorkitemId() {
		try {
			WFAuditRecord wfAuditRecord = wfAuditRecordMapper.selectByWorkitemId("03b7715a-bf72-11e7-8e22-c85b76a3c17b", "03e22af4-bf72-11e7-8e22-c85b76a3c17b");
			System.out.println("测试呢！");
			System.out.println(JSON.toJSONStringWithDateFormat(wfAuditRecord, "yyyy-MM-dd HH:mm:ss.SSS"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @Date: 2017年10月23日下午7:19:04
	 * @Title: multiTest
	 * @Description: TODO(多线程测试)
	 * @return void 返回值类型
	 */
	@Test
	public void multiTest() {
		TestRunnable runner = new TestRunnable() {
			@Override
			public void runTest() throws Throwable {
				// 测试内容
				teststartProcessInstanceByKey();
				System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆【" + Thread.currentThread().getName() + "】★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			}
		};
		int runnerCount = 1;
		// Rnner数组，想当于并发多少个。
		TestRunnable[] trs = new TestRunnable[runnerCount];
		for (int i = 0; i < runnerCount; i++) {
			trs[i] = runner;
		}
		// 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		try {
			// 开发并发执行数组里定义的内容
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private Serializable teststartProcessInstanceByKey() {
		Map<String, Object> variables = new LinkedHashMap<String, Object>();
		variables.put("dynamic_participant_name", "肖飞雪");
		variables.put("dynamic_participant_partyid", OABizUtil.generateNineteenUUIDPK());
		variables.put("dynamic_participant_code", OABizUtil.generateNineteenUUIDPK() + "_" + OABizUtil.generateThirtySixUUIDPK());
		variables.put("dynamic_participant_dept_name", "集团产品外包部");
		variables.put("dynamic_participant_dept_code", "10991004000000000010000100001000070007800008");
		variables.put("business_bill_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_name", "事假申请-北京回龙观新区光缆改造项目组员工-肖飞雪");
		variables.put("business_bill_no", "OA" + System.currentTimeMillis());
		variables.put("business_bill_kind_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_kind_name", "请假单");
		String processDefinitionKey = "HQ_OABIZ_LEAVE_AUDIT_V1.0";
		try {
			oaBizWFService.startProcessInstanceByKey(processDefinitionKey, variables);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonExecuteStatus.SUCCESS.name();
	}

	@Test
	public void testCompleteWorkitemByPK() {
		Map<String, Object> variables = new LinkedHashMap<String, Object>();
		variables.put("dynamic_participant_name", "肖飞雪");
		variables.put("dynamic_participant_partyid", OABizUtil.generateNineteenUUIDPK());
		variables.put("dynamic_participant_code", OABizUtil.generateNineteenUUIDPK() + "_" + OABizUtil.generateThirtySixUUIDPK());
		variables.put("dynamic_participant_dept_name", "集团产品外包部");
		variables.put("dynamic_participant_dept_code", "10991004000000000010000100001000070007800008");
		variables.put("business_bill_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_name", "事假申请-北京回龙观新区光缆改造项目组员工-肖飞雪");
		variables.put("business_bill_no", "OA" + System.currentTimeMillis());
		variables.put("business_bill_kind_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_kind_name", "请假单");
		variables.put("is_agreed", true);
		try {
			oaBizWFService.completeWorkitemByPK("6ff31e9e-c1fd-11e7-8c08-c85b76a3c17b", variables);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initWFBpmnConfigVarRef() {
		WFBpmnConfigVarRef ref = new WFBpmnConfigVarRef();
		for (WFVariableType enumValue : WFVariableType.values()) {
			ref.setWfBpmnConfigVarRefId(OABizUtil.generateThirtySixUUIDPK());
			ref.setBpmnVariableKey(enumValue.getKey());
			ref.setBpmnVariableName("");
			ref.setBpmnVariableIntro(enumValue.getIntro());
			ref.setUsableStatus("1");
			ref.setCreateDatetime(OABizUtil.getCurrentTimestamp());
			ref.setBpmnEngineType(WFEngineType.ACTIVITI518.name());
			wfBpmnConfigVarRefMapper.insertSelective(ref);
		}
	}

	public static void main(String[] args) {
		for (WFVariableType element : WFVariableType.values()) {
			System.out.println(element);
		}
	}
}
