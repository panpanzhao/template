package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsRole;
import com.idasound.ju321.tbs.dao.TbsRoleMapper;
import com.idasound.ju321.tbs.service.TbsRoleService;


@Service("tbsRoleService")
public class TbsRoleServiceImpl implements TbsRoleService{
	@Autowired
	private TbsRoleMapper tbsRoleMapper;
	 /**
     * 总数
     * @param tbsRole
     * @return int
     */
    public int getMatchedTbsRoleCount(TbsRole tbsRole){
    	return  tbsRoleMapper.getMatchedTbsRoleCount(tbsRole);
    }
    /**
     * 列表
     * @param tbsRole
     * @return List<TbsRole>
     */
    public List<TbsRole> getMatchedTbsRoleList(TbsRole tbsRole){
    	return tbsRoleMapper.getMatchedTbsRoleList(tbsRole);
    }
    /**
     * 列表
     * @param tbsRole
     * @return List<TbsRole>
     */
    public List<TbsRole> getMatchedTbsRoleAll(TbsRole tbsRole){
    	return tbsRoleMapper.getMatchedTbsRoleAll(tbsRole);
    }	
	/**
	* 通过主键查询详情
	* @param id
	* @return TbsRole
	*/
	public TbsRole selectByPrimaryKey(TbsRole tbsRole){
		return tbsRoleMapper.selectByPrimaryKey(tbsRole);
	}
    /**
	 * 保存
	 * @param tbsRole
	 */
    @Transactional
    public int insert(TbsRole tbsRole){
    	return tbsRoleMapper.insert(tbsRole);
    }
    /**
	 * 选择性保存
	 * @param tbsRole
	 */
    @Transactional
    public int insertSelective(TbsRole tbsRole){
    	return tbsRoleMapper.insertSelective(tbsRole);
    }
    /**
	 * 更新
	 * @param tbsRole
	 */
    @Transactional
    public int updateByPrimaryKey(TbsRole tbsRole){
    	return tbsRoleMapper.updateByPrimaryKey(tbsRole);
    }
    /**
	 * 选择性更新
	 * @param tbsRole
	 */
    @Transactional
    public int updateByPrimaryKeySelective(TbsRole tbsRole){
    	return tbsRoleMapper.updateByPrimaryKeySelective(tbsRole);
    }
    /**
	 * 删除
	 * @param tbsRole
	 */
    @Transactional
    public int deleteByPrimaryKey(TbsRole tbsRole){
    	return tbsRoleMapper.deleteByPrimaryKey(tbsRole);
    }
    /**
	 * 删除多条信息
	 * @param tbsRole
	 */
    @Transactional
    public int deleteListByPrimaryKey(ListModel<TbsRole> listModel){
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsRole> tbsRoles=listModel.getList();
    	for (Object map:tbsRoles) {
    		TbsRole tbsRole=(TbsRole) JSONObject.toBean(JSONObject.fromObject(map), TbsRole.class);
    		tbsRoleMapper.deleteByPrimaryKey(tbsRole);
		}
    	return listModel.getList().size();
    }
}