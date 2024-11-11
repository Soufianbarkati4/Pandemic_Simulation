package exam;

/**
 * A human who has become infected with the Covid virus.
 * A covided may infect a human.
 */
class Covided extends Human implements Infected {
    private static final int RESISTANCE_REDUCTION = 10;
    private static final int RESISTANCE_REDUCTION_PER_TURN = 10;
    protected boolean isContagious;

    Covided(String name) {
        // ...add your constructors code here (question 1)...
        this(name, Actor.INITIAL_RESISTANCE/2);
    }

    Covided(String name, int resistance) {
        // ...and here (question 1)...
        super(name, resistance);
        this.isContagious = false;
        this.isInfected = true;
    }

    void becomeContagious() {
        isContagious = true;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void encounters(Actor actor) {
        // ...add your code here (question 2)...
        if(!actor.isInfected() && this.isContagious){
            infect((Human) actor);
            System.out.println(this.name+" is infecting "+ ((Human) actor).name);
        }
    }

    @Override
    public void endOfTurn() {
        // ...add your code here (question 6)...
        if (this.isInfected) {
            this.turnsSinceInfection++;
        }
        if(Simulator.randomBoolean()){
            becomeContagious();
        }
        this.resistance -= RESISTANCE_REDUCTION_PER_TURN;
        says("resistance reduction " + RESISTANCE_REDUCTION_PER_TURN);
    }

    @Override
    public void infect(Human h) { h.becomeInfected(RESISTANCE_REDUCTION); }

    @Override
    public void says(String saying) { System.out.println(getName() + saying); }
}
