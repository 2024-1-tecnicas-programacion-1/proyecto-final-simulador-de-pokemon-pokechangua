<<<<<<< Updated upstream
package simulador;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear Pokémon
        Map<String, Pokemon> pokemones = Pokemon.inicializarPokemones();

        // Mostrar información inicial de los Pokémon
        System.out.println("Información inicial de los Pokémon:");
        for (Pokemon pokemon : pokemones.values()) {
            mostrarInfoPokemon(pokemon);
        }

        // Menú para simular batallas o salir
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Simular una batalla");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Simular una batalla
                    System.out.println("\nElige tu Pokémon para la batalla:");
                    int i = 1;
                    for (String nombre : pokemones.keySet()) {
                        System.out.println(i + ". " + nombre);
                        i++;
                    }
                    System.out.print("Ingrese el número de tu Pokémon: ");
                    int opcionPokemon = scanner.nextInt();
                    String nombrePokemon = (String) pokemones.keySet().toArray()[opcionPokemon - 1];
                    Pokemon pokemonElegido = pokemones.get(nombrePokemon);
                    System.out.println("\n¡Comienza la batalla!");
                    Batalla batalla = new Batalla();
                    batalla.comenzarBatalla(pokemonElegido, batalla.getRandomPokemon(pokemones));
                    // Mostrar cantidad de vida que le queda al Pokémon
                    System.out.println("\nVida restante de tu Pokémon después de la batalla:");
                    mostrarInfoPokemon(pokemonElegido);
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 2);
    }

    // Método para mostrar información de un Pokémon
    public static void mostrarInfoPokemon(Pokemon pokemon) {
        System.out.println("Nombre: " + pokemon.getNombre());
        System.out.println("Tipo: " + pokemon.getTipo());
        System.out.println("Salud: " + pokemon.getSalud());
        System.out.println("Ataque: " + pokemon.getAtaque());
        System.out.println("--------------------------");
=======
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
>>>>>>> Stashed changes
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
