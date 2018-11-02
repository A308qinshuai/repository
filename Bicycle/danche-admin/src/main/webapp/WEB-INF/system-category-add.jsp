<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
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
	<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
	<script>DD_belatedPNG.fix('*');</script>
	<![endif]-->
	<title>新增图片</title>
	<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="/lib/layui/css/layui.css" media="all">
</head>
<body>
<div class="page-container">
	<form class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>客户端标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="title" name="">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">版本号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="" id="vnumber" name="">
			</div>
		</div>




		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">版本描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="des" cols="" rows="" class="textarea"  placeholder="说点什么..." datatype="*10-100" dragonfly="true" ></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">上传安装包：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class ="input-append">
					<label> &nbsp;</label >
					<input type ="file" id="ImportPicInput" name= "uploadFile" onchange="testUpload()"  />
				</div >
				<span id="tishi"></span>
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="save_submit" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>



<!--_footer 作为公共模版分离出去  enctype="multipart/form-data"-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="lib/ajaxfileupload.js"></script>

<script type="text/javascript">
    function article_save(){
        alert("刷新父级的时候会自动关闭弹层。")
        window.parent.location.reload();
    }

    var testUpload1=0;

    function testUpload() {
        document.getElementById('tishi').innerHTML= "上传中。。。";

        $.ajaxFileUpload({
            type: "POST",
            url: "/banben/Fileload",
			/* data:{picParams:text},//要传到后台的参数，没有可以不写 */
            fileElementId:'ImportPicInput',//文件选择框的id属性
            dataType: 'json',//服务器返回的格式
            success: function(data){
                if(data.error == 0){
                    document.getElementById('tishi').innerHTML= "上传完毕!";
                    testUpload1=1;
                }else {
                    document.getElementById('tishi').innerHTML= "上传失败!";
                }
            },
            error: function (data,status,e){
                alert(e);
            }
        });
    }

    $("#save_submit").click(function(){
        if(testUpload1==1){
        $.post("/banben/submit",{
                name:$("#title").val(),
                des:$("#des").val(),
                vnumber:$("#vnumber").val()
            },
            function(data){
                if(data.status==200){
                    alert("提交成功");
                }else{
                    alert("提交失败，请稍后再试");
            }
            });
        }else {
            alert("请先上传安装包,有意外请联系管理员");
		}
    });

</script>
</body>
</html>