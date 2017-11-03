CREATE TABLE `wf_bpmn_config_var_ref` (
  `WF_BPMN_CONFIG_VAR_REF_ID` varchar(40) NOT NULL,
  `BPMN_VARIABLE_KEY` varchar(150) DEFAULT NULL,
  `BPMN_VARIABLE_NAME` varchar(500) DEFAULT NULL,
  `BPMN_VARIABLE_INTRO` varchar(1000) DEFAULT NULL,
  `BPMN_ENGINE_TYPE` varchar(100) DEFAULT NULL,
  `REF_BIZ_VARIABLE_KEY` varchar(150) DEFAULT NULL,
  `REF_BIZ_VARIABLE_NAME` varchar(500) DEFAULT NULL,
  `REF_BIZ_VARIABLE_INTRO` varchar(1000) DEFAULT NULL,
  `CREATE_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MODIFY_DATETIME` timestamp NULL DEFAULT NULL,
  `USABLE_STATUS` char(1) NOT NULL,
  `RESERVED_ATTRIBUTE1` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE2` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE3` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE4` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE5` varchar(500) DEFAULT NULL,
  `RESERVED_ATTRIBUTE6` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`WF_BPMN_CONFIG_VAR_REF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
