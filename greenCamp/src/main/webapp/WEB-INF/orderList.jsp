<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>사이즈</th>
			<th>가격</th>
		</tr>


		<c:choose>
			<c:when test="${empty requestScope.orders || fn:length(orders) == 0}">
				<tr>
					<td>주문된 차 정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.orders}" var="orderlist">
					<tr>
						<td>${orderlist.id}</td>
						<td>${orderlist.name}</td>
						<td>${orderlist.size}</td>
						<td>${orderlist.price}</td>
						<td>${orderlist.quantity}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>

	</table>

</body>
</html>