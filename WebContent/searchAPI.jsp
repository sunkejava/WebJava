<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="css/searchapi.css" type="text/css">
<script src="js/2124512.js"></script>
<title>搜索页</title>
</head>
<body>
	<div class="search-box">
		<div class="search-container">
			<div class="search-pannel">
				<form action="search" method="post">
					<input id="searchtype" name = "searchtype" type="hidden" value="YY">
					<div id="search_tab" class="search-list">
						<select name="type" id="select" class="select"
							onchange="gradeChange(this.value)">
							<option selected="selected" value="1">YY神曲</option>
							<option value="2">51AVI</option>
							<option value="3">音悦台</option>
							<option value="4">恋恋影视</option>
						</select>
					</div>
					<div class="search-button">
						<button class="btn-search" type="submit" onclick="getjs()">搜索</button>
					</div>
					<div class="search-common-pannel">
						<input class="searchContext" id="searchContext" name = "searchContext" type="text"
							placeholder="输入主播YY号" value="${searchContext}">
					</div>
				</form>
				<a>${error }</a>
			</div>
		</div>
		<div id = "textbox" class = "textbox">
		<h2 class="textshow">精品推荐</h2>
		<div id = "hot-text"class="hot-text">
			<ul>
				<li><div class="text-li">
						<h3>
							<a href="http://www.iying.tv/info/243-1-1.html" target="_blank"
								class="s-yahei">[国产]老九门全集在线观看</a>
						</h3>
					</div></li>
				<li><div class="text-li">
						<h3>
							<a
								href="/bt/5fcf15b02705abc7546022414e3d1b0886611ec11397962.html"
								target="_blank" class="s-yahei">魔兽.魔兽世界(韩版).HD720P.X264.AAC.中英字幕
							</a>
						</h3>
					</div></li>
				<li><div class="text-li">
						<h3>
							<a
								href="/bt/7de9e466edbc54f5f194ac2adcf58daa3011e3e01380948.html"
								target="_blank" class="s-yahei">愤怒的小鸟Angry.Birds.2016.BD720P.X264.AAC.中文字幕</a>
						</h3>
					</div></li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/82021da5c2a14c755f98cb42fc52b80e44136d031351389.html"
								target="_blank" class="s-yahei">美人鱼.Mermaid.2016.HD720P.X264.AAC.Mandarin.CHS</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/3e074745384cfb47e1bf53fe6c3dea0346734bab1355768.html"
								target="_blank" class="s-yahei">星球大战7.原力觉醒.Star.Wars.Episode.VII.The.Force.Awakens.2015.1080p</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/84c3f98216e61d385abdcc78b1d23638d533ea331381225.html"
								target="_blank" class="s-yahei">功夫熊猫3.Kung.Fu.Panda.3.2016.HD1280超清英语中韩双字</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/355c1ba4ebefef30f89cd244db6995702d21d0ad1285978.html"
								target="_blank" class="s-yahei">The.33.2015.地心营救.720p.Chi_Eng.BD-MP4</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/3b9769fac32fdb973cd10453d382571542baff751370136.html"
								target="_blank" class="s-yahei">老炮儿.Mr.Six.2015.HD-720.国语中字</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a
								href="/bt/83124820ed1e6b3725dc63718cc0c9f364036d1b1315321.html"
								target="_blank" class="s-yahei">鬼吹灯之寻龙诀.The
								Ghouls[2015.1080P.高清国语.mkv].mkv</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a href="/main-show-id-7031953.html" target="_blank"
								class="s-yahei">[万万没想到：西游篇][2015][大陆][奇幻][国语中字][1080P]</a>
						</h3>
					</div>
				</li>
				<li>
					<div class="text-li">
						<h3>
							<a href="/so/神探夏洛克-first-asc-1" target="_blank" class="s-yahei">2015年英国IMDb8.7分悬疑犯罪片《神探夏洛克》HD</a>
						</h3>
					</div>
				</li>
			</ul>
		</div>
		</div>
		<div id = "tagsbox"class="tagsbox">
			<h2 class="textshow">热门标签</h2>
			<div id = "tagscloud" class="tagscloud">
			<a href="http://www.17sucai.com/" target="_blank" class="tagc1">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc2">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc3">银行贷款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc4">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc5">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc6">不孕不育</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc1">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc2">银行贷款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc3">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc4">房贷利率2013</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc5">银行存款利率表</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc6">银行贷款利率表</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc1">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc2">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc3">银行贷款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc4">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc5">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc6">不孕不育</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc1">银行存款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc2">银行贷款利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc3">银行利率</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc4">房贷利率2013</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc5">银行存款利率表</a>
			<a href="http://www.17sucai.com/" target="_blank" class="tagc6">银行贷款利率表</a>
		</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function show() {
		var random_bg = parseInt(Math.random() * 66);
		var bg = 'url(images/bg-' + random_bg + '.jpg)';
		$("body").css("background-image", bg);
		document.getElementById("tagsbox").style.height=document.getElementById("textbox").offsetHeight+"px";
		document.getElementById("tagscloud").style.marginTop = "-"+document.getElementById("textbox").offsetHeight+"px";
	}
</script>
<script src='js/tagscloud.js' type="text/javascript"></script>
<script src="js/jquery-1.10.2.min.js"></script>
</html>