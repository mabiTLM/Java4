<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- views/user/regist.jsp --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/regist" method="post">
		<label for="user-id">
			ID :
			<input type="text" name="user-id" id="user-id">
		</label>
		<label for="user-pw">
			Password :
			<input type="password" name="user-pw" id="user-pw">
		</label>
		<label for="user-name">
			Name :
			<input type="text" name="user-name" id="user-name">
		</label>
		<button>회원가입</button>
	</form>
</body>
</html>