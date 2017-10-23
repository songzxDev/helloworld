/**
* @Title: OABizWFServiceI.java
* @Package cn.songzx.helloworld.oabiz.wf.service
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author Songzx songzx_2326@163.com
* @date 2017��10��23�� ����9:22:07
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service;

import java.util.Map;

import cn.songzx.helloworld.oabiz.wf.pagemodel.WFBizDataPM;
import cn.songzx.helloworld.oabiz.wf.pagemodel.WFWorkitemPM;

/**
 * @ClassName: OABizWFServiceI
 * @Description: TODO(������һ�仰��������������)
 * @author Songzx songzx_2326@163.com
 * @date 2017��10��23�� ����9:22:07
 *
 */
public interface OABizWFServiceI {

	/**
	 *
	 * @Date: 2017��10��23������9:39:27
	 * @Title: startProcessInstanceByKey
	 * @Description: TODO(����һ���µ�����ʵ��)
	 * @param processDefinitionKey
	 *            ���̶����keyֵ
	 * @param variables
	 *            ����ʵ����������
	 * @return
	 * @throws Exception
	 * @return WFBizDataPM ����һ���µ�����ʵ��
	 */
	public WFBizDataPM startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) throws Exception;

	/**
	 *
	 * @Date: 2017��10��23������9:33:44
	 * @Title: getWFWorkitemByPK
	 * @Description: TODO(���ݹ������������ȡ���������Ϣ)
	 * @param workitemId
	 *            �����������
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM ��������ϸ��Ϣ
	 */
	public WFWorkitemPM getWFWorkitemByPK(String workitemId) throws Exception;

	/**
	 *
	 * @Date: 2017��10��23������10:00:47
	 * @Title: completeWorkitemByPK
	 * @Description: TODO(�ύ��ǰ����������������Ĺ�����)
	 * @param workitemId
	 *            ��ǰ����������
	 * @param variables
	 *            ����ʵ����������
	 * @return
	 * @throws Exception
	 * @return WFWorkitemPM ����ֵ���ͣ������Ĺ�����
	 */
	public WFWorkitemPM completeWorkitemByPK(String workitemId, Map<String, Object> variables) throws Exception;

}
