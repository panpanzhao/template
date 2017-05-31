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
import com.idasound.ju321.tbs.model.TbsMenu;
import com.idasound.ju321.tbs.service.TbsMenuService;

@Controller
public class TbsMenuController {
	@Autowired
	private TbsMenuService tbsMenuService;
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsMenu/list", method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsMenu/list";
	}
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsMenu/edit",method = RequestMethod.POST)
	public String mainEdit(TbsMenu filterMask,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("obj", tbsMenuService.selectByPrimaryKey(filterMask));
		return "tbs/TbsMenu/edit";
	}
	/**
	 * 进入添加页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsMenu/add",method = RequestMethod.GET)
	public String mainAdd(HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsMenu/add";
	}
	
	/**
	 * 通过id获取详情
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/tbs/tbsMenu/getObj")
    public void getObj(HttpServletRequest request,HttpServletResponse response,java.lang.String id) throws Exception{
		/**
		 * 输出到页面
		 */
		TbsMenu filterMask=new TbsMenu();
		filterMask.setId(id);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		String objJson=JSONObject.fromObject(tbsMenuService.selectByPrimaryKey(filterMask),config).toString();
		PrintWriter write = response.getWriter();
		write.write(objJson);
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsMenu/query")
    public void getJsonDataGrid(HttpServletRequest request,HttpServletResponse response,TbsMenu filterMask) throws Exception{
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
		List<TbsMenu> list = new ArrayList<TbsMenu>();
		int total = tbsMenuService.getMatchedTbsMenuCount(filterMask);
		if(total>0){
			list = tbsMenuService.getMatchedTbsMenuList(filterMask);
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
	 * @param TbsMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsMenu/queryAll")
    public void queryAll(HttpServletRequest request,HttpServletResponse response,TbsMenu filterMask) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsMenu> list = new ArrayList<TbsMenu>();
		list = tbsMenuService.getMatchedTbsMenuAll(filterMask);
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
	@RequestMapping(value = "/tbs/tbsMenu/queryTree")
    public void queryTree(HttpServletRequest request,HttpServletResponse response,TbsMenu filterMask,String treeId,String treePId,String treePValue,String showId,String showText) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsMenu> list = new ArrayList<TbsMenu>();
		list = tbsMenuService.getMatchedTbsMenuAll(filterMask);
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
	 * @param TbsMenu
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsMenu/queryById")
    public void queryById(HttpServletRequest request,HttpServletResponse response,TbsMenu filterMask) throws Exception{
		/**
		 * 获取数据
		 */
		TbsMenu tbsMenu = tbsMenuService.selectByPrimaryKey(filterMask);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject o =JSONObject.fromObject(tbsMenu, config);
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
	@RequestMapping(value = "/tbs/tbsMenu/add")
	public void add(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.insert(filterMask);
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
	@RequestMapping(value = "/tbs/tbsMenu/addSelective")
	public void addSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.insertSelective(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsMenu/edit")
	 public void edit(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.updateByPrimaryKey(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsMenu/editSelective")
	 public void editSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsMenu filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.updateByPrimaryKeySelective(filterMask);
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
	@RequestMapping(value = "/tbs/tbsMenu/delete")
	public void delete(TbsMenu filterMask,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.deleteByPrimaryKey(filterMask);
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
	@RequestMapping(value = "/tbs/tbsMenu/deleteList")
	public void deleteList(@RequestBody ListModel<TbsMenu> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsMenuService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
