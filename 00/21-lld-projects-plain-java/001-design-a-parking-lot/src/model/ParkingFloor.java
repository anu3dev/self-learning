package model;

import java.util.List;

public class ParkingFloor {
	private int id;
	private List<ParkingSpot> parkingSpots;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}
	public void setParkingSpots(List<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}
	
	@Override
	public String toString() {
		return "ParkingFloor [id=" + id + ", parkingSpots=" + parkingSpots + "]";
	}
}
