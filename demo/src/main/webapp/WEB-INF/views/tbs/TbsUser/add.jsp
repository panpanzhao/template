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
		ajaxForm("${contextPath}/tbs/tbsUser/addSelective",
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
			<span class="lable">用户名:</span>
			<span>
				<input  id="add_userName" name="userName" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">性别:</span>
			<span>
				<select  id="add_sex" name="sex" class="easyui-combobox" data-options="required:true">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">真实姓名:</span>
			<span>
				<input  id="add_realName" name="realName" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">出生日期:</span>
			<span>
				<input  id="add_birthday" name="birthday" class="easyui-datebox" data-options="required:true,validType:['length[0,10]']" />
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
			<span class="lable">证件类型:</span>
			<span>
				<select  id="add_certificateType" name="certificateType" class="easyui-combobox" data-options="required:true">
					<option value="01">身份证</option>
					<option value="02">户口簿</option>
					<option value="03">军官证</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">证件号码:</span>
			<span>
				<input  id="add_certificateNo" name="certificateNo" class="easyui-textbox" data-options="required:true,validType:['length[0,30]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">电话:</span>
			<span>
				<input  id="add_telephone" name="telephone" class="easyui-textbox" data-options="required:false,validType:['length[0,20]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">邮件:</span>
			<span>
				<input  id="add_email" name="email" class="easyui-textbox" data-options="required:false,validType:['length[0,50]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">过期时间:</span>
			<span>
				<input  id="add_invalidateDate" name="invalidateDate" class="easyui-datebox" data-options="required:false,validType:['length[0,10]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">审核时间:</span>
			<span>
				<input  id="add_validateDate" name="validateDate" class="easyui-datebox" data-options="required:true,validType:['length[0,10]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">备注信息:</span>
			<span>
				<input  id="add_remark" name="remark" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">密码:</span>
			<span>
				<input  id="add_passpword" name="passpword" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">省:</span>
			<span>
				<input  id="add_province" name="province" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">市:</span>
			<span>
				<input  id="add_city" name="city" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">县:</span>
			<span>
				<input  id="add_county" name="county" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">详细地址:</span>
			<span>
				<input  id="add_address" name="address" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']" />
			</span>
		</li>
		<li style="">
			<span class="lable">公司名称:</span>
			<span>
				<input  id="add_companyName" name="companyName" class="easyui-textbox" data-options="required:false,validType:['length[0,32]']" />
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


