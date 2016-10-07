<%@ page language="java" import="java.util.*,javax.servlet.*,com.sunkejava.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/ckplayer.css" type="text/css">
<script type="text/javascript" src="ckplayer/ckplayer.js" charset="utf-8"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="js/ac.js"></script>
<%
Date date = new Date();
String a = request.getParameter("a");
String b = request.getParameter("b");
String c = request.getParameter("c");
String d = request.getParameter("d");
String e = request.getParameter("e");
String f = request.getParameter("f");
String g = request.getParameter("g");

%>
<title></title>
</head>
<body onload="show()">
	<div class="box">
		<div class="top-box">
			
		</div>
		<div id="a1"></div>
		<div class="button-box"></div>
	</div>
	<input id="searchtype" name = "searchtype" type="hidden" value="<%= a %>">
<input id="searchContext" name = "searchContext" type="hidden" value="<%= a %>">
<a rev="<%= a %>" rel="<%= a %>" title="706" lang="4j216" name="Ss1|Ss2|Ss3|Ss4" class="//a.aq-cn.com:88/b389" type="<%= b %>" href="<%= a %>" id="n1"></a>
	<script type="text/javascript">
	var ps;
	var flashvars;
	function show() {
		var random_bg = parseInt(Math.random() * 66);
		var bg = 'url(images/bg-' + random_bg + '.jpg)';
		var i1 = W("ke"), 
		rd1 = yp() ? i1 ? "m2" : "ms" : i1 ? "c2" : "cs";
		$("body").css("background-image", bg);
		  p = get();
		  s = (yp() ? "" : rm(8));
		  var q= "?k1=<%= c %>&k2="+rd1+s+"&k3=<%= d %>&k4=<%= e %>&k5=<%= a %>&k6=<%= f %>&k7=<%= g %>";
		  ps = p+q;
	      flashvars={
	    			f:ps,
	    			a:'',
	    			s:'0',
	    			c:'0',
	    			x:'',
	    			//i:'',
	    			e:'3',
	    			v:'50',
	    			p:'0',
	    			h:'3',
	    			wh:'4:3',
	    			lv:'0',
	    			Title:'<%= a %>',
	    			deft:'',
	    			deff:'',
	    			loaded:'loadedHandler'
	    			};
	    		var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};//这里定义播放器的其它参数如背景色（跟flashvars中的b不同），是否支持全屏，是否支持交互
	    		var video=['ps>video/mp4'];
	    		CKobject.embed('ckplayer/ckplayer.swf','a1','ckplayer_a1','100%','100%',false,flashvars,video,params);
	      
	}
	function loadedHandler(){
		if(CKobject.getObjectById('ckplayer_a1').getType()){//说明使用html5播放器
			document.title="正在播放恋恋视频："+flashvars.Title;
			alert(flashvars.f);
		}
		else{
			document.title="正在播放恋恋视频："+flashvars.Title;
		}
	}
	
	</script>
	</body>
</html>