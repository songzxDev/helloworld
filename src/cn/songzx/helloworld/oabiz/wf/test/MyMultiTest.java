/**
* @Title: MyMultiTest.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月30日 下午6:57:45
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

/**
 * @ClassName: MyMultiTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月30日 下午6:57:45
 *
 */
public class MyMultiTest {
	public static void main(String[] args) {
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(new ArrayList<String>().get(0));
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "，当前线程的终止状态为：" + Thread.currentThread().isInterrupted());
					System.out.println("线程出异常了，但是我还在继续做我自己的事情！");
				}
			}

		}, "ThreadA");
		threadA.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(e.getMessage());
				System.out.println(t.getName());
				if (t.isInterrupted() == false) {
					t.interrupt();
				}
				System.out.println(t.isInterrupted());
			}

		});
		threadA.start();
	}
}
