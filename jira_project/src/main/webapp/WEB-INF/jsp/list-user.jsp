<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
</head>
<body>
	<div id="userRegistered">
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
			<tr>
				<td>${user.userName}</td>
				<td>${user.active}</td>
				<td>${user.createdDate}</td>
				<td>${user.updatedDate}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.displayName}</td>
				<td>${user.emailAddress}</td>
			</tr>

		</table>
	</div>
</body>
</html>