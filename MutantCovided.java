package exam;

public class MutantCovided extends Covided implements Infected{
    private static final int RESISTANCE_MUTANT_REDUCTION = 30;

    MutantCovided(String name) {
        super(name);
    }

    @Override
    public void infect(Human h) { h.becomeInfected(RESISTANCE_MUTANT_REDUCTION); }
}
