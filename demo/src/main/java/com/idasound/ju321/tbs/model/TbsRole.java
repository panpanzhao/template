package com.idasound.ju321.tbs.model;


import org.springframework.format.annotation.DateTimeFormat;
import com.idasound.ju321.common.utils.PaginatedHelper;


public class TbsRole extends PaginatedHelper implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//构造函数
	public TbsRole(){
	}
	
	//属性
	
	 /**
     * 角色主键       db_column: ID 
     */
	private java.lang.String id;

	
    /**
     * 管理员标记       db_column: IS_ADMIN 
     */	
	private java.lang.String isAdmin;
	
    /**
     * 供应商标记       db_column: IS_SUPPLIER 
     */	
	private java.lang.String isSupplier;
	
    /**
     * 父级信息       db_column: PARENT_ID 
     */	
	private java.lang.String parentId;
	
    /**
     * 备注       db_column: REMARK 
     */	
	private java.lang.String remark;
	
    /**
     * 角色描述       db_column: ROLE_DESC 
     */	
	private java.lang.String roleDesc;
	
    /**
     * 角色名称       db_column: ROLE_NAME 
     */	
	private java.lang.String roleName;
	
    /**
     * 状态       db_column: STATUS 
     */	
	private java.lang.String status;
	
    /**
     * 供应商ID       db_column: SUPPLIER_ID 
     */	
	private java.lang.String supplierId;
	
	//getter setter方法
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getIsAdmin() {
		return this.isAdmin;
	}
	public void setIsAdmin(java.lang.String value) {
		this.isAdmin = value;
	}
	
	public java.lang.String getIsSupplier() {
		return this.isSupplier;
	}
	public void setIsSupplier(java.lang.String value) {
		this.isSupplier = value;
	}
	
	public java.lang.String getParentId() {
		return this.parentId;
	}
	public void setParentId(java.lang.String value) {
		this.parentId = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
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
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getSupplierId() {
		return this.supplierId;
	}
	public void setSupplierId(java.lang.String value) {
		this.supplierId = value;
	}
		
}