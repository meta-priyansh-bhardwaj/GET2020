<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../includes/header.jsp" %>

	<div class="container form-container">
			<form:form modelAttribute="student" action="addStudent">
	
			<form:errors />
			<!-- <form:hidden path="id"/> -->
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" type="text" class="form-control"
					id="exampleInputFirstName1" placeholder="First Name" />
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" type="text" class="form-control"
					id="exampleInputLastName1" placeholder="Last Name" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="fatherName">Father's Name</form:label>
				<form:input path="fatherName" type="text" class="form-control"
					id="exampleInputFatherName1" placeholder="Father's Name" />
				<form:errors path="fatherName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control"
					id="exampleInputEmail1" placeholder="Email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="standard">Class</form:label>
				<form:input path="standard" type="text" class="form-control"
					id="exampleInputClass1" placeholder="Class" />
				<form:errors path="standard" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="age">Age</form:label>
				<form:input path="age" type="text" class="form-control"
					id="exampleInputAge1" placeholder="Age" />
				<form:errors path="age" cssClass="text-danger" />
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>		
		
		</form:form>
	</div>
	
<%@ include file="../includes/footer.jsp" %>