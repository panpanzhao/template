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
	var comboNumber=2;
	initValue=function(){
		if(comboNumber>0){
			comboNumber--;
		}
		if(comboNumber==0){
			ajaxJSON("${contextPath}/tbs/tbsRoleMenu/getObj",{"id":"${obj.id}"},
					function(obj){
		$('#edit_id').textbox('setValue', obj.id);
		$('#edit_roleId').combobox('setValue', obj.roleId);
		$('#edit_menuId').combotree('setValue', obj.menuId);
		$('#edit_status').combobox('setValue', obj.status);
		$('#edit_remark').textbox('setValue', obj.remark);
					}
			);
			comboNumber--;
		}
	}
	
})
function saveEdit(){
 	var isValid = $('#edit-form').form('validate');
	if (isValid){
		ajaxForm("${contextPath}/tbs/tbsRoleMenu/editSelective",
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
			<span class="lable">角色权限关系主键:</span>
			<span>
				<input  id="edit_id" name="id" class="easyui-textbox" data-options="required:true,validType:['length[0,32]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">角色信息:</span>
			<span>
				<input  id="edit_roleId" name="roleId" class="easyui-combobox"  data-options="onLoadSuccess:function(){initValue();},required:true,valueField:'id',textField:'roleName',url:'${contextPath}//tbs/tbsRole/queryAll'" />
			</span>
		</li>
		<li style="">
			<span class="lable">权限信息:</span>
			<span>
				<input  id="edit_menuId" name="menuId" class="easyui-combotree" data-options="onLoadSuccess:function(){initValue();},editable:true,url:'${contextPath}//tbs/tbsMenu/queryTree?showId=id&showText=menuName&treeId=id&treePId=parentId&treePValue='">
			</span>
		</li>
		<li style="">
			<span class="lable">状态:</span>
			<span>
				<select  id="edit_status" name="status" class="easyui-combobox" data-options="required:true">
					<option value="0">无效</option>
					<option value="1">有效</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">备注:</span>
			<span>
				<input  id="edit_remark" name="remark" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']"/>
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


