package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractSpaceshipWeapons{
	protected static final int ANNUAL_MAINTENANCE_COST_DEFAULT = 2500;
	protected static final int ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT = 1000;


	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return ANNUAL_MAINTENANCE_COST_DEFAULT + getSumAnnualMaintenanceCostWeapons() + Math.round(ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT * maximalSpeed);
	}
}
