package com.idasound.ju321.tbs.model;


import org.springframework.format.annotation.DateTimeFormat;
import com.idasound.ju321.common.utils.PaginatedHelper;


public class TbsUserRole extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//构造函数
	public TbsUserRole(){
	}
	
	//属性
	
	 /**
     * 用户角色关系主键       db_column: ID 
     */
	private java.lang.String id;

	
    /**
     * 备注       db_column: REMARK 
     */	
	private java.lang.String remark;
	
    /**
     * 角色信息       db_column: ROLE_ID 
     */	
	private java.lang.String roleId;
	
    /**
     * 状态       db_column: STATUS 
     */	
	private java.lang.String status;
	
    /**
     * 用户信息       db_column: USER_ID 
     */	
	private java.lang.String userId;
	
    /**
     * 用户名       db_column: USER_NAME 
     */	
	private java.lang.String userName;
	
    /**
     * 角色名称       db_column: ROLE_NAME 
     */	
	private java.lang.String roleName;
	
	//getter setter方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(java.lang.String value) {
		this.roleId = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getUserId() {
		return this.userId;
	}
	public void setUserId(java.lang.String value) {
		this.userId = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
		
}