<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2 class="alert alert-danger">${message }</h2>
	</div>
	<a href='<c:url value="/product/products"></c:url>' class="btn btn-primary"><span class="glyphicon glyphicon-hand-left"></span> Products</a>