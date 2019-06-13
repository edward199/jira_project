<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<h3>Welcome, Enter The Issue Details</h3>
	<form:form method="POST"
		action="/jira_project/project/issue/addIssue"
		modelAttribute="issue">
		<table>
			<tr>
				<td><label>Parent Id</label></td>
				<td><form:input path="parentId" /></td>
			</tr>
			<tr>
				<td><label>Project Key</label></td>
				<td><form:input path="projectKey" /></td>
			</tr>
			<tr>
				<td><label>Issue Number</label></td>
				<td><form:input path="issueNumber" /></td>
			</tr>
			<tr>
				<td><label>Project Id</label></td>
				<td><form:input path="projectId"/></td>
			</tr>
			<tr>
				<td><label>Reporter</label>
				<td><form:input path="reporter" /></td>
			</tr>
			<tr>
				<td><label>Creator</label>
				<td><form:input path="creator" /></td>
			</tr>
			<tr>
				<td><label>Summary</label>
				<td><form:input path="summary" /></td>
			</tr>
			<tr>
				<td><label>Description</label>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><label>Duedate</label>
				<td><form:input path="duedate" type="date"/></td>
			</tr>
			<tr>
				<td><label>Time Estimate</label>
				<td><form:input path="timeEstimate" /></td>
			</tr>
			<tr>
				<td><label>Time Spent</label>
				<td><form:input path="timeSpent"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Issue" id="addIssueButton" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>