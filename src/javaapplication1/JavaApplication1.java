package javaapplication1;

import java.sql.*;
import java.util.*;

public class JavaApplication1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_class_1", "root", "1234");
            Statement st = con.createStatement();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter 1.Select 2.Delete 3.Update 4.Insert 5.exit");
                int n = sc.nextInt();
                if (n == 1) {
                    ResultSet rs = st.executeQuery("Select * from Employee");
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Class: " + rs.getInt("sal"));
                    }
                }
                if (n == 2) {
                    System.out.println("Enter a id");
                    int drn = sc.nextInt();
                    st.executeUpdate("delete from Employee where id=" + drn);
                }
                if (n == 3) {
                    System.out.println("enter ID and increment of salary");
                    int i_id = sc.nextInt();
                    int i_sal = sc.nextInt();
                    String sql = "update Employee set sal=sal+(?)where id=(?)";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setInt(1, i_sal);
                    ps.setInt(2, i_id);
                    ps.executeUpdate();
                    System.out.println("salary updated successfully");
                    
                    
                }
                if (n == 4) {
                    System.out.println("enter id, name and sal");
                    int i_id = sc.nextInt();
                    String i_name = sc.next();
                    int i_sal = sc.nextInt();
//                    st.executeUpdate("insert into Employee values(" + i_id + ", '" + i_name + "', " + i_sal + ")");
                    String sql = "INSERT INTO Employee (id, name, sal) VALUES (?, ?, ?)";
                    PreparedStatement ps=con.prepareStatement(sql);
                    ps.setInt(1, i_id);
                    ps.setString(2, i_name);
                    ps.setInt(3, i_sal);

                    ps.executeUpdate();

                }
                if (n == 5) {
                    System.exit(0);
                }
            }

        } catch (Exception e) {
        }

    }

}
