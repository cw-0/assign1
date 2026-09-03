package assignOne;

import java.util.Random;

public class Problem2 {
  public static int PASSED_CASE_COUNT, FAILED_CASE_COUNT, RANDOM_CASE_COUNT = 0;

  public static void main(String[] args) {
    testIntToString(-34, "-34");
    testIntToString(-10, "-10");
    testIntToString(-2, "-2");
    testIntToString(-1, "-1");
    testIntToString(0, "0");
    testIntToString(000, "0");
    testIntToString(-0, "0");
    testIntToString(1, "1");
    testIntToString(2, "2");
    testIntToString(10, "10");
    testIntToString(34, "34");
    Random random = new Random();
    for (int i = 0; i < 10; i++) {
      testIntToString(random.nextInt(-999999, 999999), true);
    }
    System.out.printf("PASSED: %d\n", PASSED_CASE_COUNT);
    System.out.printf("FAILED: %d\n", FAILED_CASE_COUNT);
    System.out.printf("RANDINT TESTS RAN: %d\n", RANDOM_CASE_COUNT);
  }

  public static String intToString(int value) {
    if (value == 0) {
      return "0";
    }
    boolean negative = false;

    if (value < 0) {
      negative = true;
      value *= -1;
    }
    String result = "";
    while (value > 0) {
      result = ((char)((value % 10) + 48)) + result;
      value /= 10;
    }
    if (negative) {
      result = '-' + result;
    }
    return result;
  }

  public static void testIntToString(int value, String expectedString) {
    String result = intToString(value);
    if (result.equals(expectedString)) {
      System.out.printf("PASSED\nInt Given:%d\nString Returned:%s\n\n", value,
                        result);
      PASSED_CASE_COUNT++;
    } else {
      System.out.printf(
          "FAILED\nInt Given:%d\nString Returned:%s\nExpected String:%s\n\n",
          value, result, expectedString);
      FAILED_CASE_COUNT++;
    }
  }

  public static void testIntToString(int value, boolean isRandom) {
    String result = intToString(value);
    System.out.printf("TEST RAND INT\nInt Given:%d\nString Returned:%s\n\n",
                      value, result);
    RANDOM_CASE_COUNT++;
  }
}
