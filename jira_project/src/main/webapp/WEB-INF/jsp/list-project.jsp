<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
<title></title>
</head>
<body>
	<div id="userRegistered">
		<table>
			<tr>
				<th>Description</th>
				<th>Leader</th>
				<th>Project Key</th>
				<th>Project Name</th>
				<th>Project Type</th>
				<th>Url</th>
			</tr>
			<tr>
				<td>${project.description}</td>
				<td>${project.leader}</td>
				<td>${project.projectKey}</td>
				<td>${project.projectName}</td>
				<td>${project.projectType}</td>
				<td>${project.url}</td>
			</tr>

		</table>
	</div>
</body>
</html>