<html>
<head>
<title>EarthMail</title>
<script class="jquery library"
	src="js/sandbox/jquery/jquery-1.8.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

$(function(){
	$.ajax();
})
</script>
	
</head>
<body>
	<form action="emailSender">
		<table>
			<tr>
				<td>Topic:</td>
				<td><input type="text" id="topic" name="topicName"></td>
			</tr>
			<tr>
				<td>Recipients:</td>
				<td><input type="text" id="recipients"><br></td>
			</tr>
			<tr>
				<td>Body:</td>
				<td><textarea id="body"></textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><button id="send" name="sendName">Send</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
