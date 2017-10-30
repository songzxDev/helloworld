/**
* @Title: MyTest.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月23日 上午10:50:35
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;

import cn.songzx.helloworld.oabiz.util.OABizSpringContextUtil;
import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.workflow.dao.enmu.CommonExecuteStatus;
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
					testMethodB();
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	private void testMethodB() {
		FutureTask<String> futureTaskA = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName() + "开始执行！" + System.currentTimeMillis());
				Thread.sleep(5000L);
				System.out.println(Thread.currentThread().getName() + "执行完了！" + System.currentTimeMillis());
				return CommonExecuteStatus.SUCCESS.name();
			}
		});
		FutureTask<String> futureTaskB = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName() + "开始执行！" + System.currentTimeMillis());
				Thread.sleep(11000L);
				System.out.println(Thread.currentThread().getName() + "执行完了！" + System.currentTimeMillis());
				return CommonExecuteStatus.FAILURE.name();
			}
		});
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		long startTime = System.currentTimeMillis();
		executorService.submit(futureTaskA);
		executorService.submit(futureTaskB);
		try {
			String flagA = futureTaskA.get();
			String flagB = futureTaskB.get();
			System.out.println(flagA + "☆★☆★☆★☆★☆★☆★" + flagB);
			long endTime = System.currentTimeMillis();
			System.out.println("程序执行了：" + ((endTime - startTime) / 1000) + "秒！");
			System.out.println(executorService.isShutdown());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			if (executorService.isShutdown() == false) {
				executorService.shutdown();
			}
		}

	}

	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTaskA = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				String flag = CommonExecuteStatus.SUCCESS.name();
				try {
					System.out.println(Thread.currentThread().getName() + "开始执行！" + System.currentTimeMillis());
					Thread.sleep(5000L);
					System.out.println(new ArrayList<String>().get(0));
					System.out.println(Thread.currentThread().getName() + "执行完了！" + System.currentTimeMillis());
				} catch (Exception e) {
					System.out.println(Thread.currentThread().getName() + "出现异常了！\r\n" + e.getMessage());
					Thread.currentThread().interrupt();
					System.out.println(Thread.currentThread().getName() + "被【interrupt】了！");
					flag = CommonExecuteStatus.FAILURE.name();
				}
				return flag;
			}

		});
		FutureTask<String> futureTaskB = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				String flag = CommonExecuteStatus.SUCCESS.name();
				try {
					System.out.println(Thread.currentThread().getName() + "开始执行！" + System.currentTimeMillis());
					Thread.sleep(11000L);
					System.out.println(Thread.currentThread().getName() + "执行完了！" + System.currentTimeMillis());
				} catch (Exception e) {
					System.out.println(Thread.currentThread().getName() + "出现异常了！\r\n" + e.getMessage());
					Thread.currentThread().interrupt();
					flag = CommonExecuteStatus.FAILURE.name();
				}
				return flag;
			}
		});

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		long startTime = System.currentTimeMillis();
		executorService.submit(futureTaskA);
		executorService.submit(futureTaskB);
		String flagA = "☆";
		String flagB = "★";
		if (futureTaskA.isDone()) {
			flagA += futureTaskA.get();
			System.out.println("futureTaskA☆★☆★☆★☆★☆★☆★" + flagA);
		}
		if (futureTaskB.isDone()) {
			flagB += futureTaskB.get();
			System.out.println("futureTaskB☆★☆★☆★☆★☆★☆★" + flagB);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序执行了：" + ((endTime - startTime) / 1000) + "秒！");
		System.out.println(executorService.isShutdown());
		executorService.shutdown();
		System.out.println("调度器已释放资源！");
	}

	@Test
	public void testMethodC() {
		WFBizData wfBizData = new WFBizData();
		wfBizData.setWfBizDataId(OABizUtil.generateThirtySixUUIDPK());
		List<WFBizData> sources = new ArrayList<WFBizData>();
		sources.add(wfBizData);
		List<WFBizDataPM> targets = new ArrayList<WFBizDataPM>();
		OABizUtil.copyProperties(sources, targets, WFBizDataPM.class);
		if (targets != null && targets.size() > 0) {
			for (WFBizDataPM wfBizDataPM : targets) {
				System.out.println("◇" + wfBizDataPM.getWfBizDataId());
			}
		}
	}

}
