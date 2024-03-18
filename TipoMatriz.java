import java.util.Scanner;

public class TipoMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese la cantidad de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matriz ingresada:");
        imprimirMatriz(matriz);

        determinarTipoMatriz(matriz);

        scanner.close();
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void determinarTipoMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        boolean esMatrizFila = filas == 1;
        boolean esMatrizColumna = columnas == 1;
        boolean esMatrizCuadrada = filas == columnas;
        boolean esMatrizDiagonal = esMatrizCuadrada;
        boolean esMatrizIdentidad = true;
        boolean esMatrizCofactores = filas == columnas; // Matriz cuadrada para regla de cofactores
        boolean esMatrizSarrus = filas == 3 && columnas == 3; // Matriz de 3x3 para regla de Sarrus

        // Comprobar regla de identidad
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if ((i != j && matriz[i][j] != 0) || (i == j && matriz[i][j] != 1)) {
                    esMatrizIdentidad = false;
                }
            }
        }

        // Comprobar regla de cofactores
        if (esMatrizCofactores) {
            int determinante = calcularDeterminante(matriz);
            if (determinante != 0) {
                System.out.println("La matriz ingresada es una matriz de cofactores.");
                return;
            }
        }

        // Comprobar regla de Sarrus
        if (esMatrizSarrus) {
            int determinanteSarrus = calcularDeterminanteSarrus(matriz);
            System.out.println("El determinante calculado por regla de Sarrus es: " + determinanteSarrus);
            return;
        }

        // Resto de las comprobaciones
        if (esMatrizFila) {
            System.out.println("La matriz ingresada es una matriz fila.");
        } else if (esMatrizColumna) {
            System.out.println("La matriz ingresada es una matriz columna.");
        } else if (esMatrizDiagonal) {
            System.out.println("La matriz ingresada es una matriz diagonal.");
        } else if (esMatrizCuadrada) {
            System.out.println("La matriz ingresada es una matriz cuadrada.");
        } else if (esMatrizIdentidad) {
            System.out.println("La matriz ingresada es una matriz identidad.");
        } else {
            System.out.println("La matriz ingresada es una matriz general.");
        }
    }

    private static int calcularDeterminante(int[][] matriz) {
        // Implementa el cálculo del determinante usando cofactores
        // Aquí deberás escribir tu propia lógica para calcular el determinante
        // Esto puede ser un poco más complejo y requerir una función recursiva
        // o puedes buscar y usar una biblioteca de álgebra lineal si prefieres.
        return 0; // solo un valor de retorno temporal, debes implementar la lógica adecuada
    }

    private static int calcularDeterminanteSarrus(int[][] matriz) {
        // Implementa el cálculo del determinante usando la regla de Sarrus
        int determinante = 0;
        determinante += matriz[0][0] * matriz[1][1] * matriz[2][2];
        determinante += matriz[0][1] * matriz[1][2] * matriz[2][0];
        determinante += matriz[0][2] * matriz[1][0] * matriz[2][1];
        determinante -= matriz[0][2] * matriz[1][1] * matriz[2][0];
        determinante -= matriz[0][0] * matriz[1][2] * matriz[2][1];
        determinante -= matriz[0][1] * matriz[1][0] * matriz[2][2];
        return determinante;
    }
}
