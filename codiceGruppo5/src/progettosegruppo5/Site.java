//Gruppo 5
package progettosegruppo5;

public class Site implements Comparable<Site>{
    private String factorySite;
    private String area;
    
    /*
    Classe di comodo per story ID 11
    Daniela Cavallaro 0612703975
    10/12/2020
    */
    public Site (String factorySite, String area){
        this.factorySite = factorySite;
        this.area = area;
    }

    public String getSiteName() {
        return factorySite;
    }

    public String getArea() {
        return area;
    }

    public void setSiteName(String factorySite) {
        this.factorySite = factorySite;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return this.getSiteName() + "  area: " + this.getArea();
    }

    @Override
    public int compareTo(Site o) {
        if(this.getSiteName().compareTo(o.getSiteName()) > 0) return 1;
        if(this.getSiteName().compareTo(o.getSiteName()) < 0) return -1;
        return 0;
    }
    
}

