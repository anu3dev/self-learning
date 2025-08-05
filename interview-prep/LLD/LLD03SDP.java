package LLD;
/**
 * Strategy Design Pattern
 * This code demonstrates the Strategy Design Pattern by defining a strategy interface
 */

 /**
  * Difference between is a relationship and has a relationship:
  * - "Is a" relationship is used for inheritance, where a subclass is a specialized
  *   version of a parent class.
  * - "Has a" relationship is used for composition, where a class contains references
  *   to other classes as part of its state.
  */

class Vehicle {
    public void drive() {
        System.out.println("Driving with normal behavior");
    }
}

class PassengerVehicle extends Vehicle {
    // Can use the same drive method as Vehicle because it is normal driving behavior
}

// have to override the drive method for specific behaviors
class SportsCar extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving fast!");
    }
}

// have to override the drive method for specific behaviors
class OffRoadVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving off-road!");
    }
}

/**
 * Solution: Strategy Design Pattern
 * Decouple driving behavior using a strategy interface
 */
interface DriveStrategy {
    void drive();
}

class NormalDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("Driving with normal behavior");
    }
}

class SportsDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("Driving fast!");
    }
}

class OffRoadDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("Driving off-road!");
    }
}

class VehicleWithStrategy {
    private DriveStrategy driveStrategy;

    // Constructor injection for the strategy
    public VehicleWithStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

// Usage Example
class LLD03SDP {
    public static void main(String[] args) {
        VehicleWithStrategy passengerVehicle = new VehicleWithStrategy(new NormalDriveStrategy());
        passengerVehicle.drive(); // Driving with normal behavior

        VehicleWithStrategy sportsCar = new VehicleWithStrategy(new SportsDriveStrategy());
        sportsCar.drive();        // Driving fast!

        VehicleWithStrategy offRoadVehicle = new VehicleWithStrategy(new OffRoadDriveStrategy());
        offRoadVehicle.drive();   // Driving off-road!
    }
}
