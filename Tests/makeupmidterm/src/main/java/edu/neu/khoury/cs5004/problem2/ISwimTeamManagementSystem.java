package edu.neu.khoury.cs5004.problem2;

/**
 * Describes the behavior of a swim team management system.
 *
 * @author evandouglass
 */
public interface ISwimTeamManagementSystem {

  /**
   * Checks if the system is empty.
   *
   * @return true if empty, else false
   */
  Boolean isEmpty();

  /**
   * Adds a swimmer to the system.
   *
   * @param swimmer the swimmer to add
   * @return a new system with the swimmer added
   */
  ISwimTeamManagementSystem add(Swimmer swimmer);

  /**
   * Removes a swimmer from the system.
   *
   * @param swimmer the swimmer to remove
   * @return a new system with the swimmer removed
   */
  ISwimTeamManagementSystem remove(Swimmer swimmer);

  /**
   * Checks if a swimmer is in the system.
   *
   * @param swimmer the swimmer to check for
   * @return true if in the system, else false
   */
  Boolean contains(Swimmer swimmer);

  /**
   * Gets the number of swimmers in the system.
   *
   * @return the size
   */
  Integer size();

  /**
   * Returns a new system, with only those swimmers who are in the given discipline type.
   *
   * @param type a DisciplineType
   * @return a new filtered system
   */
  ISwimTeamManagementSystem filterByDiscipline(DisciplineType type);
}
