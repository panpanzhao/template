package com.idasound.ju321.tbs.service;

import java.util.List;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRoleMenu;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRole;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsMenu;

public interface TbsRoleMenuRelationService{
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsRole> getUnCheckTbsRoleList(String id);
	public List<TbsRoleMenu> getCheckTbsRoleList(String id);
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsMenu> getUnCheckTbsMenuList(String id);
	public List<TbsRoleMenu> getCheckTbsMenuList(String id);
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    public int insertSelective(TbsRoleMenu tbsRoleMenu);
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    public int insertListSelective(ListModel<TbsRoleMenu> listModel);
    /**
	 * 删除
	 * @param tbsUserRole
	 */
    public int deleteByPrimaryKey(TbsRoleMenu tbsRoleMenu);
    /**
   	 * 删除多条记录
   	 * @param tbsUserRole
   	 */
     public int deleteListByPrimaryKey(ListModel<TbsRoleMenu> listModel);
}

