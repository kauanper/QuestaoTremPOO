package qtrem;

import java.util.ArrayList;

public class Vagao {
    private ArrayList<Passageiro> cadeiras;
    private int capacidade;

    public Vagao(int capacidade) {
        this.capacidade = capacidade;
        this.cadeiras = new ArrayList<Passageiro>();

        for(int i = 0; i < this.capacidade; i++){
            this.cadeiras.add(null);
        }
    }

    public boolean embarcar(Passageiro pass){

        for(int i = 0; i < this.capacidade; i++){

            if(cadeiras.get(i) == null){

                cadeiras.set(i, pass);
                return true;
            }
        }
        return false;
    }

    public boolean desembarcar(String idPass){

        int k = search(idPass);

        if(k != -1){
            this.cadeiras.set(k, null);
            return true; // idPass encontrado
        }
        
        return false; 
    }

    public boolean exists(String idPass){

        for(Passageiro pass : this.cadeiras){

            if(pass != null && pass.getIdPass().equals(idPass)){
                return true; // idPass encontrado
            }
        }

        return false; // idPass não encontrado
    }

    private int search(String idPass){

        for(int i = 0; i < this.cadeiras.size(); i++){

            if(this.cadeiras.get(i) != null && this.cadeiras.get(i).getIdPass().equals(idPass)){
                
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        
        String s = "[ ";
        for(Passageiro pass : this.cadeiras){

            if(pass != null){

                s += pass + " ";
            }else{

                s += "- ";
            }
        }
        s += "]";

        return s;
    }

}
