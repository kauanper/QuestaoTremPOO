package qtrem;

import java.util.Scanner;

public class Solver {
    public static void main(String[] args){
        
        Trem trem = new Trem(0);

        while (true) {

            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] cmd = line.split(" ");
            
                try{
                    
                    if(cmd[0].equals("end")){
                        
                        break;
                    }else if(cmd[0].equals("la")){
                       
                        System.out.println(trem);
                    }else if(cmd[0].equals("init")){
                        
                        trem = new Trem(Integer.parseInt(cmd[1]));
                    }else if(cmd[0].equals("nwvag")){

                        trem.addVagao(new Vagao (Integer.parseInt(cmd[1])));
                    }else if(cmd[0].equals("entrar")){
                        
                        trem.embarcar(new Passageiro(cmd[1]));
                    }else if(cmd[0].equals("sair")){

                        trem.desembarcar(cmd[1]);
                    }else if(cmd[0].equals("show")){
                        
                        System.out.println(trem);
                    }else if(cmd[0].equals("cadastro")){
                        
                        System.out.print(trem.getRegistro().showCad());
                    }else if(cmd[0].equals("movimentacao")){

                        System.out.print(trem.getRegistro().showMov());
                    }else{
                        System.out.println("comando inválido!");
                    }



                }catch(Exception e){
                    System.out.println(e.getMessage());
                }            
        }

        
    }
    private static Scanner scanner = new Scanner (System.in);
    
}
