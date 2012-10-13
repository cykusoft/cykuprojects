
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConnect {
    private static AppConnect appcon;
    private Connection connection;
    public static AppConnect getAppConnection(){
        if(appcon == null) {
            appcon = new AppConnect();
        }
        return appcon;
    }
    public Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:sqlitedb/dbLocal.sqlite");
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {  
            System.out.println("Not Connected");
            e.printStackTrace();  
        }
        return connection;
    }
}