/**
 * Switch Expressions
 * https://openjdk.org/jeps/361
 */
public class SwitchExpression {
    public static void main(String[] args) {

        var gender = Gender.BOY;
        int strength = switch (gender) {
            case BOY -> 99;
            case GIRL -> 100;
        };

        int power = switch (gender) {
            case BOY:
                yield 88;
            case GIRL:
                yield 90;
        };

        System.out.println(strength);
        System.out.println(power);
    }
}

enum Gender {
    BOY, GIRL;
}
