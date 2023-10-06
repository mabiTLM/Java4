<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
List list = (ArrayList) request.getAttribute("list");
String name1 =(String) request.getAttribute("name");
Integer num1 =(Integer)request.getAttribute("num");
String hobby1 =(String) request.getAttribute("hobby");
%>

<table>
<tr>
<th>번호</th>
<th>이름</th>
<th>취미</th>
</tr>
<%--
for(int i = 0; i < list.size(); ++i)
--%>
<tr>
<th><%=num1 %></th>
<th><%=name1 %></th>
<th><%=hobby1 %></th>
</tr>

<tr>
<th><%=num1 %></th>
<th><%=request.getParameter("name") %></th>
<th><%=hobby1 %></th>
</tr>


</table>