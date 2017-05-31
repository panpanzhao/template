package com.idasound.ju321.tbs.service;

import java.util.List;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUserRole;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUser;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsRole;

public interface TbsUserRoleRelationService{
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsUser> getUnCheckTbsUserList(String id);
	public List<TbsUserRole> getCheckTbsUserList(String id);
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsRole> getUnCheckTbsRoleList(String id);
	public List<TbsUserRole> getCheckTbsRoleList(String id);
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    public int insertSelective(TbsUserRole tbsUserRole);
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    public int insertListSelective(ListModel<TbsUserRole> listModel);
    /**
	 * 删除
	 * @param tbsUserRole
	 */
    public int deleteByPrimaryKey(TbsUserRole tbsUserRole);
    /**
   	 * 删除多条记录
   	 * @param tbsUserRole
   	 */
     public int deleteListByPrimaryKey(ListModel<TbsUserRole> listModel);
}

