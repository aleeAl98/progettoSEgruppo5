//Gruppo 5
package progettosegruppo5;

public class Materiale {
    private String nomeMateriale;

    /*
    Classe di comodo per story ID 12
    Alessia Carbone 0622701487
    10/12/2020
    */
    public Materiale(String nomeMateriale) {
        this.nomeMateriale = nomeMateriale;
    }

    public String getNomeMateriale() {
        return nomeMateriale;
    }

    @Override
    public String toString() {
        return nomeMateriale;
    }
    
    
}
