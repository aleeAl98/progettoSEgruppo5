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
public class AmministratoreUsersTest {

    private Amministratore a;
    private Query q;

    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }

    /*
    Test per story ID 1: User management 
    Laura De Vivo 0622701475
    28/11/2020
    */
    @Test
    public void test1InsertUserPlanner() throws SQLException {

        a.insertUser("prova1Planner", "prova2Planner", "prova3Planner", Boolean.TRUE);
        String query = "select nomeplanner from planner where nomeplanner = 'prova3Planner'";
        String nomeplanner = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeplanner = s.getString("nomeplanner");
            test = s.next();
        }

        assertEquals(nomeplanner, "prova3Planner");

    }

    @Test
    public void test2InsertUserMaintainer() throws SQLException {
        a.insertUser("prova1Maintainer", "prova2Maintainer", "prova3Maintainer", Boolean.FALSE);
        String query = "select nomemaintainer from maintainer where nomemaintainer = 'prova3Maintainer'";
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

        assertEquals(nomemaintainer, "prova3Maintainer");
    }

    @Test
    public void test3UpdateUserPlanner() throws SQLException {
        a.updateUser("prova3Planner", "nuovaprova3Planner", Boolean.TRUE);
        String query = "select nomeplanner from planner where nomeplanner = 'nuovaprova3Planner'";
        String nomeplanner = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeplanner = s.getString("nomeplanner");
            test = s.next();
        }

        assertEquals(nomeplanner, "nuovaprova3Planner");
    }

    @Test
    public void test4UpdateUserMaintainer() throws SQLException {
        a.updateUser("prova3Maintainer", "nuovaprova3Ma", Boolean.FALSE);
        String query = "select nomemaintainer from maintainer where nomemaintainer = 'nuovaprova3Ma'";
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

        assertEquals(nomemaintainer, "nuovaprova3Ma");
    }

    @Test
    public void test5ViewUser() throws SQLException {
        LinkedList<String> returnedUsers = a.viewUser();
        String query = "select nomeplanner as nomeutenti from planner union select nomemaintainer from maintainer";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<String> users = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            users.add(rst.getString("nomeutenti"));
            test = rst.next();

        }
        for (int i = 0; i < returnedUsers.size(); i++) {
            assertEquals(returnedUsers.get(i), users.get(i));
            assertEquals(returnedUsers.get(i), users.get(i));
        }
    }

    @Test(expected = SQLException.class)
    public void test6DeleteUserPlanner() throws SQLException {
        a.deleteUser("nuovaprova3Planner", Boolean.TRUE);
        String query = "select nomeplanner from planner where nomeplanner = 'nuovaprova3Planner'";
        String nomeplanner = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeplanner = s.getString("nomeplanner");
            test = s.next();
        }

        assertEquals(nomeplanner, "nuovaprova3Planner");

    }

    @Test(expected = SQLException.class)

    public void test7DeleteUserMaintainer() throws SQLException {
        a.deleteUser("nuovaprova3Ma", Boolean.FALSE);
        String query = "select nomemaintainer from maintainer where nomemaintainer = 'nuovaprova3Ma'";
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

        assertEquals(nomemaintainer, "nuovaprova3Ma");

    }

}
