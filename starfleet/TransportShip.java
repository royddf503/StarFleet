package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship{
	private final int cargoCapacity;
	private final int passengerCapacity;
	private final static int ANNUAL_MAINTENANCE_COST_DEFAULT = 3000;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	@Override
	public int getFirePower() {
		return FIRE_POWER_DEFAULT;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return ANNUAL_MAINTENANCE_COST_DEFAULT + 5 * cargoCapacity  + 3 * passengerCapacity;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t" + "CargoCapacity=" + cargoCapacity + "\n\t" + "PassengerCapacity=" + passengerCapacity;
	}
}
