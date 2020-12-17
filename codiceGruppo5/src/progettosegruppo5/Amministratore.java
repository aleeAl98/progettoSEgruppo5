//Gruppo 5 
package progettosegruppo5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Amministratore {

    private final String username;
    private final String password;
    private final String nome;

    public Amministratore(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }
    
    /*
    Story ID 1: User management 
    Laura De Vivo 0622701475
    28/11/2020
     */
    public void insertUser(String username, String password, String nome, Boolean planner) throws SQLException {
        String query = null;
        String query2 = null;
        String query3 = null;
        if (planner) {
            query = "insert into planner (nomeplanner, nomeamministratore) values ('" + nome + "','" + this.nome + "')";
            query2 = "insert into accesso (usernameac, nomeplanner, nomeamministratore, passwordac) values ('" + username + "','" + nome + "','" + this.nome + "','" + password + "')";
        } else {
            query = "insert into maintainer (nomemaintainer, nomeamministratore) values ('" + nome + "','" + this.username + "')";
            query2 = "insert into accesso (usernameac, nomemaintainer, nomeamministratore, passwordac) values ('" + username + "','" + nome + "','" + this.nome + "','" + password + "')";
        } 
        Query.genericUpdate(query);
        Query.genericUpdate(query2);
    }

    public void updateUser(String oldName, String newName, Boolean planner) throws SQLException {
        String query = null;

        if (planner) {
            query = "update planner set nomeplanner = '" + newName + "'where nomeplanner='" + oldName + "'";

        } else {
            query = "update maintainer set nomemaintainer ='" + newName + "'where nomemaintainer='" + oldName + "'";

        }
        Query.genericUpdate(query);
    }

    public void deleteUser(String nome, Boolean planner) throws SQLException {
        String query = null;
        if (planner) {
            query = "delete from planner where nomeplanner='" + nome + "'";

        } else {
            query = "delete from maintainer where nomemaintainer ='" + nome + "'";

        }
        Query.genericUpdate(query);
    }

    public LinkedList viewUser() throws SQLException {
        LinkedList<String> l = new LinkedList<>();
        String query = "select nomeplanner as nomeutenti from planner union select nomemaintainer from maintainer";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();
        if (!test) {
            return new LinkedList<>();
        }
        while (test) {
            String nomeUtente = rst.getString("nomeutenti");
            l.add(nomeUtente);
            test = rst.next();
        }
        return l;
    }

    /*
    Story ID 5: List of Maintainance Procedure
    Daniela Cavallaro  0612703975
    28/11/2020
     */
    public void insertProcedure(String procedureName, String procedureFileName) throws SQLException {
        String query = "insert into maintainanceprocedure (nomeprocedura, smp) values ('" + procedureName + "','" + procedureFileName + "')";
        Query.genericUpdate(query);

    }

    public void updateProcedure(String oldProcedureName, String newProcedureName, String oldProcedureFileName, String newProcedureFileName) throws SQLException {
        String query;
        if (newProcedureName.isEmpty() || oldProcedureName.isEmpty()) {
            if (!oldProcedureFileName.isEmpty() && !newProcedureFileName.isEmpty()) {
                query = "update maintainanceprocedure set smp ='" + newProcedureFileName + "'where smp ='" + oldProcedureFileName + "'";
                Query.genericUpdate(query);
            }
        } else if (!newProcedureName.isEmpty() && !oldProcedureName.isEmpty()) {
            query = "update maintainanceprocedure set nomeprocedura ='" + newProcedureName + "'where nomeprocedura ='" + oldProcedureName + "'";
            Query.genericUpdate(query);
            if (!oldProcedureFileName.isEmpty() && !newProcedureFileName.isEmpty()) {
                String query1 = "update maintainanceprocedure set smp ='" + newProcedureFileName + "'where smp ='" + oldProcedureFileName + "'";
                Query.genericUpdate(query1);
            }
        }
    }

    public void deleteProcedure(String procedureName) throws SQLException {

        String query = "delete from maintainanceprocedure where nomeprocedura='" + procedureName + "'";
        Query.genericUpdate(query);
    }

    public LinkedList viewProcedures() throws SQLException {
        String query;
        LinkedList<MaintainanceProcedure> procedures = new LinkedList<>();

        query = "select nomeprocedura,smp from maintainanceprocedure";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();

        if (!test) {
            System.out.println("Non è presente alcuna procedura");
        }
        while (test) {
            String nomeprocedura = rst.getString("nomeprocedura");
            String smp = rst.getString("smp");
            procedures.add(new MaintainanceProcedure(nomeprocedura, smp));
            test = rst.next();

        }

        return procedures;
    }

    /*
    Story ID 7: List of Competencies
    Chiara Cafaro 0622701443
    1/12/2020
     */
    public void insertCompetency(String competencyName) throws SQLException {
        String query = null;
        query = "insert into competenze (competenza) values ('" + competencyName + "')";
        Query.genericUpdate(query);

    }

    public void updateCompetency(String oldCompetencyName, String newCompetencyName) throws SQLException {
        String query = "update competenze set competenza ='" + newCompetencyName + "' where competenza = '" + oldCompetencyName + "'";
        Query.genericUpdate(query);
    }

    public void deleteCompetency(String competencyName) throws SQLException {
        String query = "delete from competenze where competenza = '" + competencyName + "'";
        Query.genericUpdate(query);
    }

    public LinkedList<String> viewCompetencies() throws SQLException {
        String query = null;
        String competenze = "";
        LinkedList<String> l = new LinkedList<>();

        query = "select competenza from competenze";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();

        if (!test) {
            return new LinkedList<>();
        }
        while (test) {
            String competenza = rst.getString("competenza");
            l.add(competenza);
            test = rst.next();
        }

        return l;
    }

    /*
    Story ID 8: List of competencies for a maintainance procedure
    Laura De Vivo 0622701475
    1/12/2020
     */
    public void insertRequiredCompetencyforProcedure(String procedureName, String competencyName) throws SQLException {
        String query = null;
        query = "insert into competenzerichieste (nomeprocedura,competenza) values ('" + procedureName + "','" + competencyName + "')";
        Query.genericUpdate(query);

    }

    public void updateRequiredCompetencyforProcedure(String procedureName, String oldCompetencyName, String newCompetencyName) throws SQLException {
        String query = null;
        query = "update competenzerichieste set competenza ='" + newCompetencyName + "'where nomeprocedura='" + procedureName + "'";
        Query.genericUpdate(query);
    }

    public void deleteRequiredCompetencyforProcedure(String procedureName, String competencyName) throws SQLException {
        String query = null;
        query = "delete from competenzerichieste where competenza='" + competencyName + "' and nomeprocedura='" + procedureName + "'";
        Query.genericUpdate(query);
    }

    public LinkedList<String> viewRequiredCompetenciesforProcedure(String procedureName) throws SQLException {
        String query = null;
        LinkedList<String> competenze = new LinkedList<>();

        query = "select competenza from competenzerichieste where nomeprocedura='" + procedureName + "'";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();

        if (!test) {
            return competenze;
        }
        while (test) {
            String competenza = rst.getString("competenza");
            competenze.add(competenza);
            test = rst.next();

        }

        return competenze;
    }

    /*
    Story ID 9: Maintainer's competencies
    Daniela Cavallaro 0612703975
    1/12/2020
     */
    public void setCompetencyMaintainer(String nomeMaintainer, String competenza) throws SQLException {
        String query = null;

        query = " insert into possesso (nomemaintainer, competenza) values ('" + nomeMaintainer + "','" + competenza + "')";

        Query.genericUpdate(query);

    }

    /*
    Story ID 10: List of maintainance's types
    Daniela Cavallaro  0612703975
    1/12/2020
     */
    public void insertMaintainanceType(String type) throws SQLException {
        String query = null;
        query = "insert into maintainancetype (tipo) values ('" + type + "')";
        Query.genericUpdate(query);

    }

    public void updateMaintainanceType(String oldTypeName, String newTypeName) throws SQLException {
        String query = null;
        query = "update maintainancetype set tipo='" + newTypeName + "'where tipo='" + oldTypeName + "'";
        Query.genericUpdate(query);
    }

    public void deleteMaintainanceType(String type) throws SQLException {
        String query = null;
        query = "delete from maintainancetype where tipo='" + type + "'";
        Query.genericUpdate(query);
    }

    public LinkedList viewTypes() throws SQLException {
        String query = null;
        LinkedList<String> tipi = new LinkedList<>();
        query = "select tipo from maintainancetype";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();
        if (!test) {
            System.out.println("Non è presente alcun tipo");
        }
        while (test) {
            String tipo = rst.getString("tipo");
            tipi.add(tipo);
            test = rst.next();

        }

        return tipi;
    }

    /*
    Story ID 11: List of sites
    Daniela Cavallaro  0612703975
    10/12/2020
    */
    public void insertSite(String factorySite, String area) throws SQLException {
        String query = "insert into siti (factorysite, area) values ('" + factorySite + "','" + area + "')";
        Query.genericUpdate(query);

    }

    public void updateSite(String oldfactorySiteName, String newfactorySiteName, String oldAreaName, String newAreaName) throws SQLException {
        String query;
        if (newfactorySiteName.isEmpty() || oldfactorySiteName.isEmpty()) {
            if (!oldAreaName.isEmpty() && !newAreaName.isEmpty()) {
                query = "update siti set area ='" + newAreaName + "'where area='" + oldAreaName + "'";
                Query.genericUpdate(query);
            }
        } else if (!newfactorySiteName.isEmpty() && !oldfactorySiteName.isEmpty()) {
            query = "update siti set factorysite ='" + newfactorySiteName + "'where factorysite='" + oldfactorySiteName + "'";
            Query.genericUpdate(query);
            if (!oldAreaName.isEmpty() && !newAreaName.isEmpty()) {
                String query1 = "update siti set area ='" + newAreaName + "'where area='" + oldAreaName + "'";
                Query.genericUpdate(query1);
            }
        }

    }

    public void deleteSite(String factorySite, String area) throws SQLException {
        String query = "delete from siti where factorysite='" + factorySite + "' and area = '" + area + "'";
        Query.genericUpdate(query);
    }

    public LinkedList<Site> viewSite() throws SQLException {
        String query;
        LinkedList<Site> site = new LinkedList<>();

        query = "select factorysite,area from siti";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();

        if (!test) {
            System.out.println("Non è presente alcun sito");
        }
        while (test) {
            String factorySite = rst.getString("factorysite");
            String area = rst.getString("area");
            site.add(new Site(factorySite, area));
            test = rst.next();

        }

        return site;
    }

    /*
    Story ID 12: List of materials
    Alessia Carbone 0622701487
    10/12/2020
    */
    public void insertMaterial(String materialName) throws SQLException {
        String query = null;
        query = "insert into materiali (nomemateriale) values ('" + materialName + "')";
        Query.genericUpdate(query);

    }

    public void updateMaterial(String oldMaterialName, String newMaterialName) throws SQLException {
        String query = null;
        query = "update materiali set nomemateriale='" + newMaterialName + "'where nomemateriale='" + oldMaterialName + "'";
        Query.genericUpdate(query);
    }

    public void deleteMaterial(String materialName) throws SQLException {
        String query = null;
        query = "delete from materiali where nomemateriale='" + materialName + "'";
        Query.genericUpdate(query);
    }

    public LinkedList<Materiale> viewMaterials() throws SQLException {
        String query = null;
        LinkedList<Materiale> materiali = new LinkedList<>();
        query = "select nomemateriale from materiali";
        ResultSet rst = Query.genericQuery(query);
        boolean test = rst.next();
        if (!test) {
            System.out.println("Non è presente alcun materiale");
        }
        while (test) {
            String nomeMateriale = rst.getString("nomemateriale");
            materiali.add(new Materiale(nomeMateriale));
            test = rst.next();

        }

        return materiali;
    }
    
    /*
    Story ID 6: Maintainer's procedure
    Laura De Vivo 0622701475
    10/12/2020
    */
    public Boolean setProcedureMaintainer(String nomeMaintainer,String nomeProcedura) throws SQLException{
       LinkedList<String> ownedCompetencies=viewOwnedCompetenciesMaintainer(nomeMaintainer);
       LinkedList<String> requiredCompetencies=viewRequiredCompetenciesforProcedure(nomeProcedura);
       for(int i=0;i<requiredCompetencies.size();i++){
        if(!ownedCompetencies.get(i).equals(requiredCompetencies.get(i)))
            return false;
    }
       return true;
    }
    
    public LinkedList<String> viewOwnedCompetenciesMaintainer(String nomeMaintainer) throws SQLException {
        String query = null;
        LinkedList<String> competenze = new LinkedList<>();

        query = "select competenza from possesso where nomemaintainer='"+nomeMaintainer+"'";
        
            ResultSet rst = Query.genericQuery(query);
            boolean test = rst.next();

            if (!test) {
                System.out.println("Non è presente alcuna competenza per lo specifico maintainer");
            }
            while (test) {
                String competenza = rst.getString("competenza");
                competenze.add(competenza);
                test = rst.next();

            }

        return competenze;
    }
}
