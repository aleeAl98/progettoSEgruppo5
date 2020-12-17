//Gruppo 5
package progettosegruppo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Query {

    private final String url = "jdbc:postgresql://localhost/progettoSE";
    private final String user = "gruppo5";
    private final String pwd = "sofen";
    private static Statement stm;

    public Query() {
        try {
            Connection conn = DriverManager.getConnection(url, user, pwd);
            stm = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ResultSet genericQuery(String query) throws SQLException {
        ResultSet rst = stm.executeQuery(query);
        return rst;

    }

    public static void genericUpdate(String query) throws SQLException {
        stm.executeUpdate(query);
    }

}
