/**
* @Title: TestWorkflowBiz.java
* @Package cn.songzx.helloworld.workflow.biz.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午4:30:44
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @ClassName: TestWorkflowBiz
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午4:30:44
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-helloworld.xml" })
public class TestWorkflowBiz {

	private WorkflowBizI workflowActBpmBiz;

	public WorkflowBizI getWorkflowActBpmBiz() {
		return workflowActBpmBiz;
	}

	@Autowired
	public void setWorkflowActBpmBiz(WorkflowBizI workflowActBpmBiz) {
		this.workflowActBpmBiz = workflowActBpmBiz;
	}

	public void test() {
		try {
			// DataSourceContextHolder.setCustomerType("dataSourceActiviti522");
			workflowActBpmBiz.getTasksById("0ce8bcac-5c69-11e7-83a7-c85b76a3c17b");
			Thread.sleep(50000L);
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
			// DataSourceContextHolder.clearCustomerType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void multiTest() {
		TestRunnable runner = new TestRunnable() {
			@Override
			public void runTest() throws Throwable {
				// 测试内容
				try {
					// DataSourceContextHolder.setCustomerType("dataSourceActiviti522");
					workflowActBpmBiz.getTasksById("0ce8bcac-5c69-11e7-83a7-c85b76a3c17b");
					System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
					// DataSourceContextHolder.clearCustomerType();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		int runnerCount = 800;
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

	@Test
	public void testInitDataSource() {
		System.out.println("流程引擎Activiti518开始初始化！");
	}

}
