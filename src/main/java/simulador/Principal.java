package simulador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Growlithe;
import simulador.pokemon.Exeggcute;
import simulador.pokemon.Farfetchd;
import simulador.pokemon.Hitmonlee;
import simulador.pokemon.Psyduck;
import simulador.pokemon.Tentacool;
import simulador.pokemon.Voltorb;
import simulador.pokemon.Zubat;
import simulador.pokemon.Onix;
import simulador.pokemon.Bellsprout;
import simulador.pokemon.TipoPokemon;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Estado;

public class Principal { 
    
    private static final Scanner lector = new Scanner(System.in); 
    private static final List<Entrenador> entrenadores = new ArrayList<>(); 
    private static final List<Pokemon> pokemones = new ArrayList<>(); 
   
    public static void main(String[] args) { //O(1)
        pokemones.add(new Growlithe()); 
        pokemones.add(new Exeggcute()); 
        pokemones.add(new Farfetchd()); 
        pokemones.add(new Hitmonlee()); 
        pokemones.add(new Psyduck ()); 
        pokemones.add(new Tentacool()); 
        pokemones.add(new Voltorb()); 
        pokemones.add(new Zubat()); 
        pokemones.add(new Onix()); 
        pokemones.add(new Bellsprout()); 

        mostrarMenuPrincipal(); 
    } 
   

    private static void mostrarMenuPrincipal() { 
        
        while (true) { //O(1)
            System.out.println("*SIMULADOR DE BATALLAS POKEMON*"); 
            System.out.println("Bienvenido al simulador POKEMONSTERS"); 
            System.out.println("Menu principal, selecciona una opción:"); 
            System.out.println("1. Gestionar Entrenadores"); 
            System.out.println("2. Gestionar Pokemones"); 
            System.out.println("3. Iniciar Batalla"); 
            System.out.println("4. Salir"); 
            String opcion = lector.next(); 

            switch (opcion) { //O(1)
                
                case "1": 
                    gestionarEntrenadores(); 
                    break; 
                case "2": 
                    gestionarPokemones(); 
                    break; 
                case "3": 
                    iniciarBatalla();
                case "4": 
                    System.out.println("Saliendo del juego...Hasta pronto"); 
                    return; //Sale del juego.
                default: 
                    System.out.println("Opción no válida, por favor intenta de nuevo."); 
                    break; 
            } 
        } 
    }
   
    private static void gestionarEntrenadores() { //O(1)
        
        while (true) { 
            System.out.println("Opción elegida: Gestionar Entrenadores"); 
            System.out.println("1. Registrar un nuevo entrenador"); 
            System.out.println("2. Ver lista de entrenadores"); 
            System.out.println("3. Seleccionar un entrenador"); 
            System.out.println("4. Volver al menú principal"); 
            String opcion = lector.next(); 

            switch (opcion) { //Complejidad temporal: O(1) Complejidad Constante.
                
                case "1": 
                    registrarEntrenador(); 
                    break; 
                case "2": 
                    verListaEntrenadores(); 
                    break; 
                case "3": 
                    seleccionarEntrenador(); 
                    break; 
                case "4": 
                    return; //Retorna al menú principal.
                default: 
                    System.out.println("Opción no válida, por favor intenta de nuevo."); 
                    
            } 
        } 
    }
    
    private static void registrarEntrenador() { //O(1)
        
        System.out.println("Registra un nuevo entrenador"); 
        System.out.print("Ingresa el nombre: "); 
        String nombre = lector.next(); 
        entrenadores.add(new Entrenador(nombre)); 
        System.out.println("Tu entrenador se registró. Nombre: " + nombre); 
        
    }
    
    private static void verListaEntrenadores() { //Complejidad lineal O(N) porque contiene un ciclo for.
        
        if (entrenadores.isEmpty()) { //Verificar si la lista está vacía.
            System.out.println("No hay entrenadores registrados."); 
        } else { 
            for (int i = 0; i < entrenadores.size(); i++) { 
                System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre()); 
            } 
        } 
        
    }
   
    private static void seleccionarEntrenador() { //O(1)
        
        if (entrenadores.isEmpty()) {//si no hay entrenadores en la lista 
            System.out.println("No hay entrenadores registrados."); 
        }else {
        

        verListaEntrenadores(); 
        System.out.print("Selecciona un entrenador por número: "); 
        int numEntrenador = lector.nextInt() - 1; 

        if (numEntrenador >= 0 && numEntrenador < entrenadores.size()) { 
            Entrenador entrenadorSeleccionado = entrenadores.get(numEntrenador); 
            gestionarEquipo(entrenadorSeleccionado); 
        } else { 
            System.out.println("Número de entrenador no válido."); 
        } 
        }
    }
    
    private static void iniciarBatalla() { //O(1)
        if(entrenadores.size() < 2 ) {
            System.out.println("Debe haber al menos dos entrenadores registrados para iniciar la batalla. ");
        }else{
            System.out.println("Selecciona el primer entrenador: ");
            Entrenador oponente1 = seleccionarEntrenadorBatalla();
            if (oponente1 == null) return;
            System.out.println("Selecciona el segundo entrenador: ");
            Entrenador oponente2 = seleccionarEntrenadorBatalla();
            if (oponente2 == null) return;
        
        System.out.println(oponente1.getNombre() + "Selecciona tu pokemon: ");
        Pokemon pokemon1 = seleccionarPokemonOponente(oponente1);
        if (pokemon1 == null) return;
        System.out.println(oponente2.getNombre() + "Selecciona tu pokemon: ");
        Pokemon pokemon2 = seleccionarPokemonOponente(oponente2);
        if (pokemon2 == null) return;
        
        System.out.println("Iniciando la batalla entre "+ pokemon1.getNombre()+ " y " + pokemon2.getNombre());
        Batalla batalla = new Batalla();
        batalla.iniciarBatalla(pokemon1, pokemon2);
        }
    }
   
    private static Entrenador seleccionarEntrenadorBatalla() {
        verListaEntrenadores();
        System.out.println("Selecciona un entrenador por numero: ");
        int numOponente = lector.nextInt() - 1; //-1 porque el indice comienza en 0
        if (numOponente >=0 && numOponente<entrenadores.size()){
            return entrenadores.get(numOponente);      
        }else{
            System.out.println("Número de entrenador no válido");
            return null;
        }
    
    }
    private static Pokemon seleccionarPokemonOponente(Entrenador entrenador) {
    List<Pokemon> equipo = entrenador.getPokemones();
    for (int i = 0; i < equipo.size(); i++) {
        Pokemon pokemon = equipo.get(i);
        System.out.println((i + 1) + ". " + pokemon.getNombre() + " (Salud: " + pokemon.getSalud() + ", Ataque: " + pokemon.getPuntosDeAtaque() + ")");
    }
    System.out.print("Selecciona un Pokémon por número: ");
    int numPokemon = lector.nextInt() - 1;
    if (numPokemon >= 0 && numPokemon < equipo.size()) {
        return equipo.get(numPokemon);
    } else {
        System.out.println("Número de Pokémon no válido.");
        return null;
    }
    }

    
    private static void gestionarEquipo(Entrenador entrenador) { //O(1)
        
        while (true) { 
            System.out.println("--GESTIONAR EQUIPO--");
            System.out.println("Gestionar equipo de " + entrenador.getNombre()); 
            System.out.println("1. Ver equipo de Pokémones"); 
            System.out.println("2. Agregar Pokémon al equipo"); 
            System.out.println("3. Entrenar Pokémon"); 
            System.out.println("4. Volver a Gestionar Entrenadores"); 
            String opcion = lector.next(); 

            switch (opcion) { 
                
                case "1": 
                    verEquipo(entrenador); 
                    break; 
                case "2": 
                    agregarPokemonAlEquipo(entrenador); 
                    break; 
                case "3": 
                    entrenarPokemon(entrenador);
                    break; 
                case "4": 
                    return; 
                default: 
                    System.out.println("Opción no válida, por favor intenta de nuevo."); 
                    
            } 
        } 
    }
   
    private static void verEquipo(Entrenador entrenador) { //Complejidad lineal O(N) porque contiene un ciclo for.
        
        List<Pokemon> equipo = entrenador.getPokemones(); 
        if (equipo.isEmpty()) { 
            System.out.println("El equipo está vacío."); 
        } else { 
            for (Pokemon pokemon : equipo) { 
                System.out.println(pokemon.getNombre()); 
            } 
        } 
        
    }
    
    private static void agregarPokemonAlEquipo(Entrenador entrenador) { //O(N)
        
        System.out.println("Agregar un nuevo Pokémon al equipo de " + entrenador.getNombre()); 
        
        for (int i = 0; i < pokemones.size(); i++) { //Complejidad lineal O(N) porque contiene un ciclo for.
            Pokemon pokemon = pokemones.get(i); 
            System.out.println((i + 1) + ". " + pokemon.getNombre() + " (Tipo: " + pokemon.getTipoPokemon() + ", Salud: " + pokemon.getSalud() + ", Ataque: " + pokemon.getPuntosDeAtaque() + ")"); 
        } 
        
        System.out.print("Selecciona un Pokémon por número: "); 
        int numPokemon = lector.nextInt() - 1; 

        if (numPokemon >= 0 && numPokemon < pokemones.size()) { 
            entrenador.getPokemones().add(pokemones.get(numPokemon)); 
            System.out.println("Pokémon añadido al equipo."); 
        } else { 
            System.out.println("Número de Pokémon no válido."); 
        } 
        
    } 
    
    private static void entrenarPokemon(Entrenador entrenador) { 
    List<Pokemon> equipo = entrenador.getPokemones(); 
    if (equipo.isEmpty()) { //Para saber si la lista equipo esta vacía equipo.isEmpty.
        System.out.println("El equipo de Pokémon está vacío"); 
        
    }else{ 
        
        System.out.println("Selecciona el Pokémon que deseas entrenar:"); 

    for (int i = 0; i < equipo.size(); i++) { //Complejidad lineal O(N) porque contiene un ciclo for.
        Pokemon pokemon = equipo.get(i); 
        System.out.println((i + 1) + "." + pokemon.getNombre() + " (Salud: " + pokemon.getSalud() + ", Ataque: " + pokemon.getPuntosDeAtaque() + ")");
    }

    System.out.print("Selecciona el número del Pokémon a entrenar: "); 
    int numPokemonEntrenar = lector.nextInt() - 1; 

    if (numPokemonEntrenar >= 0 && numPokemonEntrenar < equipo.size()) { 
        Pokemon pokemonSeleccionado = equipo.get(numPokemonEntrenar); 
        pokemonSeleccionado.entrenar(); 
        System.out.println(pokemonSeleccionado.getNombre() + " ha sido entrenado. salud nueva: " + pokemonSeleccionado.getSalud() + ", ataque nuevo: " + pokemonSeleccionado.getPuntosDeAtaque()); 
    } else 
        { 
            System.out.println("Número de Pokémon no válido."); 
        }
    }
}
    
    private static void gestionarPokemones() { //O(1)
        
        while (true) { 
            System.out.println("Opción elegida: Gestionar Pokémones"); 
            System.out.println("1. Ver todos los Pokémones registrados"); 
            System.out.println("2. Registrar nuevo Pokémon"); 
            System.out.println("3. Volver al menú principal"); 
            String opcion = lector.next(); 

            switch (opcion) { 
                
                case "1" -> verPokemonesRegistrados();
                case "2" -> registrarNuevoPokemon();
                case "3" -> {
                    return;
                }
                default -> System.out.println("Opción no válida, por favor intenta de nuevo."); 
                    
            } 
        } 
        
    }
    
    private static void verPokemonesRegistrados() { //Complejidad lineal O(N) porque contiene un ciclo for.
        
        System.out.println("Todos los Pokémones registrados: "); 
        
        for (int i = 0; i < pokemones.size(); i++) { 
            Pokemon pokemon = pokemones.get(i); 
            System.out.println((i + 1) + ". " + pokemon.getNombre() + "\nTipo: " + pokemon.getTipoPokemon() + "\nSalud: " + pokemon.getSalud() + "\nAtaque: " + pokemon.getPuntosDeAtaque()); 
        } 
        
    }
    /**
     * Método que registra un nuevo pokémon.
     * Complejidad lineal O(N) porque contiene un ciclo for.
     * 
     */
    private static void registrarNuevoPokemon() {
    System.out.println("Registrar un nuevo Pokémon:");
    System.out.print("Nombre del Pokémon: ");
    String nombreNuevoPokemon = lector.next();
    System.out.print("Puntos de salud: ");
    int saludNuevoPokemon = lector.nextInt();
    System.out.print("Puntos de ataque: ");
    int ataqueNuevoPokemon = lector.nextInt();
    
    // Mostrar todos los tipos de Pokémon disponibles.
    TipoPokemon[] tipos = TipoPokemon.values();//Todos los valores de TipoPokemon, es decir todos los tipos registrados de pokémon.
    System.out.println("Tipos de Pokémon disponibles:");
    for (int i = 0; i < tipos.length; i++) {//Complejidad lineal O(N) porque contiene un ciclo for.
        System.out.println((i + 1) + "." + tipos[i]);
    }
    // Ingresar el tipo de pokémon.
    System.out.print("Selecciona el número del tipo de Pokémon: ");
    int tipoSeleccionado = lector.nextInt()-1;//-1 porque el arreglo va desde 0 (el índice).
    TipoPokemon tipo;
    if (tipoSeleccionado >= 0 && tipoSeleccionado < tipos.length) {
        tipo = tipos[tipoSeleccionado];
    } else {
        System.out.println("Número de tipo no válido. Usando tipo NORMAL por defecto.");
        tipo = TipoPokemon.NORMAL;
    }
    // Definir el estado inicial del Pokémon.
    Estado estado = Estado.NORMAL;
    // Aquí se crea un nuevo pokémon y se agrega a la lista.
    Pokemon nuevoPokemon = new Pokemon(nombreNuevoPokemon, saludNuevoPokemon, ataqueNuevoPokemon, tipo, estado) {};
    pokemones.add(nuevoPokemon);
    System.out.println("Nuevo Pokémon registrado: " + nombreNuevoPokemon + " (Salud: " + saludNuevoPokemon + ", Ataque: " + ataqueNuevoPokemon + ", Tipo: " + tipo + ")");
    }
}