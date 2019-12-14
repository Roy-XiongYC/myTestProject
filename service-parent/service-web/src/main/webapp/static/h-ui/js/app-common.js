var app = {
	description : 'App Common JS Library',
	version : '0.0.1'
};

//app.webroot = function() {
//
//	if (${webroot} == null) {
//		return "";
//	}
//	return webroot;
//};


// 格式化日期：年-月-日
app.inputDate = {
	myformatter : function(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	},

	myparser : function(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	},
	myformatterTime : function(val) {
		var date=new Date(parseInt(val));
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		var h = date.getHours();
		var i = date.getMinutes();
		var s = date.getSeconds();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d) + ' ' + (h < 10 ? ('0' + h) : h)
				+ ':' + (i < 10 ? '0' + i : i) + ':' + (s < 10 ? '0' + s : s);
	}
};


app.addButton = {
		update : function(method,id,width,height,url){
			return "<a title=\"编辑\" href=\"javascript:;\" onclick=\""+method+"('编辑','"+id+"','"+width+"','"+height+"','"+url+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>";
		},
		changePassword : function(method,id,width,height){
			return "<a title=\"重置密码\" href=\"javascript:;\" onclick=\""+method+"('重置密码','"+id+"','"+width+"','"+height+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe63f;</i></a>";
		},
		del : function(method,id,url){
			return "<a title=\"删除\" href=\"javascript:;\" onclick=\""+method+"('"+id+"','"+url+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>";
		},
		stop : function(method,id){
			return "<a style=\"text-decoration:none\" onClick=\""+method+"('"+id+"')\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a>";
		},
		start : function(method,id){
			return "<a style=\"text-decoration:none\" onClick=\""+method+"('"+id+"')\" href=\"javascript:;\" title=\"启用\"><i class=\"Hui-iconfont\">&#xe615;</i></a>";
		},
		group : function(method,id,width,height){
			return "<a title=\"修改用户组\" href=\"javascript:;\" onclick=\""+method+"('修改用户组','"+id+"','"+width+"','"+height+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6bd;</i></a>";
		},
		resource : function(method,id,width,height){
			return "<a title=\"配置权限\" href=\"javascript:;\" onclick=\""+method+"('配置权限','"+id+"','"+width+"','"+height+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe61d;</i></a>";
		},
		checkBox : function(id){
			return "<td><input type=\"checkbox\" id=\""+id+"\" name=\""+id+"\"></td>";
		},
		//启用停用
		stauts : function(method,id,url,stauts,icon){
			return "<a title=\""+stauts+"\" href=\"javascript:;\" onclick=\""+method+"('"+id+"','"+url+"','"+stauts+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">"+icon+";</i></a>";
		},
	};

/* closeParentLayer 需传入index  父页面需包含doQuery方法 */
app.messager = {
		success : function(msg){
			layer.msg(msg,{icon: 6,time:2000});
		},
		error : function(msg){
			layer.msg(msg,{icon: 5,time:2000});
		},
		closeParentLayer : function(index){
//			parent.doQuery();
			setTimeout(function(){
				parent.layer.close(index);
			},2000); 
		}
}


var index = parent.layer.getFrameIndex(window.name);
//保存
function save(url,data) {
		$.ajax({
			url : url,
			type : "POST",
			dataType : "json",
			data : data,
			async : false,
			cache : false,
			success : function(resp) {
				if(resp!=null && resp.success){
					app.messager.success('保存成功!');
					app.messager.closeParentLayer(index);
				}else{
					app.messager.error(resp.message);
				}
		}
		});
}

/*-编辑*/
function edit(title, id, w, h ,url) {
	layer_show(title,id, url, w, h);
}


//刷新页面
function doQuery(){
	Datatables.api().ajax.reload();
}

/*通用删除*/
function del(id,url){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			"type" : 'post',
			"url" : url,
			"dataType" : "json",
			"data" : {
					id : id
			},
			"success" : function(resp) {
				if(resp!=null && resp.success){
					app.messager.success('已删除!');
					doQuery();
				}else{
					app.messager.error(resp.message);
				}
			}
		});
	});
}

/*管理员-启用*/
function admin_start(id,url,stauts){
	layer.confirm('确认要'+stauts+'吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		var userStauts=stauts=="启用"?0:1;
		
		$.ajax({
		"type" : 'post',
		"url" : url,
		"dataType" : "json",
		"data" : {
				id : id,
				stauts:userStauts
		},
		"success" : function(resp) {
				if(resp!=null && resp.success){
					layer.msg('已'+stauts+'!', {icon: userStauts==0?6:5,time:1000});
//					app.messager.success('已'+stauts+'!');
					doQuery();
				}else{
					app.messager.error(resp.message);
				}
			}
		});
		
		
		
	});
}
