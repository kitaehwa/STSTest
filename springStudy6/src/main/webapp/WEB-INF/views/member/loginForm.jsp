<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>

*{
    padding: 0;
    margin: 0;
    border: none;
}
body{
    font-size: 14px;
    font-family: 'Roboto', sans-serif;
}

.login-wrapper{
    width: 400px;
    height: 350px;
    padding: 40px;
    box-sizing: border-box;
    position: absolute;
    text-align: center;
  	margin-left: -200px;
  	margin-top: -200px;
  	left: 50%;
  	top: 40%;
}

.login-wrapper > h2{
    font-size: 24px;
    color: #0055FF;
    margin-bottom: 20px;
}
#login-form > input{
    width: 100%;
    height: 48px;
    padding: 0 10px;
    box-sizing: border-box;
    margin-bottom: 16px;
    border-radius: 6px;
    background-color: #F8F8F8;
}
#login-form > input::placeholder{
    color: #D2D2D2;
}
#login-form > input[type="submit"]{
    color: #fff;
    font-size: 16px;
    background-color: #0055FF;
    margin-top: 20px;
}

#login-form > input[type="checkbox"]{
    display: none;
}
#login-form > label{
    color: #999999;
}
#login-form input[type="checkbox"] + label{
    cursor: pointer;
    padding-left: 26px;
    background-image: url("checkbox.png");
    background-repeat: no-repeat;
    background-size: contain;
}
#login-form input[type="checkbox"]:checked + label{
    background-image: url("checkbox-active.png");
    background-repeat: no-repeat;
    background-size: contain;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-wrapper">
		<h2>login</h2>
			<form method="post" id="login-form"> <!-- action 속성이 없을 때 자신의 주소를 호출  -->
				<input type="text" name="userid" placeholder="사원번호"><br>
				<input type="password" name="userpw" placeholder="비밀번호"><br>
				<label for="remember-check">
                <input type="checkbox" id="remember-check"> 사원번호 저장</label>	
				<input type="submit" value="로그인">
         	  		   
                <a href="">비밀번호를 잊으셨나요??</a>
	</div>	
</body>
</html>
