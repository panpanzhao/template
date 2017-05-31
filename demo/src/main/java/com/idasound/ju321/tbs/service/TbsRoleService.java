package com.idasound.ju321.tbs.service;

import java.util.List;
import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsRole;

public interface TbsRoleService{
	 /**
     * 总数
     * @param tbsRole
     * @return int
     */
    public int getMatchedTbsRoleCount(TbsRole tbsRole);
    /**
     * 列表
     * @param tbsRole
     * @return List<TbsRole>
     */
    public List<TbsRole> getMatchedTbsRoleList(TbsRole tbsRole);
    /**
     * 列表
     * @param tbsRole
     * @return List<TbsRole>
     */
    public List<TbsRole> getMatchedTbsRoleAll(TbsRole tbsRole);
    /**
	  * 通过主键查询详情
	  * @param id
	  * @return TbsRole
	  */
	 public TbsRole selectByPrimaryKey(TbsRole tbsRole);
    /**
	 * 保存
	 * @param tbsRole
	 */
    public int insert(TbsRole tbsRole);
    /**
	 * 选择性保存
	 * @param tbsRole
	 */
    public int insertSelective(TbsRole tbsRole);
    /**
	 * 更新
	 * @param tbsRole
	 */
    public int updateByPrimaryKey(TbsRole tbsRole);
    /**
	 * 选择性更新
	 * @param tbsRole
	 */
    public int updateByPrimaryKeySelective(TbsRole tbsRole);
    /**
	 * 删除
	 * @param tbsRole
	 */
    public int deleteByPrimaryKey(TbsRole tbsRole);
    /**
   	 * 删除多条记录
   	 * @param tbsRole
   	 */
     public int deleteListByPrimaryKey(ListModel<TbsRole> listModel);
}

