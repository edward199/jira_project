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
				<th>Id</th>
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
			<c:forEach var="tempIssueSearched" items="${issuesSearched}">
				<tr>
					<td>${tempIssueSearched.id}</td>
					<td>${tempIssueSearched.parentId}</td>
					<td>${tempIssueSearched.projectKey}</td>
					<td>${tempIssueSearched.issueNumber}</td>
					<td>${tempIssueSearched.projectId}</td>
					<td>${tempIssueSearched.reporter}</td>
					<td>${tempIssueSearched.creator}</td>
					<td>${tempIssueSearched.summary}</td>
					<td>${tempIssueSearched.description}</td>
					<td>${tempIssueSearched.created}</td>
					<td>${tempIssueSearched.updated}</td>
					<td>${tempIssueSearched.duedate}</td>
					<td>${tempIssueSearched.timeEstimate}</td>
					<td>${tempIssueSearched.timeSpent}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>