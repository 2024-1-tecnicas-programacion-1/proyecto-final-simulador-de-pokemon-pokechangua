package simulador.pokemon;

public class TipoPokemon {
   NORMAL,FUEGO,AGUA,ELECTRICO,PLANTA,HIELO,PSIQUICO,ROCA,TIERRA,VOLADOR,HADA,LUCHA,BICHO,ACERO,VENENO,FANTASMA; 

    public double daño (TipoPokemon atacante, TipoPokemon defensor) {
        switch (atacante) {
            
            case NORMAL -> {
            return switch (defensor) {
                case ROCA -> 0.5;
                case FANTASMA -> 0.0;
                default -> 1.0;
            }; // Inmune al tipo fantasma
            }

            case FUEGO -> {
            return switch (defensor) {
                case PLANTA, BICHO, HIELO -> 2.0;
                case AGUA, ROCA, FUEGO -> 0.5;
                default -> 1.0;
            };
            }

            case AGUA -> {
            return switch (defensor) {
                case FUEGO, TIERRA, ROCA -> 2.0;
                case PLANTA, AGUA -> 0.5;
                default -> 1.0;
            };
            }

            case ELECTRICO -> {
            return switch (defensor) {
                case AGUA, VOLADOR -> 2.0;
                case ELECTRICO, PLANTA -> 0.5;
                case TIERRA -> 0.0;
                default -> 1.0;
            }; // Inmune al tipo tierra
            }

            case PLANTA -> {
            return switch (defensor) {
                case AGUA, TIERRA, ROCA -> 2.0;
                case FUEGO, PLANTA, VOLADOR, BICHO, VENENO -> 0.5;
                default -> 1.0;
            };
            }
            case HIELO -> {
            return switch (defensor) {
                case HIELO, PLANTA, TIERRA, VOLADOR -> 2.0;
                case FUEGO, LUCHA, ROCA, ACERO -> 0.5;
                default -> 1.0;
            };
            }
                
            case PSIQUICO -> {
            return switch (defensor) {
                case LUCHA, VENENO -> 2.0;
                case PSIQUICO, ACERO -> 0.5;
                case FANTASMA -> 0.0;
                default -> 1.0;
            };
            }

            case ROCA -> {
            return switch (defensor) {
                case NORMAL, FUEGO, VENENO, VOLADOR -> 0.5;
                case AGUA, PLANTA, LUCHA, TIERRA -> 2.0;
                default -> 1.0;
            };
            }
            case TIERRA -> {
            return switch (defensor) {
                case VENENO, ROCA -> 2.0;
                case AGUA, PLANTA, HIELO -> 2.0;
                case ELECTRICO, VOLADOR -> 0.0;
                default -> 1.0;
            }; // Inmune al tipo eléctrico y volador
            }
            case VOLADOR -> {
            return switch (defensor) {
                case PLANTA, LUCHA, BICHO -> 2.0;
                case ROCA, ELECTRICO, ACERO -> 0.5;
                default -> 1.0;
            };
            }
            case HADA -> {
            return switch (defensor) {
                case LUCHA, BICHO -> 2.0;
                case FUEGO, VENENO, ACERO -> 0.5;
                case FANTASMA -> 0.0;
                default -> 1.0;
            }; // Inmune al tipo fantasma
            }
            case BICHO -> {
            return switch (defensor) {
                case PLANTA, PSIQUICO, FUEGO, LUCHA, VOLADOR, VENENO, FANTASMA, ACERO -> 0.5;
                default -> 1.0;
            };
            }
                
            case LUCHA -> {
            return switch (defensor) {
                case NORMAL, ROCA, HIELO, ACERO -> 2.0;
                case VOLADOR, VENENO, PSIQUICO, BICHO, HADA -> 0.5;
                default -> 1.0;
            };
            }
            case ACERO -> {                                                           
            return switch (defensor) {
                case NORMAL, PLANTA, HIELO, VOLADOR, PSIQUICO, BICHO, HADA -> 0.5;
                case ROCA, HIELO, HADA -> 2.0;
                default -> 1.0;
            };
            }
            case FANTASMA -> {
            return switch (defensor) {
                case NORMAL, LUCHA -> 0.0;
                case PSIQUICO -> 2.0;
                case FANTASMA -> 0.5;
                default -> 1.0;
            }; // Inmune a ataques normales y de lucha
                    
       }
     }      
   }
}   

