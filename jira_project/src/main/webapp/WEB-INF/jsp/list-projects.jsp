<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<title></title>
</head>
<body>
	<div id="listProjects">
		<table>
			<tr>
				<th>Description</th>
				<th>Leader</th>
				<th>Project Key</th>
				<th>Project Name</th>
				<th>Project Type</th>
				<th>Url</th>
			</tr>
			<c:forEach var="tempProject" items="${projects}">
				<tr>
					<td>${tempProject.description}</td>
					<td>${tempProject.leader}</td>
					<td>${tempProject.projectKey}</td>
					<td>${tempProject.projectName}</td>
					<td>${tempProject.projectType}</td>
					<td>${tempProject.url}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>