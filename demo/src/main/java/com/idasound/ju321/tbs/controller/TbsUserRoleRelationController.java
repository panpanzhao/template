package com.idasound.ju321.tbs.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import com.idasound.ju321.common.dto.ListModel;
import com.idasound.ju321.common.utils.DateJsonValueProcessor;
import com.idasound.ju321.common.utils.JsonTreeUtil;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUserRole;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsUser;
import com.idasound.ju321.tbs.model.tbsUserRoleRelation.TbsRole;
import com.idasound.ju321.tbs.service.TbsUserRoleRelationService;

@Controller
public class TbsUserRoleRelationController {
	@Autowired
	private TbsUserRoleRelationService tbsUserRoleRelationService;
	/**
	 * 进入关联页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/addTbsUserRelation", method = RequestMethod.POST)
	public String addTbsUserRelation(TbsRole tbsRole, ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("tbsRole", tbsRole);
		return "tbs/TbsUserRoleRelation/addTbsUserRelation";
	}
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/queryUnCheckTbsUser")
    public void queryUnCheckTbsUser(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsUser> list = tbsUserRoleRelationService.getUnCheckTbsUserList(id);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray o =JSONArray.fromObject(list, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/queryCheckTbsUser")
    public void queryCheckTbsUser(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsUserRole> list = tbsUserRoleRelationService.getCheckTbsUserList(id);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray o =JSONArray.fromObject(list, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	/**
	 * 进入关联页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/addTbsRoleRelation", method = RequestMethod.POST)
	public String addTbsRoleRelation(TbsUser tbsUser, ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("tbsUser", tbsUser);
		return "tbs/TbsUserRoleRelation/addTbsRoleRelation";
	}
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/queryUnCheckTbsRole")
    public void queryUnCheckTbsRole(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsRole> list = tbsUserRoleRelationService.getUnCheckTbsRoleList(id);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray o =JSONArray.fromObject(list, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/queryCheckTbsRole")
    public void queryCheckTbsRole(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsUserRole> list = tbsUserRoleRelationService.getCheckTbsRoleList(id);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray o =JSONArray.fromObject(list, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }	
    
    
    
    
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/addList")
	public void addListSelective(@RequestBody ListModel<TbsUserRole> listModel,HttpServletRequest request,Model model,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleRelationService.insertListSelective(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
	
	/**
	 * 删除多条信息
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRoleRelation/deleteList")
	public void deleteList(@RequestBody ListModel<TbsUserRole> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleRelationService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
