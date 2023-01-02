/**
 * Text Blocks
 * https://openjdk.org/jeps/378
 */
public class TextBlock {
    public static void main(String[] args) {
        String html = "<html>\n" +
                " <body>\n" +
                " <p>Hello, world</p>\n" +
                " </body>\n" +
                "</html>\n";

        var htmlBlock = """
                <html>
                 <body>
                 <p>Hello, world</p>
                 </body>
                 </html>
                """;
        System.out.println(html);
        System.out.println(".................");
        System.out.println(htmlBlock);
    }
}
