//Gruppo 5
package progettosegruppo5;

import enumeratives.GeneralState;
import enumeratives.TicketStateForArea;
import enumeratives.TipoAttività;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Planner {

    private final String username;
    private final String password;
    private final String nome;

    public Planner(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;

    }

    /*
    Story ID 3: Planner's Management for activities
    Alessia Carbone 0622701487
    28/11/2020
     */
    public void insertMaintainanceActivity(String activityID, String nomeProcedura, TipoAttività tipologia,
            String descrizione, int tempo, Boolean interrompibile, int settimana, String tipo,
            Date data, String area, String factorySite, LinkedList<String> materialiScelti) throws SQLException {
        String query = null;
        String t = tipologia.toString();
        query = "insert into maintainanceactivity (activityID, nomeprocedura, tipologia, descrizione, tempo, interrompibile, settimana, tipo, data, generalstate)"
                + " values ('" + activityID + "','" + nomeProcedura + "','" + t + "','" + descrizione + "','" + tempo + "','" + interrompibile + "','"
                + settimana + "','" + tipo + "','" + data + "','" + GeneralState.NOTSTARTED.toString() + "')";
        Query.genericUpdate(query);
        String q = "insert into possessos (activityID,factorysite,area,ticketstateforarea) values ('" + activityID + "', '" + factorySite + "', '" + area + "','" + TicketStateForArea.SENT.toString() + "')";
        Query.genericUpdate(q);
        String q1 = "insert into pianificazione(nomeplanner,activityID) values ('" + this.nome + "', '" + activityID + "')";
        Query.genericUpdate(q1);
        for(String m : materialiScelti){
            Query.genericUpdate("insert into possessom(activityID,nomemateriale) values ('" + activityID + "', '" + m + "')");
        }
    }

    public ArrayList<MaintainanceActivity> viewMaintainanceActivity() throws SQLException {
        String query;
        ArrayList<MaintainanceActivity> activity = new ArrayList<>();
        query = "select activityID,nomeProcedura,tipologia,descrizione,tempo,interrompibile,"
                + "settimana,tipo,data,generalState from maintainanceactivity";
        ResultSet rst = Query.genericQuery(query);

        boolean test = rst.next();
        if (!test) {
            System.out.println("Non è presente alcuna attività");
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
            TipoAttività t = null;
            GeneralState gs = null;
            if (TipoAttività.EWO.toString().compareTo(tipologia) == 0) {
                t = TipoAttività.EWO;
            }
            if (TipoAttività.EXTRA.toString().compareTo(tipologia) == 0) {
                t = TipoAttività.EXTRA;
            }
            if (TipoAttività.PLANNED.toString().compareTo(tipologia) == 0) {
                t = TipoAttività.PLANNED;
            }
            if (TipoAttività.UNPLANNED.toString().compareTo(tipologia) == 0) {
                t = TipoAttività.UNPLANNED;
            }
            if (GeneralState.CLOSED.toString().compareTo(generalState) == 0) {
                gs = GeneralState.CLOSED;
            }
            if (GeneralState.INPROGRESS.toString().compareTo(generalState) == 0) {
                gs = GeneralState.INPROGRESS;
            }
            if (GeneralState.NOTSTARTED.toString().compareTo(generalState) == 0) {
                gs = GeneralState.NOTSTARTED;
            }

            MaintainanceActivity a = new MaintainanceActivity(activityID, nomeProcedura, t, descrizione, tempo, interrompibile, settimana, tipo, data, gs);
            activity.add(a);
            test = rst.next();
        }
        Collections.sort(activity);
        return activity;
    }

    public void deleteMaintainanceActivity(String activityID) throws SQLException {
        String query = null;

        query = "delete from maintainanceactivity where activityID='" + activityID + "'";
        Query.genericUpdate(query);
    }

    public void updateMaintainanceActivity(String oldName, String newName) throws SQLException {
        String query = null;
        query = "update maintainanceactivity set generalState = '" + newName + "'where generalState='" + oldName + "'";
        Query.genericUpdate(query);
    }
    
    /*
    Story ID 4: Set an activity to a maintainer
    Chiara Cafaro 0622701443
    10/12/2020
     */
    public void setMaintainanceActivity(String activityID, String nomemaintainer, String statomaintainer, Date data, int minuti) throws SQLException {
        String query = "select min from availability where giorno = '" + data + "' and nomemaintainer = '" + nomemaintainer + "'";
        int m = 0;
        ResultSet rst = Query.genericQuery(query);
        Boolean test = rst.next();
        while(test){
            m = rst.getInt("min");
            test = rst.next();
        }
        int min = m - minuti;
        if(min < 0) throw new SQLException();
        
        else{
            query = "insert into assegnazioneattivita(activityID, nomemaintainer, statomaintainer) values ('" + activityID + "', '" + nomemaintainer + "', '" + statomaintainer + "')";
            Query.genericUpdate(query);
            query = "update availability set min = " + min + " where nomemaintainer = '" + nomemaintainer + "' and giorno = '" + data + "'";
            Query.genericUpdate(query); 
        }
    }
    
    /*
    Story ID 13: Planner's EWO add
    Laura De Vivo 0622701475
    10/12/2020
    */
    public void addEWOActivity(String activityID, String nomeProcedura, TipoAttività tipologia,
            String descrizione, int tempo, Boolean interrompibile, int settimana, String tipo,
            Date data, String area, String factorySite, LinkedList<String> materiali) throws SQLException {
        String query = null;

        if (tipologia == TipoAttività.EWO) {
            query = "insert into maintainanceactivity (activityID, nomeprocedura, tipologia, descrizione, tempo, interrompibile, settimana, tipo, data, generalstate)"
                    + " values ('" + activityID + "','" + nomeProcedura + "','" + tipologia + "','" + descrizione + "','" + tempo + "','" + interrompibile + "','"
                    + settimana + "','" + tipo + "','" + data + "','" + GeneralState.NOTSTARTED.toString() + "')";
            Query.genericUpdate(query);
            String q = "insert into possessos (activityID,factorysite,area,ticketstateforarea) values ('" + activityID + "', '" + factorySite + "', '" + area + "', 'SENT')";
            Query.genericUpdate(q);
            String q1 = "insert into pianificazione(nomeplanner,activityID) values ('" + this.nome + "', '" + activityID + "')";
            Query.genericUpdate(q1);
            for(String m : materiali){
                Query.genericUpdate("insert into possessom(activityID,nomemateriale) values ('" + activityID + "', '" + m + "')");
            }

        } else {
            System.out.println("Non puoi inserire attività diverse da EWO");
        }
    }
    
    /*
    Story ID 19: Maintainer's notification
    Chiara Cafaro 0622701443
    Alessia Carbone 0622701487
    Daniela Cavallaro 0612703975
    Laura De Vivo 0622701475
    16/12/2020
    */
    public void sendNotify(String nomeMaintainer, String message) throws SQLException{
        String query = "insert into notifiche (nomemaintainer, notifica) values ('" + nomeMaintainer + "', '" + message + "')";
        Query.genericUpdate(query);
    }
}
