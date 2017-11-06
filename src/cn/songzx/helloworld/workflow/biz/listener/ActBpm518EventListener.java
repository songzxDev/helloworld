package cn.songzx.helloworld.workflow.biz.listener;

import java.io.Serializable;

import javax.annotation.Resource;

import org.activiti.engine.EngineServices;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;
import cn.songzx.helloworld.oabiz.wf.service.OABizWFServiceI;
import cn.songzx.helloworld.workflow.biz.WorkflowBizI;

public class ActBpm518EventListener implements ActivitiEventListener, Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 8217370115363802174L;

	@Resource(name = "oaBizWFService")
	private OABizWFServiceI oaBizWFService;

	/**
	 * @Date: 2017年10月26日上午11:05:12
	 * @Title: onEvent
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param event
	 * @return 返回值类型
	 */
	@Override
	public void onEvent(ActivitiEvent event) {
		ActivitiEventType eventType = event.getType();// 流程引擎事件类型
		EngineServices engineServices = event.getEngineServices();// 包含流程引擎定义的对外提供的所有服务的接口方法
		/*
		 * execution 即流程执行线路，或者执行环境
		 *
		 * 当流程中没有分支时，Execution等同于ProcessInstance，甚至连ID也相同； 当流程中存在分支(fork,
		 * parallel gateway)，则在分支口会形成子Execution，在下一个gateway才会合并(joined)。
		 *
		 * execution其实就是分支的执行线。
		 * 有的文章说task与execution是一对一的关系，这个是不准确的，应该是execution和分支是一对一的关系，
		 * 有多少个分支就有多少个execution。
		 * 从数量上来说，task是始终小于等于execution，每个task总是对应一个execution，
		 * 而execution不一定对应一个task。
		 * 从级别上来说，execution相当于task的执行环境，execution是包含task的。
		 */
		String executionId = event.getExecutionId();// 流程实例的分支流程ID
		String processInstanceId = event.getProcessInstanceId();// 流程实例ID
		switch (eventType) {
		case TASK_CREATED:// 新增待办事项事件
			System.out.println("Activiti518流程引擎待办任务已创建完成！");
			break;
		case TASK_ASSIGNED:// 待办事项指派参与者事件
			System.out.println("Activiti518流程引擎待办任务参与者已指派！");
			break;
		case TASK_COMPLETED:// 待办事项提交事件
			System.out.println("Activiti518流程引擎待办任务已提交完成！");
			break;
		case PROCESS_STARTED:// 新增流程实例事件
			System.out.println("新流程实例：☆" + processInstanceId + "★创建了！");
			break;
		case PROCESS_COMPLETED:// 结束流程实例事件
			try {
				System.out.println("流程实例：☆" + processInstanceId + "★结束了！");
				WFBizData endWFBizData = oaBizWFService.getWFBizDataByProcInstId(processInstanceId);
				if (endWFBizData != null) {
					endWFBizData.setBizBillAuditStatus(WorkflowBizI.APPROVAL_COMPLETED);
					endWFBizData.setModifyDatetime(OABizUtil.getCurrentTimestamp());
					oaBizWFService.modifyWFBizData(endWFBizData);// 更新业务模块-流程实例业务单据关联信息表数据的审批状态为："通过审批"
					oaBizWFService.modifyBizBillInfoAfterProcInstEnd(endWFBizData);// 更新此流程实例关联的业务单据的相关数据
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

	/**
	 * @Date: 2017年10月26日上午11:05:12
	 * @Title: isFailOnException
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @return 返回值类型
	 */
	@Override
	public boolean isFailOnException() {
		return false;
	}

}
