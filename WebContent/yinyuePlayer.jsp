<%@ page language="java" import="javax.servlet.*,com.sunkejava.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/ckplayer.css" type="text/css">
<script type="text/javascript" src="ckplayer/ckplayer.js" charset="utf-8"></script>
<script src="js/2124512.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<%
response.setContentType("text/html");
request.setCharacterEncoding("utf-8");
String a = request.getParameter("a");
String b = request.getParameter("b");
String c = request.getParameter("c");
String d = request.getParameter("d");
//d=java.net.URLDecoder.decode(d,"utf-8");
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
	<input id="searchtype" name = "searchtype" type="hidden" value="${searchtype}">
<input id="searchContext" name = "searchContext" type="hidden" value="${searchContext}">
	<script type="text/javascript">
	function loadedHandler(){
		if(CKobject.getObjectById('ckplayer_a1').getType()){//说明使用html5播放器
			document.title="正在播放:"+flashvars.Title;
		}
		else{
			document.title="正在播放:"+flashvars.Title;
		}
	}
	
	var flashvars={
		f:'<%= a %>',
		a:'',
		s:'0',
		c:'0',
		x:'',
		i:'',
		e:'3',
		v:'50',
		p:'0',
		h:'3',
		wh:'4:3',
		lv:'0',
		Title:'<%= d %>',
		deft:'流畅432P,高清540P,超清720P',
		deff:'<%= a %>|<%= b %>|<%= c %>',
		loaded:'loadedHandler'
		};
	var params={bgcolor:'#FFF',allowFullScreen:true,allowScriptAccess:'always'};//这里定义播放器的其它参数如背景色（跟flashvars中的b不同），是否支持全屏，是否支持交互
	var video=['<%= a %>->video/mp4'];
	CKobject.embed('ckplayer/ckplayer.swf','a1','ckplayer_a1','100%','100%',false,flashvars,video,params);
	</script>
	</body>
</html>