<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="/resources/css/home.css">
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<body>
	<jsp:include page="./layout/header.jsp"></jsp:include>

	<c:if test="${ses.id == null }">
		<a href="/member/login">
			<button type="button">Login</button>
		</a>
		<a href="/member/signup">
			<button type="button">Sign Up</button>
		</a>

	</c:if>

	<c:if test="${ses.id != null}">
		<h1>${ses.id } _ WelCome:)</h1>
	</c:if>
	<c:if test="${ses.id != null }">
		<a href="/member/logout">
			<button type="button">Log Out</button>
		</a>
		<a href="/board/register">
			<button type="button">게시글 작성</button>
		</a>
		<a href="/board/list">
			<button type="button">게시글 보기</button>
		</a>
	</c:if>

	


	<script type="text/javascript">
		const msg_login = '<c:out value="${msg_login}" />';
		const msg_logout = '<c:out value="${msg_logout}" />';
		console.log(msg_login);
		console.log(msg_logout);
		if (msg_login === '0') {
			alert('로그인실패');
		}
		if (msg_logout === '1') {
			alert('로그아웃 되었습니다');
		}
	</script>
	<br>
	<br>
	<jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>