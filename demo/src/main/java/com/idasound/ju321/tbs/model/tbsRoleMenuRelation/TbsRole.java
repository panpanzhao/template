package com.idasound.ju321.tbs.model.tbsRoleMenuRelation;

import org.springframework.format.annotation.DateTimeFormat;

public class TbsRole{
	//属性
	
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