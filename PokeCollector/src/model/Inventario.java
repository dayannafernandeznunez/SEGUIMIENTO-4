package model;

public class Inventario {
    private Carta[] cartas; // Arreglo para almacenar objetos Carta
    private int contador;

    public Inventario(int capacidad) {
        cartas = new Carta[capacidad]; // Inicializa el arreglo de cartas
        contador = 0; // Inicializa el contador de cartas
    }

    public void agregarCarta(Carta carta) {
        if (contador < cartas.length) {
            // Verificar si el ID es único
            for (int i = 0; i < contador; i++) {
                if (cartas[i].getId() == carta.getId()) {
                    System.out.println("El ID de la carta ya existe.");
                    return; // Salir si el ID ya existe
                }
            }
            cartas[contador++] = carta; // Agregar carta y aumentar el contador
            ordenarCartas(); // Ordenar las cartas después de agregar
        } else {
            System.out.println("Inventario lleno");
        }
    }

    public void listarCartas() {
        System.out.println("Listado de Cartas:");
        for (int i = 0; i < contador; i++) {
            System.out.println("ID: " + cartas[i].getId() + ", Nombre: " + cartas[i].getNombre() + ", Puntos de Vida: " + cartas[i].getPuntosVida());
        }
    }

    public Carta consultarCarta(int id) {
        for (int i = 0; i < contador; i++) {
            if (cartas[i].getId() == id) {
                return cartas[i]; // Devolver carta si se encuentra
            }
        }
        return null; // Retornar null si no se encuentra la carta
    }

    public void actualizarCarta(int id, Carta nuevaCarta) {
        for (int i = 0; i < contador; i++) {
            if (cartas[i].getId() == id) {
                // Actualizar atributos de la carta
                cartas[i].setNombre(nuevaCarta.getNombre());
                cartas[i].setPuntosVida(nuevaCarta.getPuntosVida());
                cartas[i].setTipo(nuevaCarta.getTipo());
                cartas[i].setRareza(nuevaCarta.getRareza());
                return; // Salir una vez actualizada
            }
        }
        System.out.println("Carta no encontrada");
    }

    public void eliminarCarta(int id) {
        for (int i = 0; i < contador; i++) {
            if (cartas[i].getId() == id) {
                // Sustituir el elemento eliminado por el último y decrementar contador
                cartas[i] = cartas[contador - 1]; // Mover el último elemento a la posición eliminada
                cartas[contador - 1] = null; // Limpiar la referencia del último elemento
                contador--; // Disminuir el contador
                return;
            }
        }
        System.out.println("Carta no encontrada");
    }

    private void ordenarCartas() {
        // Implementación de un método de ordenación simple (burbuja)
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (cartas[j].getPuntosVida() < cartas[j + 1].getPuntosVida()) {
                    // Intercambiar cartas
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }
}
