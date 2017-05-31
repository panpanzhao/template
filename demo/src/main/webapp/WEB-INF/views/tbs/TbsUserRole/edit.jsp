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
			ajaxJSON("${contextPath}/tbs/tbsUserRole/getObj",{"id":"${obj.id}"},
					function(obj){
		$('#edit_id').textbox('setValue', obj.id);
		$('#edit_userId').combobox('setValue', obj.userId);
		$('#edit_roleId').combobox('setValue', obj.roleId);
		$('#edit_status').textbox('setValue', obj.status);
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
		ajaxForm("${contextPath}/tbs/tbsUserRole/editSelective",
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
			<span class="lable">用户角色关系主键:</span>
			<span>
				<input  id="edit_id" name="id" class="easyui-textbox" data-options="required:true,validType:['length[0,32]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">用户信息:</span>
			<span>
				<input  id="edit_userId" name="userId" class="easyui-combobox"  data-options="onLoadSuccess:function(){initValue();},required:true,valueField:'id',textField:'userName',url:'${contextPath}//tbs/tbsUser/queryAll'" />
			</span>
		</li>
		<li style="">
			<span class="lable">角色信息:</span>
			<span>
				<input  id="edit_roleId" name="roleId" class="easyui-combobox"  data-options="onLoadSuccess:function(){initValue();},required:true,valueField:'id',textField:'roleName',url:'${contextPath}//tbs/tbsRole/queryAll'" />
			</span>
		</li>
		<li style="">
			<span class="lable">状态:</span>
			<span>
				<input  id="edit_status" name="status" class="easyui-textbox" data-options="required:true,validType:['length[0,1]']"/>
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


