package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{

	private static int countStealthCruiser = 0;
	private final static int PRICE_PER_CLOAKING_DEVICE = 50;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		countStealthCruiser++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, new ArrayList<>());
		weapons.add(new Weapon("Laser Cannons",10,100));
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + countStealthCruiser * PRICE_PER_CLOAKING_DEVICE;
	}
}
