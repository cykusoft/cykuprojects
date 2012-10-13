
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnect {
    private static AppConnect appcon;
    
    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:sqlitedb/dbLocal.sqlite");
        } catch (ClassNotFoundException | SQLException ex) {}
        return null;
    }
}