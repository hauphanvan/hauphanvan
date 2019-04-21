<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="col-lg-6">
			<img alt="image" src='<c:url value="/img/${product.productId }.png"></c:url>' style="width:100%">
			<h3>Name: ${product.name }</h3>
			<p>ID: ${product.productId }</p>
			<p>Price: ${product.unitPrice } USD</p>
			<p>Manufacturer: ${product.manufacturer }</p>
			<p>Category: ${product.category }</p>
			<p>Available: ${product.unitsInStock }</p>
			<p>Units In Order: ${product.unitsInOrder }</p>
			<p>Condition: ${product.condition }</p>
		</div>
	</div>