/**
* @Title: TestWorkflowBiz.java
* @Package cn.songzx.helloworld.workflow.biz.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午4:30:44
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.test;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.activiti.engine.ActivitiException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;
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
@ContextConfiguration(locations = { "classpath:/spring-lazy-wf.xml", "classpath:/spring-lazy-biz.xml" })
public class TestWorkflowBiz {

	@Resource(name = "workflowBizActBpm518")
	private WorkflowBizI workflowBiz;

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
				try {
					System.out.println("流程引擎Activiti518开始初始化！");
					System.out.println(DataSourceContextHolder.getCustomerType());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		int runnerCount = 10;
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

	/**
	 *
	 * @Date: 2017年10月23日下午7:18:43
	 * @Title: testInitDataSource
	 * @Description: TODO(初始化流程引擎)
	 * @return void 返回值类型
	 */
	@Test
	public void testInitDataSource() {
		try {
			System.out.println("流程引擎Activiti518开始初始化！");
		} catch (ActivitiException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 * @Date: 2017年10月23日下午7:18:29
	 * @Title: testDeployDiagramByZipFile
	 * @Description: TODO(发布流程)
	 * @return void 返回值类型
	 */
	@Test
	public void testDeployDiagramByZipFile() {
		try {
			File directory = new File("");// 参数为空
			String courseFile = directory.getCanonicalPath();
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★【" + courseFile + "】☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			String sourceFilePath = courseFile + "\\bpmn\\cn\\songzx\\helloworld\\oabiz\\bpmn\\HQ";
			String zipFilePath = courseFile + "\\bpmn\\cn\\songzx\\helloworld\\oabiz\\bpmn\\HQ";
			String fileName = "HQ_OABIZ_CONTRACT_AUDIT_V1.0";
			// OABizUtil.fileToZip(sourceFilePath, zipFilePath, fileName);
			String zipFileName = fileName + ".zip";
			workflowBiz.deployDiagramByZipFile(zipFilePath + "\\" + zipFileName, zipFileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
