package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	private static final int ANNUAL_MAINTENANCE_COST_DEFAULT = 3500;
	private static final int ANNUAL_MAINTENANCE_COST_CREW_MEMBER = 500;
	private static final int ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT = 1200;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return ANNUAL_MAINTENANCE_COST_DEFAULT + getSumAnnualMaintenanceCostWeapons() + getAnnualMaintenanceCostCrewMember();
	}

	private int getAnnualMaintenanceCostCrewMember() {
		return ANNUAL_MAINTENANCE_COST_CREW_MEMBER * crewMembers.size() + Math.round(maximalSpeed * ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT);
	}
}





	


