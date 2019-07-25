package edu.neu.khoury.cs5004.problem1;

public class HomebakeProcessor {

  public static void main(String[] args) {
    HomebakeOperation op = getOp(args);
    op.validateArgs(args);
    op.setData(new HomebakeData(args));
    op.execute();
  }

  private static HomebakeOperation getOp(String[] args)
      throws IllegalArgumentException {
    if (args.length == 0) {
      throw new IllegalArgumentException(
          "No arguments detected. Usage: Homebake <operation> <formula> [flags]");
    }
    switch (args[0]) {
      case "install":
        return new Install(new OperationValidator(args));
      case "uninstall":
        return new Uninstall(new OperationValidator(args));
      case "update":
        return new Update(new OperationValidator(args));
      default:
        String msg = "Unrecognized operation: " + args[0];
        throw new IllegalArgumentException(msg);
    }
  }
}
