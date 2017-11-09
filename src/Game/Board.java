package Game;

import java.util.ArrayList;

public class Board {
	private ArrayList<Cell> board = new ArrayList<>();
	
	public Board() {
		board.add(new Cell("A1", false, null));
		board.add(new Cell("A2", false, null));
		board.add(new Cell("A3", false, null));
		board.add(new Cell("B1", false, null));
		board.add(new Cell("B2", false, null));
		board.add(new Cell("B3", false, null));
		board.add(new Cell("C1", false, null));
		board.add(new Cell("C2", false, null));
		board.add(new Cell("C3", false, null));
	}
	
	public boolean makeMove(String cellName, String player) {
		for(Cell c : board) {
			if(c.getName().equals(cellName)) {
				if(!c.occupied()) {
					c.setOccupied();
					c.setPlayer(player);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean checkWin() {
		for(Cell c : board) {
			
		}
	}
}

class Cell {
	private String name;
	private boolean occupied;
	private String player;
	
	public Cell(String name, boolean occupied, String player) {
		this.name = name;
		this.occupied = occupied;
		this.player = player;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public String getPlayer() {
		return this.player;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean occupied() {
		return this.occupied;
	}
	
	public void setOccupied() {
		this.occupied = true;
	}
}
