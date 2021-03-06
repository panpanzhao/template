<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/layouts/links.jsp"%>
<%@ include file="/WEB-INF/views/common/layouts/meta.jsp"%>
<title>列表</title>
</head>

<script type="text/javascript">
	//搜索列表
	function doSearch(){
		$('#table').datagrid('load',{userName:$('#search_userName').val()});
	}	
	//跳转添加页面
	function doAdd(){
		if($("#addWindow").length<=0){
			var addWindow=$("<div id='addWindow'></div>")
			var addIframe='<iframe id="addIframe" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
			addWindow.append(addIframe).appendTo("body");
			
			addWindow.window({
			    title: '添加',
			    width: '80%',
			    height: '100%',
			    collapsible:false,
			    minimizable:false,
			    modal: true
			});
			
		}
		$("#addIframe").attr("src","${contextPath}/tbs/tbsUser/add");
		$("#addWindow").window('open');
	}
	//跳转修改页面
	function doEdit(){
		var rows = $('#table').datagrid('getSelections');
		if(rows.length<=0){
			$.messager.alert('提示信息','请选择要修改项','info');
			return
		}
		if(rows.length>1){
			$.messager.alert('提示信息','只能选择一项','info');
			return
		}
		
		if($("#editWindow").length<=0){
			var editWindow=$("<div id='editWindow'></div>")
			var editIframe='<iframe name="editIframe" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
			var editForm=$("<form id='editForm'></form>");
			editWindow.append(editIframe).append(editForm).appendTo("body");
			
			editWindow.window({
			    title: '修改',
			    width: '80%',
			    height: '100%',
			    collapsible:false,
			    minimizable:false,
			    modal: true
			});
			editForm.css({"display":"none"}).attr({"action":"${contextPath}/tbs/tbsUser/edit","method":"post","target":"editIframe"});
		}
		$("#editForm").empty();
		var dataParem=rows[0];
		for(var pro in dataParem){
			$("#editForm").append("<input  name='"+pro+"'  value='"+dataParem[pro]+"'/>");
		}
		$("#editForm").submit();
		$("#editWindow").window('open');
	}
	//删除信息
	function doDelete(){
		var rows = $('#table').datagrid('getSelections');
		if(rows.length<=0){
			$.messager.alert('提示信息','请选择要删除的项','info');
			return
		}
		$.messager.confirm('提示', '是否确认删除?', function(r){
			if (r){
				var dataParem=JSON.stringify({"list":rows});
				$.ajax({
					type: "POST",
					url: "${contextPath}/tbs/tbsUser/deleteList",
					data:dataParem,
					contentType:"application/json;charset=UTF-8",
					success: function(msg){		  
						if(msg=='SUCCESS'){
							$.messager.alert('提示信息','删除成功','info');
							doSearch();//查询列表
						}else{
							$.messager.alert('提示信息','删除失败','error');
						}
					}
				});
			}
		});
	}
	//功能列表
	function doRelationRole(){
		var rows = $('#table').datagrid('getSelections');
		if(rows.length<=0){
			$.messager.alert('提示信息','请选择要关联角色的项','info');
			return
		}
		if(rows.length>1){
			$.messager.alert('提示信息','只能选择一项','info');
			return
		}
		
		if($("#RelationRoleWindow").length<=0){
			var insertWindow=$("<div id='RelationRoleWindow' style='overflow:hidden;'></div>")
			var insertIframe='<iframe name="RelationRoleIframe" frameborder="0" style="border:0;width:100%;height:100%;"></iframe>';
			var insertForm=$("<form id='RelationRoleForm'></form>");
			insertWindow.append(insertIframe).append(insertForm).appendTo("body");
			
			insertWindow.window({
			    title: '关联角色',
			    width: '100%',
			    height: '100%',
			    collapsible:false,
			    minimizable:false,
			    modal: true
			});
			insertForm.css({"display":"none"}).attr({"action":"${contextPath}//tbs/tbsUserRoleRelation/addTbsRoleRelation","method":"post","target":"RelationRoleIframe"});
		}
		$("#RelationRoleForm").empty();
		var dataParem=rows[0];
		$("#RelationRoleForm").append("<input  name='tbsUserId'  value='"+dataParem['id']+"'/>");
		$("#RelationRoleForm").submit();
		$("#RelationRoleWindow").window('open');
	}
</script>
<body >
<!-- 表格信息 -->
<div id="paramSearch" >
	<ul class="searchUl">
		<li style="">
			<span class="lable">用户名:</span>
			<span>
				<input id="search_userName" class="easyui-textbox" />
			</span>
		</li>
		<li style="display: ">
			<a class="easyui-linkbutton" onclick="doSearch()" data-options="iconCls:'icon-search'">查&nbsp;询&nbsp;</a>
		</li>
	</ul>
	<div>
		<a href="javascript:void(0);" class="easyui-linkbutton"  data-options="iconCls:'icon-add',plain:true" onclick="javascript:doAdd()">添加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton"  data-options="iconCls:'icon-edit',plain:true" onclick="javascript:doEdit()">修改</a>
		<a href="javascript:void(0);" class="easyui-linkbutton"  data-options="iconCls:'icon-remove',plain:true" onclick="javascript:doDelete()">删除</a>
		<a href="javascript:void(0);" class="easyui-linkbutton"  data-options="iconCls:'icon-ok',plain:true" onclick="javascript:doRelationRole()">关联角色</a>
	</div>
</div>
<table id="table" class="easyui-datagrid" title="列表信息"
       data-options="url:'${contextPath}/tbs/tbsUser/query',
       				toolbar:'#paramSearch',
       				striped:true,
       				rownumbers:true,pagination:true">
	<thead>
		<tr>
			<th data-options="field:'_operate',checkbox:true">操作</th>
			<th data-options="field:'validateDate',sortable:true" >审核时间</th>
			<th data-options="field:'id',sortable:true,hidden:true" >用户主键</th>
			<th data-options="field:'userName',sortable:true" >用户名</th>
			<th data-options="field:'realName',sortable:true" >真实姓名</th>
			<th data-options="field:'certificateType',sortable:true,formatter:function(value, row, index) {if(value=='01'){return '身份证'}if(value=='02'){return '户口簿'}if(value=='03'){return '军官证'} return value;}" >证件类型</th>
			<th data-options="field:'certificateNo',sortable:true" >证件号码</th>
			<th data-options="field:'telephone',sortable:true" >电话</th>
			<th data-options="field:'companyName',sortable:true" >公司名称</th>
			<th data-options="field:'status',sortable:true,formatter:function(value, row, index) {if(value=='0'){return '无效'}if(value=='1'){return '有效'} return value;}" >状态</th>
		</tr>
	</thead>
</table>
</body>
</html>

