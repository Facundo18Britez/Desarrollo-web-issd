package Juego;
import java.util.Scanner;
import java.util.Random;
public class Controlador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1; // Número entre 1 y 100
        int intentosMaximos = 7;//inicio variables
        int intentos = 0;
        boolean adivinado = false;

        System.out.println("¡Bienvenido al juego de Adivina el Número!");
        System.out.println("Tienes " + intentosMaximos + " intentos para adivinar un número entre 1 y 100.");

        while (intentos < intentosMaximos) {
            System.out.print("Intento " + (intentos + 1) + ": Ingresa tu número --->");
            int intentoUsuario;

            try {
                intentoUsuario = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número válido. --->");
                continue;
            }

            intentos++;

            if (intentoUsuario == numeroSecreto) {
                System.out.println("¡Ganaste! Adivinaste el número en " + intentos + " intentos.");
                adivinado = true;// Aca ganas el juego si adivinas
                break;
            } else if (intentoUsuario < numeroSecreto) {//con un solo condicional por exclusion si no es mas bajo que x, es mas alto que x
                System.out.println("Demasiado bajo.");
            } else {
                System.out.println("Demasiado alto.");
            }
        }

        if (!adivinado) {
            System.out.println("!PERDISTE¡ Has agotado tus intentos. El número correcto era: " + numeroSecreto);
        }

        System.out.println("Gracias por jugar. :3");
        scanner.close();
    }
}
