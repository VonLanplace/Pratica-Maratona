package edu.fatec.mainframe;

import java.util.Scanner;

public class AHeliconEAlem {
    public void run(Scanner scn) {
        int tamanho = scn.nextInt();
        int[] valores = new int[tamanho];
        {
            String[] entrada = scn.nextLine().split("\\s+");
            for (int i = 0; i < tamanho; i++) {
                valores[i] = Integer.parseInt(entrada[i]);
            }
        }

        long max = 0;
        for (int k = 1; k <= tamanho / 2; k++) {
            for (int m = 0; m < k; m++) {
                int sum = 0;
                for (int l = m; l < tamanho; l += k) {
                    sum += valores[l];
                }
                if (sum > max || k == 1) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    public void test() {
        {
            String[] teste = {"6", "3 -1 4 -1 5 -9"};
            long resposta = 12;
            long saida = test(teste);
            if (saida == resposta) {
                System.out.println("Sucesso no Teste 1.");
            } else {
                System.out.println("Falha no Teste 1.");
            }
        }
        {
            String[] teste = {"12", "-5 2 1 7 -3 -4 -8 10 -6 1 -1 3"};
            long resposta = 20;
            long saida = test(teste);
            if (saida == resposta) {
                System.out.println("Sucesso no Teste 2.");
            } else {
                System.out.println("Falha no Teste 2.");
            }
        }
    }

    private long test(String[] inputs) {
        int tamanho = Integer.parseInt(inputs[0]);
        int[] valores = new int[tamanho];
        {
            String[] entrada = inputs[1].split("\\s+");
            for (int i = 0; i < tamanho; i++) {
                valores[i] = Integer.parseInt(entrada[i]);
            }
        }

        long max = 0;
        for (int k = 1; k <= tamanho / 2; k++) {
            for (int m = 0; m < k; m++) {
                int sum = 0;
                for (int l = m; l < tamanho; l += k) {
                    sum += valores[l];
                }
                if (sum > max || k == 1) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
        return max;
    }
}
