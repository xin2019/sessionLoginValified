<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login-session</title>
<link rel="stylesheet" href="../layui/css/layui.css" type="text/css" />
<script src="../layui/layui.js"></script>
</head>
<body>

<script>
	window.onload=function(){
		
		var msg = "${sessionScope.msg }";
		if (msg != null && msg != "") {
						
			layui.use('layer',function(){
				var layer=layui.layer;
				
				layer.open({
					title:'Error',
					content:msg
				});
			});
		}
		
		
	}
	</script>

	<form action="../servlets/Login" class="layui-form" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-inline">
				<input type="text" name="username" required placeholder="请输入帐号"
					class="layui-input">

			</div>
			<div id="id"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" required name="password" class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit>立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form;
		});
	</script>
</body>
</html>