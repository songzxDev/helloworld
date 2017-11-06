package cn.songzx.helloworld.oabiz.wf.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;

public interface WFBizDataMapper {
	int deleteByPrimaryKey(String wfBizDataId) throws SQLException, Exception;

	int insert(WFBizData record) throws SQLException, Exception;

	int insertSelective(WFBizData record) throws SQLException, Exception;

	WFBizData selectByPrimaryKey(String wfBizDataId) throws SQLException, Exception;

	int updateByPrimaryKeySelective(WFBizData record) throws SQLException, Exception;

	int updateByPrimaryKey(WFBizData record) throws SQLException, Exception;

	@Select("SELECT * FROM WF_BIZ_DATA WHERE USABLE_STATUS='1' AND PROCESS_INSTANCE_ID=#{procInstId}")
	@ResultMap("cn.songzx.helloworld.oabiz.wf.dao.WFBizDataMapper.BaseResultMap")
	WFBizData selectByProcInstId(@Param("procInstId") String procInstId) throws SQLException, Exception;
}