<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>기존 티 수정</h2>
    <form action="teas/update" method="POST">
        <label for="tea-id">수정할 티 id:</label>
        <input type="text" id="tea-id" name="teaId">
        <label for="tea-name">티 이름:</label>
        <input type="text" id="tea-name" name="teaName">
        <p>티 사이즈 </p>
          <input type="radio" id="tall" name="teaSize" value="TALL">
          <label for="tall">TALL</label><br>
          <input type="radio" id="grande" name="teaSize" value="GRANDE">
          <label for="grande">GRANDE</label><br>
          <input type="radio" id="venti" name="teaSize" value="VENTI">
          <label for="venti">VENTI</label>
        <br /><br />
        <label for="tea-price">가격:</label>
        <input type="number" id="tea-price" name="teaPrice">
        <br /><br />
        <button type="submit">수정하기</button>
    </form>
</body>
</html>