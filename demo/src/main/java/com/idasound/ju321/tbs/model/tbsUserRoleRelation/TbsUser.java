package com.idasound.ju321.tbs.model.tbsUserRoleRelation;

import org.springframework.format.annotation.DateTimeFormat;

public class TbsUser{
	//属性
	
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
	
	//get set方法
	
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
}