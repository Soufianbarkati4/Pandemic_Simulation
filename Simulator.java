package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Simulates a pandemic. Sort of.
 */
class Simulator {
    // List of actors currently in the simulation
    private List<Actor> actors;

    Simulator() {
        // Create characters
        actors = List.of(
            new Human("Human 1"),
            new Human("Human 2"),
            new Covided("Covided 1"),
            new Covided("Covided 2")
        );

        // ...uncomment the following lines (question 5)...
        actors = new ArrayList<>(actors);
        actors.add(new MutantCovided("MutantCovided 1"));
    }

    public static void main(String[] args) {
        Simulator sim = new Simulator();
        sim.run();
    }

    static boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * @return The number of humans currently in the simulation who are
     * ah...ah...ah...ah...stayinAlive.
     */
    private int nbHumansLeft() {
        // ...needs implementing too...
        return actors.size();
    }

    /**
     * Perform all simulation logic for next turn.
     */
    private void nextTurn() {
        Collections.shuffle(actors);  // randomizes the list order
        // each character encounters the next character in the list
        // ...add your code here (question 7)...
        for (int i = 0; i < actors.size(); i++) {
            if( i == actors.size() - 1)
                actors.get(i).encounters(actors.get(0));
            else
                actors.get(i).encounters(actors.get(i+1));
        }

        // dead actors are removed from the list
        // ...add your code here (question 8)...
        actors.removeIf(actor -> !actor.stayinAlive());

        // Humans that have been infected become covideds
        // ...add your code here (question 9)...
        actors.forEach(actor -> {
                if(actors instanceof Human && ((Human) actors).isInfected()) {
                    actor = ((Human) actor).turnIntoCovided();
                }
        });

        // Perform end-of-turn actions for all characters
        actors.forEach(Actor::endOfTurn);
    }

    private void run() {
        System.out.println("Simulation starts with " + nbHumansLeft() + " humans");
        // iterate until no human remains
        while (nbHumansLeft() > 0) {
            nextTurn();
        }
        throw new AllHumansInfectedException("Nobody left to infect :-(");
    }
}