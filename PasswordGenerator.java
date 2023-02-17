/**
 * This program generates a random password.
 */
public class PasswordGenerator {
  public static void main(String[] args) {
    String result = makePassword(16);
    System.out.println(result);
  }

  /**
   * Generates a random password.
   * 
   * @param length the length of the password
   * @return a password of the given length with one digit and one special symbol
   */
  public static String makePassword(int length) {
    // Make an empty string called password
    String password = "";
    // Randomly generate length -2 letters and append them to the password
    for (int i = 0; i < length - 2; i++) {
      password = password + randomCharacter("abcdefghijklmnopqrstuvwxyz");
    }
    // Randomly generate a digit and insert it at a random location in password
    String randomDigit = randomCharacter("0123456789");
    password = insertAtRandom(password, randomDigit);
    // Randomly generate a symbol and insert it at a random location in password
    String randomSymbol = randomCharacter("+-*/?!@#$%&");
    password = insertAtRandom(password, randomSymbol);

    return password;
  }

  /**
   * Returns a string containing one character randomly chosen from a given
   * string.
   * 
   * @param characters the string from which to randomly choose a character
   * @return a substring of length 1, taken at a random index
   */
  public static String randomCharacter(String characters) {
    // n = length of characters
    int n = characters.length();
    // r = a random integer between 0 and n - 1
    int r = (int) (n * Math.random());
    // Return the substring of characters of length 1 that starts at r.
    return characters.substring(r, r + 1);
  }

  /**
   * Inserts one string into another at a random position.
   * 
   * @param str      the string into which another string is inserted
   * @param toInsert the string to be inserted
   * @return the result of inserting toInsert into str
   */
  public static String insertAtRandom(String str, String toInsert) {
    // n = length of str
    int n = str.length();
    // r = a random integer between 0 and n
    int r = (int) ((n + 1) * Math.random());
    // Return the substring of str from 0 to r - 1 + toInsert + the remainder of
    // str.
    return str.substring(0, r) + toInsert + str.substring(r);
  }
}
