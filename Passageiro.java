package qtrem;

public class Passageiro {
    private String idPass;

    public Passageiro(String idPass) {
        this.idPass = idPass;
    }

    public String getIdPass() {
        return idPass;
    }

    @Override
    public String toString() {
        
        return idPass;
    }

}
