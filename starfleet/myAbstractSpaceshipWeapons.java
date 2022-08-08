package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myAbstractSpaceshipWeapons extends myAbstractSpaceship{

    protected List<Weapon> weapons;

    public myAbstractSpaceshipWeapons(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List <Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }


    public int getFirePower() {
        return FIRE_POWER_DEFAULT + getSumFirePowerWeapons();
    }

    public List<Weapon> getWeapon() {
        return weapons;
    }

    protected int getSumAnnualMaintenanceCostWeapons() {
        int sum = 0;
        for (Weapon weapon : weapons) {
            sum += weapon.getAnnualMaintenanceCost();
        }
        return sum;
    }

    private int getSumFirePowerWeapons() {
        int sum = 0;
        for (Weapon weapon : weapons) {
            sum += weapon.getFirePower();
        }
        return sum;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t" + "WeaponArray=" + weapons;
    }
}
