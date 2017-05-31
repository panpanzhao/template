package com.idasound.ju321.tbs.model.tbsUserRoleRelation;

import org.springframework.format.annotation.DateTimeFormat;

public class TbsUserRole{
	//属性
	
    /**
     * 用户角色关系主键       db_column: ID 
     */	
	private java.lang.String id;
	
    /**
     * 角色信息       db_column: ROLE_ID 
     */	
	private java.lang.String roleId;
	
    /**
     * 用户信息       db_column: USER_ID 
     */	
	private java.lang.String userId;

	
    /**
     * 用户主键       db_column: ID 
     */	
	private java.lang.String tbsUserId;
	
    /**
     * 真实姓名       db_column: REAL_NAME 
     */	
	private java.lang.String realName;
	
    /**
     * 用户名       db_column: USER_NAME 
     */	
	private java.lang.String userName;

	
    /**
     * 角色主键       db_column: ID 
     */	
	private java.lang.String tbsRoleId;
	
    /**
     * 角色描述       db_column: ROLE_DESC 
     */	
	private java.lang.String roleDesc;
	
    /**
     * 角色名称       db_column: ROLE_NAME 
     */	
	private java.lang.String roleName;

	//get set方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}

	
	public java.lang.String getTbsUserId() {
		return this.tbsUserId;
	}
	public void setTbsUserId(java.lang.String value) {
		this.tbsUserId = value;
	}
	
	public java.lang.String getRealName() {
		return this.realName;
	}
	public void setRealName(java.lang.String value) {
		this.realName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}

	
	public java.lang.String getTbsRoleId() {
		return this.tbsRoleId;
	}
	public void setTbsRoleId(java.lang.String value) {
		this.tbsRoleId = value;
	}
	
	public java.lang.String getRoleDesc() {
		return this.roleDesc;
	}
	public void setRoleDesc(java.lang.String value) {
		this.roleDesc = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
}