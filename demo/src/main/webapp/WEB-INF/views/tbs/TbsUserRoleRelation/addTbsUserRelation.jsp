<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>后台管理系统</title>
</head>

<script type="text/javascript">
//删除选中信息
function deleteRow(){
	var rows = $('#right_table').datagrid("getChecked");
	if(rows.length<=0){
		$.messager.alert("提示信息","请选择要取消关联的项","info");
		return
	}
	$.messager.confirm("提示", "是否取消关联?", function(r){
		if (r){
			var dataParem=JSON.stringify({"list":rows});
			$.ajax({
				type: "POST",
				url: "${contextPath}/tbs/tbsUserRoleRelation/deleteList",
				data:dataParem,
				contentType:"application/json;charset=UTF-8",
				success: function(msg){		  
					if(msg=="SUCCESS"){
						$('#left_table').datagrid("reload");
						$('#right_table').datagrid("reload");
					}else{
						$.messager.alert("提示信息","取消关联失败","error");
					}
				}
			});
		}
	});
}
//保存选中信息
function saveRow(){
	var rows = $('#left_table').datagrid("getChecked");
	if(rows.length<=0){
		$.messager.alert("提示信息","请选择添加关联的项","info");
		return
	}
	$.messager.confirm("提示", "是否确认添加关联?", function(r){
		if (r){
			var rowList=[];
			$.each(rows,function(index,row){
				var obj={
					"userId":row.tbsUserId,
					"roleId":"${tbsRole.tbsRoleId}"
				}
				rowList.push(obj);
			});
			var dataParem=JSON.stringify({"list":rowList});
			$.ajax({
				type: "POST",
				url: "${contextPath}/tbs/tbsUserRoleRelation/addList",
				data:dataParem,
				contentType:"application/json;charset=UTF-8",
				success: function(msg){
					if(msg=="SUCCESS"){
						$('#left_table').datagrid("reload");
						$('#right_table').datagrid("reload");
					}else{
						$.messager.alert("提示信息","添加关联失败","error");
					}
				}
			});
		}
	});
}
</script>
<body id="indexLayout" class="easyui-layout" >
    <div data-options="region:'west'" style="width:45%">
		<table id="left_table" class="easyui-datagrid" title="未选列表信息"
		       data-options="url:'${contextPath}/tbs/tbsUserRoleRelation/queryUnCheckTbsUser?id=${tbsRole.tbsRoleId}',
		       				striped:true">
			<thead>
				<tr>
					<th data-options="field:'_operate',checkbox:true">操作</th>
					<th data-options="field:'tbsUserId',hidden:true" >用户主键</th>
					<th data-options="field:'realName'" >真实姓名</th>
					<th data-options="field:'userName'" >用户名</th>
				</tr>
			</thead>
		</table>
    </div>
    <div data-options="region:'center'" style="width:10%;text-align: center;padding-top:50%">
    	<a href="javascript:void(0);" onclick="saveRow()" class="easyui-linkbutton" style="width: 80%;">添加&nbsp;&nbsp;&gt;&gt;</a>
    	<br/><br/>
    	<a href="javascript:void(0);" onclick="deleteRow()" class="easyui-linkbutton" style="width: 80%">&lt;&lt;&nbsp;&nbsp;删除</a>
    </div>
    <div data-options="region:'east'" style="width:45%">
		<table id="right_table" class="easyui-datagrid" title="已选列表信息"
		       data-options="url:'${contextPath}/tbs/tbsUserRoleRelation/queryCheckTbsUser?id=${tbsRole.tbsRoleId}',
		       				striped:true">
			<thead>
				<tr>
					<th data-options="field:'_operate',checkbox:true">操作</th>
					<th data-options="field:'id',hidden:true" >用户角色关系主键</th>
					<th data-options="field:'realName'" >真实姓名</th>
					<th data-options="field:'userName'" >用户名</th>
				</tr>
			</thead>
		</table>
    </div>
</body>
</html>

