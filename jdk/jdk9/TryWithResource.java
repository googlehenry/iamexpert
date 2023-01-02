/**
 *
 *
 * https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 *
 *
 * <=jdk7
 * FileReader fr = new FileReader(path);
 *     BufferedReader br = new BufferedReader(fr);
 *     try {
 *         return br.readLine();
 *     } finally {
 *         br.close();
 *         fr.close();
 *     }
 *
 * <=jdk8
 * try (Statement stmt = con.createStatement()) {
 *         ResultSet rs = stmt.executeQuery(query);
 *
 *         while (rs.next()) {
 *             String coffeeName = rs.getString("COF_NAME");
 *             int supplierID = rs.getInt("SUP_ID");
 *             float price = rs.getFloat("PRICE");
 *             int sales = rs.getInt("SALES");
 *             int total = rs.getInt("TOTAL");
 *
 *             System.out.println(coffeeName + ", " + supplierID + ", " +
 *                                price + ", " + sales + ", " + total);
 *         }
 *     } catch (SQLException e) {
 *         JDBCTutorialUtilities.printSQLException(e);
 *     }
 *
 * <=jdk9, you don’t need to declare r1 and r2:
 * // New and improved try-with-resources statement in Java SE 9
 *  try (resource1;
 *  resource2) {
 *  ...
 *  }
 */
public class TryWithResource {
    public static void main(String[] args) {
        var abc = "";
        var _abcd = "";
    }
}
