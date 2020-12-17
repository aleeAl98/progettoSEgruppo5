//Gruppo 5
package PlannerTest;

import enumeratives.GeneralState;
import enumeratives.TipoAttività;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import progettosegruppo5.MaintainanceActivity;
import progettosegruppo5.Planner;
import progettosegruppo5.Query;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlannerTestActivities {

    private Planner p;
    private Query q;

    @Before
    public void setUp() {
        p = new Planner("planner", "planner", "planner");
        q = new Query();

    }

    /*
    Test per story ID 3: Planner's Management for activities
    Alessia Carbone 0622701487
    28/11/2020
    */
    @Test
    public void test1InsertMaintainanceActivity() throws SQLException, ParseException {
        java.sql.Date d1 = java.sql.Date.valueOf("2011-03-02");
        p.insertMaintainanceActivity("activity1", "proceduraBase1", TipoAttività.PLANNED, "descrizione1",
                23, Boolean.FALSE, 5, "Elettrica", d1, "Molding", "Fisciano", new LinkedList<>());
        String query = "select activityID from maintainanceactivity where activityID = 'activity1'";
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

        assertEquals(activityID, "activity1");

    }

    @Test
    public void test2GetArea() throws SQLException {
        java.sql.Date d1 = java.sql.Date.valueOf("2011-03-02");
        MaintainanceActivity attività = new MaintainanceActivity("activity1", "proceduraBase1", TipoAttività.PLANNED, "descrizione1", 23, Boolean.FALSE, 5, "Elettrica", d1, GeneralState.NOTSTARTED);
        String a = attività.getArea();
        String query = "select area from possessos where activityid = '" + attività.getActivityID() + "'";
        ResultSet rst = null;
        rst = Query.genericQuery(query);
        Boolean test = rst.next();
        String area = null;
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            area = rst.getString("area");
            test = rst.next();
        }
        assertEquals(a, area);
    }

    @Test
    public void test3GetFactorySite() throws SQLException {
        java.sql.Date d1 = java.sql.Date.valueOf("2011-03-02");
        MaintainanceActivity attività = new MaintainanceActivity("activity1", "proceduraBase1", TipoAttività.PLANNED, "descrizione1", 23, Boolean.FALSE, 5, "Elettrica", d1, GeneralState.NOTSTARTED);
        String f = attività.getFactorySite();
        String query = "select factorysite from possessos where activityid = '" + attività.getActivityID() + "'";
        ResultSet rst = null;
        rst = Query.genericQuery(query);
        Boolean test = rst.next();
        String factorySite = null;
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            factorySite = rst.getString("factorysite");
            test = rst.next();
        }
        assertEquals(f, factorySite);
    }

    @Test
    public void test4ViewMaintainanceActivity() throws SQLException {
        ArrayList<MaintainanceActivity> l = p.viewMaintainanceActivity();
        String string = "";
        for (MaintainanceActivity m : l) {
            string = string + m.toString() + "/";
        }
        String query = "select activityID,nomeProcedura,tipologia,descrizione,tempo, interrompibile, "
                + "settimana,tipo, data, generalState from maintainanceactivity";
        ResultSet rst = Query.genericQuery(query);
        String activity = "";

        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String activityID = rst.getString("activityID");
            String nomeProcedura = rst.getString("nomeProcedura");
            String tipologia = rst.getString("tipologia");
            String descrizione = rst.getString("descrizione");
            int tempo = rst.getInt("tempo");
            Boolean interrompibile = rst.getBoolean("interrompibile");
            int settimana = rst.getInt("settimana");
            String tipo = rst.getString("tipo");
            Date data = rst.getDate("data");
            String generalState = rst.getString("generalState");

            activity = activity + (activityID + "\t" + nomeProcedura + "\t" + tipologia + "\t"
                    + descrizione + "\t" + tempo + "\t" + interrompibile + "\t" + settimana + "\t" + tipo + "\t" + data + "\t" + generalState)
                    + "/";
            test = rst.next();
        }

        assertEquals(activity, string);

    }

    @Test
    public void test5UpdateMaintainanceActivity() throws SQLException {
        p.updateMaintainanceActivity("NOTSTARTED", "STARTED");
        String query = "select generalState from maintainanceactivity where generalState = 'STARTED'";
        String generalState = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            generalState = s.getString("generalState");
            test = s.next();
        }

        assertEquals(generalState, "STARTED");
    }

    @Test(expected = SQLException.class)
    public void test6DeleteMaintainanceActivity() throws SQLException {
        p.deleteMaintainanceActivity("activity1");
        String query = "select activityID from maintainanceactivity where activityID = 'activity1'";
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

        assertEquals(activityID, "activity1");

    }
    
    /*
    Test per story ID 13: Planner's EWO add
    Laura De Vivo 0622701475
    10/12/2020
    */
    @Test
    public void test7addEWOActivity() throws SQLException, ParseException {
        java.sql.Date d1 = java.sql.Date.valueOf("2020-05-04");
        p.addEWOActivity("activit60", "proceduraBase1", TipoAttività.EWO, "descrizione1",
                23, Boolean.FALSE, 5, "Elettrica", d1, "Molding", "Fisciano", new LinkedList<>());
        String query = "select activityID from maintainanceactivity where activityID = 'activit60'";
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

        assertEquals(activityID, "activit60");

    }
    
    @Test(expected = SQLException.class)
    public void test8addEWOActivity() throws SQLException, ParseException {
        java.sql.Date d1 = java.sql.Date.valueOf("2020-05-04");
        p.addEWOActivity("activit70", "proceduraBase1", TipoAttività.PLANNED, "descrizione1",
                23, Boolean.FALSE, 5, "Elettrica", d1, "Molding", "Fisciano", new LinkedList<>());
        String query = "select activityID from maintainanceactivity where activityID = 'activit70'";
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

        assertEquals(activityID, "activit70");

    }
}
