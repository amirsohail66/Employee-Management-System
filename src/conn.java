import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection c;
    Statement s;

    public conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Aliah@662462");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
