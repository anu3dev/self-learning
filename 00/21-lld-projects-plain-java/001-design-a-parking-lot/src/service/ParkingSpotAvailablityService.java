package service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import enums.VechileType;
import model.ParkingFloor;
import model.ParkingSpot;

public class ParkingSpotAvailablityService {

    /**
     * Displays all currently available parking spots grouped by Vehicle Type for every parking floor.
     */
    public void getAvailableParkingLot(List<ParkingFloor> parkingFloors) {

        System.out.println("\n===== Current Parking Spot Availability =====");

        // Iterate through every parking floor
        for (ParkingFloor parkingFloor : parkingFloors) {

            /*
             * LinkedHashMap:
             * --------------
             * Stores key-value pairs while preserving insertion order.
             *
             * Key   -> Vehicle Type (BIKE, CAR, TRUCK)
             * Value -> List of available Parking Spots
             *
             * Example:
             * BIKE  -> [1,2]
             * CAR   -> [1,2,3]
             * TRUCK -> [1]
             */
            Map<VechileType, List<ParkingSpot>> groupedMap = new LinkedHashMap<>();

            // Iterate through every parking spot on the current floor
            for (ParkingSpot spot : parkingFloor.getParkingSpots()) {

                // Only consider available (unoccupied) parking spots
                if (!spot.isOccupied()) {

                    /*
                     * computeIfAbsent():
                     * ------------------
                     * If the VehicleType key doesn't exist,
                     * create a new ArrayList and insert it into the map.
                     *
                     * Otherwise, return the existing list.
                     *
                     * Equivalent to:
                     *
                     * if (!groupedMap.containsKey(spot.getType())) {
                     *     groupedMap.put(spot.getType(), new ArrayList<>());
                     * }
                     */
                    groupedMap
                            .computeIfAbsent(spot.getType(), k -> new ArrayList<>())

                            // Add the current parking spot into its VehicleType list
                            .add(spot);
                }
            }

            /*
             * entrySet():
             * -----------
             * Returns all key-value pairs of the Map.
             *
             * Example:
             *
             * BIKE  -> [Spot1, Spot2]
             * CAR   -> [Spot3, Spot4]
             * TRUCK -> [Spot5]
             */
            for (Map.Entry<VechileType, List<ParkingSpot>> entry : groupedMap.entrySet()) {

                /*
                 * getKey()
                 * --------
                 * Returns current Vehicle Type.
                 *
                 * Example:
                 * BIKE
                 */
                System.out.print("Floor " + parkingFloor.getId() + " -> " + entry.getKey() + " -> ");

                /*
                 * getValue()
                 * ----------
                 * Returns list of ParkingSpot objects
                 * associated with the current VehicleType.
                 */
                for (ParkingSpot spot : entry.getValue()) {

                    // Print Parking Spot IDs
                    System.out.print(spot.getId() + ", ");
                }

                System.out.println();
            }
        }
    }
}



//LinkedHashMap
//Stores key-value pairs while preserving insertion order.

//computeIfAbsent()
//Creates a value only if the key is absent, otherwise returns the existing value.

//entrySet()
//Returns all key-value pairs (Map.Entry<K,V>) of a Map.

//getKey()
//Returns the current key from the Map.

//getValue()
//Returns the value associated with the current key.

//Map.Entry<K,V>
//Represents one key-value pair inside a Map.

//Enhanced for-loop
//Iterates through every element in a collection.

//Lambda (k -> new ArrayList<>())
//Creates a new ArrayList when the key doesn't already exist.