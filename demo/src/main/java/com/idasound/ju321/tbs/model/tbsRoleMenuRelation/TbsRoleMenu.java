package com.idasound.ju321.tbs.model.tbsRoleMenuRelation;

import org.springframework.format.annotation.DateTimeFormat;

public class TbsRoleMenu{
	//属性
	
    /**
     * 角色权限关系主键       db_column: ID 
     */	
	private java.lang.String id;
	
    /**
     * 权限信息       db_column: MENU_ID 
     */	
	private java.lang.String menuId;
	
    /**
     * 角色信息       db_column: ROLE_ID 
     */	
	private java.lang.String roleId;

	
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

	
    /**
     * 权限主键       db_column: ID 
     */	
	private java.lang.String tbsMenuId;
	
    /**
     * 菜单描述       db_column: MENU_DESC 
     */	
	private java.lang.String menuDesc;
	
    /**
     * 菜单名称       db_column: MENU_NAME 
     */	
	private java.lang.String menuName;
	
    /**
     * 父ID       db_column: PARENT_ID 
     */	
	private java.lang.String parentId;

	//get set方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getMenuId() {
		return this.menuId;
	}
	public void setMenuId(java.lang.String value) {
		this.menuId = value;
	}
	
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
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

	
	public java.lang.String getTbsMenuId() {
		return this.tbsMenuId;
	}
	public void setTbsMenuId(java.lang.String value) {
		this.tbsMenuId = value;
	}
	
	public java.lang.String getMenuDesc() {
		return this.menuDesc;
	}
	public void setMenuDesc(java.lang.String value) {
		this.menuDesc = value;
	}
	
	public java.lang.String getMenuName() {
		return this.menuName;
	}
	public void setMenuName(java.lang.String value) {
		this.menuName = value;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}
	public void setParentId(java.lang.String value) {
		this.parentId = value;
	}
}