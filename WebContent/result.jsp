<%@ page language="java" import="net.sf.json.JSONArray,com.sunkejava.api.*,com.sunkejava.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String searchContext = request.getParameter("searchContext");
String searchType = request.getParameter("searchtype");
if(searchContext == "" || searchContext == null || searchType == "" || searchType == null){
response.sendRedirect("404.jsp");
}else{
	StringUtil str = new StringUtil();
	DataJsonp datajsp = new DataJsonp();
	searchType = new String(str.decode(searchType));
	searchContext = new String(str.decode(searchContext));
	if(searchType.equalsIgnoreCase("YINYUETAI")){
		out.print(datajsp.GetDate("YINYUETAI",searchContext));
	}else if(searchType.equalsIgnoreCase("YY")){
	out.print(datajsp.GetDate(searchType.replaceAll(" ", ""),searchContext));
	}
}
%>