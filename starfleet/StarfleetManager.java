package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List <String> stringSpaceships = new ArrayList<>();
		List <Spaceship> spaceships = new ArrayList<>(fleet);
		spaceships.sort(new myStarFleetComparator<>());

		for (Spaceship spaceship : spaceships) {
			stringSpaceships.add(spaceship.toString());
		}
		return stringSpaceships;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map <String, Integer> numPerClass = new HashMap<>();
		String spaceshipClassName;

		for (Spaceship spaceship : fleet) {
			spaceshipClassName = spaceship.getClass().getSimpleName();
			if (!numPerClass.containsKey(spaceshipClassName)) {
				numPerClass.put(spaceshipClassName, 1);
			}
			else {
				numPerClass.put(spaceshipClassName, numPerClass.get(spaceshipClassName) + 1);
			}
		}
		return numPerClass;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalMaintenanceCost = 0;
		for (Spaceship spaceship : fleet) {
			totalMaintenanceCost += spaceship.getAnnualMaintenanceCost();
		}
		return totalMaintenanceCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set <String> fleetWeaponNames = new HashSet<>();
		List<Weapon> spaceshipListWeapons;

		for (Spaceship spaceship : fleet) {
			if (spaceship instanceof myAbstractSpaceshipWeapons) { //In case it has weapons
				spaceshipListWeapons = ((myAbstractSpaceshipWeapons) spaceship).getWeapon();
				for (Weapon weapon : spaceshipListWeapons) {
					fleetWeaponNames.add(weapon.getName());
				}
			}
		}
		return fleetWeaponNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalNumberOfFleetCrewMembers = 0;

		for (Spaceship spaceship : fleet) {
			totalNumberOfFleetCrewMembers += spaceship.getCrewMembers().size();
		}
		return totalNumberOfFleetCrewMembers;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int totalAgeOfFleetOfficers = 0;
		int totalCountFleetOfficer = 0;
		Set <? extends CrewMember> crewMembers;

		for (Spaceship spaceship : fleet) {
			crewMembers = spaceship.getCrewMembers();
			for (CrewMember crewMember : crewMembers) {
				if (crewMember instanceof Officer) {
					totalAgeOfFleetOfficers += crewMember.getAge();
					totalCountFleetOfficer += 1;
				}
			}
		}

		return (float) (totalAgeOfFleetOfficers) / totalCountFleetOfficer;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map <Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<>();
		Set <? extends CrewMember> crewMembers;
		Officer highestRankingOfficer = null;
		Officer tempOfficer;
		boolean isExistOfficer;

		for (Spaceship spaceship : fleet) {
			isExistOfficer = false;
			crewMembers = spaceship.getCrewMembers();
			for (CrewMember crewMember : crewMembers) {
				if (crewMember instanceof Officer) {
					tempOfficer = (Officer) crewMember;
					if (!isExistOfficer) {
						highestRankingOfficer = tempOfficer;
						isExistOfficer = true;
					}
					else {
						if(highestRankingOfficer.getRank().compareTo(tempOfficer.getRank()) <= 0) {
							highestRankingOfficer = tempOfficer;
						}
					}
				}
			}
			highestRankingOfficerPerShip.put(highestRankingOfficer, spaceship);
		}
		return highestRankingOfficerPerShip;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map <OfficerRank, Integer> rankPopularity = new HashMap<>();
		List <Map.Entry<OfficerRank, Integer>> officerRanksSortedByPopularity;
		Officer officerCrewMember;
		OfficerRank officerRank;
		Set <? extends CrewMember> crewMembers;

		for (Spaceship spaceship : fleet) {
			crewMembers = spaceship.getCrewMembers();
			for (CrewMember crewMember : crewMembers) {
				if (crewMember instanceof Officer) {
					officerCrewMember = (Officer) crewMember;
					officerRank = officerCrewMember.getRank();
					if (!rankPopularity.containsKey(officerRank)) {
						rankPopularity.put(officerRank, 1);
					} else {
						rankPopularity.put(officerRank, rankPopularity.get(officerRank) + 1);
					}
				}
			}
		}
		officerRanksSortedByPopularity = new ArrayList<>(rankPopularity.entrySet());
		officerRanksSortedByPopularity.sort(
				(x, y) -> {
				if(x.getValue().compareTo(y.getValue()) != 0) {
					return x.getValue().compareTo(y.getValue());
				}
				return x.getKey().compareTo(y.getKey());
				});
		return officerRanksSortedByPopularity;
	}

}
