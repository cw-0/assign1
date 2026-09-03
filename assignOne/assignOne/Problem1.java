package assignOne;

public class Problem1 {
  public static int PASSED_CASES_COUNT, FAILED_CASES_COUNT = 0;

  public static void main(String[] args) {
    testStrToInt("1429", 1429);
    testStrToInt("-1429", -1429);
    testStrToInt("1", 1);
    testStrToInt("0", 0);
    testStrToInt("000", 0);
    testStrToInt("0001230", 1230);
    testStrToInt("cat", 0);
    testStrToInt("", 0);
    System.out.printf("PASSED: %d\n", Problem1.PASSED_CASES_COUNT);
    System.out.printf("FAILED: %d\n", Problem1.FAILED_CASES_COUNT);
  }

  public static int stringToInt(String str) {
    boolean isNegative = false;
    String newStr = "";
    int result = 0;

    if (str.length() < 1) {
      return 0;
    }
    if (str.charAt(0) == '-' || str.charAt(0) == '+') {
      if (str.charAt(0) == '-') {
        isNegative = true;
      }
      for (int i = 1; i < str.length(); i++) {
        newStr += str.charAt(i);
      }
    } else {
      newStr = str;
    }
    // DEBUG: System.out.printf("NewStr: %s\n", newStr);

    int multiplier = 1;
    for (int i = 0; i < newStr.length() - 1; i++) {
      multiplier *= 10;
    }

    for (int i = 0; i < newStr.length(); i++) {
      if (newStr.charAt(i) < 48 || newStr.charAt(i) > 57) {
        return 0;
      }
      result += (newStr.charAt(i) - 48) * multiplier;
      multiplier /= 10;
    }

    return (isNegative ? (result * -1) : result);
  }

  public static void testStrToInt(String testStr, int expectedValue) {
    int returnedValue = stringToInt(testStr);
    if (returnedValue == expectedValue) {
      System.out.printf("PASSED\nString: \"%s\"\nReturned Value: %d\n\n",
                        testStr, returnedValue);
      Problem1.PASSED_CASES_COUNT++;
    } else {
      System.out.printf(
          "FAILED\nString: \"%s\"\nReturned Value: %d\nExpected Value: %d\n\n",
          testStr, returnedValue, expectedValue);
      Problem1.FAILED_CASES_COUNT++;
    }
  }
}
