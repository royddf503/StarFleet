package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstractSpaceshipWeapons{

	private final int numberOfTechnicians;
	protected static final int ANNUAL_MAINTENANCE_COST_DEFAULT = 5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return ANNUAL_MAINTENANCE_COST_DEFAULT + (int)(getSumAnnualMaintenanceCostWeapons() * getPercentageWeaponsCost());
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}

	private double getPercentageWeaponsCost() {
		return 1 - 0.1 * numberOfTechnicians;
	}

	@Override
	public String toString() {
		return super.toString() + "\n\t" + "NumberOfTechnicians=" + numberOfTechnicians;
	}


}
