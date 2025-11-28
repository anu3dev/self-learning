package main.vehicle;

public class VehicleConstructorInjection {
	private IVehicle veh;
	
	public VehicleConstructorInjection(IVehicle vehicle) {
		// constructor injection.
		this.veh = vehicle;
	}
	
	public void drive() {
		veh.drive();
	}
}
