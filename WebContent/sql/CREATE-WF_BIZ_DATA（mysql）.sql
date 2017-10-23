drop index WF_BIZ_DATA_INDEX_1 on WF_BIZ_DATA;

drop table if exists WF_BIZ_DATA;

/*==============================================================*/
/* Table: WF_BIZ_DATA                                           */
/*==============================================================*/
create table WF_BIZ_DATA
(
   WF_BIZ_DATA_ID       varchar(40) not null,
   BIZ_BILL_ID          varchar(40) not null,
   BIZ_BILL_AUDIT_STATUS char(3) not null,
   BIZ_BILL_NO          varchar(100) not null,
   BIZ_BILL_NAME        varchar(200) not null,
   BIZ_BILL_KIND_ID     varchar(40) not null,
   BIZ_BILL_KIND_NAME   varchar(100) not null,
   PROCESS_INSTANCE_ID  varchar(40) not null,
   PROCESS_DEFINITION_KEY varchar(300) not null,
   PROCESS_DEFINITION_NAME varchar(300) not null,
   BIZ_BILL_EDITOR_NAME varchar(100) not null,
   BIZ_BILL_EDITOR_PARTYID varchar(100) not null,
   BIZ_BILL_EDITOR_CODE varchar(200) not null,
   BIZ_BILL_EDITOR_DEPT_NAME varchar(500) not null,
   BIZ_BILL_EDITOR_DEPT_CODE varchar(500) not null,
   USABLE_STATUS        char(1) not null default '1',
   CREATE_DATETIME      timestamp not null default CURRENT_TIMESTAMP,
   MODIFY_DATETIME      timestamp,
   WF_ENGINE_TYPE       varchar(40) not null,
   RESERVED_ATTRIBUTE_1 varchar(500),
   RESERVED_ATTRIBUTE_2 varchar(500),
   RESERVED_ATTRIBUTE_3 varchar(500),
   RESERVED_ATTRIBUTE_4 varchar(500),
   RESERVED_ATTRIBUTE_5 varchar(500),
   primary key (WF_BIZ_DATA_ID)
);

/*==============================================================*/
/* Index: WF_BIZ_DATA_INDEX_1                                   */
/*==============================================================*/
create index WF_BIZ_DATA_INDEX_1 on WF_BIZ_DATA
(
   BIZ_BILL_ID,
   BIZ_BILL_NO,
   PROCESS_INSTANCE_ID
);
