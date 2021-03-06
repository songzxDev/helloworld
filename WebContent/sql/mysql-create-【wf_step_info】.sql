CREATE TABLE `wf_step_info` (
  `WF_STEP_INFO_ID` varchar(40) NOT NULL,
  `PROCESS_KEY` varchar(150) NOT NULL,
  `PROCESS_NAME` varchar(300) NOT NULL,
  `STEP_ID` varchar(40) NOT NULL,
  `STEP_NAME` varchar(200) NOT NULL,
  `STEP_TYPE` char(1) NOT NULL,
  `STEP_FILTER_USER_TYPE` char(1) NOT NULL,
  `STEP_FILTER_ROLE_ID` varchar(120) DEFAULT NULL,
  `STEP_FILTER_ROLE_NAME` varchar(400) DEFAULT NULL,
  `STEP_DEPT_CODE` varchar(1000) DEFAULT NULL,
  `STEP_DEPT_NAME` varchar(300) DEFAULT NULL,
  `STEP_DEPT_TYPE` varchar(100) DEFAULT NULL,
  `STEP_DEPT_LEVEL` varchar(10) DEFAULT NULL,
  `STEP_PATH` varchar(1000) NOT NULL,
  `STEP_FURTHER_PATH` varchar(200) DEFAULT NULL,
  `BIZ_FORM_URL` varchar(1000) DEFAULT NULL,
  `IS_IMPORTANCE` char(1) NOT NULL,
  `FILTER_PERSONS_TEAM_ID` varchar(40) DEFAULT NULL,
  `FILTER_PERSONS_TEAM_NAME` varchar(200) DEFAULT NULL,
  `SWITCHE_ID` varchar(200) DEFAULT NULL,
  `SWITCHE_NAME` varchar(600) DEFAULT NULL,
  `MUST_AUDIT_PERSON_NAME` varchar(100) DEFAULT NULL,
  `MUST_AUDIT_PERSON_CODE` varchar(500) DEFAULT NULL,
  `MUST_AUDIT_PERSON_PARTYID` varchar(500) DEFAULT NULL,
  `IS_MUST_WRITE_AUDIT_IDEA` char(1) NOT NULL,
  `CREATE_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFY_DATETIME` timestamp NULL DEFAULT NULL,
  `USABLE_STATUS` char(1) NOT NULL,
  `RESERVED_ATTRIBUTE1` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE2` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE3` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE4` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE5` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`WF_STEP_INFO_ID`),
  KEY `WF_STEP_INFO_IK` (`PROCESS_KEY`,`STEP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

