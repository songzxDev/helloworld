/**
* @Title: WorkflowBizI.java
* @Package cn.songzx.helloworld.workflow.biz
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月19日 上午9:42:22
* @version V1.0
*/
package cn.songzx.helloworld.workflow.biz;

import java.util.Map;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;

/**
 * @ClassName: WorkflowBizI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月19日 上午9:42:22
 *
 */
public interface WorkflowBizI {

	/**
	 *
	 * @Date: 2017年10月23日上午9:39:27
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(启动一个新的流程实例)
	 * @param processDefinitionKey
	 *            流程定义的key值
	 * @param variables
	 *            流程实例公共变量
	 * @return
	 * @throws Exception
	 * @return WFBizData 返回一个新的流程实例
	 */
	public WFBizData startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception;

	/**
	 *
	 * @Date: 2017年10月23日上午9:33:44
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(根据工作项的主键获取工作项的信息)
	 * @param workitemId
	 *            工作项的主键
	 * @return
	 * @throws Exception
	 * @return WFWorkitem 工作项详细信息
	 */
	public WFWorkitem getWFWorkitemByPK(String workitemId) throws Exception;

	/**
	 *
	 * @Date: 2017年10月23日上午10:00:47
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(提交当前工作项，并返回新增的工作项)
	 * @param workitemId
	 *            当前工作项主键
	 * @param variables
	 *            流程实例公共变量
	 * @return
	 * @throws Exception
	 * @return WFWorkitem 返回值类型：新增的工作项
	 */
	public WFWorkitem completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception;

	/**
	 *
	 * @Date: 2017年10月23日下午6:13:47
	 * @Title: deployDiagramByZipFile
	 * @Description: TODO(通过zip文件部署流程图至流程引擎)
	 * @param zipFilePath
	 *            zip文件路径
	 * @param zipFileName
	 *            zip文件名称
	 * @return
	 * @throws Exception
	 * @return String 返回值类型
	 */
	public String deployDiagramByZipFile(String zipFilePath, String zipFileName) throws Exception;
}
