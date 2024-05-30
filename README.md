import java.util.ArrayList;
import java.util.List;


enum TipoPokemon {
    FUEGO, AGUA, PLANTA, ELECTRICO, NORMAL;

   
    public double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
       
        return 1.0;
    }
}


abstract class Pokemon {
    protected String nombre;
    protected double salud;
    protected double puntosDeAtaque;
    protected TipoPokemon tipo;
    protected Estado estado;

    
    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = Estado.NORMAL;
    }

    public void atacar(Pokemon oponente) {
        double multiplicadorDeDaño = this.tipo.obtenerMultiplicadorDeDaño(this.tipo, oponente.tipo);
        double dañoInfligido = this.puntosDeAtaque * multiplicadorDeDaño;
        oponente.recibirDaño(dañoInfligido);
    }

    public void recibirDaño(double daño) {
        this.salud -= daño;
        if (this.salud <= 0) {
            this.estado = Estado.DEBILITADO;
        }
    }

    
    public void entrenar() {
       
    }
}


class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        this.pokemones = new ArrayList<>();
    }

   
    public void agregarPokemon(Pokemon pokemon) {
        this.equipo.add(pokemon);
        this.pokemones.add(pokemon);
    }

    
    public void entrenarPokemon(Pokemon pokemon) {
        pokemon.entrenar();
    }

    
    public void mostrarPokemones() {
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.nombre);
        }
    }

    public Pokemon prepararBatalla() {
        
        return equipo.get(0); 
    }

    public void batallar(Entrenador oponente) {
    }
}

enum Estado {
    NORMAL, DEBILITADO
}

class Batalla {
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        
    }
}

class Growlithe extends Pokemon {
    public Growlithe(String nombre, double salud, double puntosDeAtaque) {
        super(nombre, salud, puntosDeAtaque, TipoPokemon.FUEGO);
    }

    
}

class Onix extends Pokemon {
    public Onix(String nombre, double salud, double puntosDeAtaque) {
        super(nombre, salud, puntosDeAtaque, TipoPokemon.TIERRA);
    }

    
}