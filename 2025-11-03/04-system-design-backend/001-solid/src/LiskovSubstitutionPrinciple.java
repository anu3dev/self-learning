/**
 * Liskov Substitution Principle states that objects of a superclass
 * should be replaceable with objects of its subclasses without
 * affecting the correctness of the program.
 * 
 * subclass should extend the behavior of superclass
 * without changing its original behavior.
 */
public class LiskovSubstitutionPrinciple {
    public class Vehicle {
        public boolean hasEngine() {
            return true;
        }

        public int noOfWheels() {
            return 2;
        }
    }

    class Motorcycle extends Vehicle {}

    class Car extends Vehicle {
        @Override
        public int noOfWheels() {
            return 4;
        }
    }

    // till now everything is fine and follows LSP but what if we have a subclass
    // that violates the behavior of superclass

    class Bicycle extends Vehicle {
        @Override
        public boolean hasEngine() {
            return false; // violates the behavior of superclass
        }

        @Override
        public int noOfWheels() {
            return 2;
        }
    }

    /**
     * better design to follow LSP is to have separate superclass
     * for vehicles with engine and without engine
     */

     // in parent class we have common behavior of all vehicles
    public class VehicleLSP {
        public int noOfWheels() {
            return 2;
        }
    }

    public class VehicleWithEngine extends VehicleLSP {
        public boolean hasEngine() {
            return true;
        }
    }

    public class MotorcycleLSP extends VehicleWithEngine {}

    public class CarLSP extends VehicleWithEngine {
        @Override
        public int noOfWheels() {
            return 4;
        }
    }

    // bicycle will extend VehicleLSP instead of VehicleWithEngine
    public class BicycleLSP extends VehicleLSP {}
}