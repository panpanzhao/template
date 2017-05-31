package com.idasound.ju321.tbs.dao;
import java.util.List;


import com.idasound.ju321.tbs.model.TbsUser;

public interface TbsUserMapper{
	 /**
     * 查询总数
     * @param tbsUser
     * @return int
     */
	 public int getMatchedTbsUserCount(TbsUser tbsUser);
	 /**
     * 查询列表
     * @param tbsUser
     * @return List<TbsUser>
     */
	 public List<TbsUser> getMatchedTbsUserList(TbsUser tbsUser);
	 /**
     * 查询所有信息（不分页）
     * @param tbsUser
     * @return List<TbsUser>
     */
	 public List<TbsUser> getMatchedTbsUserAll(TbsUser tbsUser);
	 /**
	  * 通过主键查询详情
	  * @param id
	  * @return TbsUser
	  */
	 public TbsUser selectByPrimaryKey(TbsUser tbsUser);
	 /**
	 * 保存
	 * @param tbsUser
	 */
     public int insert(TbsUser tbsUser);
	 /**
	 * 选择性保存
	 * @param tbsUser
	 */
     public int insertSelective(TbsUser tbsUser);
     /**
	 * 更新
	 * @param tbsUser
	 */
	 public int updateByPrimaryKey(TbsUser tbsUser);
	 /**
	 * 选择性更新
	 * @param tbsUser
	 */
	 public int updateByPrimaryKeySelective(TbsUser tbsUser);
	 /**
	 * 删除
	 * @param tbsUser
	 */
	 public int deleteByPrimaryKey(TbsUser tbsUser);
}
