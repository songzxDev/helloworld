package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFBpmnConfigVarRef;

public interface WFBpmnConfigVarRefMapper {
    int deleteByPrimaryKey(String wfBpmnConfigVarRefId);

    int insert(WFBpmnConfigVarRef record);

    int insertSelective(WFBpmnConfigVarRef record);

    WFBpmnConfigVarRef selectByPrimaryKey(String wfBpmnConfigVarRefId);

    int updateByPrimaryKeySelective(WFBpmnConfigVarRef record);

    int updateByPrimaryKey(WFBpmnConfigVarRef record);
}