import java.util.Random;
import java.util.Scanner;

public class Main
{

    // Funzione principale
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Lista dei Pokémon disponibili
        Pokemon[] pokemons =
                {
                new Zapdos(),
                new Moltres(),
                new Articuno(),
                new Lugia(),
                new HoOh(),
                new Mewtwo()
        };
        int n = 5;
        System.out.println("v1.0.1");
        System.out.println("██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗ ███╗   ██╗        ███████╗ ██████╗██╗     ██╗██████╗ ███████╗███████╗");
        System.out.println("██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗████╗  ██║        ██╔════╝██╔════╝██║     ██║██╔══██╗██╔════╝██╔════╝");
        System.out.println("██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██╔██╗ ██║        █████╗  ██║     ██║     ██║██████╔╝███████╗█████╗  ");
        System.out.println("██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║╚██╗██║        ██╔══╝  ██║     ██║     ██║██╔═══╝ ╚════██║██╔══╝  ");
        System.out.println("██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝██║ ╚████║        ███████╗╚██████╗███████╗██║██║     ███████║███████╗");
        System.out.println("╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝        ╚══════╝ ╚═════╝╚══════╝╚═╝╚═╝     ╚══════╝╚══════╝\n");
        Random random = new Random();

        String[] frasi = new String[6];
        frasi[0] = "oh non farmi incazzare scegli un valore tra 0 e 3";
        frasi[1] = "mangiasassi scegli una mossa valida: ";
        frasi[2] = "ma ti svegli?: ";
        frasi[3] = "sei ritardato?? scegli un cazzo di numero tra 0 e 3: ";
        frasi[4] = "evidentemente sei leso: ";
        frasi[5] = "non sei simpatico, svegliati mongoloide:";

        // _____________________________________

        System.out.println("Allenatore 1, come ti chiami? ");
        String nome1 = scanner.nextLine();
        nome1 = nome1.replaceAll(" ", "");
        if (nome1.length() == 0) {
            System.out.println("scrivi il tuo nome allenatore!");
            nome1 = scanner.nextLine();
        }

        System.out.println(nome1 + ", scegli il tuo Pokémon:");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(i + 1 + ". " + pokemons[i].getNome());
        }
        System.out.println("Pokemon n°: ");
        int scelta1 = scanner.nextInt() - 1;
        while (scelta1 < 0 || scelta1 >= pokemons.length) {
            System.out.println("fai poco il g:");
            scelta1 = scanner.nextInt() - 1;
        }
        Pokemon giocatore1 = pokemons[scelta1];

        scanner.nextLine();

        // _____________________________________

        System.out.println("Allenatore 2, come ti chiami?");
        String nome2 = scanner.nextLine();
        nome1 = nome1.replaceAll(" ", "");
        if (nome2.length() == 0) {
            System.out.println("scrivi il tuo nome allenatore!");
            nome2 = scanner.nextLine();
        }

        System.out.println(nome2 + ", scegli il tuo Pokémon:");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(i + 1 + ". " + pokemons[i].getNome());
        }
        System.out.println("Pokemon n°: ");
        int scelta2 = scanner.nextInt() - 1;
        while (scelta2 < 0 || scelta2 >= pokemons.length) {
            System.out.println("fai poco il g:");
            scelta2 = scanner.nextInt() - 1;
        }
        Pokemon giocatore2 = pokemons[scelta2];

        // _____________________________________

        System.out.println("\nInizia la battaglia tra " + nome1 + " e " + nome2 + "!");

        // _____________________________________

        int risposteCorrette1 = 0;
        int risposteCorrette2 = 0;

        while (giocatore1.getSalute() > 0 && giocatore2.getSalute() > 0)
        {
            System.out.println("\nTurno del Giocatore 1");
            System.out.println("Scegli una mossa per " + giocatore1.getNome() + ":");
            String[] mosse1 = giocatore1.getMosse();
            for (int i = 0; i < mosse1.length; i++)
            {
                System.out.println(i + ". " + mosse1[i]);
            }
            int mossa1 = scanner.nextInt();
            while (mossa1 < 0 || mossa1 >= mosse1.length)
            {
                System.out.println("Scegli una mossa valida!");
                mossa1 = scanner.nextInt();
            }

            System.out.println("\nTurno del Giocatore 2");
            System.out.println("Scegli una mossa per " + giocatore2.getNome() + ":");
            String[] mosse2 = giocatore2.getMosse();
            for (int i = 0; i < mosse2.length; i++)
            {
                System.out.println(i + ". " + mosse2[i]);
            }
            int mossa2 = scanner.nextInt();
            while (mossa2 < 0 || mossa2 >= mosse2.length)
            {
                System.out.println("Scegli una mossa valida!");
                mossa2 = scanner.nextInt();
            }

            // _____________________________________

            risposteCorrette1 = chiediDomandaCasuale(scanner, risposteCorrette1, nome1);
            risposteCorrette2 = chiediDomandaCasuale(scanner, risposteCorrette2, nome2);

            // _____________________________________

            System.out.println("\nEsecuzione delle mosse!");
            giocatore1.usaMossa(giocatore2, mossa1);
            if (giocatore2.getSalute() > 0) {
                giocatore2.usaMossa(giocatore1, mossa2);
            }

            // _____________________________________


            if (risposteCorrette1 >= 3)
            {
                pietrasacra(giocatore1);
                risposteCorrette1 = 0;
            }

            if (risposteCorrette2 >= 3)
            {
                pietrasacra(giocatore2);
                risposteCorrette2 = 0;
            }

            // _____________________________________

            System.out.println("\nSalute attuale:");
            System.out.println(giocatore1.getNome() + ": " + giocatore1.getSalute());
            System.out.println(giocatore2.getNome() + ": " + giocatore2.getSalute());
        }

        // _____________________________________

        if (giocatore1.getSalute() <= 0 && giocatore2.getSalute() <= 0) {
            System.out.println("La battaglia termina in parità!");
        } else if (giocatore1.getSalute() <= 0) {
            System.out.println(giocatore2.getNome() + " vince la battaglia!");
        } else {
            System.out.println(giocatore1.getNome() + " vince la battaglia!");
        }

        scanner.close();
    }

    public static int chiediDomandaCasuale(Scanner scanner, int risposteCorrette, String nomeGiocatore)
    {
        Random random = new Random();
        String[] domande =
                {
                "Quando inizio' la seconda guerra mondiale?",
                "Chi è il creatore di Minecraft?",
                "Chi è la professoressa migliore?",
                        "Chi è il goat del calcio?",
                        "Tra Ponti e Einstein, chi è il più intelligente?",
                        "java è un linguaggio compilato o interpretato?",
                        "Chi è il goat del basket?",
                        "Qual'è la capitale del brasile?",
                        "Qual'è la capitale dell'Australia?"
        };

        String[][] risposte =
                {
                        {"1939"},
                        {"Notch", "Markus Alexej Persson", "Markus Persson"},
                  {"Bottari", "Prof.ssa Bottari", "Barbara Bottari", "io"},
                 {"Cristiano Ronaldo", "Ronaldo", "CR7"},
                    {"Ponti", "Daniele Ponti", "Sonti","tonti","monti"},
                 {"sia compilato che interpretato", "tutti e due", "ambedue"},
                 {"Lebron", "Lebron James", "LEBROOON","ponti"},
                 {"Brasilia"},
                  {"Canberra"}
        };

        int domandasium = random.nextInt(domande.length);
        scanner.nextLine();

        System.out.println(nomeGiocatore + ", rispondi alla domanda: " + domande[domandasium]);
        String risposta = scanner.nextLine();

        boolean rispostaCorretta = false;
        for (String rispostaCorrettaPossibile : risposte[domandasium])
        {
            if (risposta.equalsIgnoreCase(rispostaCorrettaPossibile))
            {
                rispostaCorretta = true;
                break;
            }
        }

        if (rispostaCorretta)
        {
            System.out.println("Bravo allenatore, Risposta corretta!");
            risposteCorrette++;
        } else {
            System.out.println("Male male allenatore, Risposta sbagliata.");
        }

        return risposteCorrette;
    }

    public static void pietrasacra(Pokemon giocatore)
    {
        Random random = new Random();
        int boostType = random.nextInt(3);

        if (boostType == 0) {
            System.out.println(giocatore.getNome() + " ha ricevuto un boost! Aumento danno di ogni mossa di 30.");

            int[] danni = giocatore.getDanni();
            for (int i = 0; i < danni.length; i++)
            {
                danni[i] += 30;
            }
        } else if (boostType == 1)
        {
            System.out.println(giocatore.getNome() + " ha ricevuto un boost! Cambio di tipo.");

            String[] tipi = {"Drago", "Fuoco", "Acqua", "Elettro"};
            String nuovoTipo = tipi[random.nextInt(tipi.length)];
            giocatore.setTipo(nuovoTipo);
            System.out.println(giocatore.getNome() + " è diventato di tipo " + nuovoTipo + "!");
        } else if (boostType == 2)
        {
            System.out.println(giocatore.getNome() + " ha ricevuto un boost! Aumento salute.");
            giocatore.setSalute(giocatore.getSalute() + 50);
        }
    }
}



