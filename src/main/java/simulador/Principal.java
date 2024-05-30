package simulador;
import java.util.Scanner;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Psyduck;
import simulador.pokemon.Hitmonlee;
import simulador.pokemon.Exeggcute;
import simulador.pokemon.Growlithe;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Simulador de Batallas Pokémon");

        // Crear entrenadores
        Entrenador entrenador1 = new Entrenador("Entrenador 1");
        Entrenador entrenador2 = new Entrenador("Entrenador 2");

        // Agregar pokemones a los entrenadores (ejemplo)
        entrenador1.agregarPokemon(new Psyduck());
        entrenador1.agregarPokemon(new Hitmonlee());
        entrenador2.agregarPokemon(new Exeggcute());
        entrenador2.agregarPokemon(new Growlithe());

        // Menú principal
        int opcion;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Iniciar Batalla");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Gestionar entrenadores
                    gestionarEntrenadores(entrenador1, entrenador2, scanner);
                    break;
                case 2:
                    // Iniciar batalla
                    iniciarBatalla(entrenador1, entrenador2);
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void gestionarEntrenadores(Entrenador entrenador1, Entrenador entrenador2, Scanner scanner) {
        // Implementa aquí la lógica para gestionar los entrenadores
        // (por ejemplo, mostrar pokemones)
        System.out.println("Pokemones de " + entrenador1.getNombre() + ":");
        entrenador1.mostrarPokemones();

        System.out.println("Pokemones de " + entrenador2.getNombre() + ":");
        entrenador2.mostrarPokemones();
    }

    public static void iniciarBatalla(Entrenador entrenador1, Entrenador entrenador2) {
        // Seleccionar un Pokémon de cada entrenador para la batalla
        System.out.println("Selecciona un Pokémon de " + entrenador1.getNombre() + " para la batalla:");
        Pokemon pokemon1 = seleccionarPokemon(entrenador1);
        System.out.println("Selecciona un Pokémon de " + entrenador2.getNombre() + " para la batalla:");
        Pokemon pokemon2 = seleccionarPokemon(entrenador2);

    }

    public static Pokemon seleccionarPokemon(Entrenador entrenador) {
        entrenador.mostrarPokemones();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige un Pokémon: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return entrenador.getPokemon(opcion - 1); // Restamos 1 para obtener el índice correcto
    }
}
