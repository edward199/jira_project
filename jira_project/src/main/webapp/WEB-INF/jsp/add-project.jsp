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
	<h3>Welcome, Enter The Project Details</h3>
	<form:form method="POST" action="/jira_project/project/addProject"
		modelAttribute="project">
		<table>
			<tr>
				<td><label>Description</label></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Leader</label></td>
				<td><form:input path="leader" /></td>
				<td><form:errors path="leader" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Project Key</label></td>
				<td><form:input path="projectKey" /></td>
				<td><form:errors path="projectKey" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Project Name</label>
				<td><form:input path="projectName" /></td>
				<td><form:errors path="projectName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Project Type</label>
				<td><form:input path="projectType" /></td>
				<td><form:errors path="projectType" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Url</label>
				<td><form:input path="url" /></td>
				<td><form:errors path="url" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Project"
					id="addProjectButton" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>