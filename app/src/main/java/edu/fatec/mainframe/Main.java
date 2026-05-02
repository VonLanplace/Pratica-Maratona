package edu.fatec.mainframe;

import edu.fatec.mainframe.questoes1.AHeliconEAlem;
import edu.fatec.mainframe.questoes1.DecisaoDoAgricultor;
import edu.fatec.mainframe.questoes1.ScoreboardClassificatoria;
import edu.fatec.mainframe.questoes1.TheMayans;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        int opc;

        while (loop) {
            for (int i = 0; i < 100; i++) System.out.println();
            printMainMenu();
            try {
                opc = Integer.parseInt(scn.nextLine().trim());
            } catch (NumberFormatException e) {
                opc = 10;
            }

            switch (opc) {
                case 1: {
                    TheMayans theMayans = new TheMayans();
                    theMayans.test();
                }
                break;
                case 2: {
                    ScoreboardClassificatoria scb = new ScoreboardClassificatoria();
                    scb.test();
                }
                break;
                case 3: {
                    DecisaoDoAgricultor dda = new DecisaoDoAgricultor();
                    dda.test();
                }
                break;
                case 4: {
                    AHeliconEAlem aHeliconEAlem = new AHeliconEAlem();
                    aHeliconEAlem.test();
                }
                break;
                case 9:
                    System.out.println("Saindo");
                    loop = false;
                    break;
                default:
                    System.out.println("Opcao Inválida");
            }
            System.out.print("Continuar (ENTER): ");
            scn.nextLine();
        }
    }

    public static void printMainMenu() {
        System.out.println(
                """
                        |--------------------------------|
                        |             MENU               |
                        |--------------------------------|
                        | 1 - The Mayans                 |
                        | 2 - Scoreboard Classificatória |
                        | 3 - Decisão do Agricultor      |
                        | 4 - À Helicon e além           |
                        | 9 - Sair                       |
                        |--------------------------------|"""
        );
        System.out.print("Option: ");
    }
}
