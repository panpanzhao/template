package com.idasound.ju321.tbs.model.tbsRoleMenuRelation;

import org.springframework.format.annotation.DateTimeFormat;

public class TbsMenu{
	//属性
	
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