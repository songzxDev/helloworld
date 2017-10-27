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
		DruidDataSource dataSource = OABizSpringContextUtil.getBean("wfActbpm518DBS", DruidDataSource.class);
		System.out.println("流程引擎数据源的对象json信息：\r\n");
		System.out.println(OABizUtil.getTargetObjectToString(dataSource));
	}
}
