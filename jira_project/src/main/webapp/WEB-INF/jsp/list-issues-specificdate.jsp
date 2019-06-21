<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<title></title>
</head>
<body>
	<div id="listIssuesToShow">
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
			<c:forEach var="tempIssueDate" items="${issuesDate}">
				<tr>
					<td>${tempIssueDate.parentId}</td>
					<td>${tempIssueDate.projectKey}</td>
					<td>${tempIssueDate.issueNumber}</td>
					<td>${tempIssueDate.projectId}</td>
					<td>${tempIssueDate.reporter}</td>
					<td>${tempIssueDate.creator}</td>
					<td>${tempIssueDate.summary}</td>
					<td>${tempIssueDate.description}</td>
					<td>${tempIssueDate.created}</td>
					<td>${tempIssueDate.updated}</td>
					<td>${tempIssueDate.duedate}</td>
					<td>${tempIssueDate.timeEstimate}</td>
					<td>${tempIssueDate.timeSpent}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>