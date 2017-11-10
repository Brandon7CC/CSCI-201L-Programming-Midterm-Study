package Sockets;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import Game.*;

@ServerEndpoint(value = "/mySocket")
public class ServerSocket {
	private static ArrayList<Session> sessions = new ArrayList<>();
	private static Board board;
	
	@OnOpen
	public void open(Session session) {
		if(!existsInList(session)) {
			System.out.println("New connection");
			sessions.add(session);
		}
		
		if(sessions.size() > 1) {
			onMessage("Let the games begin!", session);
			board = new Board();
			onMessage("1" + board.toString(), session);
		}
		
	}
	
	public boolean existsInList(Session session) {
		for(Session s : sessions) {
			if(s.equals(session)) {
				return true;
			}
		}
		
		return false;
	}
	
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println(message);
		try {
			for(Session s : sessions) {
				/*
				if(!s.equals(session)) {
					s.getBasicRemote().sendText(message);
				}
				*/
				s.getBasicRemote().sendText(message);
				
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