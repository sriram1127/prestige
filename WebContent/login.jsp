<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestige Home</title>
</head>
<style>
body, html {
	height: 100%;
	width: 100%;
	margin: 0;
}

.bg {
	/* The image used */
	background-image: url("image/home.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	margin-top: -10px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<body>
	<div class="bg">
		<h4 align="center">
			<form action="FormServlet" method="post">
				<br> <label> PRESTIGE </label><br> <br> <br> <br>
				<br> LOGIN AND NOMINATE HERE <br> <br> <br> <br>
				<table align="center" width="400px" height="200px">
					<tr>
						<td>USER ID: <font color="red">*</font></td>
						<td><input type="text" class="form-control"
							required="required"></td>
					<tr>
						<td>PASSWORD: <font color="red">*</font></td>
						<td><input type="password" class="form-control"
							name="password" required="required"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><input type="hidden"
							name="action" value="Login"> <input type="submit"
							value="Submit" class="btn btn-primary"></td>
					</tr>

				</table>
			</form>
		</h4>
	</div>


</body>

</html>