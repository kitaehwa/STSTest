<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>loginForm.jsp</h1>
	
	<fieldset>
		<legend>로그인</legend>
		<form method="post"> <!-- action 속성이 없을 때 자신의 주소를 호출  -->
			아이디 : <input type="text" name="userid"><br>
			비밀번호 : <input type="password" name="userpw"><br>
			<input type="submit" value="로그인">
	</fieldset>
</body>
</html>