package edu.fatec.mainframe.questoes2;

import java.util.Scanner;

public class BaseInimiga {


    public void run(Scanner scn) {

        int Ds;
        int Ys;
        {
            String[] entrada = scn.nextLine().trim().split("\\s+");
            Ds = Integer.parseInt(entrada[0]);
            Ys = Integer.parseInt(entrada[1]);
        }

        int Dm;
        int Ym;
        {
            String[] entrada = scn.nextLine().trim().split("\\s+");
            Dm = Integer.parseInt(entrada[0]);
            Ym = Integer.parseInt(entrada[1]);
        }

        int resp = 0;

        System.out.println(resp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseInimiga baseInimiga = new BaseInimiga();
        baseInimiga.run(scanner);
    }
}
