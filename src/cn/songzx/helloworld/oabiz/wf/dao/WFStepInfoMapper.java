package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFStepInfo;

public interface WFStepInfoMapper {
    int deleteByPrimaryKey(String wfStepInfoId);

    int insert(WFStepInfo record);

    int insertSelective(WFStepInfo record);

    WFStepInfo selectByPrimaryKey(String wfStepInfoId);

    int updateByPrimaryKeySelective(WFStepInfo record);

    int updateByPrimaryKey(WFStepInfo record);
}