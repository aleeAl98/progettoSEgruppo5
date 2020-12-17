//Gruppo 5
package progettosegruppo5;

public class MaintainanceProcedure {
    private String ProcedureName;
    private String SMP;
    
    /*
    Classe di comodo per story ID 5
    Daniela Cavallaro 0612703975
    28/11/2020
    */
    public MaintainanceProcedure(String ProcedureName, String SMP) {
        this.ProcedureName = ProcedureName;
        this.SMP = SMP;
    }

    public String getProcedureName() {
        return ProcedureName;
    }

    public String getSMP() {
        return SMP;
    }

    public void setProcedureName(String ProcedureName) {
        this.ProcedureName = ProcedureName;
    }

    public void setSMP(String SMP) {
        this.SMP = SMP;
    }

    @Override
    public String toString() {
        return this.getProcedureName() + "  SMP: " + this.getSMP();
    }
    
}
