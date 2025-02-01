import java.util.Random;
import java.util.Scanner;

public class PokemonGame
{

    // Contatori delle risposte corrette per i due giocatori
    private static int contatore1 = 0;
    private static int contatore2 = 0;

    public static void main(String[] args) {
        // Crea i Pokémon
        Pokemon zapdos = new Zapdos();
        Pokemon moltres = new Moltres();

        // Esempio di nomi per i giocatori
        String nome1 = "Giocatore 1";
        String nome2 = "Giocatore 2";

        // Simulazione di domande e boost
        gestisciDomanda(nome1, nome2, zapdos, moltres);
    }

    // Funzione per gestire le domande casuali alla fine di ogni turno
    public static void gestisciDomanda(String nome1, String nome2, Pokemon giocatore1, Pokemon giocatore2) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Domande e risposte possibili
        String[] domande = {
                "Qual è il tipo di Zapdos?", // Risposta corretta: Elettrico
                "Qual è il tipo di Moltres?", // Risposta corretta: Fuoco
                "Qual è il tipo di Articuno?", // Risposta corretta: Ghiaccio
                "Qual è il tipo di Lugia?", // Risposta corretta: Psico
                "Qual è il tipo di Ho-Oh?", // Risposta corretta: Fuoco
                "Qual è il tipo di Mewtwo?" // Risposta corretta: Psico
        };

        String[] risposte = {
                "Elettrico", "Fuoco", "Ghiaccio", "Psico", "Fuoco", "Psico"
        };

        // Scelta della domanda per il giocatore 1
        int domanda1 = random.nextInt(domande.length);
        System.out.println(nome1 + ", " + domande[domanda1]);
        String risposta1 = scanner.nextLine();

        if (risposta1.equalsIgnoreCase(risposte[domanda1])) {
            contatore1++;
            System.out.println(nome1 + " ha risposto correttamente! Contatore: " + contatore1);
        } else {
            System.out.println(nome1 + " ha risposto erroneamente.");
        }

        // Scelta della domanda per il giocatore 2
        int domanda2 = random.nextInt(domande.length);
        System.out.println(nome2 + ", " + domande[domanda2]);
        String risposta2 = scanner.nextLine();

        if (risposta2.equalsIgnoreCase(risposte[domanda2])) {
            contatore2++;
            System.out.println(nome2 + " ha risposto correttamente! Contatore: " + contatore2);
        } else {
            System.out.println(nome2 + " ha risposto erroneamente.");
        }

        // Controllo dei boost
        if (contatore1 == 3) {
            pietraSacra(giocatore1); // Applica il boost al giocatore 1
            contatore1 = 0; // Resetta il contatore per il prossimo ciclo
        }

        if (contatore2 == 3) {
            pietraSacra(giocatore2); // Applica il boost al giocatore 2
            contatore2 = 0; // Resetta il contatore per il prossimo ciclo
        }
    }

    // Funzione che applica un boost a un giocatore quando ha risposto correttamente a 3 domande
    public static void pietraSacra(Pokemon giocatore)
    {
        Random random = new Random();
        int tipoBoost = random.nextInt(3); // 0 = danno, 1 = tipo, 2 = salute

        switch (tipoBoost) {
            case 0: // Aumento del danno
                int mossaBoost = random.nextInt(giocatore.getMosse().length);
                System.out.println(giocatore.getNome() + " ha ricevuto un boost al danno della mossa " + giocatore.getMosse()[mossaBoost]);
                int nuovoDanno = giocatore.getDanni()[mossaBoost] + 20; // Aumenta il danno di 20
                int[] danniBoost = giocatore.getDanni();
                danniBoost[mossaBoost] = nuovoDanno;
                break;
            case 1: // Cambia tipo
                System.out.println(giocatore.getNome() + " ha ricevuto un boost al tipo!");
                String nuovoTipo = "Drago"; // Cambia a un tipo potente
                giocatore.setTipo(nuovoTipo);
                break;
            case 2: // Aumento della salute
                System.out.println(giocatore.getNome() + " ha ricevuto un boost alla salute!");
                int nuovaSalute = giocatore.getSalute() + 30; // Aumenta la salute di 30
                giocatore.setSalute(nuovaSalute);
                break;
        }
    }
}
