<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
</head>
<body>
	<div id="listIssues">
		<table>
			<tr>
				<th>Parent Id</th>
				<th>Project Key</th>
				<th>Issue Number</th>
				<th>Project Id</th>
				<th>Reporter</th>
				<th>Creator</th>
				<th>Summary</th>
				<th>Description</th>
				<th>Created</th>
				<th>Updated</th>
				<th>Due Date</th>
				<th>Time Estimate</th>
				<th>Time Spent</th>
			</tr>
			<c:forEach var="tempIssue" items="${issues}">
				<tr>
					<td>${tempIssue.parentId}</td>
					<td>${tempIssue.projectKey}</td>
					<td>${tempIssue.issueNumber}</td>
					<td>${tempIssue.projectId}</td>
					<td>${tempIssue.reporter}</td>
					<td>${tempIssue.creator}</td>
					<td>${tempIssue.summary}</td>
					<td>${tempIssue.description}</td>
					<td>${tempIssue.created}</td>
					<td>${tempIssue.updated}</td>
					<td>${tempIssue.duedate}</td>
					<td>${tempIssue.timeEstimate}</td>
					<td>${tempIssue.timeSpent}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>