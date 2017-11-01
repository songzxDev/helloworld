drop index WF_AUDIT_RECORD_INDEX1 on WF_AUDIT_RECORD;

drop table if exists WF_AUDIT_RECORD;

/*==============================================================*/
/* Table: WF_AUDIT_RECORD                                       */
/*==============================================================*/
create table WF_AUDIT_RECORD
(
   WF_AUDIT_RECORD_ID   varchar(40) not null,
   PROCESS_INSTANCE_ID  varchar(40) not null,
   PROCESS_NAME         varchar(300) not null,
   CURRENT_STEP_ID      varchar(40) not null,
   CURRENT_WORKITEM_ID  varchar(40) not null,
   CURRENT_STEP_NAME    varchar(100) not null,
   CURRENT_STEP_TYPE    varchar(30) not null,
   CURRENT_APPROVER_NAME varchar(100) not null,
   CURRENT_APPROVER_PARTYID varchar(100) not null,
   CURRENT_APPROVER_CODE varchar(200) not null,
   CURRENT_APPROVER_DEPT_NAME varchar(300) not null,
   CURRENT_APPROVER_DEPT_CODE varchar(500) not null,
   CURRENT_APPROVER_AUDIT_TIME timestamp,
   CURRENT_APPROVER_AUDIT_IDEA varchar(500),
   NEXT_STEP_ID         varchar(40),
   NEXT_STEP_NAME       varchar(100),
   NEXT_STEP_TYPE       varchar(30),
   NEXT_APPROVER_NAME   varchar(100),
   NEXT_APPROVER_PARTYID varchar(100),
   NEXT_APPROVER_CODE   varchar(300),
   WF_AUTHORIZE_TYPE    varchar(30),
   WF_AUTHORIZE_NAME    varchar(100),
   WF_AUTHORIZE_PARTYID varchar(100),
   WF_AUTHORIZE_CODE    varchar(300),
   USABLE_STATUS        char(1) not null default '1',
   CREATE_DATETIME      timestamp not null default CURRENT_TIMESTAMP,
   MODIFY_DATETIME      timestamp,
   RESERVED_ATTRIBUTE_1 varchar(500),
   RESERVED_ATTRIBUTE_2 varchar(500),
   RESERVED_ATTRIBUTE_3 varchar(500),
   RESERVED_ATTRIBUTE_4 varchar(500),
   RESERVED_ATTRIBUTE_5 varchar(500),
   primary key (WF_AUDIT_RECORD_ID)
);

/*==============================================================*/
/* Index: WF_AUDIT_RECORD_INDEX1                                */
/*==============================================================*/
create index WF_AUDIT_RECORD_INDEX1 on WF_AUDIT_RECORD
(
   PROCESS_INSTANCE_ID,
   CURRENT_STEP_ID,
   CURRENT_APPROVER_NAME,
   CURRENT_APPROVER_PARTYID,
   CURRENT_APPROVER_AUDIT_TIME,
   NEXT_STEP_ID,
   NEXT_APPROVER_NAME,
   NEXT_APPROVER_PARTYID
);
