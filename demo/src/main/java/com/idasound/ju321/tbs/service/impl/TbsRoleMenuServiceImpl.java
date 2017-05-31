package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsRoleMenu;
import com.idasound.ju321.tbs.dao.TbsRoleMenuMapper;
import com.idasound.ju321.tbs.service.TbsRoleMenuService;


@Service("tbsRoleMenuService")
public class TbsRoleMenuServiceImpl implements TbsRoleMenuService{
	@Autowired
	private TbsRoleMenuMapper tbsRoleMenuMapper;
	 /**
     * 总数
     * @param tbsRoleMenu
     * @return int
     */
    public int getMatchedTbsRoleMenuCount(TbsRoleMenu tbsRoleMenu){
    	return  tbsRoleMenuMapper.getMatchedTbsRoleMenuCount(tbsRoleMenu);
    }
    /**
     * 列表
     * @param tbsRoleMenu
     * @return List<TbsRoleMenu>
     */
    public List<TbsRoleMenu> getMatchedTbsRoleMenuList(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.getMatchedTbsRoleMenuList(tbsRoleMenu);
    }
    /**
     * 列表
     * @param tbsRoleMenu
     * @return List<TbsRoleMenu>
     */
    public List<TbsRoleMenu> getMatchedTbsRoleMenuAll(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.getMatchedTbsRoleMenuAll(tbsRoleMenu);
    }	
	/**
	* 通过主键查询详情
	* @param id
	* @return TbsRoleMenu
	*/
	public TbsRoleMenu selectByPrimaryKey(TbsRoleMenu tbsRoleMenu){
		return tbsRoleMenuMapper.selectByPrimaryKey(tbsRoleMenu);
	}
    /**
	 * 保存
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int insert(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.insert(tbsRoleMenu);
    }
    /**
	 * 选择性保存
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int insertSelective(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.insertSelective(tbsRoleMenu);
    }
    /**
	 * 更新
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int updateByPrimaryKey(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.updateByPrimaryKey(tbsRoleMenu);
    }
    /**
	 * 选择性更新
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int updateByPrimaryKeySelective(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.updateByPrimaryKeySelective(tbsRoleMenu);
    }
    /**
	 * 删除
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int deleteByPrimaryKey(TbsRoleMenu tbsRoleMenu){
    	return tbsRoleMenuMapper.deleteByPrimaryKey(tbsRoleMenu);
    }
    /**
	 * 删除多条信息
	 * @param tbsRoleMenu
	 */
    @Transactional
    public int deleteListByPrimaryKey(ListModel<TbsRoleMenu> listModel){
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsRoleMenu> tbsRoleMenus=listModel.getList();
    	for (Object map:tbsRoleMenus) {
    		TbsRoleMenu tbsRoleMenu=(TbsRoleMenu) JSONObject.toBean(JSONObject.fromObject(map), TbsRoleMenu.class);
    		tbsRoleMenuMapper.deleteByPrimaryKey(tbsRoleMenu);
		}
    	return listModel.getList().size();
    }
}