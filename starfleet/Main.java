package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new StealthCruiser(
                "Normandy", 2183, 2.98f, Collections.emptySet(), Collections.emptyList());
        List<Weapon> weapon1 = Collections.singletonList(new Weapon("Molecular Disruption Device", 1000000, 100000));
        Bomber b1 = new Bomber("Starfighter #2", 2102, 1f, Collections.emptySet(), weapon1, 1);
        System.out.println(b1.getAnnualMaintenanceCost());
    }

}
