package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRoleMenu;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRole;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsMenu;
import com.idasound.ju321.tbs.dao.TbsRoleMenuRelationMapper;
import com.idasound.ju321.tbs.service.TbsRoleMenuRelationService;

@Service("tbsRoleMenuRelationService")
public class TbsRoleMenuRelationServiceImpl implements TbsRoleMenuRelationService{
	@Autowired
	private TbsRoleMenuRelationMapper tbsRoleMenuRelationMapper;
	
	@Override
	public List<TbsRole> getUnCheckTbsRoleList(String id) {
		return tbsRoleMenuRelationMapper.selectUnCheckTbsRoleList(id);
	}

	@Override
	public List<TbsRoleMenu> getCheckTbsRoleList(String id) {
		return tbsRoleMenuRelationMapper.selectCheckTbsRoleList(id);
	}

	@Override
	public List<TbsMenu> getUnCheckTbsMenuList(String id) {
		return tbsRoleMenuRelationMapper.selectUnCheckTbsMenuList(id);
	}

	@Override
	public List<TbsRoleMenu> getCheckTbsMenuList(String id) {
		return tbsRoleMenuRelationMapper.selectCheckTbsMenuList(id);
	}

	@Override
	public int insertSelective(TbsRoleMenu tbsRoleMenu) {
		return tbsRoleMenuRelationMapper.insertSelective(tbsRoleMenu);
	}

	@Override
	public int insertListSelective(ListModel<TbsRoleMenu> listModel) {
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsRoleMenu> tbsRoleMenus=listModel.getList();
    	for (Object map:tbsRoleMenus) {
    		TbsRoleMenu tbsRoleMenu=(TbsRoleMenu) JSONObject.toBean(JSONObject.fromObject(map), TbsRoleMenu.class);
    		tbsRoleMenuRelationMapper.insertSelective(tbsRoleMenu);
		}
    	return listModel.getList().size();
	}

	@Override
	public int deleteByPrimaryKey(TbsRoleMenu tbsRoleMenu) {
		return tbsRoleMenuRelationMapper.deleteByPrimaryKey(tbsRoleMenu);
	}
	
	@Override
	public int deleteListByPrimaryKey(ListModel<TbsRoleMenu> listModel) {
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsRoleMenu> tbsRoleMenus=listModel.getList();
    	for (Object map:tbsRoleMenus) {
    		TbsRoleMenu tbsRoleMenu=(TbsRoleMenu) JSONObject.toBean(JSONObject.fromObject(map), TbsRoleMenu.class);
    		tbsRoleMenuRelationMapper.deleteByPrimaryKey(tbsRoleMenu);
		}
    	return listModel.getList().size();
	}
}