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
	<title>资讯列表</title>
</head>
<body id="1" onload="onloads(1)">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>车辆管理 <span class="c-gray en">&gt;</span> 车辆列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="text-c">
		<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
		日期范围：
		<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })" id="logmax" class="input-text Wdate" style="width:120px;">
		<input type="text" name="" id="" placeholder=" 资讯名称" style="width:250px" class="input-text">
		<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 按订单号搜索</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">  <span class="r">共有数据：<strong><span id="zongshu">50</span></strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="80">单车编号</th>
				<th width="80">单车密钥</th>
				<th width="80">所属人</th>
				<th width="75">描述</th>
				<th width="120">创建时间</th>
				<th width="120">结束时间</th>
				<th width="75">状态</th>
				<th width="120">操作</th>
			</tr>
			</thead>
			<tbody id="articles">
			<tr class="text-c" v-for="item in list">
				<td><input type="checkbox" value="" name=""></td>
				<td>{{item.id}}</td>
				<td>{{item.bikeid}}</td>
				<td>{{item.psword}}</td>
				<td>{{item.user}}</td>
				<td>{{item.des}}</td>
				<td> {{item.created | time}}</td>
				<td class="td-status">{{item.updared | time}}</td>
				<td><span class="label label-success radius">{{item.status}}</span></td>
				<td class="f-14 td-manage"><a style="text-decoration:none" onClick="article_stop(this,'10001')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','article-add.html','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
			</tbody>
		</table>
	</div>
	<div style="margin:2% 800px;" id="offset">
		<div v-for="items in yes">
			<span class="label label-success radius" :id=items style="width: 30px;height:25px;text-align: center;float: left;line-height: 25px;font-size: larger;" onclick="onloads(this.id)"><a>{{items}}</a></span>
		</div>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="lib/vue.js"></script>
<script type="text/javascript" src="lib/time.js"></script>
<script type="text/javascript">

    var article = new Vue({
        el: "#articles",
        data: {
            list: [],
            total: 0,
        }
    });
    var offset = new Vue({
        el: "#offset",
        data: {
            yes: 0,
        }
    });
    function onloads(value) {
        console.log(value);
        $.get("/bike/list?page="+value, function (res) {
            article.list = res.rows;
            article.total = res.total;
            offset.yes = Math.ceil(article.total/8);
            $("#zongshu").html(article.total);
        }, "JSON");
    }


	/*资讯-编辑*/
    function article_edit(title,url,id,w,h){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
	/*资讯-删除*/
    function article_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }


	/*资讯-下架*/
    function article_stop(obj,id){
        layer.confirm('确认要下架吗？',function(index){
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
            $(obj).remove();
            layer.msg('已下架!',{icon: 5,time:1000});
        });
    }




</script>
</body>
</html>