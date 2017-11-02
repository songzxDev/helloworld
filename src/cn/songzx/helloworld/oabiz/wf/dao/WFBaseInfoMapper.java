package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import cn.songzx.helloworld.oabiz.wf.entity.WFBaseInfo;

public interface WFBaseInfoMapper {
	int deleteByPrimaryKey(String wfBaseInfo) throws SQLException, Exception;

	int insert(WFBaseInfo record) throws SQLException, Exception;

	int insertSelective(WFBaseInfo record) throws SQLException, Exception;

	WFBaseInfo selectByPrimaryKey(String wfBaseInfo) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFBaseInfo record) throws SQLException, Exception;

	int updateByPrimaryKey(WFBaseInfo record) throws SQLException, Exception;
}