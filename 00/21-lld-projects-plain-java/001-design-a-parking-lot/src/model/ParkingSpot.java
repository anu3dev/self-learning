package model;

import enums.VechileType;

public class ParkingSpot {
	private int Id;
	private VechileType type;
	private boolean isOccupied;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public VechileType getType() {
		return type;
	}
	public void setType(VechileType type) {
		this.type = type;
	}
	
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [Id=" + Id + ", type=" + type + ", isOccupied=" + isOccupied + "]";
	}
}
