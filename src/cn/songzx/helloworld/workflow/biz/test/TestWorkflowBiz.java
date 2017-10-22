/**
* @Title: TestWorkflowBiz.java
* @Package cn.songzx.helloworld.workflow.biz.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��19�� ����4:30:44
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
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��19�� ����4:30:44
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
			System.out.println("������������������������������������������������������");
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
				// ��������
				try {
					// DataSourceContextHolder.setCustomerType("dataSourceActiviti522");
					workflowActBpmBiz.getTasksById("0ce8bcac-5c69-11e7-83a7-c85b76a3c17b");
					System.out.println("������������������������������������������������������");
					// DataSourceContextHolder.clearCustomerType();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		int runnerCount = 800;
		// Rnner���飬�뵱�ڲ������ٸ���
		TestRunnable[] trs = new TestRunnable[runnerCount];
		for (int i = 0; i < runnerCount; i++) {
			trs[i] = runner;
		}
		// ����ִ�ж��̲߳���������Runner����ǰ�涨��ĵ���Runner��ɵ����鴫��
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
		try {
			// ��������ִ�������ﶨ�������
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInitDataSource() {
		System.out.println("��������Activiti518��ʼ��ʼ����");
	}

}
