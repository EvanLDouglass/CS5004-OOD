package edu.neu.khoury.cs5004.problem1;

/**
 * A collection of the command line arguments for a given operation in Homebake.
 */
public class HomebakeData {

  private String formula;
  private Boolean warningsFlag = false;
  private Boolean verboseFlag = false;
  private Boolean debugFlag = false;

  /**
   * Constructor for data
   *
   * @param args the command line arguments
   */
  public HomebakeData(String[] args) {
    this.formula = args[1];
    for (int i = 2; i < args.length; i++) {
      setFlag(args[i]);
    }
  }

  /**
   * Sets a single flag value.
   * @param arg a flag value
   * @throws IllegalArgumentException if the flag given is not recognized
   */
  private void setFlag(String arg) throws IllegalArgumentException {
    switch (arg) {
      case "-q":
        this.warningsFlag = true;
        break;
      case "-v":
        this.verboseFlag = true;
        break;
      case "-d":
        this.debugFlag = true;
        break;
      default:
        throw new IllegalArgumentException("Unrecognized flag: " + arg);
    }
  }

  public String getFormula() {
    return formula;
  }

  public Boolean getWarningsFlag() {
    return warningsFlag;
  }

  public Boolean getVerboseFlag() {
    return verboseFlag;
  }

  public Boolean getDebugFlag() {
    return debugFlag;
  }
}
