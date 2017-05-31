package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsMenu;
import com.idasound.ju321.tbs.dao.TbsMenuMapper;
import com.idasound.ju321.tbs.service.TbsMenuService;


@Service("tbsMenuService")
public class TbsMenuServiceImpl implements TbsMenuService{
	@Autowired
	private TbsMenuMapper tbsMenuMapper;
	 /**
     * 总数
     * @param tbsMenu
     * @return int
     */
    public int getMatchedTbsMenuCount(TbsMenu tbsMenu){
    	return  tbsMenuMapper.getMatchedTbsMenuCount(tbsMenu);
    }
    /**
     * 列表
     * @param tbsMenu
     * @return List<TbsMenu>
     */
    public List<TbsMenu> getMatchedTbsMenuList(TbsMenu tbsMenu){
    	return tbsMenuMapper.getMatchedTbsMenuList(tbsMenu);
    }
    /**
     * 列表
     * @param tbsMenu
     * @return List<TbsMenu>
     */
    public List<TbsMenu> getMatchedTbsMenuAll(TbsMenu tbsMenu){
    	return tbsMenuMapper.getMatchedTbsMenuAll(tbsMenu);
    }	
	/**
	* 通过主键查询详情
	* @param id
	* @return TbsMenu
	*/
	public TbsMenu selectByPrimaryKey(TbsMenu tbsMenu){
		return tbsMenuMapper.selectByPrimaryKey(tbsMenu);
	}
    /**
	 * 保存
	 * @param tbsMenu
	 */
    @Transactional
    public int insert(TbsMenu tbsMenu){
    	return tbsMenuMapper.insert(tbsMenu);
    }
    /**
	 * 选择性保存
	 * @param tbsMenu
	 */
    @Transactional
    public int insertSelective(TbsMenu tbsMenu){
    	return tbsMenuMapper.insertSelective(tbsMenu);
    }
    /**
	 * 更新
	 * @param tbsMenu
	 */
    @Transactional
    public int updateByPrimaryKey(TbsMenu tbsMenu){
    	return tbsMenuMapper.updateByPrimaryKey(tbsMenu);
    }
    /**
	 * 选择性更新
	 * @param tbsMenu
	 */
    @Transactional
    public int updateByPrimaryKeySelective(TbsMenu tbsMenu){
    	return tbsMenuMapper.updateByPrimaryKeySelective(tbsMenu);
    }
    /**
	 * 删除
	 * @param tbsMenu
	 */
    @Transactional
    public int deleteByPrimaryKey(TbsMenu tbsMenu){
    	return tbsMenuMapper.deleteByPrimaryKey(tbsMenu);
    }
    /**
	 * 删除多条信息
	 * @param tbsMenu
	 */
    @Transactional
    public int deleteListByPrimaryKey(ListModel<TbsMenu> listModel){
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsMenu> tbsMenus=listModel.getList();
    	for (Object map:tbsMenus) {
    		TbsMenu tbsMenu=(TbsMenu) JSONObject.toBean(JSONObject.fromObject(map), TbsMenu.class);
    		tbsMenuMapper.deleteByPrimaryKey(tbsMenu);
		}
    	return listModel.getList().size();
    }
}