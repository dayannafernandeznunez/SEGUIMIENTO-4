package model;

public class Carta {
    private int id;
    private String nombre;
    private int puntosVida;
    private String tipo;
    private String rareza;

    public Carta(int id, String nombre, int puntosVida, String tipo, String rareza) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.tipo = tipo;
        this.rareza = rareza;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRareza() {
        return rareza;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }
}
