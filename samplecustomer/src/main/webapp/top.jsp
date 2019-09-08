<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>トップページ</h1>
トップページ
<ul>
	<li><a href="user/user.jsp">一般ユーザー用ページ</a></li>
	<li><a href="admin/admin.jsp">管理者専用ページ</a></li>
</ul>
<form action="logout" method="post">
	<button>ログアウト</button>
</form>
</body>
</html>