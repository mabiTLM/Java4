<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.Date"
    pageEncoding="UTF-8"%>
    
    <%-- webapp/c231010/jstl-test/fmt-test/index.jsp --%>
    <%-- fmt : format, 언어 형식 --%>
    <%-- JSTL : c, fmt, sql, x(XML), fn(function) --%>

<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원하는 언어로 즉각적인 적용</title>
</head>
<body>

<fmt:setLocale value = "en_US" />

<%--
<fmt:setLocale value = "en_US" />
<fmt:setLocale value = "ja_JP" />
<fmt:setLocale value = "zh_CN" />
 --%>
 
 <div id="locale" data-locale="ko_KR">
 <div id="name" data-name="test_ko.name"></div>
 <%-- 파일의 위치는 WEB-INF/classes/student.properties --%>
 <%-- 파일의 위치는 WEB-INF/classes/student_ko.properties --%>
 <%-- 파일의 위치는 WEB-INF/classes/student_en.properties --%>
 </div>
 
 <fmt:bundle basename="student">
 <fmt:message key="student.name"/><br/>
 <fmt:message key="student.className"/><br/>
 </fmt:bundle>
 
 <fmt:setLocale value = "ko_KR" />
 <fmt:setBundle basename="student"/>
 <fmt:message key="student.name"/><br/>
 <fmt:message key="student.className"/><br/>
<%-- l18n --%>
<fmt:formatNumber value="1000" type="number" var="won"/>
${won }<br/>
<fmt:formatNumber value="1000" type="currency" currencySymbol="\\" groupingUsed="true" />
 <br/>
 <c:set var="now" value="<%= new Date() %>" />
 ${now }<br/>
  <fmt:formatDate value = "${now }" pattern= "YYYY/MM/dd - hh:mm:ss"/><br/>
 <fmt:timeZone value="America/New York">
 <fmt:formatDate value = "${now }" type="time" dateStyle="full" timeStyle="full"/><br/>
 <fmt:formatDate value = "${now }" pattern= "YYYY/MM/dd - hh:mm:ss"/><br/>
 </fmt:timeZone>
</body>
</html>