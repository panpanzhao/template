package com.idasound.ju321.tbs.dao;
import java.util.List;

import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUserRole;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUser;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsRole;

public interface TbsUserRoleRelationMapper{
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsUser> selectUnCheckTbsUserList(String id);
	public List<TbsUserRole> selectCheckTbsUserList(String id);
	
	/**
	 * 
	 * @param 
	 * @return
	 */
	public List<TbsRole> selectUnCheckTbsRoleList(String id);
	public List<TbsUserRole> selectCheckTbsRoleList(String id);
	
	 /**
	 * 删除
	 * @param tbsUserRole
	 */
	 public int deleteByPrimaryKey(TbsUserRole tbsUserRole);
	 /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
     public int insertSelective(TbsUserRole tbsUserRole);
}
