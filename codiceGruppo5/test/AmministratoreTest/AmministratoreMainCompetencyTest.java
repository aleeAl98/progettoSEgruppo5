package AmministratoreTest;

//Gruppo 5
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Maintainer;
import progettosegruppo5.Planner;
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreMainCompetencyTest {

    private Planner a;
    private Query q;
    private Amministratore b;
    private Maintainer c;

    public AmministratoreMainCompetencyTest() {
    }

    @Before
    public void setUp() {
        a = new Planner("planner", "planner", "planner");
        q = new Query();
        b = new Amministratore("admin", "admin", "admin");
        c = new Maintainer("main", "main", "main");
    }

    /*
     Test per story ID 9: Maintainer's competencies
     Daniela Cavallaro  0612703975
     1/12/2020
     */
    @Test
    public void test1InsertUserMaintainer() throws SQLException {
        b.insertUser("prova1Maintainer", "prova2Maintainer", "nomemain3", Boolean.FALSE);
        String query = "select nomemaintainer from maintainer where nomemaintainer = 'nomemain3'";
        String nomemaintainer = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomemaintainer = s.getString("nomemaintainer");
            test = s.next();
        }

        assertEquals(nomemaintainer, "nomemain3");
    }

    @Test
    public void test2InsertCompetency() throws SQLException {

        b.insertCompetency("provaCompetencyName");
        String query = "select competenza from competenze where competenza = 'provaCompetencyName'";
        String nomeCompetenza = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeCompetenza = s.getString("competenza");
            test = s.next();
        }

        assertEquals(nomeCompetenza, "provaCompetencyName");

    }

    @Test
    public void test3setCompetencyMaintainer() throws SQLException, ParseException {
        b.setCompetencyMaintainer("nomemain3", "provaCompetencyName");
        String query = "select nomemaintainer from possesso where nomemaintainer = 'nomemain3'";
        String nomemaintainer = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomemaintainer = s.getString("nomemaintainer");
            test = s.next();
        }

        assertEquals(nomemaintainer, "nomemain3");

    }

    @Test
    public void test4InsertProcedure() throws SQLException {
        b.insertProcedure("procedura1", "smp1");
        String query = "select nomeprocedura from maintainanceprocedure where nomeprocedura = 'procedura1'";
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

        assertEquals(nomeprocedura, "procedura1");

    }

    /*
    Test per story ID 6: Maintainer's procedure
    Laura De Vivo 0622701475
    10/12/2020
     */
    @Test
    public void test5InsertRequiredCompetencyforProcedure() throws SQLException {

        b.insertRequiredCompetencyforProcedure("procedura1", "provaCompetencyName");
        String query = "select nomeprocedura, competenza from competenzerichieste where nomeprocedura='procedura1' and competenza = 'provaCompetencyName'";
        String nomeProcedura = null;
        String nomeCompetenza = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeProcedura = s.getString("nomeprocedura");
            nomeCompetenza = s.getString("competenza");
            test = s.next();
        }
        assertEquals(nomeCompetenza, "provaCompetencyName");
        assertEquals(nomeProcedura, "procedura1");
    }

    @Test
    public void test6SetProcedureMaintainer() throws SQLException {
        Boolean returnValue = b.setProcedureMaintainer("nomemain3", "procedura1");
        assertEquals(returnValue, true);
    }
}
