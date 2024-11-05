package qtrem;

import java.util.ArrayList;

public class Trem {
    private int maxVagoes;
    private ArrayList<Vagao> vagoes;
    private Cadastro registro;
    
    public Trem(int maxVagoes) {
        this.maxVagoes = maxVagoes;
        this.vagoes = new ArrayList<Vagao>();
        this.registro = new Cadastro();
    }

    public Cadastro getRegistro() {
        return registro;
    }



    public boolean addVagao(Vagao vagao) throws Exception{
        
        if(vagoes.size() == maxVagoes){
            
            throw new Exception("fail: limite de vagões atingido");
        }
        
        this.vagoes.add(vagao);
        return true;
    }

    public void embarcar(Passageiro pass) throws Exception{

        if(this.exists(pass.getIdPass())){
            throw new Exception("fail: " + pass + " já está no trem");
        }

        this.registro.cadastrar(pass);

        for(Vagao vagao : vagoes){

            if(vagao.embarcar(pass)){
                
                this.registro.addMov(new Movimento(pass.getIdPass(), Direcao.IN));
                //return true; 
            }
        }

        throw new Exception("fail: trem lotado");

    }

    public void desembarcar(String idPass) throws Exception{

        if (!exists(idPass)) {
            
            throw new Exception("fail: " + idPass + " nao esta no trem");
        }
        
        for(Vagao vagao : vagoes){
            
            if(vagao.desembarcar(idPass)){

                this.registro.addMov(new Movimento(idPass, Direcao.OUT));
                break;
            }
        
        }

    }

    private boolean exists(String idPass){

        for(Vagao vagao : vagoes){

            if(vagao.exists(idPass)){
                return true; // idPass encontrado
            }
        }
        return false; //idPass não encontrada
    }

    public Passageiro search(String idPass){
        
        return null;
    }
    
    @Override
    public String toString() {
        String s = "Trem ";

        for(Vagao vagao : this.vagoes){

            s += vagao;
        }

        return s;
    }
}
