<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tea Menu</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

</head>
<body>
	<h1>Tea Menu</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Size</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tea" items="${teas}">
				<tr>
					<td>${tea.name}</td>
					<td>${tea.size}</td>
					<td>${tea.price}</td>
					<td><a href="<c:url value='/teas/edit?id=${tea.id}'/>">Edit</a>
						<a href="<c:url value='/teas/delete?id=${tea.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h2>Add New Tea</h2>
	<h2>신규 티 추가</h2>
	<form action="teas/add" method="POST">
		<label for="tea-name">티 이름:</label> <input type="text" id="tea-name"
			name="teaName">
		<p>티 사이즈를 선택하세요 :)</p>
		  <input type="radio" id="tall" name="teaSize" value="TALL">  
		<label for="tall">TALL</label><br>   <input type="radio"
			id="grande" name="teaSize" value="GRANDE">   <label
			for="grande">GRANDE</label><br>   <input type="radio" id="venti"
			name="teaSize" value="VENTI">   <label for="venti">VENTI</label>
		<br />
		<br /> <label for="tea-price">가격:</label> <input type="number"
			id="tea-price" name="teaPrice"> <br />
		<br />
		<button type="submit">추가하기</button>
	</form>
</body>
</html>
