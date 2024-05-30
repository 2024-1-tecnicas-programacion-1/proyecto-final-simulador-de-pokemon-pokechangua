package simulador.entrenador;

import java.util.LinkedList;
import java.util.List;
import simulador.pokemon.Pokemon;

public class Entrenador{ 
    private String nombre; 
    private List<Pokemon> pokemones; 
    
    public static Pokemon pokemon; 

    public Entrenador(String nombre){ 
        this.nombre = nombre;
        this.pokemones = new LinkedList<>();           
    }
 
    public void agregarPokemon(Pokemon pokemon) { 
        if (pokemones.size() < 6) { 
            pokemones.add(pokemon); 
        } 
    }
  
    public void entrenarPokemon() { 
        if (pokemones.contains(pokemon)) { 
            pokemon.entrenar();          
        } 
    }
    
     public Pokemon prepararBatalla() { 
        if (!pokemones.isEmpty()) { 
            Pokemon pokemonParaBatalla = pokemones.get(0); 
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

    public Pokemon getPokemon(int i) {
        this.pokemon = pokemon;
        return null;
    } 

    public void mostrarPokemones() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
     
}