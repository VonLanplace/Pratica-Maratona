package edu.fatec.mainframe.extras1;

import java.util.Scanner;

public class Suprimentos {
    public void run(Scanner scn) {
        int size = scn.nextInt();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += scn.nextInt();
            if (sum < 0) break;
        }
        if (sum < 0) {
            sum *= -1;
        }
        System.out.println(sum);
    }

    public void test() {
        {
            int[] entrada = {3, 3, -5, 3};
            int resposta = 2;
            int saida = test(entrada);
            boolean sucesso = true;
            if (saida != resposta) {
                sucesso = false;
            }
            if (sucesso) {
                System.out.println("Sucesso no Teste 1.");
            } else {
                System.out.println("Falha no Teste 1.");
            }
        }
        {
            int[] entrada = {4, 2, -3, 1, -1};
            int resposta = 1;
            int saida = test(entrada);
            boolean sucesso = true;
            if (saida != resposta) {
                sucesso = false;
            }
            if (sucesso) {
                System.out.println("Sucesso no Teste 2.");
            } else {
                System.out.println("Falha no Teste 2.");
            }
        }
    }

    public int test(int[] entrada) {
        int size = entrada[0];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += entrada[i + 1];
            if (sum < 0) break;
        }
        if (sum < 0) {
            sum *= -1;
        }
        return sum;
    }
}
