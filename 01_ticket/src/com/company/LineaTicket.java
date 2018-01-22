package com.company;

public class LineaTicket {
    private String producto;
    private double precio;
    private int cantidad;
    private Ticket ticket;

    public LineaTicket (Ticket ticket) {
        this.ticket = ticket;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return producto + " (" + cantidad + "): " + precio;
    }
}
