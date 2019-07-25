package edu.neu.khoury.cs5004.problem1;

/**
 * Provides common functionality for an operation
 */
public abstract class AbstractOperation implements HomebakeOperation {

  private HomebakeData data;
  private OperationValidator validator;

  /**
   * Basic constructor.
   *
   * @param validator a validator used to ensure arguments are valid
   */
  public AbstractOperation(OperationValidator validator) {
    this.validator = validator;
  }

  @Override
  public void validateArgs(String[] args) {
    validator.validateArgs();
  }

  @Override
  public void setData(HomebakeData data) {
    this.data = data;
  }
}
