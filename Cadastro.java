package qtrem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cadastro {
    private ArrayList<Passageiro> cadastro;
    private ArrayList<Movimento> movimentacao; 

    public Cadastro(){
        this.cadastro = new ArrayList<>();
        this.movimentacao = new ArrayList<>();
    }

    

    public ArrayList<Passageiro> getCadastro() {
        return cadastro;
    }



    public ArrayList<Movimento> getMovimentacao() {
        return movimentacao;
    }


    public void cadastrar(Passageiro pass){
        
        if(!exists(pass.getIdPass())){
            this.cadastro.add(pass);
        }
    }

    public void addMov(Movimento mov){
        this.movimentacao.add(mov);
    }

    private boolean exists(String idPass){

        for(Passageiro pass : this.cadastro){

            if(pass.getIdPass().equals(idPass)){
                return true; // idPass encontrado
            }
        }

        return false; // idPass não encontrado
    }

    public String showCad(){
        
    Collections.sort(this.cadastro, Comparator.comparing(Passageiro :: getIdPass));

        String s = "";

        for(Passageiro pass : cadastro){

            s += pass.getIdPass();
            s += "\n";
        }
        
        return s;
    }

    public String showMov(){
        
        String s = "";

        for(Movimento mov : this.movimentacao){

            s += mov;
            s += "\n";
        }
        
        return s;

    }


}
