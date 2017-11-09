package Game;

public class Tile {
	private String name;
	private boolean occupied;
	private String player;

	public Tile(String name, boolean occupied, String player) {
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
