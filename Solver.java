package qtrem;

import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Trem trem = new Trem(0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] cmd = line.split(" ");
            
            try {
                switch (cmd[0]) {
                    case "end":
                        scanner.close();
                        return; // ou break;

                    case "la":
                        System.out.println(trem);
                        break;

                    case "init":
                        trem = new Trem(Integer.parseInt(cmd[1]));
                        break;

                    case "nwvag":
                        trem.addVagao(new Vagao(Integer.parseInt(cmd[1])));
                        break;

                    case "entrar":
                        trem.embarcar(new Passageiro(cmd[1]));
                        break;

                    case "sair":
                        trem.desembarcar(cmd[1]);
                        break;

                    case "show":
                        System.out.println(trem);
                        break;

                    case "cadastro":
                        System.out.print(trem.getRegistro().showCad());
                        break;

                    case "movimentacao":
                        System.out.print(trem.getRegistro().showMov());
                        break;

                    default:
                        System.out.println("Comando inválido!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
