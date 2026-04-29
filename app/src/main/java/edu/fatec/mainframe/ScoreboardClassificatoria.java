package edu.fatec.mainframe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ScoreboardClassificatoria {

    public void run(Scanner scn) {
        String nomeSede = scn.nextLine();
        int qtdVagas;
        int qtdVagasExtras;
        {
            String[] qtds = scn.nextLine().split("\\s+");
            qtdVagas = Integer.parseInt(qtds[0]);
            qtdVagasExtras = Integer.parseInt(qtds[1]);
        }

        int qtdTimes = scn.nextInt();

        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Grupo> classificados = new ArrayList<>();
        ArrayList<Grupo> espera = new ArrayList<>();
        ArrayList<Grupo> desclassificados = new ArrayList<>();

        for (int i = 0; i < qtdTimes; i++) {
            Grupo time = new Grupo(scn.nextLine().split("\\|"));
            if (time.acertos == 0) {
                desclassificados.add(time);
            } else {
                grupos.add(time);
            }
        }

        grupos.sort(Comparator.comparing((Grupo p) -> p.fatec)
                .thenComparing(Comparator.comparingInt((Grupo p) -> p.acertos).reversed())
                .thenComparingInt(p -> p.tempo)
        );

        classificados.add(grupos.getFirst());
        grupos.removeFirst();
        qtdVagas--;
        for (Grupo time : grupos) {
            if (!time.fatec.equals(classificados.getLast().fatec)) {
                classificados.add(time);
                qtdVagas--;
            } else if (time.fatec.equals(nomeSede) && qtdVagasExtras > 0) {
                classificados.add(time);
                qtdVagas--;
                qtdVagasExtras--;
            } else {
                espera.add(time);
            }
        }


        espera.sort(
                Comparator.comparingInt((Grupo p) -> p.acertos).reversed()
                        .thenComparingInt(p -> p.tempo)
        );

        for (int i = qtdVagas; i > 0; i--) {
            classificados.add(espera.getFirst());
            espera.removeFirst();
        }


        classificados.sort(Comparator.comparing(p -> p.nome));

        System.out.println("Classificados para a Final");
        for (Grupo time : classificados) {
            System.out.println(time);
        }
        System.out.println("Lista de Espera");
        for (Grupo time : espera) {
            System.out.println(time);
        }
        System.out.println("Desclassificados");
        for (Grupo time : desclassificados) {
            System.out.println(time);
        }
        System.out.println("Apuracao concluida!");
    }

    public void test() {
        String[] entrada = {
                "Fatec E",
                "8 2",
                "14",
                "Time 01|Fatec A|3|150",
                "Time 02|Fatec A|3|110",
                "Time 03|Fatec B|3|100",
                "Time 04|Fatec B|2|280",
                "Time 05|Fatec B|4|210",
                "Time 06|Fatec C|2|90",
                "Time 07|Fatec C|3|151",
                "Time 08|Fatec D|0|0",
                "Time 09|Fatec E|2|130",
                "Time 10|Fatec E|3|140",
                "Time 11|Fatec E|2|330",
                "Time 12|Fatec E|1|180",
                "Time 13|Fatec F|1|200",
                "Time 14|Fatec F|0|0"
        };
        String resposta =
                "Classificados para a Final" + "\n"
                        + "Time 02 - Fatec A (3,110)" + "\n"
                        + "Time 03 - Fatec B (3,100)" + "\n"
                        + "Time 05 - Fatec B (4,210)" + "\n"
                        + "Time 07 - Fatec C (3,151)" + "\n"
                        + "Time 09 - Fatec E (2,130)" + "\n"
                        + "Time 10 - Fatec E (3,140)" + "\n"
                        + "Time 11 - Fatec E (2,330)" + "\n"
                        + "Time 13 - Fatec F (1,200)" + "\n"
                        + "\n"
                        + "Lista de Espera" + "\n"
                        + "Time 01 - Fatec A (3,150)" + "\n"
                        + "Time 06 - Fatec C (2,90)" + "\n"
                        + "Time 04 - Fatec B (2,280)" + "\n"
                        + "Time 12 - Fatec E (1,180)" + "\n"
                        + "\n"
                        + "Desclassificados" + "\n"
                        + "Time 08 - Fatec D (0,0)" + "\n"
                        + "Time 14 - Fatec F (0,0)" + "\n"
                        + "\n"
                        + "Apuracao concluida!";
        String saida = test(entrada);
        if (saida.equals(resposta)) {
            System.out.println("Sucesso no Teste 1");
        } else {
            System.out.println("Falhou no Teste 1");
        }
    }

    private String test(String[] input) {
        String nomeSede = input[0];
        int qtdVagas;
        int qtdVagasExtras;
        {
            String[] qtds = input[1].split("\\s+");
            qtdVagas = Integer.parseInt(qtds[0]);
            qtdVagasExtras = Integer.parseInt(qtds[1]);
        }

        int qtdTimes = Integer.parseInt(input[2]);

        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Grupo> classificados = new ArrayList<>();
        ArrayList<Grupo> espera = new ArrayList<>();
        ArrayList<Grupo> desclassificados = new ArrayList<>();

        for (int i = 0; i < qtdTimes; i++) {
            Grupo time = new Grupo(input[i + 3].split("\\|"));
            if (time.acertos == 0) {
                desclassificados.add(time);
            } else {
                grupos.add(time);
            }
        }

        grupos.sort(Comparator.comparing((Grupo p) -> p.fatec)
                .thenComparing(Comparator.comparingInt((Grupo p) -> p.acertos).reversed())
                .thenComparingInt(p -> p.tempo)
        );

        classificados.add(grupos.getFirst());
        grupos.removeFirst();
        qtdVagas--;
        for (Grupo time : grupos) {
            if (!time.fatec.equals(classificados.getLast().fatec)) {
                classificados.add(time);
                qtdVagas--;
            } else if (time.fatec.equals(nomeSede) && qtdVagasExtras > 0) {
                classificados.add(time);
                qtdVagas--;
                qtdVagasExtras--;
            } else {
                espera.add(time);
            }
        }


        espera.sort(
                Comparator.comparingInt((Grupo p) -> p.acertos).reversed()
                        .thenComparingInt(p -> p.tempo)
        );

        for (int i = qtdVagas; i > 0; i--) {
            classificados.add(espera.getFirst());
            espera.removeFirst();
        }


        classificados.sort(Comparator.comparing(p -> p.nome));

        StringBuffer saida = new StringBuffer();

        System.out.println("Classificados para a Final");
        saida.append("Classificados para a Final\n");

        for (Grupo time : classificados) {
            System.out.println(time);
            saida.append(time).append("\n");
        }

        System.out.println("\nLista de Espera");
        saida.append("\nLista de Espera\n");

        for (Grupo time : espera) {
            System.out.println(time);
            saida.append(time).append("\n");
        }

        System.out.println("\nDesclassificados");
        saida.append("\nDesclassificados\n");

        for (Grupo time : desclassificados) {
            System.out.println(time);
            saida.append(time).append("\n");
        }

        System.out.println("\nApuracao concluida!");
        saida.append("\nApuracao concluida!");

        return saida.toString();
    }
}

class Grupo {
    String nome;
    String fatec;
    int acertos;
    int tempo;

    Grupo(String[] input) {
        nome = input[0];
        fatec = input[1];
        acertos = Integer.parseInt(input[2]);
        tempo = Integer.parseInt(input[3]);
    }

    @Override
    public String toString() {
        StringBuffer stb = new StringBuffer();
        stb
                .append(nome).append(" - ")
                .append(fatec).append(" (")
                .append(acertos).append(",")
                .append(tempo).append(")");
        return stb.toString();
    }
}
