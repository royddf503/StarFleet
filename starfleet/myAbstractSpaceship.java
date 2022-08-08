package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship{
    protected String name;
    protected int commissionYear;
    protected float maximalSpeed;
    protected Set<? extends CrewMember> crewMembers;
    protected final static int FIRE_POWER_DEFAULT = 10;


    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set <? extends CrewMember> crewMembers) {
        this.name = name;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCommissionYear() {
        return commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public Set <? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\n\t" + "Name=" + name + "\n\t" + "CommissionYear=" + commissionYear + "\n\t" + "MaximalSpeed=" + maximalSpeed + "\n\t"
                + "FirePower=" + getFirePower() + "\n\t" + "CrewMembers=" + crewMembers.size() + "\n\t"
                + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return commissionYear == that.commissionYear &&
                Float.compare(that.maximalSpeed, maximalSpeed) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(crewMembers, that.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commissionYear, maximalSpeed, crewMembers);
    }
}
