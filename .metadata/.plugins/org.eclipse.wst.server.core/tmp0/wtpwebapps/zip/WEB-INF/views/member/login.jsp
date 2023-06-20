<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
<form action="/member/login" method="post">

    <label for="id">ID</label>
    <input type="text" id="id" name="id" placeholder="id"> <br> <br>
    <label for="pw">PW</label>
    <input type="password" id="pw" name="pw" placeholder="password"> <br> <br>
    <button type="submit">Login</button>

</form>
</body>
</html>