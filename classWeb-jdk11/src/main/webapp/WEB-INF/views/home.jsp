<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>
		Hello
		<c:choose>
			<c:when test="${userName != null}">${userName}</c:when>
			<c:otherwise>world!
				<form action="/login" method="post">
					<label for="user-id">
						ID :
						<input type="text" name="user-id" id="user-id">
					</label>
					<label for="user-pw">
						Password :
						<input type="password" name="user-pw" id="user-pw">
					</label>
					<button>로그인</button>
				</form>
			</c:otherwise>
		</c:choose>
	</h1>



	<c:choose>
		<c:when test="${userName != null}">
			<form action="/logout" method="post">
				<button>로그아웃</button>
			</form>
		</c:when>
	</c:choose>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
