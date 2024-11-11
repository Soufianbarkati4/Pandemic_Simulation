package exam;

import java.util.Objects;

/**
 * A human starts with resistance to the Covid virus which is reduced with age.
 * Once their resistance is < 0 the human is dead of old age.
 * A human may become infected with the virus.
 */
class Human implements Actor {
    private static final int RESISTANCE_REDUCTION_PER_TURN = 2;
    private static final int TURNS_BEFORE_COVIDED = 4;

    protected String name;
    protected boolean isInfected;
    protected int resistance;
    protected int turnsSinceInfection;

    Human(String name) { this(name, Actor.INITIAL_RESISTANCE); }

    Human(String name, int resistance) {
        this.name = name;
        this.resistance = resistance;
        isInfected = false;
        turnsSinceInfection = 0;
    }

    void becomeInfected(int reduction) {
        isInfected = true;
        resistance -= reduction;
    }

    Covided turnIntoCovided() {
        // ... add your code here (question 9) ...
        Covided covider = new Covided(this.name,this.resistance);
        covider.becomeContagious();
        return covider;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void encounters(Actor actor) { says("Keep away " + actor.getName()); }

    @Override
    public void endOfTurn() {
        if (isInfected) {
            turnsSinceInfection++;
        }
        resistance -= RESISTANCE_REDUCTION_PER_TURN;
        says("resistance reduction " + RESISTANCE_REDUCTION_PER_TURN);
    }

    @Override
    public boolean isInfected() { return isInfected; }

    @Override
    public void says(String saying) { System.out.println(getName() + " says " + saying); }

    @Override
    public boolean stayinAlive() {
        boolean isAlive = resistance > 0;
        if (!isAlive) {
            System.out.println(name + " has expired");
        }
        return isAlive;
    }

    // ...add your code for equals here (question 11)...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return isInfected == human.isInfected && resistance == human.resistance && turnsSinceInfection == human.turnsSinceInfection && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isInfected, resistance, turnsSinceInfection);
    }
}
