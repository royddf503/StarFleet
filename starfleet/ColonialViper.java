package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter{
	private static final int ANNUAL_MAINTENANCE_COST_DEFAULT = 4000;
	private static final int ANNUAL_MAINTENANCE_COST_CREW_MEMBER = 500;
	private static final int ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT = 500;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return ANNUAL_MAINTENANCE_COST_DEFAULT + getSumAnnualMaintenanceCostWeapons() + getAnnualMaintenanceCostCrewMember() + (int)(maximalSpeed * ANNUAL_MAINTENANCE_COST_ENGINES_DEFAULT);
	}

	private int getAnnualMaintenanceCostCrewMember() {
		return ANNUAL_MAINTENANCE_COST_CREW_MEMBER * crewMembers.size();
	}
}
