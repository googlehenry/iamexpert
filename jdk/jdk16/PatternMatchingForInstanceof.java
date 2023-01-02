/**
 * Pattern Matching for instanceof
 * https://openjdk.org/jeps/394
 *
 * // Old code
 * if (o instanceof String) {
 *     String s = (String)o;
 *     ... use s ...
 * }
 *
 * // New code
 * if (o instanceof String s) {
 *     ... use s ...
 * }
 */
public class PatternMatchingForInstanceof {
    public static void main(String[] args) {
        Object obj = "abcdef";
        if (obj instanceof String str) {
            String s = (String) obj;
            System.out.println("s:" + s);
            System.out.println("str:" + str);
        }
        if (obj instanceof String s && s.length() > 5) {
            System.out.println("I'm longer than 5: "+ s);
        }
    }
}
