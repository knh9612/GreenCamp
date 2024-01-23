<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>신규 티 추가</h2>
    <form action="teas/add" method="POST">
        <label for="tea-name">티 이름:</label>
        <input type="text" id="tea-name" name="teaName">
        <p>티 사이즈를 선택하세요 :)</p>
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
        <button type="submit">추가하기</button>
    </form>
</body>
</html>