<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
	<h3>Welcome, Enter The User Details</h3>
	<form:form method="POST" action="/jira_project/user/registerUser" modelAttribute="user">
		<table>
			<tr>
				<td><label>Username</label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><label>Active</label></td>
				<td><form:input path="active" /></td>
			</tr>
			<tr>
				<td><label>First Name</label>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><label>Last Name</label>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><label>Display Name</label>
				<td><form:input path="displayName" /></td>
			</tr>
			<tr>
				<td><label>Email Address</label>
				<td><form:input path="emailAddress" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>