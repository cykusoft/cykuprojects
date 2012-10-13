
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;

public class AppSetting extends JFrame{
    public AppSetting(){
        
    }
    public static void main(String [] args) throws SQLException{
        try (Connection connection = AppConnect.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM appsetting")) {  
            while (resultSet.next()) {  
                System.out.println("NAME:" + resultSet.getString("corpname"));  
                System.out.println("ADDRESS :" + resultSet.getString("corpADDR"));
            }
        }
    }
}