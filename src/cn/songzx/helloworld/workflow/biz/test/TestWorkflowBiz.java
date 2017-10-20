/**
* @Title: TestWorkflowBiz.java
* @Package cn.songzx.helloworld.workflow.biz.test
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 下午4:30:44
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.songzx.helloworld.workflow.biz.WorkflowBizI;
import cn.songzx.helloworld.workflow.dao.holder.DataSourceContextHolder;

/**
 * @ClassName: TestWorkflowBiz
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 下午4:30:44
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-activiti518.xml" })
public class TestWorkflowBiz {

	private WorkflowBizI workflowActBpmBiz;

	public WorkflowBizI getWorkflowActBpmBiz() {
		return workflowActBpmBiz;
	}

	@Autowired
	public void setWorkflowActBpmBiz(WorkflowBizI workflowActBpmBiz) {
		this.workflowActBpmBiz = workflowActBpmBiz;
	}

	@Test
	public void test() {
		try {
			DataSourceContextHolder.setCustomerType("dataSourceActiviti518");
			workflowActBpmBiz.getTasksById(UUID.randomUUID().toString());
			DataSourceContextHolder.clearCustomerType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
