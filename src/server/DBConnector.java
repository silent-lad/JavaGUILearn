package server;
import javax.swing.*;
import java.sql.*;

public class DBConnector {

    /*public static Connection mariaDBconnection() {
        Connection connection;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cab302_assignment?user=root&password=Craigw77");
            JOptionPane.showMessageDialog(null, "Success! Please login:");
            return connection;
            } catch (Exception E) {
                JOptionPane.showMessageDialog(null, E);
                return null;
            }
        }*/

    public static void main(String[] args) {
        System.out.println("Listing all table name in Database!");
        Connection con;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cab302_assignment?user=root&password=Craigw77");
            try{
                DatabaseMetaData dbm = con.getMetaData();
                String[] types = {"TABLE"};
                ResultSet rs = dbm.getTables(null,null,"%",types);
                System.out.println("Table name:");
                while (rs.next()){
                    String table = rs.getString("TABLE_NAME");
                    System.out.println(table);
                }
            }
            catch (SQLException s){
                System.out.println("No any table in the database");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}