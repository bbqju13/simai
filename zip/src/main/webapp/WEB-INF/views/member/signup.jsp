<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/signup.css">
</head>
<body>
	<form action="/member/signup" method="post">
		ID : <input type="text" name="id" placeholder="아이디">
		PW : <input type="password" name="pw" placeholder="비밀번호">
		NAME : <input type="text" name="name" placeholder="이름">
		BIRTH : <input type="text" name="birth" placeholder="1999-12-31">
		AGE : <input type="text" name="age" placeholder="나이">
		EMAIL : <input type="email" name="email" placeholder="abcd@abcd.com">
		ADDR : <input type="text" name="addr" placeholder="주소">
		<button>가입</button>
	</form>
</body>
</html>