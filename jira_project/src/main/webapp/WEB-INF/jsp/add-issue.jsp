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
	<h3>Welcome, Enter The Issue Details</h3>
	<form:form method="POST" action="/jira_project/project/issue/addIssue"
		modelAttribute="issue">
		<table>
			<tr>
				<td><label>Parent Id</label></td>
				<td><form:input path="parentId" /></td>
			</tr>
			<tr>
				<td><label>Project Key</label></td>
				<td><form:input path="projectKey" /></td>
				<td><form:errors path="projectKey" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Issue Number</label></td>
				<td><form:input path="issueNumber" /></td>
				<td><form:errors path="issueNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Project Id</label></td>
				<td><form:input path="projectId" /></td>
				<td><form:errors path="projectId" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Reporter</label>
				<td><form:input path="reporter" /></td>
				<td><form:errors path="reporter" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Creator</label>
				<td><form:input path="creator" /></td>
				<td><form:errors path="creator" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Summary</label>
				<td><form:input path="summary" /></td>
				<td><form:errors path="summary" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Description</label>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Duedate</label>
				<td><form:input path="duedate" type="date" /></td>
				<td><form:errors path="duedate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Time Estimate</label>
				<td><form:input path="timeEstimate" /></td>
				<td><form:errors path="timeEstimate" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Time Spent</label>
				<td><form:input path="timeSpent" /></td>
				<td><form:errors path="timeSpent" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Issue" id="addIssueButton" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>