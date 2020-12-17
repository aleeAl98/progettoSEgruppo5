//Gruppo 5
package progettosegruppo5;

import enumeratives.GeneralState;
import enumeratives.TipoAttività;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaintainanceActivity implements Comparable<MaintainanceActivity>{
    private String activityID;
    private String nomeProcedura; 
    private TipoAttività tipologia;
    private String descrizione; 
    private int tempo; 
    private Boolean interrompibile;
    private int settimana;
    private String tipo; 
    private Date data;
    private GeneralState generalState;
    
    /*
    Classe di comodo per story ID 3
    Alessia Carbone 0622701487
    28/11/2020
    */
    public MaintainanceActivity(String activityID, String nomeProcedura, TipoAttività tipologia, 
            String descrizione, int tempo, Boolean interrompibile, int settimana, String tipo, 
            Date data, GeneralState generalState) {
        this.activityID = activityID;
        this.nomeProcedura = nomeProcedura;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.tempo = tempo;
        this.interrompibile = interrompibile;
        this.settimana = settimana;
        this.tipo = tipo;
        this.data = data;
        this.generalState = generalState;
    }

    public String getActivityID() {
        return activityID;
    }

    public String getNomeProcedura() {
        return nomeProcedura;
    }

    public TipoAttività getTipologia() {
        return tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getTempo() {
        return tempo;
    }

    public Boolean getInterrompibile() {
        return interrompibile;
    }

    public int getSettimana() {
        return settimana;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public GeneralState getGeneralState() {
        return generalState;
    }

    public String getArea() throws SQLException {
        String query = "select area from possessos where activityid = '" + this.getActivityID() + "'";
        ResultSet rst = null;
        rst = Query.genericQuery(query);
        Boolean test = rst.next();
        String area = null;
        if(!test){
            return area;
        }
        while(test){
            area = rst.getString("area");
            test = rst.next();
        }
        return area;
    }
    
    public String getFactorySite() throws SQLException {
        String query = "select factorysite from possessos where activityID = '" + this.getActivityID() + "'";
        ResultSet rst = null;
        rst = Query.genericQuery(query);
        Boolean test = rst.next();
        String factorySite = null;
        if(!test){
            return factorySite;
        }
        while(test){
            factorySite = rst.getString("factorysite");
            test = rst.next();
        }
        return factorySite;
    }    

    @Override
    public String toString() {
        return activityID + "\t" + nomeProcedura + "\t" + tipologia.toString() + "\t" + descrizione + "\t" + tempo + "\t" + interrompibile + "\t" + settimana + "\t" + tipo + "\t" + data + "\t" + generalState.toString();
    }

    @Override
    public int compareTo(MaintainanceActivity o) {
        if(this.getSettimana() < o.getSettimana()) return -1;
        if(this.getSettimana() > o.getSettimana()) return 1;
        return 0;
    }
    
    public void setDescrizione(String descrizione) throws SQLException {
        this.descrizione = descrizione;
       String query = null;
        query = "update maintainanceactivity set descrizione = '" + descrizione + "'where descrizione='" + this.descrizione + "'";
        Query.genericUpdate(query);
    }

    public void setTempo(int tempo) throws SQLException {
        this.tempo = tempo;
        String query = null;
        query = "update maintainanceactivity set tempo = '" + tempo + "'where tempo='" + this.tempo + "'";
        Query.genericUpdate(query);
        
    }
    
    public void setInsertCompetency(String competency) throws SQLException {
        String query = null;
        query = "insert into competenzerichieste (nomeprocedura,competenza) values ('" + this.getNomeProcedura() + "','" + competency + "')";
        Query.genericUpdate(query);

    }
    
    public void setDeleteCompetency(String competency) throws SQLException {
        String query = null;
         query = "delete from competenzerichieste where competenza='" + competency + "' and nomeprocedura='" + this.getNomeProcedura() + "'";
        Query.genericUpdate(query);

    }
    
    public void setInsertMaterials(String material) throws SQLException {
        String query = null;
        query = "insert into possessom (activityid,nomemateriale) values ('" + this.getActivityID() + "','" + material + "')";
        Query.genericUpdate(query);

    }
    
    public void setDeleteMaterials(String material) throws SQLException {
        String query = null;
         query = "delete from possessom where nomemateriale='" + material + "' and activityid='" + this.getActivityID() + "'";
        Query.genericUpdate(query);

    }
    
}
