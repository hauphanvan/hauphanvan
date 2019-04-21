<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<c:forEach items="${products }" var="product">
				<div class="col-lg-4">
					<div class="thumbnail">
						<img alt="image" src='<c:url value="/img/${product.productId }.png"></c:url>' style="width:100%">
						<div class="caption">
							<h3>${product.name }</h3>
							<p>${product.productId }</p>
							<p>${product.unitPrice }</p>
							<p>Available: ${product.unitsInStock }</p>
							<a href='<c:url value="/product/product?id=${product.productId }"></c:url>' class="btn btn-primary">Detail</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>