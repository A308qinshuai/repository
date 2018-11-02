<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录 - Danche.admin v3.0</title>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <div style="text-align: center;" id="tishi"></div>
    <form class="form form-horizontal">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8" onchange="isUsername()">
          <input id="isUsername" name="" type="text" placeholder="账户" class="input-text size-L" >
          <div id="Username"><h5></h5></div>
        </div>

      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8" onchange="isPassword()">
          <input id="isPassword" name="" type="password" placeholder="密码" class="input-text size-L">
          <div id="Password"><h5></h5></div>
        </div>
      </div>

      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="button"  onclick="login()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset"   class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 小混蛋科技有限公司 by Danche.admin v3.0</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script>// 登陆前端验证
function isUsername(){

    var text=document.getElementById("isUsername");
    var val=text.value;
    if(val==''){
        document.getElementById("Username").style.color = "red";
        document.getElementById("Username").innerHTML = "*用户名不能为空";

    }else if(val.length<4){
        document.getElementById("Username").style.color = "red";
        document.getElementById("Username").innerHTML = "*用户名不能小于4位字符";
    }else{
        document.getElementById("Username").innerHTML = " ";
        return true;
    }
}
function isPassword(){
    var text=document.getElementById("isPassword");
    var val=text.value;
    if(val==''){
        document.getElementById("Password").style.color = "red";
        document.getElementById("Password").innerHTML = "*密码不能为空";
    }else{
        document.getElementById("Password").innerHTML = " ";
        return true;
    }
}


//登录注册
function login(){
    var n=document.getElementById("isUsername").value;
    var p=document.getElementById("isPassword").value;
    if(isUsername()&&isPassword()){
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
               var data = xmlhttp.responseText;
                data = JSON.parse(data);
                //alert(xmlhttp.responseText);
                if(data.status==200){
                    alert("登录成功");
                    window.location.href="/index";
                }else{
                    document.getElementById("tishi").style.color = "red";
                    document.getElementById("tishi").innerHTML = "用户名或密码错误！";
                    alert(data.msg);
                }

            }
        }
        xmlhttp.open("POST","/page/login",true);
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("n="+n+"&p="+p);

    }else{
        alert("请填写完整信息！");
    }
}</script>
</body>
</html>