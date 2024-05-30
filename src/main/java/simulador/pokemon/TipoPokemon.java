package simulador.pokemon;

public enum TipoPokemon {
    FUEGO, AGUA, PLANTA, VENENO, ELECTRICO, PSIQUICO, ROCA, TIERRA, NORMAL, VOLADOR, LUCHA;

    public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
        // Tabla de multiplicadores (simplificada para este ejemplo)
        double[][] multiplicadores = {
            // FUEGO    AGUA     PLANTA   VENENO   ELECTRICO  PSIQUICO  ROCA     TIERRA   NORMAL   VOLADOR  LUCHA
            {1,        0.5,     2,       1,       1,         1,        0.5,     1,       1,       1,       1}, // FUEGO
            {2,        1,       0.5,     1,       1,         1,        2,       1,       1,       1,       1}, // AGUA
            {0.5,      2,       1,       0.5,     1,         1,        2,       2,       1,       1,       1}, // PLANTA
            {1,        1,       2,       1,       1,         1,        0.5,     1,       1,       1,       2}, // VENENO
            {1,        2,       0.5,     1,       1,         1,        1,       0,       1,       2,       1}, // ELECTRICO
            {1,        1,       1,       2,       1,         1,        1,       1,       1,       1,       2}, // PSIQUICO
            {2,        1,       1,       1,       1,         1,        1,       1,       1,       0.5,     2}, // ROCA
            {2,        1,       1,       2,       0,         1,        2,       1,       1,       1,       1}, // TIERRA
            {1,        1,       1,       1,       1,         1,        1,       1,       1,       1,       1}, // NORMAL
            {1,        1,       2,       1,       2,         1,        0.5,     1,       1,       1,       1}, // VOLADOR
            {1,        1,       1,       1,       1,         0.5,      2,       1,       2,       0.5,     1}  // LUCHA
        };
        return multiplicadores[atacante.ordinal()][defensor.ordinal()];
    }
}
