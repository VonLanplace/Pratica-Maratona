package edu.fatec.mainframe.extras1;

import edu.fatec.mainframe.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Triangulo {

    private final double PI = 3.14159265358979323846;

    public void run(Scanner scn) {
        double resp = 0;
        double a, b, alpha;

        do {

            {
                String[] nums = scn.nextLine().trim().split("\\s+");
                a = Double.parseDouble(nums[0]);
                b = Double.parseDouble(nums[1]);
                alpha = Double.parseDouble(nums[2]);
            }

            if (a + b + alpha == 0) break;

            resp = (a * b * Math.sin(Math.toRadians(alpha))) / 2;
            System.out.println(String.format("%.4f", resp));
        } while (true);
    }

    public void test() {
        String[] entrada = {
                "3.00 4.00 90.00",
                "5.00 7.00 60.00",
                "10.00 10.00 30.00",
                "0 0 0"
        };
        String[] resposta = {
                "6.0000",
                "15.1554",
                "25.0000"
        };

        ArrayList<String> saida = test(entrada);

        boolean sucess = true;
        for (int i = 0; i < resposta.length; i++) {
            if (resposta[i].equals(saida.get(i))) {
                sucess = false;
                break;
            }
        }

        if (sucess) {
            System.out.println("Sucesso no Teste 1");
        } else {
            System.out.println("Falhou no Teste 1");
        }

    }

    private ArrayList<String> test(String[] entrada) {
        ArrayList<String> saida = new ArrayList<>();
        int entradaLinha = 0;
        double a, b, alpha;

        do {
            {
                String[] nums = entrada[entradaLinha].trim().split("\\s+");
                a = Double.parseDouble(nums[0]);
                b = Double.parseDouble(nums[1]);
                alpha = Double.parseDouble(nums[2]);
                entradaLinha++;
            }

            if (a + b + alpha == 0) break;


            String resp = String.format("%.4f", (a * b * Math.sin(Math.toRadians(alpha))) / 2);
            System.out.println(resp);
            saida.add(resp);
        } while (true);
        return saida;
    }
}
