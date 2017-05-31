package com.idasound.ju321.tbs.service;

import java.util.List;
import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsUser;

public interface TbsUserService{
	 /**
     * 总数
     * @param tbsUser
     * @return int
     */
    public int getMatchedTbsUserCount(TbsUser tbsUser);
    /**
     * 列表
     * @param tbsUser
     * @return List<TbsUser>
     */
    public List<TbsUser> getMatchedTbsUserList(TbsUser tbsUser);
    /**
     * 列表
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
    /**
   	 * 删除多条记录
   	 * @param tbsUser
   	 */
     public int deleteListByPrimaryKey(ListModel<TbsUser> listModel);
}

