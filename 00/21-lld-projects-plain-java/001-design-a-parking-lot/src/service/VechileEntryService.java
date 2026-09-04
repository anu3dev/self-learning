package service;

import java.util.List;
import java.util.Scanner;

import model.ParkingFloor;
import model.Ticket;
import model.Vechile;

public class VechileEntryService {
	private static boolean isVechileAlreadyParked(String currentVechileNumber, List<Ticket> parkedVehilceList) {
		for(Ticket itemTicket : parkedVehilceList) {
        	if(itemTicket.getVechileNumber().equals(currentVechileNumber)) {
        		return true;
        	}
        }
		return false;
	}
	
	public void enterVechileDetails(Scanner scanner, List<ParkingFloor> parkingFloorList, List<Ticket> parkedVehilceList, List<Vechile> totalVechileList, List<Ticket> totalRevenueList) {
		System.out.println("\n===== Enter Vechile Information =====");
		
		System.out.print("Enter vechile number - ");
        String currentVechileNumber = scanner.next().trim().toUpperCase();
        
        if(isVechileAlreadyParked(currentVechileNumber, parkedVehilceList)) {
        	VechileExitService vechileExitService = new VechileExitService();
        	vechileExitService.handleVehicleExit(scanner, parkingFloorList, currentVechileNumber, parkedVehilceList, totalVechileList, totalRevenueList);
        } else {
        	TicketGenerationService ticketGenerationService = new TicketGenerationService();
        	ticketGenerationService.generateTicket(scanner, parkingFloorList, currentVechileNumber, parkedVehilceList, totalVechileList, totalRevenueList);
        }
	}
}
