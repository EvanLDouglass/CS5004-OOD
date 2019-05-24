package edu.neu.khoury.cs5004.game;

public class Marine extends Soldier {

  public Marine(Name name, Age age, Double stamina) {
    super(name, age, stamina);
  }

  @Override
  public String toString() {
    return String.format(
        "Marine{%s, %s, %s}",
        this.getName(), this.getAge(), this.getStamina()
    );
  }
}
