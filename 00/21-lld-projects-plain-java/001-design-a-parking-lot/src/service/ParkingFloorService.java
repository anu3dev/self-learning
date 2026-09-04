package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.VechileType;
import model.ParkingFloor;
import model.ParkingSpot;

public class ParkingFloorService {

    /**
     * Initializes the Parking Lot by taking user input.
     *
     * Creates:
     * - Parking Floors
     * - Parking Spots for each floor
     * - Assigns Vehicle Types to each parking spot
     *
     * Returns a list of configured Parking Floors.
     */
    public List<ParkingFloor> initializeParkingLot(Scanner scanner) {

        System.out.println("===== Parking Lot =====\n");

        // Read total number of parking floors
        System.out.print("Total available floor in parking lot - ");
        int totalAvailableFloorInParkingLot = scanner.nextInt();

        // Consume the newline left by nextInt()
        scanner.nextLine();

        System.out.println();

        // Stores all parking floors
        List<ParkingFloor> parkingFloorList = new ArrayList<>();

        // Create each parking floor
        for (int i = 1; i <= totalAvailableFloorInParkingLot; i++) {

            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);

            // Stores all parking spots for the current floor
            List<ParkingSpot> parkingSpotList = new ArrayList<>();

            /*
             * Iterate through every supported Vehicle Type.
             *
             * Example:
             * BIKE
             * CAR
             * TRUCK
             */
            for (VechileType vechileType : VechileType.values()) {

                System.out.print("Enter available parking slot for " + vechileType + " for floor " + i + " - ");

                int availableParkingLot = scanner.nextInt();
                scanner.nextLine();

                /*
                 * Create required number of parking spots
                 * for the current Vehicle Type.
                 */
                for (int j = 1; j <= availableParkingLot; j++) {

                    ParkingSpot parkingSpot = new ParkingSpot();

                    // Spot number within the Vehicle Type
                    parkingSpot.setId(j);

                    // Vehicle Type supported by this parking spot
                    parkingSpot.setType(vechileType);

                    // Initially every parking spot is available
                    parkingSpot.setOccupied(false);

                    parkingSpotList.add(parkingSpot);
                }
            }

            // Associate all parking spots with the current floor
            parkingFloor.setParkingSpots(parkingSpotList);

            // Add floor to the parking lot
            parkingFloorList.add(parkingFloor);
        }

        System.out.println("\n===== Parking Lot is Ready =====");
        
        // printing available parking slots per floor per vehicle type
        ParkingSpotAvailablityService parkingSpotAvailablityService = new ParkingSpotAvailablityService();
        parkingSpotAvailablityService.getAvailableParkingLot(parkingFloorList);

        return parkingFloorList;
    }
}