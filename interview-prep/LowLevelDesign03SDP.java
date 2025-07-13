/**
 * Strategy Design Pattern
 * This code demonstrates the Strategy Design Pattern by defining a strategy interface
 */

class Vehicle {
    public void drive () {
        // normal driving behavior
    }
}

class PassengerVehicle extends Vehicle {
    @Override
    public void drive() {
        super.drive();
    }
}
/**
 * Problem Example: Tight coupling, hard to extend driving behavior
 */
class VehicleWithProblem {
    public void drive() {
        System.out.println("Driving with normal behavior");
    }
}

class SportsCarWithProblem extends VehicleWithProblem {
    @Override
    public void drive() {
        System.out.println("Driving fast!");
    }
}

class OffRoadVehicleWithProblem extends VehicleWithProblem {
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

    public VehicleWithStrategy(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}

// Usage Example
class Main {
    public static void main(String[] args) {
        VehicleWithStrategy passengerVehicle = new VehicleWithStrategy(new NormalDriveStrategy());
        VehicleWithStrategy sportsCar = new VehicleWithStrategy(new SportsDriveStrategy());
        VehicleWithStrategy offRoadVehicle = new VehicleWithStrategy(new OffRoadDriveStrategy());

        passengerVehicle.drive(); // Driving with normal behavior
        sportsCar.drive();        // Driving fast!
        offRoadVehicle.drive();   // Driving off-road!
    }
}
