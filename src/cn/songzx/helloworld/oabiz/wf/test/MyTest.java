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

/**
 * @ClassName: MyTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月23日 上午10:50:35
 *
 */
public class MyTest {

	public static void main(String[] args) throws Exception {

		List<String> list = new ArrayList<String>();
		list.add("孙悟空");
		try {
			System.out.println(list.get(0));
		} catch (Exception e) {
			throw new Exception("出异常了：\r\n" + e.getMessage());
		} finally {
			System.out.println("都他妈的出异常了，咋还他妈的让我执行呢！");
		}
		System.out.println("他妈的终于运行正常了，喝酒庆祝一下！");
	}

}
