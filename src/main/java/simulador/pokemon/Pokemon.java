package simulador.pokemon;
import java.util.*;

public class Pokemon {
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

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public List<TipoPokemon> getTipos() {
        return tipos;
    }

    // Método para inicializar Pokémon
    public static Map<String, Pokemon> inicializarPokemones() {
        Map<String, Pokemon> pokemones = new HashMap<>();
        pokemones.put("Growlithe", new Pokemon("Growlithe", 55, 70, TipoPokemon.FUEGO));
        pokemones.put("Psyduck", new Pokemon("Psyduck", 50, 52, TipoPokemon.AGUA));
        pokemones.put("Bellsprout", new Pokemon("Bellsprout", 50, 75, TipoPokemon.PLANTA, TipoPokemon.VENENO));
        pokemones.put("Voltorb", new Pokemon("Voltorb", 40, 30, TipoPokemon.ELECTRICO));
        pokemones.put("Exeggcute", new Pokemon("Exeggcute", 60, 40, TipoPokemon.PLANTA, TipoPokemon.PSIQUICO));
        pokemones.put("Onix", new Pokemon("Onix", 35, 45, TipoPokemon.ROCA, TipoPokemon.TIERRA));
        pokemones.put("Zubat", new Pokemon("Zubat", 40, 45, TipoPokemon.VENENO, TipoPokemon.VOLADOR));
        pokemones.put("Farfetch'd", new Pokemon("Farfetch'd", 52, 90, TipoPokemon.NORMAL, TipoPokemon.VOLADOR));
        pokemones.put("Hitmonlee", new Pokemon("Hitmonlee", 50, 120, TipoPokemon.LUCHA));
        pokemones.put("Tentacool", new Pokemon("Tentacool", 40, 40, TipoPokemon.AGUA, TipoPokemon.VENENO));
        return pokemones;
    }
}