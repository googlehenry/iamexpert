/**
 * sealed classes and interfaces
 * https://openjdk.org/jeps/409
 */
public class SealedClass {
    public static void main(String[] args) {
        Fruit fruit1 = new Apple(0.5);
        if (fruit1 instanceof Apple apple) {
            System.out.println("apple:" + apple.getWeight());
        }
    }
}

sealed class Fruit permits Apple, Pear {
    double weight = 0;

    public Fruit(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
}

final class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }
}

final class Pear extends Fruit {
    public Pear(double weight) {
        super(weight);
    }
}
