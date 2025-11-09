package main.vehicle;

public class VehicleSetterInjection {
	private IVehicle veh;
	
	public void setVechile(IVehicle vehicle) {
		// setter injection.
		this.veh = vehicle;
	}
	
	public void drive() {
		veh.drive();
	}
}
