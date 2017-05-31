package com.idasound.ju321.tbs.dao;
import java.util.List;

import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRoleMenu;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRole;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsMenu;

public interface TbsRoleMenuRelationMapper{
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsRole> selectUnCheckTbsRoleList(String id);
	public List<TbsRoleMenu> selectCheckTbsRoleList(String id);
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsMenu> selectUnCheckTbsMenuList(String id);
	public List<TbsRoleMenu> selectCheckTbsMenuList(String id);
	
	 /**
	 * 删除
	 * @param tbsUserRole
	 */
	 public int deleteByPrimaryKey(TbsRoleMenu tbsRoleMenu);
	 /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
     public int insertSelective(TbsRoleMenu tbsRoleMenu);
}
