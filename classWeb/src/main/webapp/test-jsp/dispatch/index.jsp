<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("name", "디스패치 테스트중");
RequestDispatcher dispatch = request.getRequestDispatcher("./index1.jsp");
dispatch.forward(request,response);
%>

</body>
</html>