CREATE TABLE `t_sys_user` (
	  `user_name` varchar(64) DEFAULT ' ' COMMENT '用户姓名',
	  `password` varchar(256) DEFAULT ' ' COMMENT '密码',
	  `real_name` varchar(60) DEFAULT ' ' COMMENT '真实名称',
	  `sex` char(4) DEFAULT '0' COMMENT '性别',
	  `mobile` varchar(32) DEFAULT ' ' COMMENT '手机号',
	  `email` varchar(32) DEFAULT ' ' COMMENT '邮箱',
	  `user_status` char(4) DEFAULT '0' COMMENT '用户状态',
	  `user_type` char(4) DEFAULT '0' COMMENT '用户类型',
	  `dept_code` varchar(32) DEFAULT ' ' COMMENT '部门信息',
		`remark` varchar(200) DEFAULT ' ' COMMENT '备注'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	-- 用户角色表
	CREATE TABLE `t_sys_user_role` (
	  `user_name` varchar(64) DEFAULT ' ' COMMENT '用户名称',
	  `role_id` varchar(32) DEFAULT ' ' COMMENT '角色Id',
	  `remark` varchar(200) DEFAULT ' ' COMMENT '备注'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	-- 角色表
	CREATE TABLE `t_sys_role` (
	  `role_id` varchar(32) DEFAULT ' ' COMMENT '角色编号',
	  `role_name` varchar(20) DEFAULT ' ' COMMENT '角色名称',
	  `role_flag` char(4) DEFAULT '0' COMMENT '角色标志',
		`remark` varchar(200) DEFAULT ' ' COMMENT '备注'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	-- 角色资源表
	CREATE TABLE `t_sys_role_menu` (
	  `role_id` varchar(32) DEFAULT ' ' COMMENT '角色Id',
	  `menu_id` int(11) DEFAULT '0' COMMENT '资源Id',
		`remark` varchar(200) DEFAULT ' ' COMMENT '备注'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	-- 资源表
	CREATE TABLE `t_sys_menu` (
	  `menu_id` int(11) DEFAULT '0' COMMENT '资源Id',
	  `menu_name` varchar(64) DEFAULT ' ' COMMENT '资源名称',
	  `menu_type` char(4) DEFAULT '0' COMMENT '资源类型',
	  `menu_pid` int(11) DEFAULT '0' COMMENT '资源的父节点',
	  `http_address` varchar(256) DEFAULT ' ' COMMENT 'HTTP地址',
		`remark` varchar(200) DEFAULT ' ' COMMENT '备注'
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;