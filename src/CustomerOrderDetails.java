
import java.sql.*;
import java.util.Scanner;

public class CustomerOrderDetails {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_class_1", "root", "1234");
            Statement st = con.createStatement();
            Scanner sc = new Scanner(System.in);

//            PreparedStatement ps = con.prepareStatement("INSERT INTO CustomerOrder (o_id, o_name,o_price) VALUES (?, ?,?)");
//            for (int i = 0; i < 5; i++) {
//                System.out.println("enter order id, order name and price");
//                int or_id = sc.nextInt();
//                String or_name = sc.next();
//                int or_price = sc.nextInt();
//                ps.setInt(1, or_id);
//                ps.setString(2, or_name);
//                ps.setInt(3, or_price);
//                ps.addBatch();
//            }
//            int[] updateCounts = ps.executeBatch();
//            System.out.println("Rows affected: " + updateCounts[0]);

            ResultSet rs = st.executeQuery("Select * from CustomerOrder");
            while (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("o_id") + ", Order Name: " + rs.getString("o_name") + ", Price : " + rs.getInt("o_price"));
            }

        } catch (Exception e) {
        }
    }

}
