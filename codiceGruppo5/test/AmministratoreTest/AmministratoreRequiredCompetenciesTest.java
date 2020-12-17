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
public class AmministratoreRequiredCompetenciesTest {

    private Amministratore a;
    private Query q;

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }

    /*
    Test per story ID 8: List of competencies for a maintainance procedure
    Laura De Vivo 0622701475
    1/12/2020
    */
    @Test
    public void test1InsertProcedure() throws SQLException {
        a.insertProcedure("procedura1", "smp1");
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

    @Test
    public void test2InsertCompetency() throws SQLException {
        a.insertCompetency("competenza1");
        a.insertCompetency("competenza2");
        String query = "select competenza from competenze";
        String nomeCompetenza = "";
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeCompetenza += s.getString("competenza");
            test = s.next();
        }
        assertEquals(nomeCompetenza, "competenza1" + "competenza2");

    }

    @Test
    public void test3InsertRequiredCompetencyforProcedure() throws SQLException {

        a.insertRequiredCompetencyforProcedure("procedura1", "competenza1");
        String query = "select nomeprocedura, competenza from competenzerichieste where nomeprocedura='procedura1' and competenza = 'competenza1'";
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
        assertEquals(nomeCompetenza, "competenza1");
        assertEquals(nomeProcedura, "procedura1");
    }

    @Test
    public void test4updateRequiredCompetencyforProcedure() throws SQLException {
        a.updateRequiredCompetencyforProcedure("procedura1", "competenza1", "competenza2");
        String query = "select nomeprocedura,competenza from competenzerichieste where competenza = 'competenza2' and nomeprocedura='procedura1'";
        String nomeCompetenza = null;
        String nomeProcedura = null;
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
        assertEquals(nomeProcedura, "procedura1");
        assertEquals(nomeCompetenza, "competenza2");
    }

    @Test
    public void test5ViewRequiredCompetencyforProcedure() throws SQLException {
        LinkedList<String> s = a.viewRequiredCompetenciesforProcedure("procedura1");
        
        String query = "select competenza from competenzerichieste where nomeprocedura='procedura1'";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<String> competenze = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String competenza = rst.getString("competenza");
            competenze.add(competenza);
            test = rst.next();
        }
        for(int i=0;i<s.size();i++)
        assertEquals(competenze, s);

    }

    @Test(expected = SQLException.class)
    public void test6DeleteRequiredCompetencyforProcedure() throws SQLException {
        a.deleteRequiredCompetencyforProcedure("procedura1", "competenza2");
        String query = "select nomeprocedura,competenza from competenzerichieste where nomeprocedura='procedura1' and competenza = 'competenza2'";
        String nomeCompetenza = null;
        String nomeProcedura = null;
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
        assertEquals(nomeCompetenza, "procedura1");
        assertEquals(nomeProcedura, "competenza2");

    }

}
