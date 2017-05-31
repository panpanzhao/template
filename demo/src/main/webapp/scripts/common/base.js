$.fn.serializeObject = function()    
{    
   var o = {};    
   var paramList = this.serializeArray();    
   $.each(paramList, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || null);    
       } else {    
           o[this.name] = this.value;    
       }    
   });    
   return o;    
};
var ajaxForm=function(paramUrl,paramJson,backFun){
	$.ajax({
		type: "POST",
		url: paramUrl,
		data:JSON.stringify(paramJson),
		contentType:"application/json;charset=UTF-8",
		success: function(msg){		
			backFun(msg);
		}
	});
}
var ajaxJSON=function(paramUrl,paramJson,backFun){
	$.ajax({
		type: "POST",
		url: paramUrl,
		data:paramJson,
		dataType:"json",
		success: function(msg){		
			backFun(msg);
		}
	});
}