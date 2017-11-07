/**
* @Title: MyTestA.java
* @Package cn.songzx.helloworld.oabiz.wf.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年11月7日 上午11:20:57
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.test;

import java.util.concurrent.Exchanger;

/**
 * @ClassName: MyTestA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年11月7日 上午11:20:57
 *
 */
public class MyTestA {

	/**
	 * @Date: 2017年11月7日上午11:20:57
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 * @return void 返回值类型
	 */
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();

		MyThreadA threadA = new MyThreadA(exchanger);
		threadA.setName("MyThreadA");
		threadA.start();

		MyThreadB threadB = new MyThreadB(exchanger);
		threadB.setName("MyThreadB");
		threadB.start();
	}

	private static class MyThreadA extends Thread {
		private Exchanger<String> exchanger;

		/**
		 * @Date: 2017年11月7日上午11:23:07
		 * @Title: MyTestA.java
		 * @Description: TODO(这里用一句话描述这个方法的作用)
		 * @param exchanger
		 */
		public MyThreadA(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}

		public void run() {
			System.out.println("堵车了！");
			try {
				Thread.sleep(3000L);
				System.out.println(Thread.currentThread().getName());
				exchanger.exchange("true");
				System.out.println(Thread.currentThread().getName() + "越过堵车区域");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private static class MyThreadB extends Thread {
		private Exchanger<String> exchanger;

		/**
		 * @Date: 2017年11月7日上午11:23:07
		 * @Title: MyTestA.java
		 * @Description: TODO(这里用一句话描述这个方法的作用)
		 * @param exchanger
		 */
		public MyThreadB(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}

		public void run() {
			System.out.println("堵车了！");
			try {
				Thread.sleep(8000L);
				System.out.println(Thread.currentThread().getName());
				if (exchanger.exchange("").equals("true")) {
					System.out.println(Thread.currentThread().getName() + "收到！");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
