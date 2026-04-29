package edu.fatec.mainframe;

import java.util.Scanner;

public class TheMayans {
    Scanner scn;

    TheMayans(Scanner scn) {
        this.scn = scn;
    }

    public void run() {
        if (this.scn == null) {
            throw new IllegalStateException("O Scanner precisa ser inicializado antes de usar!");
        }

        String[] inputs = scn.nextLine().split("\\s+");
        int[] values = new int[inputs.length];
        {
            int i = 0;
            for (String input : inputs) {
                char[] chars = input.toCharArray();
                for (Character c : chars) {
                    switch (c) {
                        case '-':
                            values[i] += 5;
                            break;
                        case '.':
                            values[i] += 1;
                            break;
                        default:
                            values[i] = 0;
                            break;
                    }
                }
                values[i] *= (int) Math.pow(20, values.length - 1 - i);
                i++;
            }
        }
        long res = 0;
        for (int v : values) {
            res += v;
        }
        System.out.println(res);
    }

    public void test() {
        if (this.scn == null) {
            throw new IllegalStateException("O Scanner precisa ser inicializado antes de usar!");
        }

        if (this.test(". --..") == 32) {
            System.out.println("Passou no Teste 1");
        }
        if (this.test("-. -- --....") == 2614) {
            System.out.println("Passou no Teste 2");
        }
        if (this.test(". * * -...") == 8008) {
            System.out.println("Passou no Teste 3");
        }
        if (this.test("....") == 4) {
            System.out.println("Passou no Teste 4");
        }
        if (this.test(". . . .") == 8421) {
            System.out.println("Passou no Teste 5");
        }
        if (this.test("---") == 15) {
            System.out.println("Passou no Teste 6");
        }
        if (this.test("- - -") == 2105) {
            System.out.println("Passou no Teste 7");
        }
        if (this.test("-. -. -. -. -. -. -. -.") == 8084210526L) {
            System.out.println("Passou no Teste 8");
        }
        if (this.test("*") == 0) {
            System.out.println("Passou no Teste 9");
        }

    }

    private long test(String entrada) {
        String[] inputs = entrada.split("\\s+");
        long[] values = new long[inputs.length];
        {
            int i = 0;
            for (String input : inputs) {
                char[] chars = input.toCharArray();
                for (Character c : chars) {
                    switch (c) {
                        case '-':
                            values[i] += 5;
                            break;
                        case '.':
                            values[i] += 1;
                            break;
                        default:
                            values[i] = 0;
                            break;
                    }
                }
                values[i] *= (long) Math.pow(20, values.length - 1 - i);
                i++;
            }
        }
        long res = 0;
        for (long v : values) {
            res += v;
        }
        System.out.println(res);
        return res;
    }
}
