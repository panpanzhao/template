package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsUserRole;
import com.idasound.ju321.tbs.dao.TbsUserRoleMapper;
import com.idasound.ju321.tbs.service.TbsUserRoleService;


@Service("tbsUserRoleService")
public class TbsUserRoleServiceImpl implements TbsUserRoleService{
	@Autowired
	private TbsUserRoleMapper tbsUserRoleMapper;
	 /**
     * 总数
     * @param tbsUserRole
     * @return int
     */
    public int getMatchedTbsUserRoleCount(TbsUserRole tbsUserRole){
    	return  tbsUserRoleMapper.getMatchedTbsUserRoleCount(tbsUserRole);
    }
    /**
     * 列表
     * @param tbsUserRole
     * @return List<TbsUserRole>
     */
    public List<TbsUserRole> getMatchedTbsUserRoleList(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.getMatchedTbsUserRoleList(tbsUserRole);
    }
    /**
     * 列表
     * @param tbsUserRole
     * @return List<TbsUserRole>
     */
    public List<TbsUserRole> getMatchedTbsUserRoleAll(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.getMatchedTbsUserRoleAll(tbsUserRole);
    }	
	/**
	* 通过主键查询详情
	* @param id
	* @return TbsUserRole
	*/
	public TbsUserRole selectByPrimaryKey(TbsUserRole tbsUserRole){
		return tbsUserRoleMapper.selectByPrimaryKey(tbsUserRole);
	}
    /**
	 * 保存
	 * @param tbsUserRole
	 */
    @Transactional
    public int insert(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.insert(tbsUserRole);
    }
    /**
	 * 选择性保存
	 * @param tbsUserRole
	 */
    @Transactional
    public int insertSelective(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.insertSelective(tbsUserRole);
    }
    /**
	 * 更新
	 * @param tbsUserRole
	 */
    @Transactional
    public int updateByPrimaryKey(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.updateByPrimaryKey(tbsUserRole);
    }
    /**
	 * 选择性更新
	 * @param tbsUserRole
	 */
    @Transactional
    public int updateByPrimaryKeySelective(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.updateByPrimaryKeySelective(tbsUserRole);
    }
    /**
	 * 删除
	 * @param tbsUserRole
	 */
    @Transactional
    public int deleteByPrimaryKey(TbsUserRole tbsUserRole){
    	return tbsUserRoleMapper.deleteByPrimaryKey(tbsUserRole);
    }
    /**
	 * 删除多条信息
	 * @param tbsUserRole
	 */
    @Transactional
    public int deleteListByPrimaryKey(ListModel<TbsUserRole> listModel){
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsUserRole> tbsUserRoles=listModel.getList();
    	for (Object map:tbsUserRoles) {
    		TbsUserRole tbsUserRole=(TbsUserRole) JSONObject.toBean(JSONObject.fromObject(map), TbsUserRole.class);
    		tbsUserRoleMapper.deleteByPrimaryKey(tbsUserRole);
		}
    	return listModel.getList().size();
    }
}