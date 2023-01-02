import java.io.FileInputStream;

/**
 * Local Variable Type Inference
 * https://openjdk.org/jeps/286
 */
public class LocalVariable {
    //var a = 100;

    public static void main(String[] args) {
        var age = 100;

        for (var i = 0; i < 100; i++) {
            System.out.println("ok:" + i);
        }

        try (var input = new FileInputStream("some file")) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
