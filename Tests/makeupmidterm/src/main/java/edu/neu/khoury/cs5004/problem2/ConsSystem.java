package edu.neu.khoury.cs5004.problem2;

/**
 * A non-empty recursive implementation of a Swim Team Management System.
 *
 * @author evandouglass
 */
public class ConsSystem implements ISwimTeamManagementSystem {

  private Swimmer swimmer;
  private ISwimTeamManagementSystem rest;

  public ConsSystem(Swimmer swimmer, ISwimTeamManagementSystem rest) {
    this.swimmer = swimmer;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public ISwimTeamManagementSystem add(Swimmer swimmer) {
    if (contains(swimmer)) {
      return this;
    }
    return new ConsSystem(swimmer, this);
  }

  @Override
  public ISwimTeamManagementSystem remove(Swimmer swimmer) {
    if (this.swimmer.equals(swimmer)) {
      return rest.remove(swimmer);
    }
    return new ConsSystem(this.swimmer, rest.remove(swimmer));
  }

  @Override
  public Boolean contains(Swimmer swimmer) {
    if (this.swimmer.equals(swimmer)) {
      return true;
    }
    return rest.contains(swimmer);
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  @Override
  public ISwimTeamManagementSystem filterByDiscipline(DisciplineType type) {
    if (this.swimmer.getDiscipline() != type) {
      return rest.filterByDiscipline(type);
    }
    return new ConsSystem(this.swimmer, rest.filterByDiscipline(type));
  }
}
