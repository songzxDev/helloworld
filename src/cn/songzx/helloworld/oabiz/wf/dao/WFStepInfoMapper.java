package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import cn.songzx.helloworld.oabiz.wf.entity.WFStepInfo;

public interface WFStepInfoMapper {
	int deleteByPrimaryKey(String wfStepInfoId) throws SQLException, Exception;

	int insert(WFStepInfo record) throws SQLException, Exception;

	int insertSelective(WFStepInfo record) throws SQLException, Exception;

	WFStepInfo selectByPrimaryKey(String wfStepInfoId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFStepInfo record) throws SQLException, Exception;

	int updateByPrimaryKey(WFStepInfo record) throws SQLException, Exception;
}