package qtrem;

public class Movimento {
    String idPass;
    Direcao dir;
    
    public Movimento(String idPass, Direcao dir) {
        this.idPass = idPass;
        this.dir = dir;
    }

    @Override
    public String toString() {
        return this.idPass + " " + this.dir;
    }
    

}
