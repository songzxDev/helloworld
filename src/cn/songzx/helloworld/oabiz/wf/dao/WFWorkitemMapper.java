package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;

public interface WFWorkitemMapper {
	int deleteByPrimaryKey(String wfWorkitemId) throws SQLException, Exception;

	int insert(WFWorkitem record) throws SQLException, Exception;

	int insertSelective(WFWorkitem record) throws SQLException, Exception;

	WFWorkitem selectByPrimaryKey(String wfWorkitemId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFWorkitem record) throws SQLException, Exception;

	int updateByPrimaryKey(WFWorkitem record) throws SQLException, Exception;
}