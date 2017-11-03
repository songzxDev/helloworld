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
			completeAuditRecord.setNextStepId((String) completeVariables.get("next_step_id"));
			completeAuditRecord.setNextStepName((String) completeVariables.get("next_step_name"));
			completeAuditRecord.setNextStepType((String) completeVariables.get("next_step_type"));
			completeAuditRecord.setNextApproverName((String) completeVariables.get("dynamic_participant_name"));
			completeAuditRecord.setNextApproverPartyid((String) completeVariables.get("dynamic_participant_partyid"));
			completeAuditRecord.setNextApproverCode((String) completeVariables.get("dynamic_participant_code"));
			targetObj.modifyWFAuditRecord(completeAuditRecord);
			/* ☆ ☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆ */
			completeVariables.put("sender_completed_datetime", completeWorkitem.getPerformerCompletedDatetime());
			completeVariables.put("sender_name", completeWorkitem.getPerformerName());
			completeVariables.put("sender_partyid", completeWorkitem.getPerformerPartyid());
			completeVariables.put("sender_code", completeWorkitem.getPerformerCode());
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
