<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<div class="jumbotron text-center text-primary">Welcome to
		Metacube Parking System</div>
	<div class="row">
		<div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3">
			<div class="card">
			  <h5 class="card-header">Edit Details</h5>
			  <form:form modelAttribute="endUser" class="card-body" method="post" action="/update-end-user">
			  	<div class="form-group row">
				    <form:label class="col-4" path="username">Username</form:label>
				    <span class="col-8"><sec:authentication property="principal.username"/></span>
				    <form:input type="hidden" path="username" class="form-control" id="username" />
				</div>
			    <div class="form-group row">
				    <form:label class="col-4" path="password">Password</form:label>
				    <form:input type="password" path="password" class="col-8 form-control" id="password" />
				</div>
				
				<sec:authorize access="hasAuthority('ADMIN')">
					<div class="form-group row">
						<label class="col-4">Role</label>
						<div class="col-8">
							<div class="form-check">
							  <form:radiobutton class="form-check-input" path="roles" id="adminCheck" value="ADMIN" />
							  <form:label class="form-check-form:label" path="roles" for="adminCheck">
							    ADMIN
							  </form:label>
							</div>
							<div class="form-check">
							  <form:radiobutton class="form-check-input" path="roles" id="userCheck" value="USER" />
							  <form:label class="form-check-form:label" path="roles" for="userCheck">
							    USER
							  </form:label>
							</div>
						</div>
					</div>
				</sec:authorize>
				
				<sec:authorize access="hasAuthority('USER')">
					<form:input type="hidden" path="roles" id="roles" />
				</sec:authorize>
				<form:input type="hidden" path="active" value="1" />
			    <form:button class="btn btn-primary">Submit</form:button>
			  </form:form>
			</div>
		</div>
	</div>
</div>

<script>
	document.getElementById("username").value = `<sec:authentication property="principal.username" />`;
	document.getElementById("password").value = `<sec:authentication property="principal.password" />`;
	var roles = `<sec:authentication property="principal.authorities" />`.slice(5,-5);
	<sec:authorize access="hasAuthority('ADMIN')">
	document.getElementById(roles.toLowerCase()+"Check").checked = true;
	</sec:authorize>
	document.getElementById("roles").value = roles;
	<sec:authorize access="hasAuthority('ADMIN')">
		
	</sec:authorize>
</script>
<%@ include file="../includes/footer.jsp"%>