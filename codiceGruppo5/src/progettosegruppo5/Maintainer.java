//Gruppo 5
package progettosegruppo5;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.ResultSet;

public class Maintainer {
    private final String username;
    private final String password;
    private  String nome;

    public Maintainer(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }
    
    /*
    Classe di comodo per story ID 19: Maintainer's notification
    Chiara Cafaro 0622701443
    16/12/2020
     */
    public void insertAvailability(Date giorno, String nomemaintainer, int min) throws SQLException {
        String query = null;
       
      
            query = "insert into availability (giorno,nomemaintainer, min ) values ('" + giorno + "','" + nomemaintainer + "','" + min +"')";
            
            
        
        Query.genericUpdate(query);
       
    }

    public LinkedList<String> viewMessages() throws SQLException {
        LinkedList<String> list = new LinkedList<>();
        String query = "select notifica from notifiche where nomemaintainer = '" + this.getNome() + "'";
        ResultSet rst = Query.genericQuery(query);
        Boolean test = rst.next();
        while(test){
            list.add(rst.getString("notifica"));
            test = rst.next();
        }
        return list;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    public LinkedList<String> getMyActivities() throws SQLException{
        LinkedList<String> list = new LinkedList<>();
        String query = "select activityID from assegnazioneattivita where nomemaintainer = '" + this.getNome() + "'";
        ResultSet rst = Query.genericQuery(query);
        Boolean test = rst.next();
        while(test){
            list.add(rst.getString("activityID"));
            test = rst.next();
        }
        return list;
    }
     
}
