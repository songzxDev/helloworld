/**
* @Title: MyTest.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 上午10:50:35
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;

import cn.songzx.helloworld.oabiz.util.OABizSpringContextUtil;
import cn.songzx.helloworld.oabiz.util.OABizUtil;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

/**
 * @ClassName: MyTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 上午10:50:35
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-lazy-wf.xml", "classpath:/spring-lazy-biz.xml" })
public class MyTest {

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
					DruidDataSource dataSource = OABizSpringContextUtil.getBean("wfActbpm518DBS", DruidDataSource.class);
					System.out.println("流程引擎数据源的对象json信息：\r\n");
					System.out.println(OABizUtil.getTargetObjectToString(dataSource));
				} catch (BeansException e) {
					e.printStackTrace();
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

	@Test
	public void testGetBean() {
		try {
			DruidDataSource dataSource = OABizSpringContextUtil.getBean("wfActbpm518DBS", DruidDataSource.class);
			System.out.println("流程引擎数据源的对象json信息：\r\n");
			System.out.println(OABizUtil.getTargetObjectToString(dataSource));
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final String str = "孙悟空";
		Thread[] threadsA = new Thread[1];
		for (int i = 0; i < threadsA.length; i++) {
			threadsA[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(OABizUtil.generateNineteenUUIDPK());
					System.out.println(OABizUtil.getTargetObjectToString(str));
				}

			});
		}
		for (int i = 0; i < threadsA.length; i++) {
			threadsA[i].start();
		}

	}
}
