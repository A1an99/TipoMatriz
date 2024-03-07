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
                System.out.print("Elemento [" + (i+1) + "][" + (j+1) + "]: ");
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
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i != j && matriz[i][j] != 0) {
                    esMatrizDiagonal = false;
                }
                if (i != j && matriz[i][j] != 0 || (i == j && matriz[i][j] != 1)) {
                    esMatrizIdentidad = false;
                }
            }
        }
        
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
}