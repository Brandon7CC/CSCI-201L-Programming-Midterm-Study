package Game;

import java.util.ArrayList;

public class Board {
	private ArrayList<Tile> board = new ArrayList<>();

	public Board() {
		board.add(new Tile("A1", false, null));
		board.add(new Tile("A2", false, null));
		board.add(new Tile("A3", false, null));
		board.add(new Tile("B1", false, null));
		board.add(new Tile("B2", false, null));
		board.add(new Tile("B3", false, null));
		board.add(new Tile("C1", false, null));
		board.add(new Tile("C2", false, null));
		board.add(new Tile("C3", false, null));
	}

	public boolean makeMove(String TileName, String player) {
		for (Tile c : board) {
			if (c.getName().equals(TileName)) {
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
				Tile c = board.get((x * 3) + y);
				if (c.occupied()) {
					out += c.getPlayer();
				} else {
					out += "*";
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