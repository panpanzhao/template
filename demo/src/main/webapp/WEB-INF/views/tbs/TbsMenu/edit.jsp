<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>修改</title>
<script type="text/javascript">
var initValue;
$(function(){
	var comboNumber=1;
	initValue=function(){
		if(comboNumber>0){
			comboNumber--;
		}
		if(comboNumber==0){
			ajaxJSON("${contextPath}/tbs/tbsMenu/getObj",{"id":"${obj.id}"},
					function(obj){
		$('#edit_id').textbox('setValue', obj.id);
		$('#edit_menuName').textbox('setValue', obj.menuName);
		$('#edit_status').combobox('setValue', obj.status);
		$('#edit_displayFlag').combobox('setValue', obj.displayFlag);
		$('#edit_menuDesc').textbox('setValue', obj.menuDesc);
		$('#edit_menuUrl').textbox('setValue', obj.menuUrl);
		$('#edit_parentId').combotree('setValue', obj.parentId);
		$('#edit_remark').textbox('setValue', obj.remark);
		$('#edit_menuSort').numberbox('setValue', obj.menuSort);
					}
			);
			comboNumber--;
		}
	}
	
})
function saveEdit(){
 	var isValid = $('#edit-form').form('validate');
	if (isValid){
		ajaxForm("${contextPath}/tbs/tbsMenu/editSelective",
				$('#edit-form').serializeObject(),
				function(msg){
					if(msg=='SUCCESS'){
						window.parent.$('#editWindow').window('close');
						window.parent.$.messager.alert('提示信息','修改成功','info');
						window.parent.doSearch();
					}else{
						$.messager.alert('提示信息','修改失败','error');
					}
				}
		);
	} 
}
</script>
</head>

<body >
<!-- 修改信息 -->
<form id="edit-form"  class="form_save" method="post">
	<ul class="dialogUl">
		<li style="display:none">
			<span class="lable">权限主键:</span>
			<span>
				<input  id="edit_id" name="id" class="easyui-textbox" data-options="required:true,validType:['length[0,32]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">菜单名称:</span>
			<span>
				<input  id="edit_menuName" name="menuName" class="easyui-textbox" data-options="required:true,validType:['length[0,256]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">状态:</span>
			<span>
				<select  id="edit_status" name="status" class="easyui-combobox" data-options="required:true">
					<option value="0">有效</option>
					<option value="1">无效</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">菜单显示状态:</span>
			<span>
				<select  id="edit_displayFlag" name="displayFlag" class="easyui-combobox" data-options="required:false">
					<option value="0">不显示</option>
					<option value="1">显示</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">菜单描述:</span>
			<span>
				<input  id="edit_menuDesc" name="menuDesc" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">权限链接:</span>
			<span>
				<input  id="edit_menuUrl" name="menuUrl" class="easyui-textbox" data-options="required:false,validType:['length[0,2000]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">父节点:</span>
			<span>
				<input  id="edit_parentId" name="parentId" class="easyui-combotree" data-options="onLoadSuccess:function(){initValue();},editable:true,url:'${contextPath}//tbs/tbsMenu/queryTree?showId=id&showText=menuName&treeId=id&treePId=parentId&treePValue='">
			</span>
		</li>
		<li style="">
			<span class="lable">备注:</span>
			<span>
				<input  id="edit_remark" name="remark" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">菜单排序:</span>
			<span>
				<input  id="edit_menuSort" name="menuSort" class="easyui-numberbox" data-options="required:false,validType:['length[0,10]']"/>
			</span>
		</li>
	</ul>
</form>
<div>
	<table style="width:100%">
		<tr>
			<td style="text-align:right">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="javascript:saveEdit();">保存</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="window.parent.$('#editWindow').window('close')">关闭</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>


