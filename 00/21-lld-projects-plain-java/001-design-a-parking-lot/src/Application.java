import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ParkingFloor;
import model.Ticket;
import model.Vechile;
import service.ParkingFloorService;
import service.VechileEntryService;

public class Application {
	public static void main(String args[]) {
				
		try (Scanner scanner = new Scanner(System.in)) {
			
			// Initializing parking floor with floor number and parking spot details
			ParkingFloorService parkingFloorService = new ParkingFloorService();
			List<ParkingFloor> parkingFloorList = parkingFloorService.initializeParkingLot(scanner);
			
			
			// Initializing ticket history
			List<Ticket> parkedVehilceList = new ArrayList<Ticket>();
			
			
			List<Vechile> totalVechileList = new ArrayList<Vechile>();
			List<Ticket> totalRevenueList = new ArrayList<Ticket>();
			
			
			// calling vehicle search service, first will check if already parked, if yes, will call ticket generation service else vehicle exit service
			VechileEntryService vechileEntryService = new VechileEntryService();
			vechileEntryService.enterVechileDetails(scanner, parkingFloorList, parkedVehilceList, totalVechileList, totalRevenueList);

			
			scanner.close();
		}
	}
}

