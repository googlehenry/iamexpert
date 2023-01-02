/**
 * https://openjdk.org/jeps/395
 */
public class RecordClass {
    public static void main(String[] args) {
        var point = new Point(22.2, 33.33);
        System.out.println("(" + point.x() + "," + point.y() + ")");
    }
}

record Point(double x, double y) {
    public Point(double x, double y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("x,y must by >=0");
        this.x = x;
        this.y = y;
    }
};
