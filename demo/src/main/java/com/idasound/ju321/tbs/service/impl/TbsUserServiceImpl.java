package com.idasound.ju321.tbs.service.impl;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.tbs.model.TbsUser;
import com.idasound.ju321.tbs.dao.TbsUserMapper;
import com.idasound.ju321.tbs.service.TbsUserService;


@Service("tbsUserService")
public class TbsUserServiceImpl implements TbsUserService{
	@Autowired
	private TbsUserMapper tbsUserMapper;
	 /**
     * 总数
     * @param tbsUser
     * @return int
     */
    public int getMatchedTbsUserCount(TbsUser tbsUser){
    	return  tbsUserMapper.getMatchedTbsUserCount(tbsUser);
    }
    /**
     * 列表
     * @param tbsUser
     * @return List<TbsUser>
     */
    public List<TbsUser> getMatchedTbsUserList(TbsUser tbsUser){
    	return tbsUserMapper.getMatchedTbsUserList(tbsUser);
    }
    /**
     * 列表
     * @param tbsUser
     * @return List<TbsUser>
     */
    public List<TbsUser> getMatchedTbsUserAll(TbsUser tbsUser){
    	return tbsUserMapper.getMatchedTbsUserAll(tbsUser);
    }	
	/**
	* 通过主键查询详情
	* @param id
	* @return TbsUser
	*/
	public TbsUser selectByPrimaryKey(TbsUser tbsUser){
		return tbsUserMapper.selectByPrimaryKey(tbsUser);
	}
    /**
	 * 保存
	 * @param tbsUser
	 */
    @Transactional
    public int insert(TbsUser tbsUser){
    	return tbsUserMapper.insert(tbsUser);
    }
    /**
	 * 选择性保存
	 * @param tbsUser
	 */
    @Transactional
    public int insertSelective(TbsUser tbsUser){
    	return tbsUserMapper.insertSelective(tbsUser);
    }
    /**
	 * 更新
	 * @param tbsUser
	 */
    @Transactional
    public int updateByPrimaryKey(TbsUser tbsUser){
    	return tbsUserMapper.updateByPrimaryKey(tbsUser);
    }
    /**
	 * 选择性更新
	 * @param tbsUser
	 */
    @Transactional
    public int updateByPrimaryKeySelective(TbsUser tbsUser){
    	return tbsUserMapper.updateByPrimaryKeySelective(tbsUser);
    }
    /**
	 * 删除
	 * @param tbsUser
	 */
    @Transactional
    public int deleteByPrimaryKey(TbsUser tbsUser){
    	return tbsUserMapper.deleteByPrimaryKey(tbsUser);
    }
    /**
	 * 删除多条信息
	 * @param tbsUser
	 */
    @Transactional
    public int deleteListByPrimaryKey(ListModel<TbsUser> listModel){
    	if(listModel.getList()==null||listModel.getList().size()<=0){
    		return 0;
    	}
    	List<TbsUser> tbsUsers=listModel.getList();
    	for (Object map:tbsUsers) {
    		TbsUser tbsUser=(TbsUser) JSONObject.toBean(JSONObject.fromObject(map), TbsUser.class);
    		tbsUserMapper.deleteByPrimaryKey(tbsUser);
		}
    	return listModel.getList().size();
    }
}