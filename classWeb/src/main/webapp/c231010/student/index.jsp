<%@ page language="java" contentType="text/html; charset=UTF-8"
import="webClass231006.StudentBean"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id ="student" class="webClass231006.StudentBean"/>
<jsp:setProperty name="student" property="*"/>
<jsp:useBean id ="students" class="java.util.ArrayList" scope="page"/>
<jsp:useBean id ="students2" class="java.util.ArrayList" scope="page"/>
<jsp:useBean id ="studentsMap" class="java.util.HashMap" scope="page"/>
<jsp:useBean id ="studentsMap2" class="java.util.HashMap" scope="page"/>
    
<%
students.add(new StudentBean("한"));
students.add(new StudentBean("임"));
request.setAttribute("students",students);
request.setAttribute("error",false);
studentsMap.put("students",students);
studentsMap.put("error",false);
request.setAttribute("studentsMap",studentsMap);

students2.add(new StudentBean("김"));
students2.add(new StudentBean("이"));
studentsMap2.put("students",students2);
request.setAttribute("studentsMap",studentsMap2);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
${empty student }<br />
--%>
${empty students }<br />
<%--
<%=request.getParameter("name") %><br />
${param.name }<br />
<%=student.getName() %><br />
 ${student.name }<br />
 --%>
${students[0].name }<br />
<jsp:forward page="../student2/index.jsp"></jsp:forward>

<%-- ${student.length }<br /> --%>
</body>
</html>