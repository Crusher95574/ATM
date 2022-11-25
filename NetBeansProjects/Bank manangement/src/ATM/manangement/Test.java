
package ATM.manangement;
import java.sql.*;

// import javax.lang.model.type.ArrayType;

public class Test {
  Connection con;
  Statement stmt;
    public  Test() {
     
        try {
            
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem", "root", "Alka95574");
             stmt = con.createStatement();
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}