# Pandemic_Simulation
Pandemic Simulation Project

*Project Overview :*

This project simulates a pandemic scenario using Java. It models the spread of a virus (e.g., COVID-19) among different types of agents, such as humans and mutants, using object-oriented programming concepts. The simulation tracks the infection spread, manages infected individuals, and includes potential exceptions for conditions like complete infection of all humans. This project provides insights into how a pandemic might progress within a population.

*Project Structure :*

  - Actor.java: A base class that defines the essential attributes and behaviors shared among different actors in the simulation.
  - Human.java: Represents a human agent within the simulation, with behaviors and attributes related to infection susceptibility.
  - Infected.java: Extends the behavior of Human to represent infected individuals, tracking their infection status and progression.
  - Covided.java: Simulates the spread of COVID-19, detailing infection mechanics.
  - MutantCovided.java: Represents a mutant strain, inheriting from Covided and modifying infection dynamics for mutant cases.
  - Simulator.java: The main simulation class, which orchestrates the simulation, tracking and updating the states of all actors over time.
  - AllHumansInfectedException.java: Custom exception that is triggered when all humans in the simulation are infected, marking a critical threshold.

*Key Features :*
  - Agent-Based Simulation: Models the behavior of individual agents (humans, infected, mutants).
  - Virus Mutation: Simulates virus mutation with MutantCovided, adding variability to infection spread.
  - Exception Handling: Includes custom exceptions to manage edge cases, like total human infection.
  - Dynamic Simulation Control: Allows for real-time tracking and control of simulation events through Simulator.java.
