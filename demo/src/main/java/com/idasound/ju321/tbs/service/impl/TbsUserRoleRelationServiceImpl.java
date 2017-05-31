package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUserRole;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUser;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsRole;
import com.idasound.ju321.tbs.dao.TbsUserRoleRelationMapper;
import com.idasound.ju321.tbs.service.TbsUserRoleRelationService;

@Service("tbsUserRoleRelationService")
public class TbsUserRoleRelationServiceImpl implements TbsUserRoleRelationService{
	@Autowired
	private TbsUserRoleRelationMapper tbsUserRoleRelationMapper;
	
	@Override
	public List<TbsUser> getUnCheckTbsUserList(String id) {
		return tbsUserRoleRelationMapper.selectUnCheckTbsUserList(id);
	}

	@Override
	public List<TbsUserRole> getCheckTbsUserList(String id) {
		return tbsUserRoleRelationMapper.selectCheckTbsUserList(id);
	}

	@Override
	public List<TbsRole> getUnCheckTbsRoleList(String id) {
		return tbsUserRoleRelationMapper.selectUnCheckTbsRoleList(id);
	}

	@Override
	public List<TbsUserRole> getCheckTbsRoleList(String id) {
		return tbsUserRoleRelationMapper.selectCheckTbsRoleList(id);
	}

	@Override
	public int insertSelective(TbsUserRole tbsUserRole) {
		return tbsUserRoleRelationMapper.insertSelective(tbsUserRole);
	}

	@Override
	public int insertListSelective(ListModel<TbsUserRole> listModel) {
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsUserRole> tbsUserRoles=listModel.getList();
    	for (Object map:tbsUserRoles) {
    		TbsUserRole tbsUserRole=(TbsUserRole) JSONObject.toBean(JSONObject.fromObject(map), TbsUserRole.class);
    		tbsUserRoleRelationMapper.insertSelective(tbsUserRole);
		}
    	return listModel.getList().size();
	}

	@Override
	public int deleteByPrimaryKey(TbsUserRole tbsUserRole) {
		return tbsUserRoleRelationMapper.deleteByPrimaryKey(tbsUserRole);
	}
	
	@Override
	public int deleteListByPrimaryKey(ListModel<TbsUserRole> listModel) {
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsUserRole> tbsUserRoles=listModel.getList();
    	for (Object map:tbsUserRoles) {
    		TbsUserRole tbsUserRole=(TbsUserRole) JSONObject.toBean(JSONObject.fromObject(map), TbsUserRole.class);
    		tbsUserRoleRelationMapper.deleteByPrimaryKey(tbsUserRole);
		}
    	return listModel.getList().size();
	}
}