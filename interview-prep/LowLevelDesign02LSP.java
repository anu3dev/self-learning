/**
 * Discuss Liskov Substitution Principle (LSP) with example.
 */

class Vehicle {
    public int getNUmberOfWheels() {
        return 2;
    }

    public Boolean hasEngine() {
        return true;
    }
}

class Car extends Vehicle {
    @Override
    public int getNUmberOfWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}

class Motorcycle extends Vehicle {
    @Override
    public int getNUmberOfWheels() {
        return 2;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}

class Bicycle extends Vehicle {
    @Override
    public int getNUmberOfWheels() {
        return 2;
    }

    @Override
    public Boolean hasEngine() {
        return false; // Bicycles do not have engines
    }
}

/**
 * List <Vehicle> vehicles = new ArrayList<>();
 * vehicles.add(new Car());
 * vehicles.add(new Motorcycle());
 * vehicles.add(new Bicycle()); // This will violate LSP
 */

/**
 * In this example, we have a base class Vehicle and three subclasses: Car, Motorcycle, and Bicycle.
 * car and Motorcycle adhere to the Liskov Substitution Principle as they can be used interchangeably with Vehicle.
 * However, Bicycle violates LSP because it does not have an engine, which is expected by the Vehicle class.
 */

/**
 * Always write most generic methods in the base class and override them in subclasses.
 * This ensures that the subclasses can be used interchangeably without breaking the expected behavior.
 */

class VehicleNew {
    public int getNUmberOfWheels() {
        return 2;
    }
}

class EngineVehicle extends VehicleNew {
    public Boolean hasEngine() {
        return true;
    }
}

class BicycleNew extends VehicleNew {
    @Override
    public int getNUmberOfWheels() {
        return 2;
    }
}

class CarNew extends EngineVehicle {
    @Override
    public int getNUmberOfWheels() {
        return 4;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}

class MotorcycleNew extends EngineVehicle {
    @Override
    public int getNUmberOfWheels() {
        return 2;
    }

    @Override
    public Boolean hasEngine() {
        return true;
    }
}

/**
 * In this revised example, we have separated the concept of vehicles with engines from those without.
 * BicycleNew does not extend EngineVehicle, thus it does not violate LSP.
 * This allows us to maintain the integrity of the Liskov Substitution Principle while still allowing for flexibility in our design.
 */