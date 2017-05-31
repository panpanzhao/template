package com.idasound.ju321.tbs.service;

import java.util.List;
import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsUserRole;

public interface TbsUserRoleService{
	 /**
     * 总数
     * @param tbsUserRole
     * @return int
     */
    public int getMatchedTbsUserRoleCount(TbsUserRole tbsUserRole);
    /**
     * 列表
     * @param tbsUserRole
     * @return List<TbsUserRole>
     */
    public List<TbsUserRole> getMatchedTbsUserRoleList(TbsUserRole tbsUserRole);
    /**
     * 列表
     * @param tbsUserRole
     * @return List<TbsUserRole>
     */
    public List<TbsUserRole> getMatchedTbsUserRoleAll(TbsUserRole tbsUserRole);
    /**
	  * 通过主键查询详情
	  * @param id
	  * @return TbsUserRole
	  */
	 public TbsUserRole selectByPrimaryKey(TbsUserRole tbsUserRole);
    /**
	 * 保存
	 * @param tbsUserRole
	 */
    public int insert(TbsUserRole tbsUserRole);
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    public int insertSelective(TbsUserRole tbsUserRole);
    /**
	 * 更新
	 * @param tbsUserRole
	 */
    public int updateByPrimaryKey(TbsUserRole tbsUserRole);
    /**
	 * 选择性更新
	 * @param tbsUserRole
	 */
    public int updateByPrimaryKeySelective(TbsUserRole tbsUserRole);
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

