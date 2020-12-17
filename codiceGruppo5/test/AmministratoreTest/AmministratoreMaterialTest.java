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
import progettosegruppo5.Materiale;
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreMaterialTest {

    private Amministratore a;
    private Query q;
    
    /*
    Test per story ID 12: List of materials
    Alessia Carbone 0622701487
    10/12/2020
    */

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }

    @Test
    public void test1InsertMaterial() throws SQLException {
        a.insertMaterial("provaMateriale");
        String query = "select nomemateriale from materiali where nomemateriale = 'provaMateriale'";
        String nomeSite = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeSite = s.getString("nomemateriale");
            test = s.next();
        }

        assertEquals(nomeSite, "provaMateriale");

    }

    @Test
    public void test2UpdateMaterial() throws SQLException {
        a.updateMaterial("provaMateriale", "nuovaProvaMateriale");
        String query = "select nomemateriale from materiali where nomemateriale = 'nuovaProvaMateriale'";
        String nomeMateriale = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeMateriale = s.getString("nomemateriale");
            test = s.next();
        }

        assertEquals(nomeMateriale, "nuovaProvaMateriale");

    }

    @Test
    public void test3ViewMaterials() throws SQLException {
        LinkedList<Materiale> returnedMaterials = a.viewMaterials();
        String query = "select nomemateriale from materiali";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<Materiale> mat = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String nomeMateriale = rst.getString("nomemateriale");
            mat.add(new Materiale(nomeMateriale));
            test = rst.next();

        }
        for (int i = 0; i < returnedMaterials.size(); i++) {
            assertEquals(returnedMaterials.get(i).getNomeMateriale(), mat.get(i).getNomeMateriale());

        }
    }

    @Test(expected = SQLException.class)
    public void test4DeleteMaterial() throws SQLException {
        a.deleteMaterial("nuovaProvaMateriale");
        String query = "select nomemateriale from materiali where nomemateriale = 'nuovaProvaMateriale'";
        String nomeMateriale = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeMateriale = s.getString("nomemateriale");
            test = s.next();
        }

        assertEquals(nomeMateriale, "nuovaProvaMateriale");

    }
}
