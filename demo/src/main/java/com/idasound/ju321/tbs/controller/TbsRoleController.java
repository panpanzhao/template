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
import com.idasound.ju321.tbs.model.TbsRole;
import com.idasound.ju321.tbs.service.TbsRoleService;

@Controller
public class TbsRoleController {
	@Autowired
	private TbsRoleService tbsRoleService;
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRole/list", method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsRole/list";
	}
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRole/edit",method = RequestMethod.POST)
	public String mainEdit(TbsRole filterMask,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("obj", tbsRoleService.selectByPrimaryKey(filterMask));
		return "tbs/TbsRole/edit";
	}
	/**
	 * 进入添加页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsRole/add",method = RequestMethod.GET)
	public String mainAdd(HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsRole/add";
	}
	
	/**
	 * 通过id获取详情
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/tbs/tbsRole/getObj")
    public void getObj(HttpServletRequest request,HttpServletResponse response,java.lang.String id) throws Exception{
		/**
		 * 输出到页面
		 */
		TbsRole filterMask=new TbsRole();
		filterMask.setId(id);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		String objJson=JSONObject.fromObject(tbsRoleService.selectByPrimaryKey(filterMask),config).toString();
		PrintWriter write = response.getWriter();
		write.write(objJson);
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRole/query")
    public void getJsonDataGrid(HttpServletRequest request,HttpServletResponse response,TbsRole filterMask) throws Exception{
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
		List<TbsRole> list = new ArrayList<TbsRole>();
		int total = tbsRoleService.getMatchedTbsRoleCount(filterMask);
		if(total>0){
			list = tbsRoleService.getMatchedTbsRoleList(filterMask);
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
	 * @param TbsRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRole/queryAll")
    public void queryAll(HttpServletRequest request,HttpServletResponse response,TbsRole filterMask) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsRole> list = new ArrayList<TbsRole>();
		list = tbsRoleService.getMatchedTbsRoleAll(filterMask);
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
	@RequestMapping(value = "/tbs/tbsRole/queryTree")
    public void queryTree(HttpServletRequest request,HttpServletResponse response,TbsRole filterMask,String treeId,String treePId,String treePValue,String showId,String showText) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsRole> list = new ArrayList<TbsRole>();
		list = tbsRoleService.getMatchedTbsRoleAll(filterMask);
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
	 * @param TbsRole
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsRole/queryById")
    public void queryById(HttpServletRequest request,HttpServletResponse response,TbsRole filterMask) throws Exception{
		/**
		 * 获取数据
		 */
		TbsRole tbsRole = tbsRoleService.selectByPrimaryKey(filterMask);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject o =JSONObject.fromObject(tbsRole, config);
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
	@RequestMapping(value = "/tbs/tbsRole/add")
	public void add(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.insert(filterMask);
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
	@RequestMapping(value = "/tbs/tbsRole/addSelective")
	public void addSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.insertSelective(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsRole/edit")
	 public void edit(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.updateByPrimaryKey(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsRole/editSelective")
	 public void editSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsRole filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.updateByPrimaryKeySelective(filterMask);
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
	@RequestMapping(value = "/tbs/tbsRole/delete")
	public void delete(TbsRole filterMask,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.deleteByPrimaryKey(filterMask);
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
	@RequestMapping(value = "/tbs/tbsRole/deleteList")
	public void deleteList(@RequestBody ListModel<TbsRole> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsRoleService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
