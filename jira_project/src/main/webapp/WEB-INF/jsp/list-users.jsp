<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
</head>
<body>
	<div id="usersRegistered">
		<table>
			<tr>
				<th>Username</th>
				<th>Active</th>
				<th>Created Date</th>
				<th>Updated Date</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Display Name</th>
				<th>Email</th>
			</tr>
			<c:forEach var="tempUser" items="${users}">
				<tr>
					<td>${tempUser.userName}</td>
					<td>${tempUser.active}</td>
					<td>${tempUser.createdDate}</td>
					<td>${tempUser.updatedDate}</td>
					<td>${tempUser.firstName}</td>
					<td>${tempUser.lastName}</td>
					<td>${tempUser.displayName}</td>
					<td>${tempUser.emailAddress}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>