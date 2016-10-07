<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/as2.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/showBo.css" />
<script type="text/javascript" src="js/showBo.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/2124512.js"></script>
<title>搜索YY号为：${searchContext}的YY神曲</title>
</head>
<body onload="show()">
		<div class = "bg-div">
			<div class = "search-box">
			<div class = "logo"></div>
			<div class="search-container">
			<div class="search-pannel">
				<form action="search" method="post">
					<input id="searchtype" name = "searchtype" type="hidden" value="${searchtype}">
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
			</div>
		</div>
<div id = "wrapper" class="wrapper">
    <div class="works-tab-body">
      <ul class="cf">
			<!-- MV -->
        <li class="works-tc-item shenqu active">
            <div id = "video-model" class="shenqu-non-empty"><div class="col-list">
            		<div id="cse2"><div id="loading" style="text-align:center; font-size:15px; width:auto; height:60px; width:100%;"><img src="images/loading.gif" /> 正在加载数据，请稍后....请不要离开...</div></div>
                    <ul class="video-user-list">               
					</ul>
                  </div>
                  <div class="shenqu-foot">
                    <div id="paginator" class="paginator"> </div>
                  </div>
                </div>
              </li>
              </div>
      </ul>
    </div>
					<div class="page-box">
					<div id="paed" class="jogger">
						  <ul>
						  </ul>
					</div>
					</div>
</body>
<script type="text/javascript"> 
</script>
</html>