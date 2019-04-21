<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="col-lg-offset-2 col-lg-8">
			<form:form method="POST" modelAttribute="newProduct" class="form-horizontal">
				<form:errors path="*" element="div" cssClass="alert alert-danger"/>
				<fieldset>
					<legend>Add New Product</legend>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="productId"><spring:message code="addNewProduct.form.productId.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="productId" id="productId" type="text" class="form:input-large"/>
							<form:errors path="productId" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="name"><spring:message code="addNewProduct.form.name.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="name" id="name" type="text" class="form:input-large"/>
							<form:errors path="name" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="unitPrice"><spring:message code="addNewProduct.form.unitPrice.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="unitPrice" id="unitPrice" type="number" class="form:input-large"/>
							<form:errors path="unitPrice" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="manufacturer"><spring:message code="addNewProduct.form.manufacturer.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="manufacturer" id="manufacturer" type="text" class="form:input-large"/>
							<form:errors path="manufacturer" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="category"><spring:message code="addNewProduct.form.category.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="category" id="category" type="text" class="form:input-large"/>
							<form:errors path="category" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="description"><spring:message code="addNewProduct.form.description.label"></spring:message></label>
						<div class="col-lg-6">
							<form:input path="description" id="description" type="text" class="form:input-large"/>
							<form:errors path="description" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="condition"><spring:message code="addNewProduct.form.condition.label"></spring:message></label>
						<div class="col-lg-6">
							<form:radiobutton path="condition" id="condition" value="New"/> New 
							<form:radiobutton path="condition" id="condition" value="Old"/> Old 
							<form:radiobutton path="condition" id="condition" value="Refurbished"/> Refurbished 
							<form:errors path="condition" cssClass="text-danger"></form:errors>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2" for="discontinued"><spring:message code="addNewProduct.form.discontinued.label"></spring:message></label>
						<div class="col-lg-6">
							<form:checkbox path="discontinued" id="discontinued"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-lg-2"></div>
						<div class="col-lg-6">
							<input type="submit" class="btn btn-primary" value="Submit">
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>