package service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import model.ParkingFloor;
import model.ParkingSpot;
import model.Ticket;
import model.Vechile;

public class VechileExitService {
	public void handleVehicleExit(Scanner scanner, List<ParkingFloor> parkingFloorList, String currentVechileNumber, List<Ticket> parkedVehilceList, List<Vechile> totalVechileList, List<Ticket> totalRevenueList) {
		Ticket currentTicket = parkedVehilceList.stream().filter(i -> i.getVechileNumber().equals(currentVechileNumber)).findFirst().orElse(new Ticket());
		Vechile currentVechile = totalVechileList.stream().filter(i -> i.getVechileNumber().equals(currentVechileNumber)).findFirst().orElse(new Vechile());
		
		System.out.print("Enter exit gate - ");
        String exitGate = scanner.next().trim().toUpperCase();
        
        LocalDateTime exitTime = LocalDateTime.now();
        
        Duration duration = Duration.between(currentTicket.getEntryTime(), exitTime);
        long parkedHours = duration.toHours();
        
        MemberShipService memberShipService = new MemberShipService();
        double fee = memberShipService.getMemberShipFee(currentVechile.getMembershipType(), currentVechile.getType());
        
        currentTicket.setExitTime(exitTime);
        currentTicket.setParkingFee(parkedHours*fee);
        currentTicket.setExitGate(exitGate);
        
        // adding current ticket to revenue list and deleting from ticket list and releasing parking lot
        totalRevenueList.add(currentTicket);
        parkedVehilceList.remove(currentTicket);
        for(ParkingFloor floor : parkingFloorList) {
        	for(ParkingSpot spot : floor.getParkingSpots()) {
        		if(currentTicket.getFloorNumber() == floor.getId() && spot.getId() == currentTicket.getParkingSpot() && spot.getType() == currentVechile.getType()) {
        			spot.setOccupied(false);
        		}
        	}
        }
        
		
		// printing available parking slots per floor per vehicle type
        ParkingSpotAvailablityService parkingSpotAvailablityService = new ParkingSpotAvailablityService();
        parkingSpotAvailablityService.getAvailableParkingLot(parkingFloorList);
        
		// parked vehicle list
        System.out.println("\n===== Parked Vechile Information =====");
        for(Ticket tickets : parkedVehilceList) {
        	System.out.println(tickets.getId() + ". - vechile number is - " + tickets.getVechileNumber() + " , floor no. " + tickets.getFloorNumber() + " and spot is " + tickets.getParkingSpot());
        }
        
        // total revenue
        System.out.println("\n===== Total revenue Information =====");
        for(Ticket rev : totalRevenueList) {
        	System.out.println(rev.getId() + ". - fee is INR - " + rev.getParkingFee());
        }
        		
		// calling vehicle search service, first will check if already parked, if yes, will call ticket generation service else vehicle exit service
		VechileEntryService vechileEntryService = new VechileEntryService();
		vechileEntryService.enterVechileDetails(scanner, parkingFloorList, parkedVehilceList, totalVechileList, totalRevenueList);
	}
}
