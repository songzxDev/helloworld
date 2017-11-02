package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;

public interface WFAuditRecordMapper {
	int deleteByPrimaryKey(String wfAuditRecordId) throws SQLException, Exception;

	int insert(WFAuditRecord record) throws SQLException, Exception;

	int insertSelective(WFAuditRecord record) throws SQLException, Exception;

	WFAuditRecord selectByPrimaryKey(String wfAuditRecordId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFAuditRecord record) throws SQLException, Exception;

	int updateByPrimaryKey(WFAuditRecord record) throws SQLException, Exception;
}