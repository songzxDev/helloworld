package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFBaseInfo;

public interface WFBaseInfoMapper {
    int deleteByPrimaryKey(String wfBaseInfo);

    int insert(WFBaseInfo record);

    int insertSelective(WFBaseInfo record);

    WFBaseInfo selectByPrimaryKey(String wfBaseInfo);

    int updateByPrimaryKeySelective(WFBaseInfo record);

    int updateByPrimaryKey(WFBaseInfo record);
}