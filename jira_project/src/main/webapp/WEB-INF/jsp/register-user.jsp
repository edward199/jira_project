<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<style>
.error {
	color: red
}
</style>
<title></title>
</head>
<body>
	<h3>Welcome, Enter The User Details</h3>
	<form:form method="POST" action="/jira_project/user/registerUser"
		modelAttribute="user">
		<table id="userRegisterFields">
			<tr>
				<td><label>Username</label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input path="password" type="password" /></td>
			</tr>
			<tr>
				<td><label>Active</label></td>
				<td><form:input path="active" /></td>
			</tr>
			<tr>
				<td><label>First Name</label>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Last Name</label>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Display Name</label>
				<td><form:input path="displayName" /></td>
				<td><form:errors path="displayName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Email Address</label>
				<td><form:input path="emailAddress" /></td>
				<td><form:errors path="emailAddress" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register User"
					id="registerUser" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>