import java.util.Random;
import java.util.Scanner;

class Pokemon
{
    private String nome;
    private String tipo;
    private int salute;
    private String[] mosse;
    private int[] danni;

    public Pokemon(String nome, String tipo, int salute, String[] mosse, int[] danni)
    {
        this.nome = nome;
        this.tipo = tipo;
        this.salute = salute;
        this.mosse = mosse;
        this.danni = danni;
    }

    public String getNome()
    {
        return nome;
    }

    public String getTipo()
    {
        return tipo;
    }

    public int getSalute()
    {
        return salute;
    }

    public void setSalute(int salute)
    {
        this.salute = salute;
    }

    public String[] getMosse()
    {
        return mosse;
    }

    public int[] getDanni()
    {
        return danni;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public void usaMossa(Pokemon avversario, int indiceMossa)
    {
        if (indiceMossa < 0 || indiceMossa >= mosse.length)
        {
            System.out.println("Mossa non valida!");
            return;
        }
        System.out.println(nome + " usa " + mosse[indiceMossa] + " contro " + avversario.getNome());
        int dannoBase = danni[indiceMossa];
        int danno = calcolaDanno(this.tipo, avversario.getTipo(), dannoBase);
        avversario.setSalute(avversario.getSalute() - danno);
        System.out.println(avversario.getNome() + " subisce " + danno + " danni!");
    }

    public static int calcolaDanno(String tipoAttaccante, String tipoDifensore, int dannoBase)
    {
        double moltiplicatore = 1;

        if (tipoAttaccante.equals("Fuoco")) {
            if (tipoDifensore.equals("Erba") || tipoDifensore.equals("Ghiaccio") || tipoDifensore.equals("Acciaio")) {
                moltiplicatore = 2; // Fuoco è forte contro Erba, Ghiaccio, Acciaio
            } else if (tipoDifensore.equals("Acqua") || tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Drago")) {
                moltiplicatore = 0.5; // Fuoco è debole contro Acqua, Fuoco, Drago
            }
        } else if (tipoAttaccante.equals("Acqua")) {
            if (tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Terra") || tipoDifensore.equals("Acciaio")) {
                moltiplicatore = 2; // Acqua è forte contro Fuoco, Terra, Acciaio
            } else if (tipoDifensore.equals("Acqua") || tipoDifensore.equals("Elettrico") || tipoDifensore.equals("Drago")) {
                moltiplicatore = 0.5; // Acqua è debole contro Acqua, Elettrico, Drago
            }
        } else if (tipoAttaccante.equals("Elettrico")) {
            if (tipoDifensore.equals("Acqua") || tipoDifensore.equals("Volante")) {
                moltiplicatore = 2; // Elettrico è forte contro Acqua, Volante
            } else if (tipoDifensore.equals("Terra")) {
                moltiplicatore = 0; // Elettrico non fa danno a Terra
            } else if (tipoDifensore.equals("Elettrico")) {
                moltiplicatore = 0.5; // Elettrico è debole contro Elettrico
            }
        } else if (tipoAttaccante.equals("Erba")) {
            if (tipoDifensore.equals("Acqua") || tipoDifensore.equals("Terra") || tipoDifensore.equals("Ghiaccio")) {
                moltiplicatore = 2; // Erba è forte contro Acqua, Terra, Ghiaccio
            } else if (tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Volante") || tipoDifensore.equals("Acciaio")) {
                moltiplicatore = 0.5; // Erba è debole contro Fuoco, Volante, Acciaio
            }
        } else if (tipoAttaccante.equals("Ghiaccio")) {
            if (tipoDifensore.equals("Drago") || tipoDifensore.equals("Volante") || tipoDifensore.equals("Erba") || tipoDifensore.equals("Terra")) {
                moltiplicatore = 2; // Ghiaccio è forte contro Drago, Volante, Erba, Terra
            } else if (tipoDifensore.equals("Acciaio") || tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Acqua")) {
                moltiplicatore = 0.5; // Ghiaccio è debole contro Acciaio, Fuoco, Acqua
            }
        } else if (tipoAttaccante.equals("Lotta")) {
            if (tipoDifensore.equals("Normale") || tipoDifensore.equals("Acciaio")) {
                moltiplicatore = 2; // Lotta è forte contro Normale, Acciaio
            } else if (tipoDifensore.equals("Psico") || tipoDifensore.equals("Buio")) {
                moltiplicatore = 0.5; // Lotta è debole contro Psico, Buio
            }
        } else if (tipoAttaccante.equals("Veleno")) {
            if (tipoDifensore.equals("Erba") || tipoDifensore.equals("Psico")) {
                moltiplicatore = 2; // Veleno è forte contro Erba, Psico
            } else if (tipoDifensore.equals("Acciaio") || tipoDifensore.equals("Veleno")) {
                moltiplicatore = 0.5; // Veleno è debole contro Acciaio, Veleno
            }
        } else if (tipoAttaccante.equals("Terra")) {
            if (tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Acciaio") || tipoDifensore.equals("Elettrico") || tipoDifensore.equals("Veleno") || tipoDifensore.equals("Roccia") || tipoDifensore.equals("Acqua")) {
                moltiplicatore = 2; // Terra è forte contro Fuoco, Acciaio, Elettrico, Veleno, Roccia, Acqua
            } else if (tipoDifensore.equals("Erba") || tipoDifensore.equals("Volante")) {
                moltiplicatore = 0.5; // Terra è debole contro Erba, Volante
            }
        } else if (tipoAttaccante.equals("Psico")) {
            if (tipoDifensore.equals("Lotta") || tipoDifensore.equals("Veleno")) {
                moltiplicatore = 2; // Psico è forte contro Lotta, Veleno
            } else if (tipoDifensore.equals("Psico")) {
                moltiplicatore = 0.5; // Psico è debole contro Psico
            }
        } else if (tipoAttaccante.equals("Drago")) {
            if (tipoDifensore.equals("Drago")) {
                moltiplicatore = 2; // Drago è forte contro Drago
            } else if (tipoDifensore.equals("Fata")) {
                moltiplicatore = 0; // Drago non fa danno a Fata
            }
        } else if (tipoAttaccante.equals("Buio")) {
            if (tipoDifensore.equals("Psico") || tipoDifensore.equals("Spettro")) {
                moltiplicatore = 2; // Buio è forte contro Psico, Spettro
            } else if (tipoDifensore.equals("Lotta") || tipoDifensore.equals("Buio")) {
                moltiplicatore = 0.5; // Buio è debole contro Lotta, Buio
            }
        } else if (tipoAttaccante.equals("Acciaio")) {
            if (tipoDifensore.equals("Ghiaccio") || tipoDifensore.equals("Roccia") || tipoDifensore.equals("Fata")) {
                moltiplicatore = 2; // Acciaio è forte contro Ghiaccio, Roccia, Fata
            } else if (tipoDifensore.equals("Acciaio") || tipoDifensore.equals("Fuoco") || tipoDifensore.equals("Acqua") || tipoDifensore.equals("Elettro")) {
                moltiplicatore = 0.5; // Acciaio è debole contro Acciaio, Fuoco, Acqua, Elettro
            }
        }

        return (int) (dannoBase * moltiplicatore);
    }
}

class Zapdos extends Pokemon
{
    public Zapdos()
    {
        super("Zapdos", "Elettrico", 220,
                new String[]{"Tuono", "fulmine", "Scarica", "Tifone"},
                new int[]{70, 50, 20, 60});
    }
}

class Moltres extends Pokemon
{
    public Moltres()
    {
        super("Moltres", "Fuoco", 220,
                new String[]{"Fiammata", "Tornado di Fuoco", "Ali di Fuoco", "Braciere"},
                new int[]{45, 70, 55, 30});
    }
}

class Articuno extends Pokemon
{
    public Articuno()
    {
        super("Articuno", "Ghiaccio", 220,
                new String[]{"Geloraggio", "Vento Polare", "Nevegelida", "Freccia Ghiacciata"},
                new int[]{70, 50, 30, 60});
    }
}

class Lugia extends Pokemon
{
    public Lugia()
    {
        super("Lugia", "Psico", 200,
                new String[]{"Aerocolpo", "Psichico", "Forza Antica", "Ventoincoda"},
                new int[]{60, 80, 70, 40});
    }
}

class HoOh extends Pokemon
{
    public HoOh()
    {
        super("Ho-Oh", "Fuoco", 200,
                new String[]{"Lanciafiamme", "Luce Solare", "Sacred Fire", "Ondacalda"},
                new int[]{70, 45, 80, 20});
    }
}

class Mewtwo extends Pokemon
{
    public Mewtwo()
    {
        super("Mewtwo", "Psico", 190,
                new String[]{"Psichico", "CannonFlash", "Confusione", "Forza"},
                new int[]{80, 90, 30, 45});
    }
}

