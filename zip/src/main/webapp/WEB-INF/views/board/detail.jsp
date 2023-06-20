<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/detail.css">
<title>DETAIL</title>

</head>
<body>

	<c:set var="board" value="${boardDTO.bvo }"></c:set>
	<table border="2">
		<tr>
			<th>번호</th>
			<td>${board.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.read_cnt }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.reg_date }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.content }</td>
		</tr>
	</table>

	<div>
		<c:set var="flist" value="#{boardDTO.flist }"></c:set>
		<ul>
			<c:forEach items="${flist }" var="fvo">
				<li><c:choose>
						<c:when test="${fvo.file_type > 0 }">
							<div>
								<img alt="XXX"
									src="/upload/${fn:replace(fvo.save_dir, '\\','/') }/${fvo.uuid}_th_${fvo.file_name}">
							</div>
						</c:when>
						<c:otherwise>
							<div></div>
						</c:otherwise>
					</c:choose>
					<div>
						<div>${fvo.file_name }</div>
						${fvo.reg_date }
					</div> <span>${fvo.file_size } Bytes</span></li>
			</c:forEach>
		</ul>
	</div>
	<br>
	<br>
	<br>

	<a href="/board/list">
		<button class="button">목록</button>
	</a> &nbsp &nbsp &nbsp




	<c:if test="${ses != null && ses.id == board.writer }">

		<a href="/board/modify?bno=${board.bno }">
			<button class="button">수정</button>
		</a> &nbsp &nbsp &nbsp
<a href="/board/delete?bno=${board.bno }">
			<button class="button">삭제</button>
		</a> &nbsp &nbsp &nbsp
</c:if>
	<br>
	<br>
	<br>
	<br>
	<hr>


	<div>

		<div>
			<span id="cmtWriter">${ses.id }</span> :: <input type="text"
				id="cmtText" placeholder="댓글작성"> &nbsp &nbsp
			<button type="button" id="cmtPostBtn" class="button">댓글등록</button>
		</div>





		<div>

			<ul id="cmtListArea">
				<li>
					<div>
						<div>작성자</div>
						댓글내용
					</div> <span>등록날짜</span>
				</li>
			</ul>
		</div>
	</div>
	<hr>




	<script type="text/javascript">
		const bnoVal = '<c:out value="${boardDTO.bvo.bno}" />';
		console.log(" >>>>> bno >>>>> : " + bnoVal);
	</script>
	<script type="text/javascript" src="/resources/js/comment.js"></script>
	<script type="text/javascript">
		getCmtList(bnoVal);
	</script>

</body>
</html>