/**
* @Title: OABizWFServiceAspect.java
* @Package cn.songzx.helloworld.oabiz.wf.service.aspect
* @Description: TODO(用一句话描述该文件做什么)
* @author Songzx songzx_2326@163.com
* @date 2017年10月26日 上午10:37:16
* @version V1.0
*/
package cn.songzx.helloworld.oabiz.wf.service.aspect;

import java.sql.SQLException;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.songzx.helloworld.oabiz.util.OABizUtil;
import cn.songzx.helloworld.oabiz.wf.enmu.WFVariableType;
import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;
import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;
import cn.songzx.helloworld.oabiz.wf.service.impl.OABizWFServiceImpl;

/**
 * @ClassName: OABizWFServiceAspect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Songzx songzx_2326@163.com
 * @date 2017年10月26日 上午10:37:16
 *
 */
@Aspect
@Component
public class OABizWFServiceAspect {

	@SuppressWarnings("unchecked")
	@Around("execution(* cn.songzx.helloworld.oabiz.wf.service.impl.OABizWFServiceImpl.completeWorkitem*(..))")
	public Object aroundCompleteWorkitemKindMethod(ProceedingJoinPoint pjp) {
		Object returnValue = null;
		// before
		OABizWFServiceImpl targetObj = (OABizWFServiceImpl) pjp.getTarget();
		Object[] args = pjp.getArgs();
		String targetMethodName = pjp.getSignature().getName();
		if (args == null || args.length < 2 || args[0] == null || args[1] == null) {
			throw new RuntimeException("执行目标方法【" + targetMethodName + "】(..)失败，参数传入不符合规范！");
		}
		String completeWorkitemId = (String) args[0];
		Map<String, Object> completeVariables = (Map<String, Object>) args[1];
		try {
			/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
			WFWorkitem completeWorkitem = targetObj.getWfWorkitemMapper().selectByPrimaryKey(completeWorkitemId);
			completeWorkitem.setReadStatus("1");
			completeWorkitem.setDoneStatus("1");
			completeWorkitem.setPerformerCompletedDatetime(OABizUtil.getCurrentTimestamp());
			completeWorkitem.setModifyDatetime(OABizUtil.getCurrentTimestamp());
			targetObj.modifyWFWorkitem(completeWorkitem);
			/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
			WFAuditRecord completeAuditRecord = targetObj.getWfAuditRecordMapper().selectByWorkitemId(completeWorkitem.getProcessInstanceId(), completeWorkitem.getWfWorkitemId());
			completeAuditRecord.setCurrentApproverAuditTime(OABizUtil.getCurrentTimestamp());
			completeAuditRecord.setModifyDatetime(OABizUtil.getCurrentTimestamp());
			completeAuditRecord.setNextStepId((String) completeVariables.get(WFVariableType.next_step_id.getKey()));
			completeAuditRecord.setNextStepName((String) completeVariables.get(WFVariableType.next_step_name.getKey()));
			completeAuditRecord.setNextStepType((String) completeVariables.get(WFVariableType.next_step_type.getKey()));
			completeAuditRecord.setNextApproverName((String) completeVariables.get(WFVariableType.current_participant_name.getKey()));
			completeAuditRecord.setNextApproverPartyid((String) completeVariables.get(WFVariableType.current_participant_partyid.getKey()));
			completeAuditRecord.setNextApproverCode((String) completeVariables.get(WFVariableType.current_participant_code.getKey()));
			targetObj.modifyWFAuditRecord(completeAuditRecord);
			/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
			completeVariables.put(WFVariableType.previous_participant_completed_datetime.getKey(), completeWorkitem.getPerformerCompletedDatetime());
			completeVariables.put(WFVariableType.previous_participant_name.getKey(), completeWorkitem.getPerformerName());
			completeVariables.put(WFVariableType.previous_participant_partyid.getKey(), completeWorkitem.getPerformerPartyid());
			completeVariables.put(WFVariableType.previous_participant_code.getKey(), completeWorkitem.getPerformerCode());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			args[0] = completeWorkitemId;
			args[1] = completeVariables;
			returnValue = pjp.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
