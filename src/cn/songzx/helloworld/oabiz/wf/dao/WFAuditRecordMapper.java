package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;

public interface WFAuditRecordMapper {
	int deleteByPrimaryKey(String wfAuditRecordId) throws SQLException, Exception;

	int insert(WFAuditRecord record) throws SQLException, Exception;

	int insertSelective(WFAuditRecord record) throws SQLException, Exception;

	WFAuditRecord selectByPrimaryKey(String wfAuditRecordId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFAuditRecord record) throws SQLException, Exception;

	int updateByPrimaryKey(WFAuditRecord record) throws SQLException, Exception;

	@Select(value = "SELECT * FROM WF_AUDIT_RECORD WHERE PROCESS_INSTANCE_ID=#{procInstId} AND CURRENT_WORKITEM_ID=#{workitemId} AND USABLE_STATUS='1'")
	@ResultMap(value="cn.songzx.helloworld.oabiz.wf.dao.WFAuditRecordMapper.BaseResultMap")
	WFAuditRecord selectByWorkitemId(@Param("procInstId") String procInstId, @Param("workitemId") String workitemId) throws SQLException, Exception;
}