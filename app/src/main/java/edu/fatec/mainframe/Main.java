package edu.fatec.mainframe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        TheMayans theMayans = new TheMayans(scn);

        theMayans.test();
    }
}
