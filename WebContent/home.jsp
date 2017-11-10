<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
	var socket;
	var gameControls = "<form><select id = 'select'><option value = 'A1'>A1</option>"+
	"<option value = 'A2'>A2</option><option value = 'A3'>A3</option>"+
	"<option value = 'B1'>B1</option><option value = 'B2'>B2</option>"+
	"<option value = 'B3'>B3</option><option value = 'C1'>C1</option>"+
	"<option value = 'C2'>C2</option><option value = 'C3'>C3</option>"+
	"</select><br><input type = 'button' value = 'Make Move!' onClick = 'makeMove()'/>";
	
	
	
	function startGame(){
		socket = new WebSocket("ws://localhost:8080/StudyExamWebsite/mySocket");
		
		socket.onopen = function(event) {
			document.getElementById("serverstatus").innerHTML = "Connected!";
		}
		
		
		socket.onmessage = function(event) {
			if(event.data.includes("1")){
				//alert(event.data);
				var table = event.data.substring(1, event.data.length);
				document.getElementById("gameTable").innerHTML = table;
				document.getElementById("gameControls").innerHTML = gameControls;
			}
			
			document.getElementById("serverstatus").innerHTML = event.data;
		}
		
		
		socket.onclose = function(event) {
			document.getElementById("serverstatus").innerHTML = "Disconnected!";
		}
	}
	
	function makeMove(){
		var e = document.getElementById("select");
		var move = e.options[e.selectedIndex].value;
		
	}

</script>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Home!</title>
</head>
<body>
	<h1>
		Welcome
		<%=session.getAttribute("currentUser")%></h1>

	<form>
		<input type="button" value="Start Game!" onClick="startGame()" />
	</form>

	<div id="serverstatus" /></div>
	<br />
	<div id="gameTable" /></div>
	<br />
	<div id="gameControls" /></div>

</body>
</html>