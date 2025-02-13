package com.mycompany.webscaping.scraper;

public class ProductInfo {
    private String nombre;
    private String precio;
    private String disponibilidad;
    private String timestamp;

    public ProductInfo(String nombre, String precio, String disponibilidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getNombre() { return nombre; }
    public String getPrecio() { return precio; }
    public String getDisponibilidad() { return disponibilidad; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("Producto: %s, Precio: %s, Disponibilidad: %s, Timestamp: %s",
            nombre, precio, disponibilidad, timestamp);
    }
}