package edu.fatec.mainframe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreboardClassificatoria {
    Scanner scn;

    ScoreboardClassificatoria(Scanner scn) {
        this.scn = scn;
    }

    public void run() {
        String nomeSede = scn.nextLine();
        int vagasTotais;
        int vagasExtras;
        {
            String[] vagas = scn.nextLine().split("\s+");
            vagasTotais = Integer.parseInt(vagas[0]);
            vagasExtras = Integer.parseInt(vagas[1]);
        }

        ArrayList<Time> times = new ArrayList<>();

        for (int i = Integer.parseInt(scn.nextLine()); i > 0; i--) {
            String[] text = scn.nextLine().split("\\|");
            Time time = new Time(
                    text[0], text[1], Integer.parseInt(text[2]), Integer.parseInt(text[3])
            );
            times.add(time);
        }

        times.sort(Comparator.comparing((Time t) -> t.fatec)
                .thenComparing(t -> t.acertos)
                .thenComparing(t -> t.tempo));

        ArrayList<Time> classificacao = new ArrayList<>();
        ArrayList<Time> desclassificados = new ArrayList<>();

        for (Time t : times) {
            if (t.acertos == 0) {
                desclassificados.add(t);
                times.remove(t);
                continue;
            }
            if (t.nome.equals(nomeSede) && ) {

            }
        }
    }
}

class Time {
    String nome;
    String fatec;
    int acertos;
    int tempo;

    Time(String nome, String fatec, int acertos, int tempo) {
        this.acertos = acertos;
        this.fatec = fatec;
        this.nome = nome;
        this.tempo = tempo;
    }
}
