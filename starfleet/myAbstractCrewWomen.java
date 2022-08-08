package il.ac.tau.cs.sw1.ex9.starfleet;

public abstract class myAbstractCrewWomen implements CrewMember {

    protected String name;
    protected int age;
    protected int yearsInService;

    public myAbstractCrewWomen(String name, int age, int yearsInService) {
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getYearsInService() {
        return yearsInService;
    }
}
