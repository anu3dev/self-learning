package model;

import java.time.LocalDateTime;

public class Ticket {
	private int id;
	private String vechileNumber;
	private LocalDateTime entryTime;
	private String entryGate;
	private int parkingSpot;
	private int floorNumber;
	private LocalDateTime exitTime;
	private String exitGate;
	private double parkingFee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getVechileNumber() {
		return vechileNumber;
	}
	public void setVechileNumber(String vechileNumber) {
		this.vechileNumber = vechileNumber;
	}
	
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	
	public String getEntryGate() {
		return entryGate;
	}
	public void setEntryGate(String entryGate) {
		this.entryGate = entryGate;
	}
	
	public int getParkingSpot() {
		return parkingSpot;
	}
	public void setParkingSpot(int parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	
	public String getExitGate() {
		return exitGate;
	}
	public void setExitGate(String exitGate) {
		this.exitGate = exitGate;
	}
	
	public double getParkingFee() {
		return parkingFee;
	}
	public void setParkingFee(double parkingFee) {
		this.parkingFee = parkingFee;
	}
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", vechileNumber=" + vechileNumber + ", entryTime="
				+ entryTime + ", entryGate=" + entryGate + ", parkingSpot=" + parkingSpot + ", floorNumber="
				+ floorNumber + ", exitTime=" + exitTime + ", exitGate=" + exitGate + ", parkingFee=" + parkingFee
				+ "]";
	}
}
