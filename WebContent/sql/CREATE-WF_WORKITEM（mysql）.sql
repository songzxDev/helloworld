drop index WF_WORKITEM_INDEX_1 on WF_WORKITEM;

drop table if exists WF_WORKITEM;

/*==============================================================*/
/* Table: WF_WORKITEM                                           */
/*==============================================================*/
create table WF_WORKITEM
(
   WF_WORKITEM_ID       varchar(40) not null,
   PROCESS_INSTANCE_ID  varchar(40) not null,
   WF_STEP_ID           varchar(40) not null,
   WF_STEP_NAME         varchar(100) not null,
   WF_STEP_TYPE         char(1) not null,
   SENDER_NAME          varchar(100) not null,
   SENDER_PARTYID       varchar(100) not null,
   SENDER_CODE          varchar(300) not null,
   SENDER_COMPLETED_DATETIME timestamp,
   PERFORMER_NAME       varchar(100),
   PERFORMER_PARTYID    varchar(100),
   PERFORMER_CODE       varchar(300),
   PERFORMER_COMPLETED_DATETIME timestamp,
   READ_STATUS          char(1) default '0',
   DONE_STATUS          char(1) default '0',
   AUTHORIZE_STATUS     char(1) default '0',
   USABLE_STATUS        char(1) not null default '1',
   CREATE_DATETIME      timestamp not null default CURRENT_TIMESTAMP,
   MODIFY_DATETIME      timestamp,
   WF_ENGINE_TYPE       varchar(40),
   RESERVED_ATTRIBUTE_1 varchar(500),
   RESERVED_ATTRIBUTE_2 varchar(500),
   RESERVED_ATTRIBUTE_3 varchar(500),
   RESERVED_ATTRIBUTE_4 varchar(500),
   RESERVED_ATTRIBUTE_5 varchar(500),
   primary key (WF_WORKITEM_ID)
);

/*==============================================================*/
/* Index: WF_WORKITEM_INDEX_1                                   */
/*==============================================================*/
create index WF_WORKITEM_INDEX_1 on WF_WORKITEM
(
   PROCESS_INSTANCE_ID,
   SENDER_NAME,
   PERFORMER_NAME,
   CREATE_DATETIME,
   SENDER_PARTYID,
   PERFORMER_PARTYID
);
