<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="col-lg-4 col-lg-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title text-center"><strong><spring:message code="login.form.title"></spring:message></strong></h3>
				</div>
				<div class="panel-body">
				<c:url value="/login" var="loginUrl"></c:url>
					<form action="${loginUrl }" method="POST" class="form-horizontal">
						<c:if test="${param.errors != null }">
							<div class="alert alert-danger">
								<p>username or password incorrect</p>
							</div>
						</c:if>
						<c:if test="${param.accessDenied != null }">
							<div class="alert alert-danger">
								<p>Sorry! You are not authorized</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null }">
							<div class="alert alert-success">
								<p>You are logged out successfully</p>
							</div>
						</c:if>
						<div class="input-group">
							<label class="input-group-addon"><span class="glyphicon glyphicon-user"></span></label>
							<input class="form-control" type="text" placeholder="<spring:message code='login.form.username'></spring:message>" id="username" name="username">
						</div>
						<div class="input-group">
							<label class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></label>
							<input class="form-control" type="password" placeholder="<spring:message code='login.form.password'></spring:message>" id="password" name="password">
						</div>
						<div class="form-action">
							<button type="submit" class="btn btn-primary btn-block"><spring:message code="login.form.button"></spring:message></button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>