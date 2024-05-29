package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private  List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    // Método para agregar un Pokémon al equipo del entrenador
    public void agregarPokemon(Pokemon pokemon) {
        this.pokemones.add(pokemon);
    }

    // Método para entrenar un Pokémon (no implementado en esta versión)
    public void entrenarPokemon(Pokemon pokemon) {
        // Lógica de entrenamiento
        System.out.println(pokemon.getNombre() + " está siendo entrenado por " + this.nombre);
    }

    // Método para mostrar los Pokémon del entrenador
    public void mostrarPokemones() {
        System.out.println("Pokémones de " + this.nombre + ":");
        for (Pokemon pokemon : pokemones) {
            System.out.println("- " + pokemon.getNombre());
        }
    }

    // Método para preparar un Pokémon para la batalla
    public Pokemon prepararBatalla() {
        if (!pokemones.isEmpty()) {
            System.out.println(this.nombre + " elige un Pokémon para la batalla:");
            mostrarPokemones();
            // Seleccionar un Pokémon para la batalla (aquí se podría implementar una lógica más compleja)
            return pokemones.get(0);
        } else {
            System.out.println(this.nombre + " no tiene ningún Pokémon para la batalla.");
            return null;
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }
}
