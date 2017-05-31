package com.idasound.ju321.tbs.dao;
import java.util.List;


import com.idasound.ju321.tbs.model.TbsUserRole;

public interface TbsUserRoleMapper{
	 /**
     * 查询总数
     * @param tbsUserRole
     * @return int
     */
	 public int getMatchedTbsUserRoleCount(TbsUserRole tbsUserRole);
	 /**
     * 查询列表
     * @param tbsUserRole
     * @return List<TbsUserRole>
     */
	 public List<TbsUserRole> getMatchedTbsUserRoleList(TbsUserRole tbsUserRole);
	 /**
     * 查询所有信息（不分页）
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
}
