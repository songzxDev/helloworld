package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFBizData;

public interface WFBizDataMapper {
    int deleteByPrimaryKey(String wfBizDataId);

    int insert(WFBizData record);

    int insertSelective(WFBizData record);

    WFBizData selectByPrimaryKey(String wfBizDataId);

    int updateByPrimaryKeySelective(WFBizData record);

    int updateByPrimaryKey(WFBizData record);
}