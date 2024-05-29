package simulador.pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Enumeración para los diferentes tipos de Pokémon
enum TipoPokemon {
    NORMAL, FUEGO, AGUA, ELECTRICO, PLANTA, HIELO, PSIQUICO, ROCA, TIERRA, VOLADOR, HADA, LUCHA, BICHO, ACERO, VENENO, FANTASMA;
}

// Clase para representar a un Pokémon
class Pokemon {
    private String nombre;
    private double salud;
    private double puntosDeAtaque;
    private List<TipoPokemon> tipos;

    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon... tipos) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipos = Arrays.asList(tipos);
    }

    // Método para crear instancias de Pokémon
    public static List<Pokemon> crearPokemon() {
        List<Pokemon> pokemon = new ArrayList<>();
        pokemon.add(new Pokemon("Growlithe", 55, 70, TipoPokemon.FUEGO));
        pokemon.add(new Pokemon("Psyduck", 50, 52, TipoPokemon.AGUA));
        pokemon.add(new Pokemon("Bellsprout", 50, 75, TipoPokemon.PLANTA, TipoPokemon.VENENO));
        pokemon.add(new Pokemon("Voltorb", 40, 30, TipoPokemon.ELECTRICO));
        pokemon.add(new Pokemon("Exeggcute", 60, 40, TipoPokemon.PLANTA, TipoPokemon.PSIQUICO));
        pokemon.add(new Pokemon("Onix", 35, 45, TipoPokemon.ROCA, TipoPokemon.TIERRA));
        pokemon.add(new Pokemon("Zubat", 40, 45, TipoPokemon.VENENO, TipoPokemon.VOLADOR));
        pokemon.add(new Pokemon("Farfetch'd", 52, 90, TipoPokemon.NORMAL, TipoPokemon.VOLADOR));
        pokemon.add(new Pokemon("Hitmonlee", 50, 120, TipoPokemon.LUCHA));
        pokemon.add(new Pokemon("Tentacool", 40, 40, TipoPokemon.AGUA, TipoPokemon.VENENO));
        return pokemon;
    }

}

