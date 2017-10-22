package cn.songzx.helloworld.oabiz.wf.dao;

import cn.songzx.helloworld.oabiz.wf.entity.WFAuditRecord;

public interface WFAuditRecordMapper {
    int deleteByPrimaryKey(String wfAuditRecordId);

    int insert(WFAuditRecord record);

    int insertSelective(WFAuditRecord record);

    WFAuditRecord selectByPrimaryKey(String wfAuditRecordId);

    int updateByPrimaryKeySelective(WFAuditRecord record);

    int updateByPrimaryKey(WFAuditRecord record);
}