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
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRoleMenu;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsRole;
import com.idasound.ju321.tbs.model.tbsRoleMenuRelation.TbsMenu;
import com.idasound.ju321.tbs.service.TbsRoleMenuRelationService;

@Controller
public class TbsRoleMenuRelationController {
	@Autowired
	private TbsRoleMenuRelationService tbsRoleMenuRelationService;
	/**
	 * 进入关联页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/addTbsRoleRelation", method = RequestMethod.POST)
	public String addTbsRoleRelation(TbsMenu tbsMenu, ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("tbsMenu", tbsMenu);
		return "tbs/TbsRoleMenuRelation/addTbsRoleRelation";
	}
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/queryUnCheckTbsRole")
    public void queryUnCheckTbsRole(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsRole> list = tbsRoleMenuRelationService.getUnCheckTbsRoleList(id);
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
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/queryCheckTbsRole")
    public void queryCheckTbsRole(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsRoleMenu> list = tbsRoleMenuRelationService.getCheckTbsRoleList(id);
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
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/addTbsMenuRelation", method = RequestMethod.POST)
	public String addTbsMenuRelation(TbsRole tbsRole, ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("tbsRole", tbsRole);
		return "tbs/TbsRoleMenuRelation/addTbsMenuRelation";
	}
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/queryUnCheckTbsMenu")
    public void queryUnCheckTbsMenu(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsMenu> list = tbsRoleMenuRelationService.getUnCheckTbsMenuList(id);
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
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/queryCheckTbsMenu")
    public void queryCheckTbsMenu(HttpServletRequest request,HttpServletResponse response,String id) throws Exception{
		/**
		 * 获取数据
		 */
		List<TbsRoleMenu> list = tbsRoleMenuRelationService.getCheckTbsMenuList(id);
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
    
    
    
    
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/addList")
	public void addListSelective(@RequestBody ListModel<TbsRoleMenu> listModel,HttpServletRequest request,Model model,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuRelationService.insertListSelective(listModel);
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
	@RequestMapping(value = "/tbs/tbsRoleMenuRelation/deleteList")
	public void deleteList(@RequestBody ListModel<TbsRoleMenu> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuRelationService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
