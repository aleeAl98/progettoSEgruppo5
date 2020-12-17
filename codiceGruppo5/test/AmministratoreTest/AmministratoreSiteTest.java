package AmministratoreTest;

//Gruppo 5
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import progettosegruppo5.Amministratore;
import progettosegruppo5.Query;
import progettosegruppo5.Site;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmministratoreSiteTest {

    private Amministratore a;
    private Query q;
    
    /*
    Test per story ID 11: List of sites
    Daniela Cavallaro  0612703975
    10/12/2020
     */
    @Before
    public void setUp() {
        a = new Amministratore("admin", "admin", "admin");
        q = new Query();
    }

    @Test
    public void test1InsertSite() throws SQLException {
        a.insertSite("siteName", "areaName");
        String query = "select factorysite from siti where factorysite = 'siteName'";
        String nomeSite = null;
        ResultSet s = Query.genericQuery(query);
        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomeSite = s.getString("factorysite");
            test = s.next();
        }

        assertEquals(nomeSite, "siteName");

    }

    @Test
    public void test2UpdateSite() throws SQLException {
        a.updateSite("siteName", "nuovaSiteName", "areaName", "nuovaAreaName");
        String query = "select factorysite,area from siti where factorysite = 'nuovaSiteName'";
        String nomesite = null;
        String area = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomesite = s.getString("factorysite");
            area = s.getString("area");
            test = s.next();
        }

        assertEquals(nomesite, "nuovaSiteName");
        assertEquals(area, "nuovaAreaName");
    }

    @Test
    public void test3ViewSite() throws SQLException {
        LinkedList<Site> returnedSite = a.viewSite();
        String query = "select factorysite,area from siti";
        ResultSet rst = Query.genericQuery(query);
        LinkedList<Site> site = new LinkedList<>();
        boolean test = rst.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            String nomesite = rst.getString("factorysite");
            String area = rst.getString("area");
            site.add(new Site(nomesite, area));
            test = rst.next();

        }
        for (int i = 0; i < returnedSite.size(); i++) {
            assertEquals(returnedSite.get(i).getSiteName(), site.get(i).getSiteName());
            assertEquals(returnedSite.get(i).getArea(), site.get(i).getArea());

        }
    }

    @Test(expected = SQLException.class)
    public void test4DeleteSite() throws SQLException {
        a.deleteSite("nuovaSiteName","nuovaAreaName");
        String query = "select factorysite from site where factorysite = 'nuovaAreaName' and area = 'nuovaAreaName'";
        String nomesite = null;
        ResultSet s = Query.genericQuery(query);

        boolean test = s.next();
        if (!test) {
            throw new SQLException();
        }
        while (test) {
            nomesite = s.getString("factorysite");
            test = s.next();
        }

        assertEquals(nomesite, "nuovaAreaName");

    } 
}
