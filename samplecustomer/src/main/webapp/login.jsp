<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ログインページ</h1>

<%-- エラーメッセージの表示 --%>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	ログインエラーです<br>
	例外型：${SPRING_SECURITY_LAST_EXCEPTION.getClass().name}<br>
	メッセージ:${SPRING_SECURITY_LAST_EXCEPTION.message}<br>
	<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
</c:if>

<form action="processLogin" method="post">
	<dl>
		<dt>
			ログイン
		</dt>
		<dd>
			<input type="text" name="paramLoginId">
		</dd>
		<dt>
			パスワード
		</dt>
		<dd>
			<input type="password" name="paramPassword">
		</dd>
	</dl>
	<button>ログイン</button>
</form>
</body>
</html>