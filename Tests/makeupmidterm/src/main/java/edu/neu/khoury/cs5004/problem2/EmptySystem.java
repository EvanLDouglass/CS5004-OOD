package edu.neu.khoury.cs5004.problem2;

/**
 * Implements an empty Swim Team Management System.
 *
 * @author evandouglass
 */
public class EmptySystem implements ISwimTeamManagementSystem {

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public ISwimTeamManagementSystem add(Swimmer swimmer) {
    return new ConsSystem(swimmer, this);
  }

  @Override
  public ISwimTeamManagementSystem remove(Swimmer swimmer) {
    return this;
  }

  @Override
  public Boolean contains(Swimmer swimmer) {
    return false;
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public ISwimTeamManagementSystem filterByDiscipline(DisciplineType type) {
    return this;
  }
}
