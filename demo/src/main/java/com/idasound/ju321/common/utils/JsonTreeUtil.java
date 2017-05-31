package com.idasound.ju321.common.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 分页参数读取辅助类
 * 
 */
public class JsonTreeUtil{
	public static JSONArray getJsonTree(List<?> sourceList,String treeId,String treePId,String treePVal,String showId,String showText){
		List<JSONObject> treeList=JsonTreeUtil.transform(sourceList,showId,showText);
		List<JSONObject> jsonTree=JsonTreeUtil.iterTree(treeList,treeId,treePId,treePVal);
		return JSONArray.fromObject(jsonTree);
	}
	
	public static JSONArray getJsonTree(List<?> sourceList,String id,String pId,String text,String paramVal){
		List<Tree> treeList=JsonTreeUtil.transform(sourceList,id,pId,text);
		List<Tree> jsonTree=JsonTreeUtil.iterTree(treeList,paramVal);
		return JSONArray.fromObject(jsonTree);
	}
	
	/**
	 * 数据转换
	 * @param sourceList
	 * @param id
	 * @param pId
	 * @param text
	 * @return
	 */
	private static List<Tree> transform(List<?> sourceList,String id,String pId,String text){
		List<Tree> treeList=new ArrayList<Tree>();
		Tree tree=null;
		JSONArray sourceArray=JSONArray.fromObject(sourceList);
		for (Object sourceObject : sourceArray) {
			tree=new Tree();
			JSONObject sourceJson=(JSONObject)sourceObject;
			tree.setId(sourceJson.getString(id));
			tree.setPid(sourceJson.getString(pId));
			tree.setText(sourceJson.getString(text));
			treeList.add(tree);
		}
		return treeList;
	}
	/**
	 * 迭代树形结构
	 * @param allList  所有数据
	 * @param paramVal 父级数据
	 * @return
	 */
	private static List<Tree> iterTree(List<Tree> allList,String paramVal){
		List<Tree> listTree=new ArrayList<Tree>();
		for (Tree jsonTree : allList) {
			if(jsonTree.getPid().equals(paramVal)){
				jsonTree.setChildren(iterTree(allList,jsonTree.getId()));
				listTree.add(jsonTree);
			}
		}
		return listTree;
	}
	
	public static class Tree{
	    public String id;       //json id
	    public String pid;      //父节点
	    public String text;     //json 显示文本
	    public List<Tree> children;//
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public List<Tree> getChildren() {
			return children;
		}
		public void setChildren(List<Tree> children) {
			this.children = children;
		} 
	}
	
	
	
	private static List<JSONObject> transform(List<?> sourceList,String showId,String showText){
		List<JSONObject> treeList=new ArrayList<JSONObject>();
		JSONArray sourceArray=JSONArray.fromObject(sourceList);
		for (Object sourceObject : sourceArray) {
			JSONObject sourceJson=(JSONObject)sourceObject;
			sourceJson.put("id", sourceJson.get(showId));
			sourceJson.put("text", sourceJson.get(showText));
			treeList.add(sourceJson);
		}
		return treeList;
	}
	private static List<JSONObject> iterTree(List<JSONObject> allList,String id,String pId,String paramVal){
		List<JSONObject> listTree=new ArrayList<JSONObject>();
		for (JSONObject jsonTree : allList) {
			if(jsonTree.getString(pId).equals(paramVal)){
				jsonTree.put("children", iterTree(allList,id,pId,jsonTree.getString(id)));
				listTree.add(jsonTree);
			}
		}
		return listTree;
	}

}
