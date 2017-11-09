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
		for (Cell c : board) {
			if (c.getName().equals(cellName)) {
				if (!c.occupied()) {
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
		return false;
	}

	public String toString() {
		String out = "";
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				Cell c = board.get((x * 3) + y);
				if (c.occupied()) {
					out += c.getPlayer();
				} else {
					out += "-";
				}
				if (y != 2) {
					out += " ";
				}
			}
			if (x != 2) {
				out += "\n";
			}
		}
		return out;
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
