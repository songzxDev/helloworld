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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
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
		int runnerCount = 2;
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
		variables.put("dynamic_participant_name", "李向东");
		variables.put("dynamic_participant_partyid", "1240100700000010624");
		variables.put("dynamic_participant_code", "1099100400000000001000010000100007000780000800005");
		variables.put("dynamic_participant_dept_name", "集团客户事业部-保险客户销售服务部");
		variables.put("dynamic_participant_dept_code", "10991004000000000010000100001000070007800008");
		variables.put("business_bill_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_name", "OA系统2017年光缆改造工程合同审计调整");
		variables.put("business_bill_no", "OA" + System.currentTimeMillis());
		variables.put("business_bill_kind_id", OABizUtil.generateNineteenUUIDPK());
		variables.put("business_bill_kind_name", "合同审计");
		String processDefinitionKey = "HQ_OABIZ_CONTRACT_AUDIT_V1.0";
		try {
			oaBizWFService.startProcessInstanceByKey(processDefinitionKey, variables);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonExecuteStatus.SUCCESS.name();
	}
}
