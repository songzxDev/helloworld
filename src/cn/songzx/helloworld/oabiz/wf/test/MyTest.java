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
import com.alibaba.fastjson.JSON;

import cn.songzx.helloworld.oabiz.util.OABizSpringContextUtil;
import cn.songzx.helloworld.oabiz.util.OABizUtil;

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
