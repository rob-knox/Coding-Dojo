<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<form action="/survey" method="POST">
			<table>
				<tr>
					<td class="half">Your Name: </td>
					<td class="half"><input type="text" name="name"></td>
				</tr>
				<tr>
					<td class="half">Dojo Location: </td>
					<td class="half">
						<select name="location">
							<option>Burbank</option>
							<option>San Jose</option>
							<option>Mountain View</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="half">Favorite Language: </td>
					<td class="half">
						<select name="language">
							<option>Java</option>
							<option>JavaScript</option>
							<option>Python</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="whole" colspan="2">Comment (optional):</td>
				</tr>
				<tr>
					<td class="whole" colspan="2">
						<textarea name="comment"></textarea>
					</td>
				</tr>
				<tr>
					<td class="whole text-align-right" colspan="2"><input type="submit" class="submitButton" value="Button"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>