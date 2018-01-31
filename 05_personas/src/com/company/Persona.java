package com.company;

public class Persona {
    private String DNI, nombre;

    public Persona(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  DNI + " - " + nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        return DNI != null ? DNI.equals(persona.DNI) : persona.DNI == null;
    }

    @Override
    public int hashCode() {
        return DNI != null ? DNI.hashCode() : 0;
    }
}
