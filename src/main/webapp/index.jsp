<html>
<head>
<title>EarthMail</title>
</head>
<body>
	${param['result']}
	<form action="emailSender" method="post">
		<table>
			<tr>
				<td>Topic:</td>
				<td><input type="text" id="topic" name="topic"></td>
			</tr>
			<tr>
				<td><a href="recipients.jsp">Recipients:</a></td>
				<td><input type="text" id="recipients" name="recipients"><br></td>
			</tr>
			<tr>
				<td>Body:</td>
				<td><textarea id="body" name="body"></textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button id="send" name="sendName">Send</button></td>
			</tr>
		</table>
	</form>
</body>
</html>      
