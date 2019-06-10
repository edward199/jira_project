<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
</head>
<body>

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
			<th>Due Date</th>
			<th>Time Estimate</th>
			<th>Time Spent</th>
		</tr>
		<c:forEach var="tempIssue" items="${issues}">
			<tr>
				<td>${tempProject.parentId}</td>
				<td>${tempProject.projectKey}</td>
				<td>${tempProject.issueNumber}</td>
				<td>${tempProject.projectId}</td>
				<td>${tempProject.reporter}</td>
				<td>${tempProject.creator}</td>
				<td>${tempProject.summary}</td>
				<td>${tempProject.description}</td>
				<td>${tempProject.duedate}</td>
				<td>${tempProject.timeEstimate}</td>
				<td>${tempProject.timeSpent}</td>
			</tr>

		</c:forEach>
	</table>

</body>
</html>