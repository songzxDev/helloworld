package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;

public interface WFBizDataMapper {
	int deleteByPrimaryKey(String wfBizDataId) throws SQLException, Exception;

	int insert(WFBizData record) throws SQLException, Exception;

	int insertSelective(WFBizData record) throws SQLException, Exception;

	WFBizData selectByPrimaryKey(String wfBizDataId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFBizData record) throws SQLException, Exception;

	int updateByPrimaryKey(WFBizData record) throws SQLException, Exception;
}