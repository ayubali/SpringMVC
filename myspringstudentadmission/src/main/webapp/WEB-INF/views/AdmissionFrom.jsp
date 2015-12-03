<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/myspringstudentadmission/admissionFrom.html?siteLanguage=en">English</a>||
	<a href="/myspringstudentadmission/admissionFrom.html?siteLanguage=fr">French</a>
	<h1>${headerMessage}</h1>
	<h3>
		<spring:message code="label.admissionForm" />
	</h3>
	<form:errors path="student1.*"></form:errors>
	<form
		action="/myspringstudentadmission/submitAdmissionFormModelAttribute2.html"
		method="post">
		<table>
			<tr>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" id="studentName" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentHobby" /></td>
				<td><input name="studentHobby" id="studentHobby" type="text" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentMobile" /></td>
				<td><input name="studentMobile" id="studentMobile" type="text" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.studentDOB" /></td>
				<td><input name="studentDOB" id="studentDOB" type="text" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.rollNumber" /></td>
				<td><input name="rollNumber" id="rollNumber" type="text" /></td>
			</tr>

			<tr>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select name="studentSkills" id="studentSkills"
					multiple="multiple">
						<option value="Java Core">Java Core</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring mvc">Spring mvc</option>
				</select></td>
			</tr>


			<tr>
				<td><spring:message code="label.studentAddress" /></td>
				<td>

					<table>
						<tr>
							<td><spring:message code="label.studentAddress.country" /></td>
							<td><input type="text" name="studentAddress.country"
								id="studentAddress.country"></td>
						</tr>
						<tr>
							<td><spring:message code="label.studentAddress.city" /></td>
							<td><input type="text" name="studentAddress.city"
								id="studentAddress.city"></td>
						</tr>
						<tr>
							<td><spring:message code="label.studentAddress.street" /></td>
							<td><input type="text" name="studentAddress.street"
								id="studentAddress.street"></td>
						</tr>
						<tr>
							<td><spring:message code="label.studentAddress.pincode" /></td>
							<td><input type="text" name="studentAddress.pincode"
								id="studentAddress.pincode"></td>
						</tr>
					</table>

				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="submit" /></td>
			</tr>



		</table>
	</form>
</body>
</html>