package AmministratoreTest;

//Gruppo 5
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import progettosegruppo5.Amministratore;
import progettosegruppo5.MaintainanceProcedure;
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreProcedureTest {
    
    private Amministratore a;
    private Query q;

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }
    
    /*
    Test per story ID 5: List of Maintainance Procedure
    Daniela Cavallaro  0612703975
    28/11/2020
    */
    @Test
    public void test8InsertProcedure() throws SQLException {
        a.insertProcedure("provaProcedureName", "provaProcFileName");
        String query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = 'provaProcedureName'";
        String nomeprocedura = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeprocedura = s.getString("nomeprocedura");
            test = s.next();
        }

        assertEquals(nomeprocedura, "provaProcedureName");

    }

    @Test
    public void test9UpdateProcedure() throws SQLException {
        a.updateProcedure("provaProcedureName", "nuovaProvaProcName", "provaProcFileName", "nuovaProvaFileName");
        String query = "select nomeprocedura,smp from maintainanceprocedure ";
        String nomeprocedura = null;
        String smp = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeprocedura = s.getString("nomeprocedura");
            smp = s.getString("smp");
            test = s.next();
        }

        assertEquals(nomeprocedura, "nuovaProvaProcName");
        assertEquals(smp, "nuovaProvaFileName");
    }
    
    @Test(expected = SQLException.class)
    public void test10DeleteProcedure() throws SQLException {
        a.deleteProcedure("nuovaProvaProcName");
        String query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = 'nuovaProvaProcName'";
        String nomeprocedura = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeprocedura = s.getString("nomeprocedura");
            test = s.next();
        }

        assertEquals(nomeprocedura, "nuovaProvaProcName");

    }
    
    @Test
    public void test11ViewProcedure() throws SQLException {
        LinkedList<MaintainanceProcedure> returnedProcedures = a.viewProcedures();
        String query = "select nomeprocedura,smp from maintainanceprocedure";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<MaintainanceProcedure> procedure = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String nomeprocedura = rst.getString("nomeprocedura");
            String smp = rst.getString("smp");
            procedure.add(new MaintainanceProcedure(nomeprocedura, smp));
            test = rst.next();

        }
        for (int i = 0; i < returnedProcedures.size(); i++) {
            assertEquals(returnedProcedures.get(i).getProcedureName(), procedure.get(i).getProcedureName());
            assertEquals(returnedProcedures.get(i).getSMP(), procedure.get(i).getSMP());

        }
    }
}
