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
	var comboNumber=0;
	initValue=function(){
		if(comboNumber>0){
			comboNumber--;
		}
		if(comboNumber==0){
			ajaxJSON("${contextPath}/tbs/tbsUser/getObj",{"id":"${obj.id}"},
					function(obj){
		$('#edit_id').textbox('setValue', obj.id);
		$('#edit_userName').textbox('setValue', obj.userName);
		$('#edit_sex').combobox('setValue', obj.sex);
		$('#edit_birthday').datebox('setValue', obj.birthday);
		$('#edit_status').combobox('setValue', obj.status);
		$('#edit_certificateType').combobox('setValue', obj.certificateType);
		$('#edit_certificateNo').textbox('setValue', obj.certificateNo);
		$('#edit_telephone').textbox('setValue', obj.telephone);
		$('#edit_email').textbox('setValue', obj.email);
		$('#edit_invalidateDate').datebox('setValue', obj.invalidateDate);
		$('#edit_validateDate').datebox('setValue', obj.validateDate);
		$('#edit_realName').textbox('setValue', obj.realName);
		$('#edit_remark').textbox('setValue', obj.remark);
		$('#edit_passpword').textbox('setValue', obj.passpword);
		$('#edit_companyName').textbox('setValue', obj.companyName);
		$('#edit_province').textbox('setValue', obj.province);
		$('#edit_city').textbox('setValue', obj.city);
		$('#edit_county').textbox('setValue', obj.county);
		$('#edit_address').textbox('setValue', obj.address);
					}
			);
			comboNumber--;
		}
	}
	initValue()
})
function saveEdit(){
 	var isValid = $('#edit-form').form('validate');
	if (isValid){
		ajaxForm("${contextPath}/tbs/tbsUser/editSelective",
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
			<span class="lable">用户主键:</span>
			<span>
				<input  id="edit_id" name="id" class="easyui-textbox" data-options="required:true,validType:['length[0,32]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">用户名:</span>
			<span>
				<input  id="edit_userName" name="userName" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">性别:</span>
			<span>
				<select  id="edit_sex" name="sex" class="easyui-combobox" data-options="required:true">
					<option value="0">男</option>
					<option value="1">女</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">出生日期:</span>
			<span>
				<input  id="edit_birthday" name="birthday" class="easyui-datebox" data-options="required:true,validType:['length[0,10]']"/>
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
			<span class="lable">证件类型:</span>
			<span>
				<select  id="edit_certificateType" name="certificateType" class="easyui-combobox" data-options="required:true">
					<option value="01">身份证</option>
					<option value="02">户口簿</option>
					<option value="03">军官证</option>
				</select>
			</span>
		</li>
		<li style="">
			<span class="lable">证件号码:</span>
			<span>
				<input  id="edit_certificateNo" name="certificateNo" class="easyui-textbox" data-options="required:true,validType:['length[0,30]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">电话:</span>
			<span>
				<input  id="edit_telephone" name="telephone" class="easyui-textbox" data-options="required:false,validType:['length[0,20]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">邮件:</span>
			<span>
				<input  id="edit_email" name="email" class="easyui-textbox" data-options="required:false,validType:['length[0,50]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">过期时间:</span>
			<span>
				<input  id="edit_invalidateDate" name="invalidateDate" class="easyui-datebox" data-options="required:false,validType:['length[0,10]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">审核时间:</span>
			<span>
				<input  id="edit_validateDate" name="validateDate" class="easyui-datebox" data-options="required:true,validType:['length[0,10]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">真实姓名:</span>
			<span>
				<input  id="edit_realName" name="realName" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">备注信息:</span>
			<span>
				<input  id="edit_remark" name="remark" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">密码:</span>
			<span>
				<input  id="edit_passpword" name="passpword" class="easyui-textbox" data-options="required:true,validType:['length[0,50]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">公司名称:</span>
			<span>
				<input  id="edit_companyName" name="companyName" class="easyui-textbox" data-options="required:false,validType:['length[0,32]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">省:</span>
			<span>
				<input  id="edit_province" name="province" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">市:</span>
			<span>
				<input  id="edit_city" name="city" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">县:</span>
			<span>
				<input  id="edit_county" name="county" class="easyui-textbox" data-options="required:false,validType:['length[0,10]']"/>
			</span>
		</li>
		<li style="">
			<span class="lable">详细地址:</span>
			<span>
				<input  id="edit_address" name="address" class="easyui-textbox" data-options="required:false,validType:['length[0,256]']"/>
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


