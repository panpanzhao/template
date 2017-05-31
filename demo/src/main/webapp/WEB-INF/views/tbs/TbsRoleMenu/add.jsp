<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>添加</title>
<script type="text/javascript">
function saveAdd(){
	var isValid = $('#add-form').form('validate');
	if (isValid){
		ajaxForm("${contextPath}/tbs/tbsRoleMenu/addSelective",
				$('#add-form').serializeObject(),
				function(msg){
					if(msg=='SUCCESS'){
						window.parent.$('#addWindow').window('close');
						window.parent.$.messager.alert('提示信息','保存成功','info');
						window.parent.doSearch();
					}else{
						$.messager.alert('提示信息','保存失败','error');
					}
				}
		);
	}
}
</script>
</head>


<body >
<!-- 添加信息 -->
<form id="add-form" class="form_save" method="post">
	<ul class="dialogUl">
		<li style="">
			<span class="lable">角色信息:</span>
			<span>
				<input  id="add_roleId" name="roleId" class="easyui-combobox" data-options="required:true,valueField:'id',textField:'roleName',url:'${contextPath}//tbs/tbsRole/queryAll'" />
			</span>
		</li>
		<li style="">
			<span class="lable">权限信息:</span>
			<span>
				<input  id="add_menuId" name="menuId" class="easyui-combotree" data-options="editable:true,url:'${contextPath}//tbs/tbsMenu/queryTree?showId=id&showText=menuName&treeId=id&treePId=parentId&treePValue='">
			</span>
		</li>
		<li style="">
			<span class="lable">状态:</span>
			<span>
				<select  id="add_status" name="status" class="easyui-combobox" data-options="required:true">
					<option value="0">无效</option>
					<option value="1">有效</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">备注:</span>
			<span>
				<input  id="add_remark" name="remark" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']" />
			</span>
		</li>
	</ul>
</form>
<div>
	<table style="width:100%">
		<tr>
			<td style="text-align:right">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="javascript:saveAdd();">保存</a>
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="window.parent.$('#addWindow').window('close')">关闭</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>


