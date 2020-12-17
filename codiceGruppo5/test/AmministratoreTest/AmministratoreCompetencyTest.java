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
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreCompetencyTest {
    
    private Amministratore a;
    private Query q;

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }
    
    /*
    Test per story ID 7: List of Competencies
    Chiara Cafaro 0622701443
    1/12/2020
    */
    @Test
    public void test12InsertCompetency() throws SQLException {

        a.insertCompetency("provaCompetencyName");
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
    public void test13UpdateCompetency() throws SQLException {
        a.updateCompetency("provaCompetencyName", "nuovaProvaCompName");
        String query = "select competenza from competenze";
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
        assertEquals(nomeCompetenza, "nuovaProvaCompName");
    }

    @Test
    public void test14ViewCompetency() throws SQLException {
        LinkedList<String> returnedCompetencies = a.viewCompetencies();
        String query = "select competenza from competenze";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<String> comp= new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String competenza = rst.getString("competenza");
            comp.add(competenza);
            test = rst.next();
        }
        for (String s : returnedCompetencies) {
            if(comp.contains(s))
                assertEquals(s, comp.get(comp.indexOf(s)));
        }
    }
    
    @Test(expected = SQLException.class)
    public void test15DeleteCompetency() throws SQLException {
        a.deleteCompetency("nuovaProvaCompName");
        String query = "select competenza from competenze where competenza = 'nuovaProvaCompName'";
        String nomecompetenza = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomecompetenza = s.getString("competenza");
            test = s.next();
        }
        assertEquals(nomecompetenza, "nuovaProvaCompName");

    }
}
