<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
	var socket;
	function startGame(){
		socket = new WebSocket("ws://localhost:8080/StudyExamWebsite/mySocket");
		
		socket.onopen = function(event) {
			document.getElementById("serverstatus").innerHTML = "Connected!";
		}
		
		
		socket.onmessage = function(event) {
			document.getElementById("serverstatus").innerHTML = event.data;
		}
		
		/*
		socket.onclose = function(event) {
			document.getElementById("mychat").innerHTML += "Disconnected!";
		}
		*/

	}

</script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Home!</title>
</head>
<body>
<h1>Welcome <%=session.getAttribute("currentUser")%></h1>

<form>
	<input type = "button" value = "Start Game!" onClick = "startGame()"/>
</form>

<div id="serverstatus" /></div>

</body>
</html>