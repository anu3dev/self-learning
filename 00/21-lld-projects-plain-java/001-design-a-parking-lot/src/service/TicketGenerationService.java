package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import enums.MembershipType;
import enums.VechileType;
import model.ParkingFloor;
import model.ParkingSpot;
import model.Ticket;
import model.Vechile;

public class TicketGenerationService {
	public static boolean isValidVechileType(String inputVechileType) {
		try {
			VechileType.valueOf(inputVechileType);
	        return true;
	    } catch (IllegalArgumentException | NullPointerException e) {
	        return false;
	    }
	}
	
	public static boolean isValidMembershipType(String inputMembershipType) {
		try {
			MembershipType.valueOf(inputMembershipType);
	        return true;
	    } catch (IllegalArgumentException | NullPointerException e) {
	        return false;
	    }
	}
	
	public static boolean isEnteredSpotOccupied(List<ParkingFloor> parkingFloorList, int inputFloorNumber, int inputParkingSpot, String inputVechileType) {
		ParkingFloor floor  = parkingFloorList.stream().filter(ParkingFloor -> ParkingFloor.getId() == inputFloorNumber).findFirst().orElse(null);
		if(floor == null) {
			return true;
		}
		ParkingSpot spot = floor.getParkingSpots().stream().filter(ParkingSpot -> ParkingSpot.getId() == inputParkingSpot && ParkingSpot.getType() == VechileType.valueOf(inputVechileType)).findFirst().orElse(null);
		if(spot == null) {
			return true;
		}
		return spot.isOccupied();
	}
	
	public void generateTicket(Scanner scanner, List<ParkingFloor> parkingFloorList, String currentVechileNumber, List<Ticket> parkedVehilceList, List<Vechile> totalVechileList, List<Ticket> totalRevenueList) {		    
        System.out.print("Enter vechile type - ");
        String inputVechileType = scanner.next().trim().toUpperCase();
        while(!isValidVechileType(inputVechileType)) {
        	System.out.print("Invalid vehicle type. Enter again - ");
        	inputVechileType = scanner.next().trim().toUpperCase();;
        }
        
        System.out.print("Enter floor number - ");
        int inputFloorNumber = scanner.nextInt();        
        System.out.print("Enter parking spot - ");
        int inputParkingSpot = scanner.nextInt();
        while(isEnteredSpotOccupied(parkingFloorList, inputFloorNumber, inputParkingSpot, inputVechileType)) {
        	System.out.print("Enter valid floor number - ");
        	inputFloorNumber = scanner.nextInt();        
            System.out.print("Enter valid parking spot - ");
            inputParkingSpot = scanner.nextInt();
        }
        
        System.out.print("Enter membership type - ");
        String inputMembershipType = scanner.next().trim().toUpperCase();
        while(!isValidMembershipType(inputMembershipType)) {
        	System.out.print("Invalid membership type. Enter again - ");
        	inputMembershipType = scanner.next().trim().toUpperCase();;
        }
        
        System.out.print("Enter entry gate - ");
        String entryGate = scanner.next().trim().toUpperCase();
        
        scanner.nextLine();
        
        LocalDateTime entryTime = LocalDateTime.now();
        
        Ticket ticket = new Ticket();
        ticket.setId(parkedVehilceList.size()+1);
        ticket.setVechileNumber(currentVechileNumber);
        ticket.setEntryGate(entryGate);
        ticket.setEntryTime(entryTime);
        ticket.setFloorNumber(inputFloorNumber);
        ticket.setParkingSpot(inputParkingSpot);
        parkedVehilceList.add(ticket);
        
        Vechile vechile = new Vechile();
        vechile.setId(totalVechileList.size()+1);
        vechile.setMembershipType(MembershipType.valueOf(inputMembershipType));
        vechile.setVechileNumber(currentVechileNumber);
        vechile.setType(VechileType.valueOf(inputVechileType));
        vechile.setVechileColor("NA");
        totalVechileList.add(vechile);

		for(ParkingFloor floor : parkingFloorList) {
			for(ParkingSpot spot : floor.getParkingSpots()) {
				if(inputFloorNumber == floor.getId() && spot.getId() == inputParkingSpot && spot.getType() == VechileType.valueOf(inputVechileType)) {
					spot.setOccupied(true);
				}
			}
		};
		
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
	};
}
