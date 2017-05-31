package com.idasound.ju321.tbs.service;

import java.util.List;
import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsMenu;

public interface TbsMenuService{
	 /**
     * 总数
     * @param tbsMenu
     * @return int
     */
    public int getMatchedTbsMenuCount(TbsMenu tbsMenu);
    /**
     * 列表
     * @param tbsMenu
     * @return List<TbsMenu>
     */
    public List<TbsMenu> getMatchedTbsMenuList(TbsMenu tbsMenu);
    /**
     * 列表
     * @param tbsMenu
     * @return List<TbsMenu>
     */
    public List<TbsMenu> getMatchedTbsMenuAll(TbsMenu tbsMenu);
    /**
	  * 通过主键查询详情
	  * @param id
	  * @return TbsMenu
	  */
	 public TbsMenu selectByPrimaryKey(TbsMenu tbsMenu);
    /**
	 * 保存
	 * @param tbsMenu
	 */
    public int insert(TbsMenu tbsMenu);
    /**
	 * 选择性保存
	 * @param tbsMenu
	 */
    public int insertSelective(TbsMenu tbsMenu);
    /**
	 * 更新
	 * @param tbsMenu
	 */
    public int updateByPrimaryKey(TbsMenu tbsMenu);
    /**
	 * 选择性更新
	 * @param tbsMenu
	 */
    public int updateByPrimaryKeySelective(TbsMenu tbsMenu);
    /**
	 * 删除
	 * @param tbsMenu
	 */
    public int deleteByPrimaryKey(TbsMenu tbsMenu);
    /**
   	 * 删除多条记录
   	 * @param tbsMenu
   	 */
     public int deleteListByPrimaryKey(ListModel<TbsMenu> listModel);
}

