package com.idasound.ju321.tbs.dao;
import java.util.List;


import com.idasound.ju321.tbs.model.TbsRoleMenu;

public interface TbsRoleMenuMapper{
	 /**
     * 查询总数
     * @param tbsRoleMenu
     * @return int
     */
	 public int getMatchedTbsRoleMenuCount(TbsRoleMenu tbsRoleMenu);
	 /**
     * 查询列表
     * @param tbsRoleMenu
     * @return List<TbsRoleMenu>
     */
	 public List<TbsRoleMenu> getMatchedTbsRoleMenuList(TbsRoleMenu tbsRoleMenu);
	 /**
     * 查询所有信息（不分页）
     * @param tbsRoleMenu
     * @return List<TbsRoleMenu>
     */
	 public List<TbsRoleMenu> getMatchedTbsRoleMenuAll(TbsRoleMenu tbsRoleMenu);
	 /**
	  * 通过主键查询详情
	  * @param id
	  * @return TbsRoleMenu
	  */
	 public TbsRoleMenu selectByPrimaryKey(TbsRoleMenu tbsRoleMenu);
	 /**
	 * 保存
	 * @param tbsRoleMenu
	 */
     public int insert(TbsRoleMenu tbsRoleMenu);
	 /**
	 * 选择性保存
	 * @param tbsRoleMenu
	 */
     public int insertSelective(TbsRoleMenu tbsRoleMenu);
     /**
	 * 更新
	 * @param tbsRoleMenu
	 */
	 public int updateByPrimaryKey(TbsRoleMenu tbsRoleMenu);
	 /**
	 * 选择性更新
	 * @param tbsRoleMenu
	 */
	 public int updateByPrimaryKeySelective(TbsRoleMenu tbsRoleMenu);
	 /**
	 * 删除
	 * @param tbsRoleMenu
	 */
	 public int deleteByPrimaryKey(TbsRoleMenu tbsRoleMenu);
}
