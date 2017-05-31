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
import com.idasound.ju321.tbs.model.TbsRoleMenu;
import com.idasound.ju321.tbs.service.TbsRoleMenuService;

@Controller
public class TbsRoleMenuController {
	@Autowired
	private TbsRoleMenuService tbsRoleMenuService;
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/list", method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsRoleMenu/list";
	}
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/edit",method = RequestMethod.POST)
	public String mainEdit(TbsRoleMenu filterMask,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("obj", tbsRoleMenuService.selectByPrimaryKey(filterMask));
		return "tbs/TbsRoleMenu/edit";
	}
	/**
	 * 进入添加页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/add",method = RequestMethod.GET)
	public String mainAdd(HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsRoleMenu/add";
	}
	
	/**
	 * 通过id获取详情
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/getObj")
    public void getObj(HttpServletRequest request,HttpServletResponse response,java.lang.String id) throws Exception{
		/**
		 * 输出到页面
		 */
		TbsRoleMenu filterMask=new TbsRoleMenu();
		filterMask.setId(id);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		String objJson=JSONObject.fromObject(tbsRoleMenuService.selectByPrimaryKey(filterMask),config).toString();
		PrintWriter write = response.getWriter();
		write.write(objJson);
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsRoleMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/query")
    public void getJsonDataGrid(HttpServletRequest request,HttpServletResponse response,TbsRoleMenu filterMask) throws Exception{
		filterMask.setStartIndex((filterMask.getPage()-1)*filterMask.getRows());
		filterMask.setEndIndex(filterMask.getStartIndex()+filterMask.getRows());
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsRoleMenu> list = new ArrayList<TbsRoleMenu>();
		int total = tbsRoleMenuService.getMatchedTbsRoleMenuCount(filterMask);
		if(total>0){
			list = tbsRoleMenuService.getMatchedTbsRoleMenuList(filterMask);
		}
		/**
		 * 转换列表需要的数据类型
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", total);
		map.put("rows",  list);
		JSONObject o =JSONObject.fromObject(map, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsRoleMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/queryAll")
    public void queryAll(HttpServletRequest request,HttpServletResponse response,TbsRoleMenu filterMask) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsRoleMenu> list = new ArrayList<TbsRoleMenu>();
		list = tbsRoleMenuService.getMatchedTbsRoleMenuAll(filterMask);
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
	 * 树形结构展示
	 * @param request
	 * @param response
	 * @param InsAttr
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/queryTree")
    public void queryTree(HttpServletRequest request,HttpServletResponse response,TbsRoleMenu filterMask,String treeId,String treePId,String treePValue,String showId,String showText) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsRoleMenu> list = new ArrayList<TbsRoleMenu>();
		list = tbsRoleMenuService.getMatchedTbsRoleMenuAll(filterMask);
		/**
		 * 转换树形结构
		 */
		JSONArray o =JsonTreeUtil.getJsonTree(list, treeId, treePId, treePValue,showId,showText);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsRoleMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/queryById")
    public void queryById(HttpServletRequest request,HttpServletResponse response,TbsRoleMenu filterMask) throws Exception{
		/**
		 * 获取数据
		 */
		TbsRoleMenu tbsRoleMenu = tbsRoleMenuService.selectByPrimaryKey(filterMask);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject o =JSONObject.fromObject(tbsRoleMenu, config);
		/**
		 * 输出到页面
		 */
		PrintWriter write = response.getWriter();
		write.write(o.toString());
		write.flush();
		write.close();
    }
	/**
	 * 新增
	 * @param country
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/add")
	public void add(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRoleMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.insert(filterMask);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
	/**
	 * 选择性新增
	 * @param country
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/addSelective")
	public void addSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRoleMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.insertSelective(filterMask);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
	/**
	 * 修改
	 * @param country
	 * @param result
	 * @return
	 */
	 @RequestMapping(value = "/tbs/tbsRoleMenu/edit")
	 public void edit(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRoleMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.updateByPrimaryKey(filterMask);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	 }
	/**
	 * 选择性修改
	 * @param country
	 * @param result
	 * @return
	 */
	 @RequestMapping(value = "/tbs/tbsRoleMenu/editSelective")
	 public void editSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRoleMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.updateByPrimaryKeySelective(filterMask);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	 }
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRoleMenu/delete")
	public void delete(TbsRoleMenu filterMask,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.deleteByPrimaryKey(filterMask);
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
	@RequestMapping(value = "/tbs/tbsRoleMenu/deleteList")
	public void deleteList(@RequestBody ListModel<TbsRoleMenu> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleMenuService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
