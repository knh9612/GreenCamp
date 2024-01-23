<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메뉴 삭제 페이지</h2>
		<form action="teas/delete" method="POST">
        <label for="tea-del-id">티 아이디 번호:</label>
        <input type="text" id="tea-del-id" name="delId">
        <br /><br />
        <button type="submit">삭제하기</button>
    </form>
</body>
</html>