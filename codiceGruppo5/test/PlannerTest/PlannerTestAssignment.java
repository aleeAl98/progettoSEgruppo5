package PlannerTest;

//Gruppo 5

import enumeratives.TipoAttività;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.util.LinkedList;
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
public class PlannerTestAssignment {

    private Planner p;
    private Query q;
    private Amministratore a;
    private Maintainer m;

    
    @Before
    public void setUp() {
        p = new Planner("planner", "planner", "planner");
        q = new Query();
        a = new Amministratore("admin", "admin", "admin");
        m = new Maintainer("main", "main", "main");

    }

    /*
    Test per story ID 4: Set an activity to a maintainer
    Chiara Cafaro 0622701443
    10/12/2020
     */
    @Test
    public void test1InsertUserMaintainer() throws SQLException {
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
    public void test2InsertAvailability() throws SQLException {
        java.sql.Date d = java.sql.Date.valueOf("2020-05-03");
        m.insertAvailability(d, "prova3Maintainer", 420);
        String query = "select nomemaintainer from availability where nomemaintainer = 'prova3Maintainer'";
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
    public void test3InsertMaintainanceActivity() throws SQLException, ParseException {
        java.sql.Date d1 = java.sql.Date.valueOf("2020-05-03");
        p.insertMaintainanceActivity("1", "proceduraBase1", TipoAttività.PLANNED, "descrizione1",
                23, Boolean.FALSE, 5, "Elettrica", d1, "Molding", "Fisciano",new LinkedList<>());
        String query = "select activityID from maintainanceactivity where activityID = '1'";
        String activityID = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            activityID = s.getString("activityID");
            test = s.next();
        }

        assertEquals(activityID, "1");

    }

    @Test
    public void test4setMaintainanceActivity() throws SQLException, ParseException {

        p.setMaintainanceActivity("1", "prova3Maintainer", "addio", Date.valueOf("2020-05-03"), 23);
        String query = "select activityID from assegnazioneattivita where activityID = '1'";
        String activityID = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            activityID = s.getString("activityID");
            test = s.next();
        }

        assertEquals(activityID, "1");

    }
    
    /*
    Test per story ID 19: Maintainer's notification
    Chiara Cafaro 0622701443
    Alessia Carbone 0622701487
    Daniela Cavallaro 0612703975
    Laura De Vivo 0622701475
    16/12/2020
    */
    @Test
    public void test5sendNotify() throws SQLException {
        this.p.sendNotify("prova3Maintainer", "notify");
        String query = "select notifica from notifiche where nomemaintainer = 'prova3Maintainer'";
        ResultSet rst = Query.genericQuery(query);
        Boolean test = rst.next();
        String notifica = null;
        if(!test){
            throw new SQLException();
        }
        while(test){
            notifica = rst.getString("notifica");
            test = rst.next();
        }
        assertEquals(notifica, "notify");
    }
}
