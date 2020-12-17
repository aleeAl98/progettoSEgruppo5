package AmministratoreTest;

//Gruppo 5
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreMaintainanceTypeTest {

    private Amministratore a;
    private Query q;

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }

    /*
    Test per story ID 10: List of maintainance's types
    Daniela Cavallaro  0612703975
    1/12/2020
    */
    @Test
    public void test1InsertMaintainanceType() throws SQLException {

        a.insertMaintainanceType("Electrical");
        String query = "select tipo from maintainancetype where tipo = 'Electrical'";
        String tipo = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            tipo = s.getString("tipo");
            test = s.next();
        }

        assertEquals(tipo, "Electrical");

    }

    @Test
    public void test2UpdateMaintainanceType() throws SQLException {
        a.updateMaintainanceType("Electrical", "Hydraulic");
        String query = "select tipo from maintainancetype where tipo = 'Hydraulic'";
        String tipo = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            tipo = s.getString("tipo");
            test = s.next();
        }
        assertEquals(tipo, "Hydraulic");
    }

    @Test
    public void test3ViewMaintainanceTypes() throws SQLException {
        LinkedList<String> returnedTypes = a.viewTypes();
        String query = "select tipo from maintainancetype";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<String> tipi = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String tipo = rst.getString("tipo");
            tipi.add(tipo);
            test = rst.next();
        }
       for (int i = 0; i < returnedTypes.size(); i++) {
            assertEquals(returnedTypes.get(i), tipi.get(i));
        }
    }

    @Test(expected = SQLException.class)
    public void test4DeleteMaintainanceType() throws SQLException {
        a.deleteMaintainanceType("Hydraulic");
        String query = "select tipo from maintainancetype where tipo = 'Hydraulic'";
        String tipo = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            tipo = s.getString("tipo");
            test = s.next();
        }
        assertEquals(tipo, "Hydraulic");

    }

}
