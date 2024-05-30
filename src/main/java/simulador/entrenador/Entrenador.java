package simulador.entrenador;

import java.util.LinkedList;
import java.util.List;
import simulador.pokemon.Pokemon;

public class Entrenador{ //O(1)
    private String nombre; 
    private List<Pokemon> pokemones; 
    
    public static Pokemon pokemon; 

    public Entrenador(String nombre){ 
        this.nombre = nombre;
        this.pokemones = new LinkedList<>();           
    }
 
    public void agregarPokemon(Pokemon pokemon) { //O(1)
        if (pokemones.size() < 6) { 
            pokemones.add(pokemon); 
        } 
    }
  
    public void entrenarPokemon() { //O(1)
        if (pokemones.contains(pokemon)) { 
            pokemon.entrenar(); //20 de salud y 5 de ataque.         
        } 
    }
    
     public Pokemon prepararBatalla() { //O(1)
        if (!pokemones.isEmpty()) { //Saber si la lista de pokemones no esta vacía.
            Pokemon pokemonParaBatalla = pokemones.get(0); // Selecciona el primer Pokémon del equipo.
            System.out.println(pokemonParaBatalla + " ha sido seleccionado para la batalla."); 
            return pokemonParaBatalla; 
        } else { 
            System.out.println("No hay Pokémones en el equipo para participar en la batalla."); 
            return null; 
        } 
    } 

    public String getNombre() {
        return nombre; 
    }

    public List<Pokemon> getPokemones() { 
        return pokemones; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones; 
    }
     
}