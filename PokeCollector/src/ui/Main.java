package ui;


import model.Carta;
import model.Inventario;
import java.util.Scanner;

public class Main {
    private static Inventario inventario = new Inventario(100);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar Carta");
            System.out.println("2. Listar Cartas");
            System.out.println("3. Consultar Carta");
            System.out.println("4. Actualizar Carta");
            System.out.println("5. Eliminar Carta");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarCarta(scanner);
                    break;
                case 2:
                    inventario.listarCartas();
                    break;
                case 3:
                    consultarCarta(scanner);
                    break;
                case 4:
                    actualizarCarta(scanner);
                    break;
                case 5:
                    eliminarCarta(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void agregarCarta(Scanner scanner) {
        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Puntos de Vida: ");
        int puntosVida = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese Rareza: ");
        String rareza = scanner.nextLine();

        Carta carta = new Carta(id, nombre, puntosVida, tipo, rareza);
        inventario.agregarCarta(carta);
    }

    private static void consultarCarta(Scanner scanner) {
        System.out.print("Ingrese ID de la carta: ");
        int id = scanner.nextInt();
        Carta carta = inventario.consultarCarta(id);
        if (carta != null) {
            System.out.println("ID: " + carta.getId() + ", Nombre: " + carta.getNombre() + ", Puntos de Vida: " + carta.getPuntosVida() + ", Tipo: " + carta.getTipo() + ", Rareza: " + carta.getRareza());
        } else {
            System.out.println("Carta no encontrada");
        }
    }

    private static void actualizarCarta(Scanner scanner) {
        System.out.print("Ingrese ID de la carta a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nuevos Puntos de Vida: ");
        int puntosVida = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese nuevo Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese nueva Rareza: ");
        String rareza = scanner.nextLine();

        Carta nuevaCarta = new Carta(id, nombre, puntosVida, tipo, rareza);
        inventario.actualizarCarta(id, nuevaCarta);
    }

    private static void eliminarCarta(Scanner scanner) {
        System.out.print("Ingrese ID de la carta a eliminar: ");
        int id = scanner.nextInt();
        inventario.eliminarCarta(id);
    }
}
