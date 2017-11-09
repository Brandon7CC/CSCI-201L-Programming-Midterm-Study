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

	public String checkWin() {
		String out;
		if (board.get(0).getPlayer().equals(board.get(1).getPlayer())
				&& board.get(1).getPlayer().equals(board.get(2).getPlayer())) {
			out = board.get(0).getPlayer();
		} else if (board.get(3).getPlayer().equals(board.get(4).getPlayer())
				&& board.get(4).getPlayer().equals(board.get(5).getPlayer())) {
			out = board.get(3).getPlayer();
		} else if (board.get(6).getPlayer().equals(board.get(7).getPlayer())
				&& board.get(7).getPlayer().equals(board.get(8).getPlayer())) {
			out = board.get(6).getPlayer();
		} else if (board.get(0).getPlayer().equals(board.get(3).getPlayer())
				&& board.get(3).getPlayer().equals(board.get(6).getPlayer())) {
			out = board.get(0).getPlayer();
		} else if (board.get(1).getPlayer().equals(board.get(4).getPlayer())
				&& board.get(4).getPlayer().equals(board.get(7).getPlayer())) {
			out = board.get(1).getPlayer();
		} else if (board.get(2).getPlayer().equals(board.get(5).getPlayer())
				&& board.get(5).getPlayer().equals(board.get(8).getPlayer())) {
			out = board.get(2).getPlayer();
		} else if (board.get(0).getPlayer().equals(board.get(4).getPlayer())
				&& board.get(4).getPlayer().equals(board.get(8).getPlayer())) {
			out = board.get(0).getPlayer();
		} else if (board.get(2).getPlayer().equals(board.get(4).getPlayer())
				&& board.get(4).getPlayer().equals(board.get(6).getPlayer())) {
			out = board.get(0).getPlayer();
		} else {
			out = null;
		}
		return out;
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
