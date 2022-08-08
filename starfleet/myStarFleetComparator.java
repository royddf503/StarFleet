package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class myStarFleetComparator <T extends Spaceship> implements Comparator<T> {
    @Override
    public int compare(Spaceship o1, Spaceship o2) {
            int firePowerCompare;
            int commissionYearCompare;

            firePowerCompare = Integer.compare(o1.getFirePower(), o2.getFirePower());
            if (firePowerCompare != 0) {
                return -firePowerCompare;
            }
            commissionYearCompare = Integer.compare(o1.getCommissionYear(), o2.getCommissionYear());
            if (commissionYearCompare != 0) {
                return -commissionYearCompare;
            }
            return o1.getName().compareTo(o2.getName());
    }
}
