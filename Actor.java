package exam;

/**
 * Behaviour of every actor in the simulation.
 */
interface Actor {
    int INITIAL_RESISTANCE = 100;

    String getName();

    void encounters(Actor other);

    boolean isInfected();

    void says(String saying);

    boolean stayinAlive();

    void endOfTurn();
}
