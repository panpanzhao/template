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
import com.idasound.ju321.tbs.model.TbsUserRole;
import com.idasound.ju321.tbs.service.TbsUserRoleService;

@Controller
public class TbsUserRoleController {
	@Autowired
	private TbsUserRoleService tbsUserRoleService;
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/list", method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsUserRole/list";
	}
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/edit",method = RequestMethod.POST)
	public String mainEdit(TbsUserRole filterMask,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("obj", tbsUserRoleService.selectByPrimaryKey(filterMask));
		return "tbs/TbsUserRole/edit";
	}
	/**
	 * 进入添加页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/add",method = RequestMethod.GET)
	public String mainAdd(HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsUserRole/add";
	}
	
	/**
	 * 通过id获取详情
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/getObj")
    public void getObj(HttpServletRequest request,HttpServletResponse response,java.lang.String id) throws Exception{
		/**
		 * 输出到页面
		 */
		TbsUserRole filterMask=new TbsUserRole();
		filterMask.setId(id);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		String objJson=JSONObject.fromObject(tbsUserRoleService.selectByPrimaryKey(filterMask),config).toString();
		PrintWriter write = response.getWriter();
		write.write(objJson);
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsUserRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/query")
    public void getJsonDataGrid(HttpServletRequest request,HttpServletResponse response,TbsUserRole filterMask) throws Exception{
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
		List<TbsUserRole> list = new ArrayList<TbsUserRole>();
		int total = tbsUserRoleService.getMatchedTbsUserRoleCount(filterMask);
		if(total>0){
			list = tbsUserRoleService.getMatchedTbsUserRoleList(filterMask);
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
	 * @param TbsUserRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/queryAll")
    public void queryAll(HttpServletRequest request,HttpServletResponse response,TbsUserRole filterMask) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsUserRole> list = new ArrayList<TbsUserRole>();
		list = tbsUserRoleService.getMatchedTbsUserRoleAll(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUserRole/queryTree")
    public void queryTree(HttpServletRequest request,HttpServletResponse response,TbsUserRole filterMask,String treeId,String treePId,String treePValue,String showId,String showText) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsUserRole> list = new ArrayList<TbsUserRole>();
		list = tbsUserRoleService.getMatchedTbsUserRoleAll(filterMask);
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
	 * @param TbsUserRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUserRole/queryById")
    public void queryById(HttpServletRequest request,HttpServletResponse response,TbsUserRole filterMask) throws Exception{
		/**
		 * 获取数据
		 */
		TbsUserRole tbsUserRole = tbsUserRoleService.selectByPrimaryKey(filterMask);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject o =JSONObject.fromObject(tbsUserRole, config);
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
	@RequestMapping(value = "/tbs/tbsUserRole/add")
	public void add(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUserRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.insert(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUserRole/addSelective")
	public void addSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUserRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.insertSelective(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsUserRole/edit")
	 public void edit(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUserRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.updateByPrimaryKey(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsUserRole/editSelective")
	 public void editSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUserRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.updateByPrimaryKeySelective(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUserRole/delete")
	public void delete(TbsUserRole filterMask,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.deleteByPrimaryKey(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUserRole/deleteList")
	public void deleteList(@RequestBody ListModel<TbsUserRole> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserRoleService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
