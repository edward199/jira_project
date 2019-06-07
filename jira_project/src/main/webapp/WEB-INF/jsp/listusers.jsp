<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
</head>
<body>
	
			<table>
				<tr>
					<th>Active</th>
					<th>Created Date</th>
					<th>Updated Date</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Display Name</th>
				</tr>
				<!--  loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}" >
					<tr>
						<td>${tempUser.active}</td>
						<td>${tempUser.createdDate}</td>
						<td>${tempUser.updatedDate}</td>
						<td>${tempUser.userName}</td>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.emailAddress}</td>
						<td>${tempUser.displayName}</td>
					</tr>
				
				</c:forEach>
			</table>

</body>
</html>