package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFWorkitem;

public interface WFWorkitemMapper {
    int deleteByPrimaryKey(String wfWorkitemId);

    int insert(WFWorkitem record);

    int insertSelective(WFWorkitem record);

    WFWorkitem selectByPrimaryKey(String wfWorkitemId);

    int updateByPrimaryKeySelective(WFWorkitem record);

    int updateByPrimaryKey(WFWorkitem record);
}