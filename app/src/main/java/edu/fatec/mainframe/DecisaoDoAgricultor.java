package edu.fatec.mainframe;

import java.util.Scanner;

public class DecisaoDoAgricultor {
    public void run(Scanner scn) {
        if (scn == null) {
            throw new IllegalStateException("O Scanner precisa ser inicializado antes de usar!");
        }
        int conjuntos = scn.nextInt();
        for (int i = 0; i < conjuntos; i++) {
            String[] entrada = scn.nextLine().split("\\s+");
            TUP valor = new TUP();
            valor.T = Double.parseDouble(entrada[0]);
            valor.U = Double.parseDouble(entrada[1]);
            valor.P = Integer.parseInt(entrada[2]);

            if (valor.P == 1) {
                System.out.println("NAO REGAR");
            } else {
                if (valor.T > 30.0 || valor.U < 50.0) {
                    System.out.println("REGAR");
                } else {
                    System.out.println("NAO REGAR");
                }
            }
        }
    }

    public void test() {
        {
            String[] entrada = {"3", "35.0 40.0 0", "28.0 60.0 1", "32.0 45.0 0"};
            String[] resposta = {"REGAR", "NAO REGAR", "REGAR"};
            String[] saida = test(entrada);
            boolean sucesso = true;
            int i = 0;
            try {
                for (i = 0; i < resposta.length; i++) {
                    if (!resposta[i].equals(saida[i])) {
                        sucesso = false;
                        break;
                    }
                }
            } catch (Exception e) {
                sucesso = false;
            }
            if (sucesso) {
                System.out.println("Passou no Teste 1");
            } else {
                System.out.println("Falhou no Teste 1, na saida " + i);
            }
        }
        {
            String[] entrada = {"2", "25.0 60.0 1", "28.0 40.0 1"};
            String[] resposta = {"NAO REGAR", "NAO REGAR"};
            String[] saida = test(entrada);
            boolean sucesso = true;
            int i = 0;
            try {
                for (i = 0; i < resposta.length; i++) {
                    if (!resposta[i].equals(saida[i])) {
                        sucesso = false;
                        break;
                    }
                }
            } catch (Exception e) {
                sucesso = false;
            }
            if (sucesso) {
                System.out.println("Passou no Teste 2");
            } else {
                System.out.println("Falhou no Teste 2, na saida " + i);
            }
        }
    }

    private String[] test(String[] inputs) {
        int conjuntos = Integer.parseInt(inputs[0]);
        String[] respostas = new String[conjuntos];

        for (int i = 0; i < conjuntos; i++) {
            String[] entrada = inputs[i + 1].split("\\s+");
            TUP valor = new TUP();
            valor.T = Double.parseDouble(entrada[0]);
            valor.U = Double.parseDouble(entrada[1]);
            valor.P = Integer.parseInt(entrada[2]);

            if (valor.P == 1) {
                System.out.println("NAO REGAR");
                respostas[i] = "NAO REGAR";
            } else {
                if (valor.T > 30.0 || valor.U < 50.0) {
                    System.out.println("REGAR");
                    respostas[i] = "REGAR";
                } else {
                    System.out.println("NAO REGAR");
                    respostas[i] = "NAO REGAR";
                }
            }
        }
        return respostas;
    }
}

class TUP {
    double T;
    double U;
    int P;
}
