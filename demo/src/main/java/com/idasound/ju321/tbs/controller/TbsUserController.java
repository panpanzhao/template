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
import com.idasound.ju321.tbs.model.TbsUser;
import com.idasound.ju321.tbs.service.TbsUserService;

@Controller
public class TbsUserController {
	@Autowired
	private TbsUserService tbsUserService;
	/**
	 * 进入主页面
	 * @param filterMask
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUser/list", method = RequestMethod.GET)
	public String mainPage(Model model,HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsUser/list";
	}
	/**
	 * 进入修改页面
	 * @param filterMask
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUser/edit",method = RequestMethod.POST)
	public String mainEdit(TbsUser filterMask,ModelMap map,HttpServletRequest request,HttpServletResponse response){
		map.put("obj", tbsUserService.selectByPrimaryKey(filterMask));
		return "tbs/TbsUser/edit";
	}
	/**
	 * 进入添加页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/tbs/tbsUser/add",method = RequestMethod.GET)
	public String mainAdd(HttpServletRequest request,HttpServletResponse response){
		return "tbs/TbsUser/add";
	}
	
	/**
	 * 通过id获取详情
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/tbs/tbsUser/getObj")
    public void getObj(HttpServletRequest request,HttpServletResponse response,java.lang.String id) throws Exception{
		/**
		 * 输出到页面
		 */
		TbsUser filterMask=new TbsUser();
		filterMask.setId(id);
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		String objJson=JSONObject.fromObject(tbsUserService.selectByPrimaryKey(filterMask),config).toString();
		PrintWriter write = response.getWriter();
		write.write(objJson);
		write.flush();
		write.close();
    }
	/**
	 * table 列表
	 * @param request
	 * @param response
	 * @param TbsUser
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUser/query")
    public void getJsonDataGrid(HttpServletRequest request,HttpServletResponse response,TbsUser filterMask) throws Exception{
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
		List<TbsUser> list = new ArrayList<TbsUser>();
		int total = tbsUserService.getMatchedTbsUserCount(filterMask);
		if(total>0){
			list = tbsUserService.getMatchedTbsUserList(filterMask);
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
	 * @param TbsUser
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUser/queryAll")
    public void queryAll(HttpServletRequest request,HttpServletResponse response,TbsUser filterMask) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsUser> list = new ArrayList<TbsUser>();
		list = tbsUserService.getMatchedTbsUserAll(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUser/queryTree")
    public void queryTree(HttpServletRequest request,HttpServletResponse response,TbsUser filterMask,String treeId,String treePId,String treePValue,String showId,String showText) throws Exception{
		String sort=request.getParameter("sort");
		String order=request.getParameter("order");
		if(sort!=null&&order!=null){
			filterMask.setOrderByClause(sort+" "+order);
		}
		/**
		 * 获取数据
		 */
		List<TbsUser> list = new ArrayList<TbsUser>();
		list = tbsUserService.getMatchedTbsUserAll(filterMask);
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
	 * @param TbsUser
	 * @throws Exception
	 */
	@RequestMapping(value = "/tbs/tbsUser/queryById")
    public void queryById(HttpServletRequest request,HttpServletResponse response,TbsUser filterMask) throws Exception{
		/**
		 * 获取数据
		 */
		TbsUser tbsUser = tbsUserService.selectByPrimaryKey(filterMask);
		/**
		 * 数据转换
		 */
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject o =JSONObject.fromObject(tbsUser, config);
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
	@RequestMapping(value = "/tbs/tbsUser/add")
	public void add(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUser filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.insert(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUser/addSelective")
	public void addSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUser filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.insertSelective(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsUser/edit")
	 public void edit(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUser filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.updateByPrimaryKey(filterMask);
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
	 @RequestMapping(value = "/tbs/tbsUser/editSelective")
	 public void editSelective(HttpServletRequest request,Model model,HttpServletResponse response,@RequestBody TbsUser filterMask){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.updateByPrimaryKeySelective(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUser/delete")
	public void delete(TbsUser filterMask,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.deleteByPrimaryKey(filterMask);
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
	@RequestMapping(value = "/tbs/tbsUser/deleteList")
	public void deleteList(@RequestBody ListModel<TbsUser> listModel,HttpServletRequest request,HttpServletResponse response){
		PrintWriter write = null;
		try {
			write = response.getWriter();
			tbsUserService.deleteListByPrimaryKey(listModel);
			write.write("SUCCESS");
		} catch (Exception e) {
			write.write("ERROR");
		}finally{
			write.flush();
			write.close();
		}
	}
}
