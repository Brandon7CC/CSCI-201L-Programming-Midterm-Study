package Sockets;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/mySocket")
public class ServerSocket {
	private static ArrayList<Session> sessions = new ArrayList<>();
	
	@OnOpen
	public void open(Session session) {
		System.out.println("New connection");
		sessions.add(session);
		
		if(sessions.size() > 1) {
			onMessage("Player joined", session);
		}
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println(message);
		try {
			for(Session s : sessions) {
				if(!s.equals(session)) {
					s.getBasicRemote().sendText(message);
				}
			}
		} catch (IOException ioe) {
			System.out.println("ioe: " + ioe.getMessage());
			close(session);
		}
	}
	
	@OnClose
	public void close(Session session) {
		System.out.println("Disconnecting!");
		sessions.remove(session);
	}
	
}
