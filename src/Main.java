/**
 * <p>Clase Fecha:</p>
 * <p>
 *  Dado un vector de enteros empezando en 2, se tachan todos los múltiplos de 2. A continuación, se encuentra el siguiente
 *  entero no tachado y se tachan todos sus múltiplos. El proceso se repite hasta que se pasa de la
 *  raíz cuadrada del valor máximo. Todos los números que queden sin tachar son números primos.
 * </p>
 * @version 3.0
 * @author Dylan Blasco de Souza
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el número para la criba de Eratóstenes: ");
        int dato = teclado.nextInt();
        int[] primos = generarPrimos(dato);

        System.out.println("\nVector inicial hasta " + dato + ":");
        imprimirVector(dato);

        System.out.println("\nVector de primos hasta " + dato + ":");
        imprimirVector(primos);
    }

    /**
     * Método que genera un array con números primos hasta el valor máximo especificado.
     * @param max Valor máximo especificado
     * @return Array de números primos
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Retorna un vector vacío si max < 2
        }

        boolean[] esPrimo = new boolean[max + 1];
        int cuenta = 0;

        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true; // Inicializa todo el array a true
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false; // Desmarca los múltiplos de i
                }
            }
        }

        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                cuenta++; // Cuenta el número de primos.
            }
        }

        int[] primos = new int[cuenta];
        int indice = 0;

        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                primos[indice++] = i; // Llena el vector de primos
            }
        }

        return primos;
    }

    /**
     * Método que imprime los números del 1 al valor especificado.
     * @param max Valor máximo especificado
     */
    public static void imprimirVector(int max) {
        for (int i = 1; i <= max; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + "\t");
        }
    }

    /**
     * Método que imprime los valores de un vector.
     * @param vector Vector a imprimir
     */
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}
